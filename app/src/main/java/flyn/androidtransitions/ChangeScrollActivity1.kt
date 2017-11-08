package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import kotlinx.android.synthetic.main.activity_change_scroll1.*

class ChangeScrollActivity1 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeScrollActivity1"
        setContentView(R.layout.activity_change_scroll1)


        button1.setOnClickListener {
            val statusBar = window.decorView.findViewById<View>(android.R.id.statusBarBackground)
            val navigationBar = window.decorView.findViewById<View>(android.R.id.navigationBarBackground)

            val pairs = arrayOf(
                    Pair.create<View, String>(statusBar, statusBar.transitionName),
                    Pair.create<View, String>(navigationBar, navigationBar.transitionName),
                    Pair.create<View, String>(button1, button1.transitionName)
            )

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs)
            val intent = Intent(this@ChangeScrollActivity1, ChangeScrollActivity2::class.java)
            startActivity(intent, activityOptions.toBundle())
        }
    }
}