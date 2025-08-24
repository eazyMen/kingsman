package ru.amria.domain.repository

interface SharedPrefs {
    fun setTokens(accessToken: String, refreshToken: String)
    fun getAccessToken(): String?
    fun getRefreshToken(): String?
}