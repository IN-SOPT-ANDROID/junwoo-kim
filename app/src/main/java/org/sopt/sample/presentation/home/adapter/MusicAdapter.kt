package org.sopt.sample.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.BR
import org.sopt.sample.data.model.dto.ResponseGetMusicDTO
import org.sopt.sample.databinding.ItemMusicBinding
import org.sopt.sample.presentation.util.MusicDiffUtil

class MusicAdapter(context: Context) :
    ListAdapter<ResponseGetMusicDTO.MusicData, RecyclerView.ViewHolder>(MusicDiffUtil) {

    private val inflater by lazy { LayoutInflater.from(context) }

    class ItemViewHolder(val binding: ItemMusicBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(ItemMusicBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as ItemViewHolder) {
            binding.setVariable(BR.music, getItem(position) as ResponseGetMusicDTO.MusicData)
        }
    }

    override fun getItemCount() = currentList.size

}

