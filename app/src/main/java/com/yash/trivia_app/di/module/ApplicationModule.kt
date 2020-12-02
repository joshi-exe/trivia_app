package com.yash.trivia_app.di.module

import android.app.Application
import android.content.Context
import com.yash.trivia_app.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Joshi on 02-12-2020.
 */
@Module
class ApplicationModule(private val application: Application) {

    @ApplicationScope
    @Provides
    fun providesApplicationContext(): Context = application.applicationContext
}