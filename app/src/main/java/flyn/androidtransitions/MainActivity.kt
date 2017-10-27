package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> startActivity(Intent(this, ShareElementActivity1::class.java))
            R.id.button2 -> startActivity(Intent(this, InterpolatorDurationStartDelayActivity1::class.java))
            R.id.button3 -> startActivity(Intent(this, CircularRevealActivity1::class.java))

        }
    }
}
