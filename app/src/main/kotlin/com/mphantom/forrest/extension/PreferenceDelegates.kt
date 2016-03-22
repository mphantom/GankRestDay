package com.mphantom.forrest.extension

import com.mphantom.forrest.AppPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by wushaorong on 3/15/16.
 */
object PreferenceDelegates {
    public fun string(defaultValue: String? = null): ReadWriteProperty<AppPreferences, String?> {
        return PrefString(defaultValue)
    }
}

private class PrefString(private val defaultValue: String?) : ReadWriteProperty<AppPreferences, String?> {
    override fun getValue(thisRef: AppPreferences, property: KProperty<*>): String? {
        return thisRef.preferences.getString(property.name, defaultValue)
    }

    override fun setValue(thisRef: AppPreferences, property: KProperty<*>, value: String?) {
        thisRef.preferences.edit().putString(property.name, value).apply()
    }
}