package com.yash.trivia_app.ui.base

import androidx.lifecycle.LifecycleObserver
import java.lang.ref.WeakReference

/**
 * Created by Joshi on 02-12-2020.
 */
abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V>, LifecycleObserver {

    private var view: WeakReference<V>? = null

    override fun getView(): V? = view?.get()

    override fun attachView(view: V) {
        this.view = WeakReference(view)
    }

    override fun detachView() {
        view?.clear()
        view = null
    }

    override fun onCreated() = Unit

    override fun onStarted() = Unit

    override fun onResumed() = Unit

    override fun onDestroyed() = Unit

    override fun onStopped() = Unit

    override fun onPaused() = Unit
}