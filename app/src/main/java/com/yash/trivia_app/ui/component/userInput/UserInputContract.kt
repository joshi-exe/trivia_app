package com.yash.trivia_app.ui.component.userInput

import com.yash.trivia_app.ui.base.BaseContract

/**
 * Created by Joshi on 02-12-2020.
 */
interface UserInputContract {

    interface View : BaseContract.View {

        fun initUI()

        fun finishView()

        fun showToast(toast: String)

        fun hideKeyboard()
    }

    interface Presenter : BaseContract.Presenter<View>
}