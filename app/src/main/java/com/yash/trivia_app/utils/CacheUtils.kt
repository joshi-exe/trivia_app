package com.yash.trivia_app.utils

import com.yash.trivia_app.model.Game
import io.paperdb.Paper

/**
 * Created by Joshi on 02-12-2020.
 */
object CacheUtils {

    private lateinit var newGame: Game

    fun getGameLog(): ArrayList<Game> {
        return Paper.book().read<ArrayList<Game>>(Constants.KEY_USER) ?: arrayListOf()
    }

    fun setGameLog(gameLog: ArrayList<Game>?) {
        Paper.book().write(Constants.KEY_USER, gameLog)
    }

    fun setNewGame(newGame: Game) {
        this.newGame = newGame
    }

    fun getNewGame(): Game {
        return if (::newGame.isInitialized) {
            newGame
        } else Game()
    }
}