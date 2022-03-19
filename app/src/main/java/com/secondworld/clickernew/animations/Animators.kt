package com.secondworld.clickernew.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import javax.inject.Inject

@SuppressLint("Recycle")
class Animators @Inject constructor(context: Context) {

    fun animScale(view: View, type: AnimateTypeScale) {

        val value = when (type) {
            AnimateTypeScale.INSIDE -> 0.9f
            AnimateTypeScale.OUTSIDE -> 1.4f
        }

        val scaleYp = ObjectAnimator.ofFloat(view, "scaleY", 1f, value, 1f)
        val scaleXp = ObjectAnimator.ofFloat(view, "scaleX", 1f, value, 1f)
        AnimatorSet().apply {
            playTogether(scaleXp, scaleYp)
            duration = 300
            start()
        }
    }

    fun animAlpha(view: View, type: AnimateTypeAlpha): ObjectAnimator {

        var start = 0f
        var end = 0f

        when (type) {
            AnimateTypeAlpha.INSIDE -> {
                start = 1f
                end = 0f
            }
            AnimateTypeAlpha.OUTSIDE -> {
                start = 0f
                end = 1f
            }
        }

        return ObjectAnimator.ofFloat(view, "alpha", start, end)
    }

    fun animTranslateY(view: View, type: AnimateTypeTranslation): ObjectAnimator {

        var start = 0f
        var end = 0f

        when (type) {
            AnimateTypeTranslation.UP -> {
                start = 0f
                end = -50f
            }
            AnimateTypeTranslation.DOWN -> {
                start = 2f
                end = 1f
            }
        }

        return ObjectAnimator.ofFloat(view, "translationY", start, end)
    }

    fun animPlayTogether(
        objectFirst: ObjectAnimator,
        objectSecond: ObjectAnimator,
        durationTime: Long
    ) {

        AnimatorSet().apply {
            playTogether(objectFirst, objectSecond)
            duration = durationTime
            start()
        }
    }


}