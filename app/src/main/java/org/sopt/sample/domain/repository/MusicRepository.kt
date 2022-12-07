package org.sopt.sample.domain.repository

import org.sopt.sample.data.model.dto.ResponseGetMusicDTO

interface MusicRepository {
    suspend fun getMusicList(): ResponseGetMusicDTO
}