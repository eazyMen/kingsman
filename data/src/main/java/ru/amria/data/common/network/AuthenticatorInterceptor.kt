package ru.amria.data.common.network

import android.content.Context
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import ru.amria.domain.repository.SharedPrefs
import javax.inject.Inject
