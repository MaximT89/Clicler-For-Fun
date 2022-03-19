package com.secondworld.clickernew.domain

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.os.CountDownTimer
import android.view.Gravity
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.secondworld.clickernew.R
import com.secondworld.clickernew.animations.AnimateTypeAlpha
import com.secondworld.clickernew.animations.AnimateTypeTranslation
import com.secondworld.clickernew.animations.Animators
import com.secondworld.clickernew.core.log
import com.secondworld.clickernew.data.repository.Repository
import javax.inject.Inject

class DamageCase @Inject constructor(
    private val repository: Repository,
    private val context: Context,
    private val anim: Animators
) {

    enum class DamageType {
        COMMON,
        CRIT
    }

    data class Damage(
        val damage: Int,
        val typeDamage: DamageType
    )

    fun getCurrentDamage(): Damage {

        val critChance = repository.getCritDamageChance()
        val damageConstructor = repository.getDamage()
        var damageType : DamageType = DamageType.COMMON
        var totalDamage = damageConstructor

        when ((1..100).random()) {
            in 1..critChance -> {
                totalDamage = (damageConstructor.toDouble() / 100 * repository.getCritDamageMultiply()).toInt()
                damageType = DamageType.CRIT
            }
            in (critChance + 1)..100 -> {
                damageConstructor * 1
                damageType = DamageType.COMMON
            }
        }

        return Damage(totalDamage, damageType)
    }

    @SuppressLint("ResourceAsColor")
    fun createTextDamage(
        fieldTextDamageToEnemy: RelativeLayout,
        value: Int?,
        typeDamage: DamageType
    ) {

        log(value.toString())

        val textView = TextView(context).apply {
            layoutParams = RelativeLayout.LayoutParams(
                400,
                200
            )
            text = "$value"
            gravity = Gravity.CENTER
        }

        textView.setPadding(0, 100, 0, 0)
        fieldTextDamageToEnemy.addView(textView)

        when(typeDamage){
            DamageType.COMMON -> {
                textView.textSize = 15f
            }
            DamageType.CRIT -> {
                textView.textSize = 30f
                textView.setTextColor(R.color.black)
            }
        }

        anim.animPlayTogether(
            anim.animAlpha(
                textView,
                AnimateTypeAlpha.INSIDE
            ),
            anim.animTranslateY(
                textView,
                AnimateTypeTranslation.UP
            ), 500
        )

        object : CountDownTimer(1000, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                fieldTextDamageToEnemy.removeView(textView)
            }
        }.start()
    }
}