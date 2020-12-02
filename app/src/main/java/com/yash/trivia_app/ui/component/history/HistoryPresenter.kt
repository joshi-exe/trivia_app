package com.yash.trivia_app.ui.component.history

import com.yash.trivia_app.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class HistoryPresenter @Inject constructor() : BasePresenter<HistoryContract.View>(),
    HistoryContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
    }
}