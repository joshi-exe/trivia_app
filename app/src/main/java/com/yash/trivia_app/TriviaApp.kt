package com.yash.trivia_app

import android.app.Application
import com.yash.trivia_app.di.component.ApplicationComponent
import com.yash.trivia_app.di.component.DaggerApplicationComponent
import com.yash.trivia_app.di.module.ApplicationModule

/**
 * Created by Joshi on 02-12-2020.
 */
class TriviaApp : Application() {

    val applicationComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}