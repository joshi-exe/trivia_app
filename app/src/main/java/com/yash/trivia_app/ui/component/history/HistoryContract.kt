package com.yash.trivia_app.ui.component.history

import com.yash.trivia_app.ui.base.BaseContract

/**
 * Created by Joshi on 02-12-2020.
 */
interface HistoryContract {

    interface View : BaseContract.View {

        fun initUI()

        fun finishView()
    }

    interface Presenter : BaseContract.Presenter<View>
}