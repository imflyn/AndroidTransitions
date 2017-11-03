package flyn.androidtransitions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.*
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_change_image_transform2.*

class ChangeImageTransformActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeImageTransformActivity2"
        setContentView(R.layout.activity_change_image_transform2)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fade = Fade()
        fade.duration = 700
        fade.addTarget(textView)
        window.enterTransition = fade
        window.returnTransition = fade

        val changeImageTransform = ChangeImageTransform()
        val changeBounds = ChangeBounds()
        val changeClipBounds = ChangeClipBounds()
        val transition = TransitionSet()
        transition.addTransition(changeImageTransform)
        transition.addTransition(changeBounds)
        transition.addTransition(changeClipBounds)
        transition.duration = 700
        transition.excludeTarget(android.R.id.statusBarBackground, false)
        transition.excludeTarget(android.R.id.navigationBarBackground, false)

        window.sharedElementEnterTransition = transition
        window.sharedElementReturnTransition = transition

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> supportFinishAfterTransition()
        }
        return super.onOptionsItemSelected(item)
    }

}