package com.jsrdxzw.github.common

import android.content.Context
import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PreferenceDelegate<T>(
    private val context: Context,
    val name: String,
    private val default: T,
    private val prefName: String = "default"
) : ReadWriteProperty<Any?, T> {

    private val prefs by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }


    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun putPreference(name: String, value: T) {
        with(prefs) {
            when (value) {
                is Long -> edit().putLong(name, value)
                is Int -> edit().putInt(name, value)
                is Boolean -> edit().putBoolean(name, value)
                is String -> edit().putString(name, value)
                is Float -> edit().putFloat(name, value)
                else -> throw IllegalArgumentException("Unsupported type.")
            }.apply()
        }
    }

    private fun findPreference(key: String): T {
        with(prefs) {
            return when (default) {
                is Long -> getLong(key, default)
                is Int -> getInt(name, default)
                is Boolean -> getBoolean(name, default)
                is String -> getString(name, default)
                is Float -> getFloat(name, default)
                else -> throw IllegalArgumentException("Unsupported type.")
            } as T
        }

    }

}

