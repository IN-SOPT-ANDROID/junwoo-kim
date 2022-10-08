package org.sopt.sample.home.adapter

import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.databinding.ItemHomeBinding
import org.sopt.sample.model.RepoData

class SampleViewHolder(private val binding: ItemHomeBinding):RecyclerView.ViewHolder(binding.root)
{
    fun onBind(data : RepoData){
        //binding.imageView = data.img
        binding.tv1.text = data.name
        binding.tv2.text = data.des
    }
}