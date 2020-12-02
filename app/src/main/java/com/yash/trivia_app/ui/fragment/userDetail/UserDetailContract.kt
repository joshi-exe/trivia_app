package com.yash.trivia_app.ui.fragment.userDetail

import com.yash.trivia_app.ui.base.BaseContract

/**
 * Created by Joshi on 02-12-2020.
 */
interface UserDetailContract {

    interface View : BaseContract.View {

        fun initUI()

        fun hideKeyboard()

        fun showToast(toast: String)

        fun navigateToNextFragment()

        fun showError(flag: String)
    }

    interface Presenter : BaseContract.Presenter<View> {

        fun validateAndProceed(username: String)
    }
}