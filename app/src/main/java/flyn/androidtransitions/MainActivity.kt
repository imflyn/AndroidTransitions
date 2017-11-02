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
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> startActivity(Intent(this, ShareElementActivity1::class.java))
            R.id.button2 -> startActivity(Intent(this, SlideActivity1::class.java))
            R.id.button3 -> startActivity(Intent(this, CircularRevealActivity1::class.java))
            R.id.button4 -> startActivity(Intent(this, PathMotionActivity1::class.java))
            R.id.button5 -> startActivity(Intent(this, ExplodeActivity1::class.java))
            R.id.button6 -> startActivity(Intent(this, ChangeBoundsActivity1::class.java))

        }
    }
}
