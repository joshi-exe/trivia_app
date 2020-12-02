package com.yash.trivia_app.ui.component.summary

import com.yash.trivia_app.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class SummaryPresenter @Inject constructor() : BasePresenter<SummaryContract.View>(),
    SummaryContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
    }
}