package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.transition.Explode
import android.transition.Fade
import android.transition.TransitionSet
import android.view.View
import kotlinx.android.synthetic.main.activity_explode1.*

class ExplodeActivity1 : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ExplodeActivity1"
        setContentView(R.layout.activity_explode1)

        val explode1 = Explode()
        explode1.duration = 2000
        explode1.excludeTarget(android.R.id.statusBarBackground, true)
        explode1.excludeTarget(android.R.id.navigationBarBackground, true)

        val fade1 = Fade()
        fade1.duration = 2000
        fade1.excludeTarget(android.R.id.statusBarBackground, false)
        fade1.excludeTarget(android.R.id.navigationBarBackground, false)

        val transition1 = TransitionSet()
        transition1.addTransition(explode1)
        transition1.addTransition(fade1)

        window.exitTransition = transition1


        val explode2 = Explode()
        explode2.duration = 2000
        explode2.excludeTarget(android.R.id.statusBarBackground, true)
        explode2.excludeTarget(android.R.id.navigationBarBackground, true)
        window.reenterTransition = explode2


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this)
        ActivityCompat.startActivity(this, Intent(this, ExplodeActivity2::class.java), activityOptions.toBundle())
    }

}