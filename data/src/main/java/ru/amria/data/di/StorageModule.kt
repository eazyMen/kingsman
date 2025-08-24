package ru.amria.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.amria.data.common.storage.SharedPrefsImpl
import ru.amria.domain.repository.SharedPrefs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    @Singleton
    abstract fun provideStorage(sharedPrefsImpl: SharedPrefsImpl): SharedPrefs
}