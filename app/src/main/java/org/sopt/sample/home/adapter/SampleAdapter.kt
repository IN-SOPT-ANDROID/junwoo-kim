package org.sopt.sample.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.databinding.ItemHomeBinding
import org.sopt.sample.model.RepoData

class SampleAdapter(context:Context):RecyclerView.Adapter<SampleViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var repoList : List<RepoData> = listOf()

    override fun getItemCount() = repoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val binding = ItemHomeBinding.inflate(inflater, parent,false)
        return SampleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    fun setDataList(newdata : List<RepoData>){
        repoList = newdata.toList()
    }

}