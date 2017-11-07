package flyn.androidtransitions

import android.os.Bundle
import android.view.View
import flyn.androidtransitions.animation.ChangeColor
import kotlinx.android.synthetic.main.activity_change_bounds2.*

class ChangeColorActivity2 : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeColorActivity2"
        setContentView(R.layout.activity_change_color_2)

        val changeColor = ChangeColor()
        changeColor.duration = 2000

        window.sharedElementEnterTransition = changeColor
        window.enterTransition = null

        window.sharedElementReturnTransition = changeColor
        window.returnTransition = null


        textView1.setOnClickListener(this)
        textView2.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        finishAfterTransition()
    }
}