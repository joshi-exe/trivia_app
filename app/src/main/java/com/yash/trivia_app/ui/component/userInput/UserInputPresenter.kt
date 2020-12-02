package com.yash.trivia_app.ui.component.userInput

import com.yash.trivia_app.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class UserInputPresenter @Inject constructor() : BasePresenter<UserInputContract.View>(),
    UserInputContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
    }
}