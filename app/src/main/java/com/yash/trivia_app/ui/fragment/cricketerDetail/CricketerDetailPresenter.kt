package com.yash.trivia_app.ui.fragment.cricketerDetail

import com.yash.trivia_app.ui.base.BasePresenter
import com.yash.trivia_app.utils.Constants.SELECT_ONE_OPTION
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class CricketerDetailPresenter @Inject constructor() :
    BasePresenter<CricketerDetailContract.View>(),
    CricketerDetailContract.Presenter {

    override fun onCreated() {
        super.onCreated()
        getView()?.initUI()
    }

    override fun validateData(proceed: Boolean, groupId: Int) {

        if (proceed) {
            if (groupId == -1) {
                getView()?.showError(SELECT_ONE_OPTION)
                return
            } else {
                getView()?.processData(groupId, proceed)
            }
        } else {
            if (groupId != -1) {
                getView()?.processData(groupId, proceed)
            }
        }
    }
}