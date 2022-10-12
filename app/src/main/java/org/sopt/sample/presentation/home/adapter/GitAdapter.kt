package org.sopt.sample.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.sopt.sample.BR
import org.sopt.sample.databinding.ItemHeaderBinding
import org.sopt.sample.databinding.ItemHomeBinding
import org.sopt.sample.presentation.home.model.GitData
import org.sopt.sample.presentation.util.GitDiffUtil

class GitAdapter(
    context: Context,
    private val itemClickListener: (GitData) -> Unit
) : ListAdapter<GitData, RecyclerView.ViewHolder>(GitDiffUtil) {
    //: RecyclerView.Adapter<ViewHolder>()
    private val inflater by lazy { LayoutInflater.from(context) }

    //private var repoList : List<RepoData> = listOf()
    init {
        setHasStableIds(true)
    }

    class ItemViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun onBind(data: GitData) {
//            binding.repodata = data
//        }

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int = position
                override fun getSelectionKey(): Long? = itemId
            }

    }


    class HeaderViewHolder(val binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root)
//    {
//        fun onBind(data: GitData) {
//            binding.header = data
//        }
//    }

    //override fun getItemCount() = repoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> {
                HeaderViewHolder(ItemHeaderBinding.inflate(inflater, parent, false))
            }
            else -> {
                ItemViewHolder(ItemHomeBinding.inflate(inflater, parent, false))
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM -> {
                with(holder as ItemViewHolder) {
                    binding.setVariable(BR.repodata, getItem(position) as GitData)
                    binding.root.setOnClickListener { itemClickListener(getItem(position) as GitData) }
                }
                //(holder as ItemViewHolder).onBind(repoList[position])
            }
            HEADER -> {
                (holder as HeaderViewHolder).binding.setVariable(BR.header, getItem(position))
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