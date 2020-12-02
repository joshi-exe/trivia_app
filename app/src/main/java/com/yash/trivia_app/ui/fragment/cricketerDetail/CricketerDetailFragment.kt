package com.yash.trivia_app.ui.fragment.cricketerDetail

import android.widget.RadioButton
import com.yash.trivia_app.R
import com.yash.trivia_app.TriviaApp
import com.yash.trivia_app.events.OnBackEvent
import com.yash.trivia_app.extensions.addFragment
import com.yash.trivia_app.extensions.toast
import com.yash.trivia_app.ui.base.BaseFragment
import com.yash.trivia_app.ui.component.userInput.UserInputActivity
import com.yash.trivia_app.ui.fragment.flagDetail.FlagDetailFragment
import com.yash.trivia_app.utils.AppUtils
import com.yash.trivia_app.utils.CacheUtils
import com.yash.trivia_app.utils.Constants.SELECT_ONE_OPTION
import kotlinx.android.synthetic.main.layout_cricketer_details.*
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class CricketerDetailFragment :
    BaseFragment<CricketerDetailContract.View, CricketerDetailContract.Presenter>(),
    CricketerDetailContract.View, OnBackEvent {

    @Inject
    lateinit var mPresenter: CricketerDetailPresenter

    override fun initUI() {
        (activity as UserInputActivity).backClick = this
    }

    override fun onResume() {
        setUI()
        super.onResume()
    }

    override fun initPresenter() = mPresenter

    override fun injectDependencies() =
        (activity?.application as TriviaApp).applicationComponent.inject(this)

    override fun getLayoutResId() = R.layout.layout_cricketer_details

    override fun hideKeyboard() = AppUtils.hideKeyboard(activity!!)

    override fun showToast(toast: String) {
        activity?.toast(toast)
    }

    private fun setUI() {
        val newGame = CacheUtils.getNewGame()
        if (!newGame.bestCricketer.isNullOrEmpty()) {
            when (newGame.bestCricketer) {
                getString(R.string.sachin_tendulkar) -> rbSachin.isChecked = true
                getString(R.string.virat_kohli) -> rbVirat.isChecked = true
                getString(R.string.adam_gilchrist) -> rbGilchrist.isChecked = true
                getString(R.string.jacques_kallis) -> rbKallis.isChecked = true
            }
        }
    }

    override fun onBackClickedInCricketerFragment() {
        validate(false)
    }

    override fun onClicks() {
        btnNext.setOnClickListener {
            validate(true)
        }
    }

    override fun navigateToNextFragment() {
        (activity as UserInputActivity).addFragment(
            FlagDetailFragment(),
            R.id.content,
            this,
            2
        )
    }

    private fun validate(proceed: Boolean) {
        val checkedRadioButtonId = rgCricketers.checkedRadioButtonId
        presenter?.validateData(proceed, checkedRadioButtonId)
    }

    override fun showError(flag: String) {
        when (flag) {
            SELECT_ONE_OPTION -> showToast(getString(R.string.select_one_option))
        }
    }

    override fun processData(id: Int, proceed: Boolean) {
        val newGame = CacheUtils.getNewGame()
        val selectedRadioButton = view?.findViewById(id) as RadioButton
        newGame.bestCricketer = selectedRadioButton.text.toString().trim()
        CacheUtils.setNewGame(newGame)

        if (proceed) navigateToNextFragment()
    }
}