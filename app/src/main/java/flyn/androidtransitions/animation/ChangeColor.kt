package flyn.androidtransitions.animation

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.drawable.ColorDrawable
import android.transition.Transition
import android.transition.TransitionValues
import android.view.ViewGroup

class ChangeColor : Transition() {

    companion object {
        val PROPNAME_BACKGROUND = "flyn.androidtransitions.animation:change_color:background"
    }

    private fun captureValues(values: TransitionValues) {
        // Capture the property values of views for later use
        values.values.put(PROPNAME_BACKGROUND, values.view.background)
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    // Capture the value of the background drawable property for a target in the ending Scene.
    override fun captureEndValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun createAnimator(sceneRoot: ViewGroup?, startValues: TransitionValues?, endValues: TransitionValues?): Animator? {
        val view = endValues?.view

        val startBackground = startValues?.values?.get(PROPNAME_BACKGROUND)
        val endBackground = endValues?.values?.get(PROPNAME_BACKGROUND)

        if (startBackground is ColorDrawable && endBackground is ColorDrawable) {
            if (startBackground.color != endBackground.color) {
                val animator = ValueAnimator.ofObject(ArgbEvaluator(), startBackground.color, endBackground.color)
                animator.addUpdateListener { animation ->
                    animation.animatedValue?.let {
                        view?.setBackgroundColor(animation.animatedValue as Int)
                    }
                }
                return animator
            }
        }
        return null
    }
}