package com.yash.trivia_app.ui.base

import androidx.lifecycle.ViewModel

/**
 * Created by Joshi on 02-12-2020.
 */
class BaseViewModel<V : BaseContract.View, P : BaseContract.Presenter<V>> : ViewModel() {

    var presenter: P? = null

    override fun onCleared() {
        super.onCleared()
        presenter?.onDestroyed()
        presenter = null
    }
}