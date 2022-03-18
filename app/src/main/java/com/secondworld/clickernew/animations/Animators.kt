package com.secondworld.clickernew.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import javax.inject.Inject

@SuppressLint("Recycle")
class Animators @Inject constructor(context: Context) {

    fun animScale(view : View, type : AnimateType){

        val value = when(type){
            AnimateType.INSIDE -> 0.9f
            AnimateType.OUTSIDE -> 1.4f
        }

        val scaleYp = ObjectAnimator.ofFloat(view, "scaleY", 1f, value, 1f)
        val scaleXp = ObjectAnimator.ofFloat(view, "scaleX", 1f, value, 1f)
        AnimatorSet().apply {
            playTogether(scaleXp, scaleYp)
            duration = 300
            start()
        }
    }
}