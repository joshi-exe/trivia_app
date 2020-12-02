package com.yash.trivia_app.ui.component.summary

import android.view.MenuItem
import com.yash.trivia_app.R
import com.yash.trivia_app.extensions.launchActivity
import com.yash.trivia_app.ui.base.BaseActivity
import com.yash.trivia_app.ui.component.history.HistoryActivity
import com.yash.trivia_app.ui.component.userInput.UserInputActivity
import com.yash.trivia_app.utils.AppUtils
import com.yash.trivia_app.utils.CacheUtils
import kotlinx.android.synthetic.main.layout_summary.*
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class SummaryActivity : BaseActivity<SummaryContract.View, SummaryContract.Presenter>(),
    SummaryContract.View {

    @Inject
    lateinit var mPresenter: SummaryPresenter

    override fun initUI() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setUI()
    }

    override fun initPresenter() = mPresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId() = R.layout.layout_summary

    override fun finishView() = finish()

    override fun showToast(toast: String) = AppUtils.showShortToast(this, toast)

    override fun onClicks() {

        btnHistory.setOnClickListener {
            launchActivity<HistoryActivity> { }
        }

        btnFinish.setOnClickListener {
            launchActivity<UserInputActivity> { }
            finishView()
            finishAffinity()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun setUI() {
        val newGame = CacheUtils.getNewGame()

        tvUserName.text = tvUserName.text.toString().trim() + " " + newGame.userName + ","
        tvBestCricketer.text = newGame.bestCricketer
        tvAnswerFlag.text = newGame.colorsInFlag
    }
}