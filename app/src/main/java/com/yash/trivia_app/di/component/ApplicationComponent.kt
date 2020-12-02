package com.yash.trivia_app.di.component

import com.yash.trivia_app.di.module.ApplicationModule
import com.yash.trivia_app.di.scope.ApplicationScope
import com.yash.trivia_app.ui.component.history.HistoryActivity
import com.yash.trivia_app.ui.component.splash.SplashActivity
import com.yash.trivia_app.ui.component.summary.SummaryActivity
import com.yash.trivia_app.ui.component.userInput.UserInputActivity
import com.yash.trivia_app.ui.fragment.cricketerDetail.CricketerDetailFragment
import com.yash.trivia_app.ui.fragment.flagDetail.FlagDetailFragment
import com.yash.trivia_app.ui.fragment.userDetail.UserDetailFragment
import dagger.Component

/**
 * Created by Joshi on 02-12-2020.
 */
@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(splashActivity: SplashActivity)
    fun inject(userInputActivity: UserInputActivity)
    fun inject(userDetailFragment: UserDetailFragment)
    fun inject(cricketerDetailFragment: CricketerDetailFragment)
    fun inject(flagDetailFragment: FlagDetailFragment)
    fun inject(summaryActivity: SummaryActivity)
    fun inject(historyActivity: HistoryActivity)
}