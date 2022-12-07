package org.sopt.sample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sample.data.repository.AuthRepositoryImpl
import org.sopt.sample.data.repository.MusicRepositoryImpl
import org.sopt.sample.data.repository.ReqresRepositoryImpl
import org.sopt.sample.domain.repository.AuthRepository
import org.sopt.sample.domain.repository.MusicRepository
import org.sopt.sample.domain.repository.ReqresRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindToAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindToReqresRepository(repositoryImpl: ReqresRepositoryImpl): ReqresRepository

    @Binds
    @Singleton
    abstract fun bindToMusicRepository(repositoryImpl: MusicRepositoryImpl): MusicRepository
}