package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import kotlinx.android.synthetic.main.activity_change_bounds1.*

class ChangeColorActivity1 : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeColorActivity1"
        setContentView(R.layout.activity_change_color_1)

        textView1.setOnClickListener(this)
        textView2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val pairs = arrayOf(
                Pair.create<View, String>(textView1, textView1.transitionName),
                Pair.create<View, String>(textView2, textView2.transitionName)
        )
        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs)
        ActivityCompat.startActivity(this, Intent(this, ChangeColorActivity2::class.java), activityOptions.toBundle())
    }

}