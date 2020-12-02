package com.yash.trivia_app.ui.component.summary

import com.yash.trivia_app.ui.base.BaseContract

/**
 * Created by Joshi on 02-12-2020.
 */
interface SummaryContract {

    interface View : BaseContract.View {

        fun initUI()

        fun finishView()

        fun showToast(toast: String)
    }

    interface Presenter : BaseContract.Presenter<View>
}