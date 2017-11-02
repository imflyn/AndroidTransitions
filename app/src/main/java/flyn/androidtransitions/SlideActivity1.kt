package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_slide1.*

class SlideActivity1 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "SlideActivity1"
        setContentView(R.layout.activity_slide1)


        val slide1 = Slide()
        slide1.slideEdge = Gravity.END
        slide1.duration = 2000
        slide1.interpolator = FastOutLinearInInterpolator()
        slide1.targets.add(button1)
        slide1.excludeTarget(android.R.id.statusBarBackground, true)
        slide1.excludeTarget(android.R.id.navigationBarBackground, true)

        val fade1 = Fade()
        fade1.duration = 2000
        fade1.excludeTarget(android.R.id.statusBarBackground, false)
        fade1.excludeTarget(android.R.id.navigationBarBackground, false)

        val transition = TransitionSet()
        transition.addTransition(slide1)
        transition.addTransition(fade1)

        window.exitTransition = transition


        val slide2 = Slide()
        slide2.slideEdge = Gravity.START
        slide2.duration = 2000
        slide2.interpolator = FastOutLinearInInterpolator()
        slide2.targets.add(button1)
        slide2.excludeTarget(android.R.id.statusBarBackground, true)
        slide2.excludeTarget(android.R.id.navigationBarBackground, true)

        window.reenterTransition = slide2


        button1.setOnClickListener {
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this)
            ActivityCompat.startActivity(this, Intent(this, SlideActivity2::class.java), activityOptions.toBundle())
        }
    }


}