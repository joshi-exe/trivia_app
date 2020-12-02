package com.yash.trivia_app.ui.component.userInput

import android.view.MenuItem
import com.yash.trivia_app.R
import com.yash.trivia_app.events.OnBackEvent
import com.yash.trivia_app.extensions.replaceFragment
import com.yash.trivia_app.model.Game
import com.yash.trivia_app.ui.base.BaseActivity
import com.yash.trivia_app.ui.fragment.cricketerDetail.CricketerDetailFragment
import com.yash.trivia_app.ui.fragment.flagDetail.FlagDetailFragment
import com.yash.trivia_app.ui.fragment.userDetail.UserDetailFragment
import com.yash.trivia_app.utils.AppUtils
import com.yash.trivia_app.utils.CacheUtils
import com.yash.trivia_app.utils.Constants.USER_DETAIL_FRAGMENT
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class UserInputActivity : BaseActivity<UserInputContract.View, UserInputContract.Presenter>(),
    UserInputContract.View {

    @Inject
    lateinit var mPresenter: UserInputPresenter

    var backClick: OnBackEvent? = null

    override fun initUI() {
        CacheUtils.setNewGame(Game())   //clear cache
        supportActionBar!!.hide()
        replaceFragment(UserDetailFragment(), R.id.content, USER_DETAIL_FRAGMENT)
    }

    override fun initPresenter() = mPresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId() = R.layout.layout_container

    override fun finishView() = finish()

    override fun showToast(toast: String) = AppUtils.showShortToast(this, toast)

    override fun hideKeyboard() = AppUtils.hideKeyboard(this)

    override fun onClicks() = Unit

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        when (supportFragmentManager.findFragmentById(R.id.content)) {

            is UserDetailFragment -> {
                backClick?.onBackClickedInUserDetailsFragment()
            }

            is CricketerDetailFragment -> {
                backClick?.onBackClickedInCricketerFragment()
            }

            is FlagDetailFragment -> {
                backClick?.onBackClickedInFlagFragment()
            }
        }

        super.onBackPressed()
    }
}