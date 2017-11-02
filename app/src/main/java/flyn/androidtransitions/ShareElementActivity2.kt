package flyn.androidtransitions

import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_shareelement2.*

class ShareElementActivity2 : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ShareElementActivity2"
        setContentView(R.layout.activity_shareelement2)

        val slide = Slide(Gravity.BOTTOM)
        slide.addTarget(R.id.button2)
        window.enterTransition = slide


        val slide2 = Slide(Gravity.TOP)
        slide2.addTarget(R.id.button2)
        slide2.excludeTarget(android.R.id.statusBarBackground, true)
        slide2.excludeTarget(android.R.id.navigationBarBackground, true)

        val fade2 = Fade()
        fade2.excludeTarget(android.R.id.statusBarBackground, false)
        fade2.excludeTarget(android.R.id.navigationBarBackground, false)

        val transition = TransitionSet()
        transition.addTransition(slide2)
        transition.addTransition(fade2)

        window.returnTransition = transition

        button2.setOnClickListener {
            finishAfterTransition()
        }
    }
}