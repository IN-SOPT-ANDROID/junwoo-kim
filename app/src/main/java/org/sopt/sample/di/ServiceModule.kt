package org.sopt.sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sample.data.datasource.AuthService
import org.sopt.sample.data.datasource.MusicService
import org.sopt.sample.data.datasource.ReqresApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideLoginService(@RemoteDataSourceModule.AuthRetrofit authService: Retrofit): AuthService {
        return authService.create(AuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideReqresService(@RemoteDataSourceModule.ReqresRetrofit reqresService: Retrofit): ReqresApi {
        return reqresService.create(ReqresApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMusicService(@RemoteDataSourceModule.MusicRetrofit musicService: Retrofit): MusicService {
        return musicService.create(MusicService::class.java)
    }

}