package com.yash.trivia_app.ui.fragment.userDetail

import com.yash.trivia_app.ui.base.BasePresenter
import com.yash.trivia_app.utils.CacheUtils
import com.yash.trivia_app.utils.Constants.USERNAME
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class UserDetailPresenter @Inject constructor() : BasePresenter<UserDetailContract.View>(),
    UserDetailContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
    }

    override fun validateAndProceed(username: String) {

        if (username.isEmpty()) {
            getView()?.showError(USERNAME)
            return
        }

        val newGame = CacheUtils.getNewGame()
        val gameLog = CacheUtils.getGameLog()
        newGame.id = gameLog.size + 1
        newGame.userName = username
        CacheUtils.setNewGame(newGame)
        getView()?.navigateToNextFragment()
    }
}