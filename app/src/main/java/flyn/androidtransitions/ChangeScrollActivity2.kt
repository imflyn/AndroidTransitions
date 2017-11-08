package flyn.androidtransitions

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.transition.ChangeScroll

@RequiresApi(Build.VERSION_CODES.M)
class ChangeScrollActivity2 : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "ChangeScrollActivity2"
        setContentView(R.layout.activity_change_scroll2)


        val changeScroll = ChangeScroll()
        changeScroll.duration = 2000

        window.sharedElementEnterTransition = changeScroll
        window.enterTransition = null

        window.sharedElementReturnTransition = changeScroll
        window.returnTransition = null

    }
}