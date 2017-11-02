package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import kotlinx.android.synthetic.main.activity_change_bounds1.*

class ChangeBoundsActivity1 : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeBoundsActivity1"
        setContentView(R.layout.activity_change_bounds1)


        textView1.setOnClickListener(this)
        textView2.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        val pairs = arrayOf(
                Pair.create<View, String>(textView1, getString(R.string.textView1)),
                Pair.create<View, String>(textView2, getString(R.string.textView2))
        )
        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs)
        ActivityCompat.startActivity(this, Intent(this, ChangeBoundsActivity2::class.java), activityOptions.toBundle())
    }
}