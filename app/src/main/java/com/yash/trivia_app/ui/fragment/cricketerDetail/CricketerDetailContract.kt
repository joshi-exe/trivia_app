package com.yash.trivia_app.ui.fragment.cricketerDetail

import com.yash.trivia_app.ui.base.BaseContract

/**
 * Created by Joshi on 02-12-2020.
 */
interface CricketerDetailContract {

    interface View : BaseContract.View {

        fun initUI()

        fun hideKeyboard()

        fun showToast(toast: String)

        fun navigateToNextFragment()

        fun showError(flag: String)

        fun processData(id: Int, proceed: Boolean)
    }

    interface Presenter : BaseContract.Presenter<View> {

        fun validateData(proceed: Boolean, groupId: Int)
    }
}