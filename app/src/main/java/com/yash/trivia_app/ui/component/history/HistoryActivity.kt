package com.yash.trivia_app.ui.component.history

import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.yash.trivia_app.R
import com.yash.trivia_app.extensions.visible
import com.yash.trivia_app.model.Game
import com.yash.trivia_app.ui.base.BaseActivity
import com.yash.trivia_app.utils.CacheUtils
import kotlinx.android.synthetic.main.layout_history.*
import javax.inject.Inject

/**
 * Created by Joshi on 02-12-2020.
 */
class HistoryActivity : BaseActivity<HistoryContract.View, HistoryContract.Presenter>(),
    HistoryContract.View {

    @Inject
    lateinit var mPresenter: HistoryPresenter

    override fun initUI() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        showNoData()

        val gameLog = CacheUtils.getGameLog()
        if (!gameLog.isNullOrEmpty()) {
            setToAdapter(gameLog)
        } else {
            showNoData()
        }
    }

    override fun initPresenter() = mPresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId() = R.layout.layout_history

    override fun finishView() = finish()

    override fun onClicks() = Unit

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun setToAdapter(it: List<Game>) {
        rcvGameLog.visible = true
        tvNoData.visible = false
        rcvGameLog.layoutManager = LinearLayoutManager(this)
        val adapter = HistoryAdapter(it)
        rcvGameLog.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun showNoData() {
        rcvGameLog.visible = false
        tvNoData.visible = true
    }
}