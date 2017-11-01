package flyn.androidtransitions

import android.os.Bundle
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_interpolator_duration_start_delay2.*

class InterpolatorDurationStartDelayActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity2"
        setContentView(R.layout.activity_interpolator_duration_start_delay2)


        val slide = Slide()
        slide.slideEdge = Gravity.START
        slide.duration = 2000
        slide.interpolator = LinearOutSlowInInterpolator()
        slide.targets.add(button2)
        slide.excludeTarget(android.R.id.statusBarBackground, true)
        slide.excludeTarget(android.R.id.navigationBarBackground, true)

        window.enterTransition = slide


        val slide2 = Slide()
        slide2.slideEdge = Gravity.END
        slide2.duration = 2000
        slide2.startDelay = 100
        slide2.interpolator = LinearOutSlowInInterpolator()
        slide2.targets.add(button2)
        slide2.excludeTarget(android.R.id.statusBarBackground, true)
        slide2.excludeTarget(android.R.id.navigationBarBackground, true)

        val fade2 = Fade()
        fade2.duration = 2000
        fade2.excludeTarget(android.R.id.statusBarBackground, false)
        fade2.excludeTarget(android.R.id.navigationBarBackground, false)

        val transition = TransitionSet()
        transition.addTransition(slide2)
        transition.addTransition(fade2)

        window.returnTransition = transition


        button2.setOnClickListener {
            supportFinishAfterTransition()
        }
    }
}