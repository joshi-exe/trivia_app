package com.yash.trivia_app.ui.fragment.flagDetail

import com.yash.trivia_app.ui.base.BaseContract

/**
 * Created by Joshi on 02-12-2020.
 */
interface FlagDetailContract {

    interface View : BaseContract.View {

        fun initUI()

        fun hideKeyboard()

        fun showToast(toast: String)

        fun showError(flag: String)

        fun navigateToNextScreen()

        fun finishView()
    }

    interface Presenter : BaseContract.Presenter<View> {

        fun validateData(
            isWhiteChecked: Boolean,
            isYellowChecked: Boolean,
            isOrangeChecked: Boolean,
            isGreenChecked: Boolean
        )
    }
}