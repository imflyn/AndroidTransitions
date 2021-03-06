package flyn.androidtransitions

import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_slide2.*

class SlideActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "SlideActivity2"
        setContentView(R.layout.activity_slide2)


        val slide = Slide()
        slide.slideEdge = Gravity.START
        slide.duration = 2000
        slide.targets.add(button2)
        slide.excludeTarget(android.R.id.statusBarBackground, true)
        slide.excludeTarget(android.R.id.navigationBarBackground, true)

        window.enterTransition = slide


        val slide2 = Slide()
        slide2.slideEdge = Gravity.END
        slide2.duration = 2000
        slide2.startDelay = 100
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