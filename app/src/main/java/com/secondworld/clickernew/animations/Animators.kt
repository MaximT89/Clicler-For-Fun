package com.secondworld.clickernew.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import javax.inject.Inject

@SuppressLint("Recycle")
class Animators @Inject constructor(context: Context) {

    fun animScale(view : View){
        val scaleYp = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.5f, 1f)
        val scaleXp = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.5f, 1f)
        AnimatorSet().apply {
            playTogether(scaleXp, scaleYp)
            duration = 400
            start()
        }
    }
}