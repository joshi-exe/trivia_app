package com.yash.trivia_app.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

/**
 * Created by Joshi on 02-12-2020.
 */
object AppUtils {

    fun showShortToast(context: Context, message: String) =
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    fun showLongToast(context: Context, message: String) =
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    fun hideKeyboard(activity: Activity) {
        val view = activity.currentFocus
        if (view != null) {
            val inputMethodManager =
                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            inputMethodManager!!.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}