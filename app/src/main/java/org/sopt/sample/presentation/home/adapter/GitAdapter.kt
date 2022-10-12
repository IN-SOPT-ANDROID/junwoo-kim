package org.sopt.sample.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.sopt.sample.databinding.ItemHeaderBinding
import org.sopt.sample.databinding.ItemHomeBinding
import org.sopt.sample.presentation.home.model.GitData
import org.sopt.sample.presentation.util.GitDiffUtil

class GitAdapter(context: Context)
    : ListAdapter<GitData,RecyclerView.ViewHolder>(GitDiffUtil) {
    //: RecyclerView.Adapter<ViewHolder>()
    private val inflater by lazy { LayoutInflater.from(context) }
    //private var repoList : List<RepoData> = listOf()


    class ItemViewHolder(private val binding: ItemHomeBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(data : GitData){
            //binding.imageView = data.img
            binding.tv1.text = data.name
            binding.tv2.text = data.des
        }
    }

    class HeaderViewHolder(private val binding: ItemHeaderBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(data: GitData){
            binding.tvHeader.text = data.name
        }
    }


    //override fun getItemCount() = repoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            HEADER ->{
                HeaderViewHolder(ItemHeaderBinding.inflate(inflater,parent,false))
            }
            else ->{
               ItemViewHolder(ItemHomeBinding.inflate(inflater,parent,false))
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder.itemViewType){
            ITEM ->{
                (holder as ItemViewHolder).onBind(getItem(position))
                //(holder as ItemViewHolder).onBind(repoList[position])

            }
            HEADER ->{
                (holder as HeaderViewHolder).onBind(getItem(position))
                //(holder as HeaderViewHolder).onBind(repoList[position])

            }
            }
        }


    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        //val item = repoList[position]
        return if (item.viewtype == 0) HEADER else ITEM
    }

//    @SuppressLint("NotifyDataSetChanged")
//    fun setDataList(newdata : List<RepoData>){
//        repoList = newdata.toList()
//        notifyDataSetChanged()
//    }

    companion object {
        const val HEADER = 1
        const val ITEM = 2
    }


}