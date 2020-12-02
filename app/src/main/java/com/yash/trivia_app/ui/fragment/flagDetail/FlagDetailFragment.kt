package com.yash.trivia_app.ui.fragment.flagDetail

import com.yash.trivia_app.R
import com.yash.trivia_app.TriviaApp
import com.yash.trivia_app.events.OnBackEvent
import com.yash.trivia_app.extensions.launchActivity
import com.yash.trivia_app.extensions.toast
import com.yash.trivia_app.model.Game
import com.yash.trivia_app.ui.base.BaseFragment
import com.yash.trivia_app.ui.component.summary.SummaryActivity
import com.yash.trivia_app.ui.component.userInput.UserInputActivity
import com.yash.trivia_app.utils.AppUtils
import com.yash.trivia_app.utils.CacheUtils
import com.yash.trivia_app.utils.Constants.SELECT_ONE_OPTION
import kotlinx.android.synthetic.main.layout_flag_details.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * Created by Joshi on 02-12-2020.
 */
class FlagDetailFragment :
    BaseFragment<FlagDetailContract.View, FlagDetailContract.Presenter>(),
    FlagDetailContract.View, OnBackEvent {

    @Inject
    lateinit var mPresenter: FlagDetailPresenter

    override fun initUI() {
        (activity as UserInputActivity).backClick = this
    }

    override fun initPresenter() = mPresenter

    override fun injectDependencies() =
        (activity?.application as TriviaApp).applicationComponent.inject(this)

    override fun getLayoutResId() = R.layout.layout_flag_details

    override fun hideKeyboard() = AppUtils.hideKeyboard(activity!!)

    override fun showToast(toast: String) {
        activity?.toast(toast)
    }

    override fun finishView() {
        activity?.finish()
    }

    override fun onClicks() {
        btnSubmit.setOnClickListener {

            val isWhiteChecked = cbWhite.isChecked
            val isYellowChecked = cbYellow.isChecked
            val isOrangeChecked = cbOrange.isChecked
            val isGreenChecked = cbGreen.isChecked
            presenter?.validateData(
                isWhiteChecked,
                isYellowChecked,
                isOrangeChecked,
                isGreenChecked
            )
        }
    }

    override fun showError(flag: String) {
        when (flag) {
            SELECT_ONE_OPTION -> showToast(getString(R.string.select_one_option))
        }
    }

    override fun navigateToNextScreen() {
        processDateTime()
        activity?.launchActivity<SummaryActivity> { }
    }

    private fun processDateTime() {
        val sdf = SimpleDateFormat("d MMMM hh:mm aa", Locale.getDefault())
        val currentDateAndTime: String = sdf.format(Date())

        val split = currentDateAndTime.split(" ", limit = 2)
        val date = split[0]
        val rest = split[1]

        val dateWithSuffix = date + getDayOfMonthSuffix(date.toInt())
        val appendDateTime = "$dateWithSuffix $rest"

        val newGame = CacheUtils.getNewGame()
        newGame.dateTime = appendDateTime
        CacheUtils.setNewGame(newGame) // Set final game data on submit

        val list = CacheUtils.getGameLog()
        list.add(newGame)
        CacheUtils.setGameLog(list) // Save game logs on one game cycle
    }

    private fun getDayOfMonthSuffix(n: Int): String? {
        return if (n in 11..13) {
            "th"
        } else when (n % 10) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    }
}