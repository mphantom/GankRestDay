package com.mphantom.forrest

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.mphantom.forrest.extension.PreferenceDelegates

/**
 * Created by wushaorong on 3/15/16.
 */
class AppPreferences(private val context: Context) {
    val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    var userName by PreferenceDelegates.string(defaultValue = "username")
    var password by PreferenceDelegates.string()
}

