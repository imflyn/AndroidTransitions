package flyn.androidtransitions

import android.os.Bundle
import android.os.Handler
import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.transition.Transition
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_path_motion2.*


class PathMotionActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "PathMotionActivity2"
        setContentView(R.layout.activity_path_motion2)

        Handler().postDelayed({
            val changeBounds = ChangeBounds()
            changeBounds.pathMotion = ArcMotion()
            changeBounds.duration = 1000

            TransitionManager.beginDelayedTransition(rootView, changeBounds)
            val params = button2.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.END or Gravity.BOTTOM
            button2.layoutParams = params
        }, 5)

        button2.setOnClickListener {
            val changeBounds = ChangeBounds()
            changeBounds.pathMotion = ArcMotion()
            changeBounds.duration = 1000
            changeBounds.addListener(object : Transition.TransitionListener {
                override fun onTransitionResume(transition: Transition?) {
                }

                override fun onTransitionPause(transition: Transition?) {
                }

                override fun onTransitionCancel(transition: Transition?) {
                }

                override fun onTransitionStart(transition: Transition?) {
                }

                override fun onTransitionEnd(transition: Transition?) {
                    finish()
                    overridePendingTransition(0, 0)
                }
            })

            TransitionManager.beginDelayedTransition(rootView, changeBounds)
            val params = button2.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP or Gravity.START
            button2.layoutParams = params


        }
    }
}