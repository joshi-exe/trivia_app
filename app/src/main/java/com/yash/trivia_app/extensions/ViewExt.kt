package com.yash.trivia_app.extensions

import android.view.View

/**
 * Created by Joshi on 03-12-2020.
 */
var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }
