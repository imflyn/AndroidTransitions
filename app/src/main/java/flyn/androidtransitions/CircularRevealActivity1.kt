package flyn.androidtransitions

import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import kotlinx.android.synthetic.main.activity_circular_reveal1.*

class CircularRevealActivity1 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "CircularRevealActivity1"
        setContentView(R.layout.activity_circular_reveal1)

        rootView.setOnTouchListener({ _, event ->
            val i = Intent(this@CircularRevealActivity1, CircularRevealActivity2::class.java)
            i.putExtra("x", event.x)
            i.putExtra("y", event.y)
            startActivity(i)
            overridePendingTransition(0, 0)
            false
        })

        val fade = Fade()
        window.reenterTransition = fade
        window.exitTransition = fade
    }
}