package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import kotlinx.android.synthetic.main.activity_path_motion1.*


class PathMotionActivity1 : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "PathMotionActivity1"
        setContentView(R.layout.activity_path_motion1)


        val fade = Fade()
        window.reenterTransition = fade
        window.exitTransition = fade


        button1.setOnClickListener {

            val i = Intent(this@PathMotionActivity1, PathMotionActivity2::class.java)
            startActivity(i)
            overridePendingTransition(0, 0)
        }
    }
}