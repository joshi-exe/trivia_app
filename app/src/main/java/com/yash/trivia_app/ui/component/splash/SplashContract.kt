package com.yash.trivia_app.ui.component.splash

import com.yash.trivia_app.ui.base.BaseContract

/**
 * Created by Joshi on 02-12-2020.
 */
interface SplashContract {

    interface View : BaseContract.View {

        fun initUI()

        fun navigateToUserInput()

        fun finishView()

        fun navigateToHistory()
    }

    interface Presenter : BaseContract.Presenter<View> {

        fun moveToNextScreen()
    }
}