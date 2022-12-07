package org.sopt.sample.domain.repository

import org.sopt.sample.data.model.dto.ResponseMusicDTO

interface MusicRepository {
    suspend fun getMusicList(): ResponseMusicDTO
}