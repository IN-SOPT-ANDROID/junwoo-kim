package org.sopt.sample.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.databinding.ItemHomeBinding
import org.sopt.sample.model.RepoData

class SampleAdapter(context: Context):RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {
    //class SampleAdapter():RecyclerView.Adapter<SampleViewHolder>() {
    //view에서 context를 얻어올수 있는데 왜 context를 파라미터를 통해서 받아 오네요

    private val inflater by lazy { LayoutInflater.from(context) }
    private var repoList : List<RepoData> = listOf()


    class SampleViewHolder(private val binding: ItemHomeBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(data : RepoData){
            //binding.imageView = data.img
            binding.tv1.text = data.name
            binding.tv2.text = data.des
        }
    }

    override fun getItemCount() = repoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        //val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        val binding = ItemHomeBinding.inflate(inflater ,parent,false)
        return SampleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(newdata : List<RepoData>){
        repoList = newdata.toList()
        notifyDataSetChanged()
    }

}