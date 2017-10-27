package flyn.androidtransitions

import android.os.Bundle
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_interpolator_duration_start_delay2.*

class InterpolatorDurationStartDelayActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "InterpolatorDurationStartDelayActivity2"
        setContentView(R.layout.activity_interpolator_duration_start_delay2)


        val slide = Slide()
        slide.slideEdge = Gravity.START
        slide.duration = 600
        slide.interpolator = FastOutLinearInInterpolator()
        slide.startDelay = 1000
        slide.targets.add(button1)

        slide.excludeTarget(android.R.id.statusBarBackground, true)
        slide.excludeTarget(android.R.id.navigationBarBackground, true)

        val transitionSet = TransitionSet()
        transitionSet.addTransition(slide)

        window.enterTransition = transitionSet
        window.returnTransition = transitionSet
    }
}