package flyn.androidtransitions

import android.graphics.Rect
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.ChangeClipBounds
import android.transition.TransitionSet
import kotlinx.android.synthetic.main.activity_change_clip_bounds2.*


class ChangeClipBoundsActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeClipBoundsActivity2"
        setContentView(R.layout.activity_change_clip_bounds2)

        val changeBounds = ChangeBounds()
        val changeClipBounds = ChangeClipBounds()
        val transition = TransitionSet()
        transition.duration = 2000
        transition.addTransition(changeBounds)
//        transition.addTransition(changeClipBounds)

        window.sharedElementEnterTransition = transition
        window.enterTransition = transition

        window.sharedElementReturnTransition = transition
        window.returnTransition = transition

        imageView.clipBounds = Rect(0, 0, 200, 200)

    }


}