package ru.amria.data.common.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.amria.domain.repository.SharedPrefs
import javax.inject.Inject

class SharedPrefsImpl @Inject constructor(@ApplicationContext private val context: Context): SharedPrefs {
    private val PREFS_NAME = "KINGSMAN_PREFS"
    private val ACCESS_TOKEN = "ACCESS_TOKEN"
    private val REFRESH_TOKEN = "REFRESH_TOKEN"
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun setTokens(accessToken: String, refreshToken: String){
        prefs.edit { putString(ACCESS_TOKEN, accessToken) }
        prefs.edit { putString(REFRESH_TOKEN, refreshToken) }
    }

    override fun getAccessToken(): String? {
        return prefs.getString(ACCESS_TOKEN, null)
    }

    override fun getRefreshToken(): String? {
        return prefs.getString(REFRESH_TOKEN, null)
    }

}