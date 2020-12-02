package com.yash.trivia_app.ui.component.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yash.trivia_app.R
import com.yash.trivia_app.model.Game
import kotlinx.android.synthetic.main.list_item_history.view.*

/**
 * Created by Joshi on 03-12-2020.
 */
class HistoryAdapter(list: List<Game>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mList: List<Game> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_history, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mList.size

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bindItems(mList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindItems(gameData: Game) = with(itemView) {

            val gameText = context.getString(R.string.game)
            tvGameId.text = "$gameText ${gameData.id}"
            tvDateTime.text = gameData.dateTime
            tvUserName.text = gameData.userName
            tvAnswerCricketer.text = gameData.bestCricketer
            tvAnswerFlag.text = gameData.colorsInFlag

        }
    }
}