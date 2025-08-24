package ru.amria.data.home

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.amria.data.fashn.FashnRepositoryImpl
import ru.amria.domain.home.HomeRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun homeRepository(homeRepository: HomeRepositoryImpl): HomeRepository
}