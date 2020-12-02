package com.yash.trivia_app.ui.fragment.flagDetail

import android.content.Context
import com.yash.trivia_app.R
import com.yash.trivia_app.ui.base.BasePresenter
import com.yash.trivia_app.utils.CacheUtils
import com.yash.trivia_app.utils.Constants.SELECT_ONE_OPTION
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class FlagDetailPresenter @Inject constructor(private val context: Context) :
    BasePresenter<FlagDetailContract.View>(),
    FlagDetailContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
    }

    override fun validateData(
        isWhiteChecked: Boolean,
        isYellowChecked: Boolean,
        isOrangeChecked: Boolean,
        isGreenChecked: Boolean
    ) {
        if (!isWhiteChecked && !isYellowChecked &&
            !isOrangeChecked && !isGreenChecked
        ) {
            getView()?.showError(SELECT_ONE_OPTION)
            return
        } else {
            var appendString = ""

            if (isWhiteChecked) appendString += context.getString(R.string.white)

            if (isYellowChecked) {
                appendString += if (appendString.isEmpty()) {
                    context.getString(R.string.yellow)
                } else {
                    ", " + context.getString(R.string.yellow)
                }
            }

            if (isOrangeChecked) {
                appendString += if (appendString.isEmpty()) {
                    context.getString(R.string.orange)
                } else {
                    ", " + context.getString(R.string.orange)
                }
            }

            if (isGreenChecked) {
                appendString += if (appendString.isEmpty()) {
                    context.getString(R.string.green)
                } else {
                    ", " + context.getString(R.string.green)
                }
            }

            val newGame = CacheUtils.getNewGame()
            newGame.colorsInFlag = appendString
            CacheUtils.setNewGame(newGame)
            getView()?.navigateToNextScreen()
            getView()?.finishView()
        }
    }
}