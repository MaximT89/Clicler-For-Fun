package com.secondworld.clickernew.domain

import android.content.Context
import android.os.CountDownTimer
import android.view.Gravity
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.secondworld.clickernew.animations.AnimateTypeAlpha
import com.secondworld.clickernew.animations.AnimateTypeTranslation
import com.secondworld.clickernew.animations.Animators
import com.secondworld.clickernew.data.repository.Repository
import javax.inject.Inject

class DamageCase @Inject constructor(
    private val repository: Repository,
    private val context: Context,
    private val anim: Animators
) {

    fun getCurrentDamage(): Int {
        return repository.getDamage()
    }

    fun createTextDamage(fieldTextDamageToEnemy: RelativeLayout, value: Int?) {

        val textView = TextView(context).apply{
            layoutParams = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            text = "$value"
            gravity = Gravity.CENTER
        }

        textView.setPadding(0, 100, 0, 0)
        fieldTextDamageToEnemy.addView(textView)

        anim.animPlayTogether(
            anim.animAlpha(
                textView ,
                AnimateTypeAlpha.INSIDE
            ),
            anim.animTranslateY(
                textView,
                AnimateTypeTranslation.UP
            ), 500)

        object : CountDownTimer(1000, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                fieldTextDamageToEnemy.removeView(textView)
            }
        }.start()
    }
}