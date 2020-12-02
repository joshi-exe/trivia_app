package com.yash.trivia_app.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.yash.trivia_app.TriviaApp
import io.paperdb.Paper

/**
 * Created by Joshi on 02-12-2020.
 */
abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> :
    AppCompatActivity(),
    BaseContract.View {

    protected var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Paper.init(this)
        setContentView(getLayoutResId())
        injectDependencies()

        val viewModel: BaseViewModel<V, P> =
            ViewModelProviders.of(this).get(BaseViewModel<V, P>()::class.java)

        viewModel.presenter = viewModel.presenter ?: initPresenter()

        presenter = viewModel.presenter
        presenter?.attachView(this as V)
        presenter?.onCreated()

        onClicks()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStarted()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResumed()
    }

    fun getApplicationComponent() = (application as TriviaApp).applicationComponent

    protected abstract fun initPresenter(): P

    protected abstract fun injectDependencies()

    protected abstract fun getLayoutResId(): Int

    protected abstract fun onClicks()
}