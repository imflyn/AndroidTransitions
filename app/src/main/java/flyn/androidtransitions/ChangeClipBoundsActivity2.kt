package flyn.androidtransitions

import android.os.Bundle
import android.transition.ChangeClipBounds
import kotlinx.android.synthetic.main.activity_change_clip_bounds2.*

class ChangeClipBoundsActivity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeClipBoundsActivity2"
        setContentView(R.layout.activity_change_clip_bounds2)


        val changeClipBounds = ChangeClipBounds()
        changeClipBounds.addTarget(view1)
        changeClipBounds.duration = 2000

        window.sharedElementEnterTransition = changeClipBounds
        window.enterTransition = changeClipBounds

        window.sharedElementReturnTransition = changeClipBounds
        window.returnTransition = null
    }

}