package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_change_image_transform1.*


class ChangeImageTransformActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeImageTransformActivity1"
        setContentView(R.layout.activity_change_image_transform1)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        window.reenterTransition = null
        window.exitTransition = null

        window.sharedElementReenterTransition = null
        window.sharedElementExitTransition = null

        imageView1.setOnClickListener {
            val statusBar = window.decorView.findViewById<View>(android.R.id.statusBarBackground)
            val navigationBar = window.decorView.findViewById<View>(android.R.id.navigationBarBackground)

            val pairs = arrayOf(
                    Pair.create<View, String>(toolbar, toolbar.transitionName),
                    Pair.create<View, String>(statusBar, statusBar.transitionName),
                    Pair.create<View, String>(navigationBar, navigationBar.transitionName),
                    Pair.create<View, String>(imageView1, imageView1.transitionName)
            )

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs)
            val intent = Intent(this@ChangeImageTransformActivity1, ChangeImageTransformActivity2::class.java)
            startActivity(intent, activityOptions.toBundle())
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> supportFinishAfterTransition()
        }
        return super.onOptionsItemSelected(item)
    }
}