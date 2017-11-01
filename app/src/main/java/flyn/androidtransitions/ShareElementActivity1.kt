package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import kotlinx.android.synthetic.main.activity_shareelement1.*

class ShareElementActivity1 : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shareelement1)


        button1.setOnClickListener {
            val pairs = arrayOf(Pair.create<View, String>(button1, getString(R.string.button)))
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(ShareElementActivity1@ this, *pairs)
            ActivityCompat.startActivity(this, Intent(ShareElementActivity1@ this, ShareElementActivity2::class.java), activityOptions.toBundle())
        }

    }
}