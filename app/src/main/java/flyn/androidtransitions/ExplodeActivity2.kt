package flyn.androidtransitions

import android.os.Bundle
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.transition.Explode
import android.transition.Fade
import android.transition.TransitionSet
import android.view.View
import kotlinx.android.synthetic.main.activity_explode2.*

class ExplodeActivity2 : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ExplodeActivity2"
        setContentView(R.layout.activity_explode2)


        val explode = Explode()
        explode.duration = 2000
        explode.excludeTarget(android.R.id.statusBarBackground, true)
        explode.excludeTarget(android.R.id.navigationBarBackground, true)

        window.enterTransition = explode


        val explode2 = Explode()
        explode2.duration = 2000
        explode2.interpolator = LinearOutSlowInInterpolator()
        explode2.excludeTarget(android.R.id.statusBarBackground, true)
        explode2.excludeTarget(android.R.id.navigationBarBackground, true)

        val fade2 = Fade()
        fade2.duration = 2000
        fade2.excludeTarget(android.R.id.statusBarBackground, false)
        fade2.excludeTarget(android.R.id.navigationBarBackground, false)

        val transition = TransitionSet()
        transition.addTransition(explode2)
        transition.addTransition(fade2)

        window.returnTransition = transition

        button1.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        finishAfterTransition()
    }
}