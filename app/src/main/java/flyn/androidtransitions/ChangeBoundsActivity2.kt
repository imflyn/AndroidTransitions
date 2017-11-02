package flyn.androidtransitions

import android.os.Bundle
import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.view.View
import kotlinx.android.synthetic.main.activity_change_bounds2.*

class ChangeBoundsActivity2 : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeBoundsActivity2"
        setContentView(R.layout.activity_change_bounds2)

        val arcMotion = ArcMotion()
        arcMotion.minimumHorizontalAngle = 50f
        arcMotion.minimumVerticalAngle = 50f

        val changeBounds = ChangeBounds()
        changeBounds.pathMotion = arcMotion
        changeBounds.addTarget(textView1)
        changeBounds.addTarget(textView2)
        changeBounds.duration = 2000


        window.sharedElementEnterTransition = changeBounds
        window.enterTransition = null

        window.sharedElementReturnTransition = changeBounds
        window.returnTransition = null


        textView1.setOnClickListener(this)
        textView2.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        finishAfterTransition()
    }
}