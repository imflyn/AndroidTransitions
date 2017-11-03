package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.transition.ChangeClipBounds
import android.view.View
import kotlinx.android.synthetic.main.activity_change_clip_bounds1.*

class ChangeClipBoundsActivity1 : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeClipBoundsActivity1"
        setContentView(R.layout.activity_change_clip_bounds1)

        val changeClipBounds = ChangeClipBounds()
        changeClipBounds.addTarget(imageView)
        changeClipBounds.duration = 2000


//        window.sharedElementEnterTransition = changeClipBounds
//        window.enterTransition = changeClipBounds
//
//        window.sharedElementReturnTransition = changeClipBounds
//        window.returnTransition = changeClipBounds

        imageView.setOnClickListener {
            val pairs = arrayOf(
                    Pair.create<View, String>(imageView, imageView.transitionName)
            )
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs)
            ActivityCompat.startActivity(this, Intent(this, ChangeClipBoundsActivity2::class.java), activityOptions.toBundle())
        }
    }


}