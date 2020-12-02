package com.yash.trivia_app.ui.component.splash

import com.yash.trivia_app.ui.base.BasePresenter
import com.yash.trivia_app.utils.CacheUtils
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class SplashPresenter @Inject constructor() : BasePresenter<SplashContract.View>(),
    SplashContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
    }

    override fun moveToNextScreen() {

        /**
         *
         * Was initially planning to load the game history
         * if it exist and redirect to input if not
         *
         * Decided to drop it later and basically launch the
         * basic game on every app launch
         *
         * */
        /*val gameLog = CacheUtils.getGameLog()
        if (gameLog.isNullOrEmpty()) {
            getView()?.navigateToUserInput()
        } else {
            getView()?.navigateToHistory()
        }*/

        getView()?.navigateToUserInput()
        getView()?.finishView()
    }
}