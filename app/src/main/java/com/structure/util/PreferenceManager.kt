package com.structure.util

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PreferenceManager constructor(var preference: SharedPreferences) {

    fun saveString(key: String, value: String) {
        preference.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String): String? {
        return preference.getString(key, defaultValue)
    }

    fun saveDouble(key: String, value: Float) {
        preference.edit().putFloat(key, value).apply()
    }

    fun getDouble(key: String, defaultValue: Float): Float {
        return preference.getFloat(key, defaultValue)
    }

    fun saveInteger(key: String, value: Int) {
        preference.edit().putInt(key, value).apply()
    }

    fun getInteger(key: String, defaultValue: Int): Int {
        return preference.getInt(key, defaultValue)
    }

    fun saveBoolean(key: String, value: Boolean) {
        preference.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return preference.getBoolean(key, defaultValue)
    }


    fun <T> setList(key: String, list: MutableList<T>) {
        val gson = Gson()
        val json = gson.toJson(list)
        set(key, json)
    }

    fun <T> getList(key: String, tt: TypeToken<List<T>>): MutableList<T> {
        val gson = Gson()

        return gson.fromJson(preference.getString(key, "[]"), tt.type)
    }

    operator fun set(key: String, value: String) {
        val editor = preference.edit()
        editor.putString(key, value)
        editor.commit()
    }

    operator fun contains(key: String): Boolean {
        return preference.contains(key)
    }

    fun getListString(key: String): MutableList<String> {
        val gson = Gson()
        var list: MutableList<String>
        val json = preference.getString(key, "")
        val type = object : TypeToken<List<String>>() {

        }.getType()
        list = gson.fromJson(json, type)
        return list
    }

    fun getListBoolean(key: String): MutableList<Boolean> {
        val gson = Gson()
        var list: MutableList<Boolean>
        val json = preference.getString(key, "")
        val type = object : TypeToken<MutableList<Boolean>>() {}.type
        list = gson.fromJson(json, type)
        return list
    }

    fun <T> saveObject(key: String, y: T) {
        val value = Gson().toJson(y)
        preference.edit().putString(key, value).apply()
    }

    fun <T> getObject(key: String, c: Class<T>): T? {
        //We read JSON String which was saved.
        val value = preference.getString(key, null)
        return Gson().fromJson(value, c)
    }
}
