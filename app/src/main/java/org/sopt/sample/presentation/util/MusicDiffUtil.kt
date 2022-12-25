package org.sopt.sample.presentation.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import org.sopt.sample.data.model.dto.ResponseGetMusicDTO

object MusicDiffUtil : DiffUtil.ItemCallback<ResponseGetMusicDTO.MusicData>() {
    override fun areItemsTheSame(oldItem: ResponseGetMusicDTO.MusicData, newItem: ResponseGetMusicDTO.MusicData): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ResponseGetMusicDTO.MusicData, newItem: ResponseGetMusicDTO.MusicData): Boolean {
        return oldItem === newItem
    }
}