package com.yash.trivia_app.ui.fragment.userDetail

import com.yash.trivia_app.R
import com.yash.trivia_app.TriviaApp
import com.yash.trivia_app.events.OnBackEvent
import com.yash.trivia_app.extensions.addFragment
import com.yash.trivia_app.extensions.toast
import com.yash.trivia_app.ui.base.BaseFragment
import com.yash.trivia_app.ui.component.userInput.UserInputActivity
import com.yash.trivia_app.ui.fragment.cricketerDetail.CricketerDetailFragment
import com.yash.trivia_app.utils.AppUtils
import com.yash.trivia_app.utils.Constants.USERNAME
import kotlinx.android.synthetic.main.layout_user_details.*
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class UserDetailFragment : BaseFragment<UserDetailContract.View, UserDetailContract.Presenter>(),
    UserDetailContract.View, OnBackEvent {

    @Inject
    lateinit var mPresenter: UserDetailPresenter

    override fun initUI() {
        (activity as UserInputActivity).backClick = this
    }

    override fun initPresenter() = mPresenter

    override fun injectDependencies() =
        (activity?.application as TriviaApp).applicationComponent.inject(this)

    override fun getLayoutResId() = R.layout.layout_user_details

    override fun hideKeyboard() = AppUtils.hideKeyboard(activity!!)

    override fun showToast(toast: String) {
        activity?.toast(toast)
    }

    override fun onClicks() {

        btnNext.setOnClickListener {
            hideKeyboard()
            val username = etUserName.text.toString().trim()
            presenter?.validateAndProceed(username)
        }
    }

    override fun showError(flag: String) {

        when (flag) {
            USERNAME -> {
                etUserName.requestFocus()
                etUserName.error = getString(R.string.enter_valid_name)
            }
        }
    }

    override fun navigateToNextFragment() {
        (activity as UserInputActivity).addFragment(
            CricketerDetailFragment(),
            R.id.content,
            this,
            1
        )
    }
}