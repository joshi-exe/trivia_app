package com.yash.trivia_app.ui.component.splash

import android.os.Handler
import com.yash.trivia_app.R
import com.yash.trivia_app.extensions.launchActivity
import com.yash.trivia_app.ui.base.BaseActivity
import com.yash.trivia_app.ui.component.history.HistoryActivity
import com.yash.trivia_app.ui.component.userInput.UserInputActivity
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class SplashActivity : BaseActivity<SplashContract.View, SplashContract.Presenter>(),
    SplashContract.View {

    @Inject
    lateinit var mPresenter: SplashPresenter

    private var mDelayHandler: Handler? = null

    override fun initUI() {
        supportActionBar!!.hide()
        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, 1500)
    }

    override fun initPresenter() = mPresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId() = R.layout.activity_splash

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) presenter?.moveToNextScreen()
    }

    override fun navigateToHistory() = launchActivity<HistoryActivity> { }

    override fun navigateToUserInput() = launchActivity<UserInputActivity> { }

    override fun finishView() = finish()

    override fun onDestroy() {
        if (mDelayHandler != null) mDelayHandler!!.removeCallbacks(mRunnable)
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (mDelayHandler != null) mDelayHandler!!.removeCallbacks(mRunnable)
        super.onBackPressed()
    }

    override fun onClicks() = Unit
}