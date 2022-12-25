package org.sopt.sample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sample.data.repository.AuthRepositoryImpl
import org.sopt.sample.data.repository.MusicRepositoryImpl
import org.sopt.sample.data.repository.ReqresRepositoryImpl
import org.sopt.sample.data.repository.SharedPrefRepositoryImpl
import org.sopt.sample.domain.repository.AuthRepository
import org.sopt.sample.domain.repository.MusicRepository
import org.sopt.sample.domain.repository.ReqresRepository
import org.sopt.sample.domain.repository.SharedPrefRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindToAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindToReqresRepository(reqresRepositoryImpl: ReqresRepositoryImpl): ReqresRepository

    @Binds
    @Singleton
    abstract fun bindToMusicRepository(musicRepositoryImpl: MusicRepositoryImpl): MusicRepository

    @Binds
    @Singleton
    abstract fun bindToSharedPrefRepository(sharedPrefRepositoryImpl: SharedPrefRepositoryImpl): SharedPrefRepository
}