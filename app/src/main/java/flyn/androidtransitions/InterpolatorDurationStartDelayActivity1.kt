package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import kotlinx.android.synthetic.main.activity_interpolator_duration_start_delay1.*

class InterpolatorDurationStartDelayActivity1 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity1"
        setContentView(R.layout.activity_interpolator_duration_start_delay1)

        button1.setOnClickListener {
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(ShareElementActivity1@ this)
            ActivityCompat.startActivity(this, Intent(ShareElementActivity1@ this, InterpolatorDurationStartDelayActivity2::class.java), activityOptions.toBundle())
        }
    }
}