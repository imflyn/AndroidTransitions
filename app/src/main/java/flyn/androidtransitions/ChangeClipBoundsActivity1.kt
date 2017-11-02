package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import kotlinx.android.synthetic.main.activity_change_clip_bounds1.*

class ChangeClipBoundsActivity1 : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeClipBoundsActivity1"
        setContentView(R.layout.activity_change_clip_bounds1)


        imageView.setOnClickListener {
            val pairs = arrayOf(
                    Pair.create<View, String>(view1, getString(R.string.view1))
            )
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs)
            ActivityCompat.startActivity(this, Intent(this, ChangeClipBoundsActivity2::class.java), activityOptions.toBundle())
        }
    }

}