package org.sopt.sample.data.repository

import org.sopt.sample.data.datasource.MusicService
import org.sopt.sample.data.model.dto.ResponseGetMusicDTO
import org.sopt.sample.domain.repository.MusicRepository
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val musicService: MusicService
) : MusicRepository {
    override suspend fun getMusicList(): ResponseGetMusicDTO {
        return musicService.getMusicList()
    }
}