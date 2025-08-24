package ru.amria.data.fashn

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.amria.domain.repository.FashnRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class FashnModule {

    @Binds
    abstract fun languageRepository(fashnRepository: FashnRepositoryImpl): FashnRepository
}