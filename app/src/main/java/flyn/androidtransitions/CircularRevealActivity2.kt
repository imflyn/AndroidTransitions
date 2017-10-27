package flyn.androidtransitions

import android.animation.Animator
import android.os.Bundle
import android.transition.Fade
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import kotlinx.android.synthetic.main.activity_circular_reveal2.*

class CircularRevealActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_reveal2)

        val x = intent.getFloatExtra("x", 0F)
        val y = intent.getFloatExtra("y", 0F)

        rootView.postDelayed(
                {
                    createReveal(false, x, y).start()
                }, 10
        )


        imageView.setOnTouchListener { _, event ->
            val animation = createReveal(true, event.x, event.y)
            animation.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    imageView.visibility = View.GONE
                    finishAfterTransition()
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {

                }
            })
            animation.start()

            false
        }


        val fade = Fade()
        window.enterTransition = fade
        window.returnTransition = fade
    }

    private fun createReveal(reversed: Boolean, x: Float, y: Float): Animator {
        val radius = Math.hypot(rootView.height.toDouble(), rootView.width.toDouble()).toFloat()
        val startRadius = if (reversed) radius else 0F
        val endRadius = if (reversed) 0F else radius

        val animator = ViewAnimationUtils.createCircularReveal(rootView, x.toInt(), y.toInt(), startRadius, endRadius)
        animator.duration = 800
        animator.interpolator = AccelerateDecelerateInterpolator()
        return animator
    }

}