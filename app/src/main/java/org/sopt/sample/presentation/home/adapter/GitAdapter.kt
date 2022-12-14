package org.sopt.sample.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.Selection
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.sopt.sample.BR
import org.sopt.sample.databinding.ItemHeaderBinding
import org.sopt.sample.databinding.ItemRepoBinding
import org.sopt.sample.presentation.home.model.GitData
import org.sopt.sample.presentation.util.GitDiffUtil

class GitAdapter( // 주석들은 RecyclerView Adapter를 사용할 경우의 코드
    context: Context,
    private val itemClickListener: (GitData) -> Unit
) : ListAdapter<GitData, RecyclerView.ViewHolder>(GitDiffUtil) {
    //: RecyclerView.Adapter<ViewHolder>()
    private val inflater by lazy { LayoutInflater.from(context) }
    private lateinit var selectionTracker: SelectionTracker<Long>
    //private var repoList : List<RepoData> = listOf()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class ItemViewHolder(val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int = absoluteAdapterPosition
                override fun getSelectionKey(): Long = itemId
            }
    }

    class HeaderViewHolder(val binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> {
                HeaderViewHolder(ItemHeaderBinding.inflate(inflater, parent, false))
            }
            else -> {
                ItemViewHolder(ItemRepoBinding.inflate(inflater, parent, false))
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM -> {
                with(holder as ItemViewHolder) {
                    binding.setVariable(BR.repodata, getItem(position) as GitData)
                    binding.root.setOnClickListener {
                        selectionTracker.select(position.toLong())
                    }
                    // 코드 위치 조심!!!!!! setOnClickListener에서 select후 빠져 나온후에 isSelected
                    // 매우 중요!!!!! 여기에 두시간씀 ㅠㅠ
                    binding.selected = selectionTracker.isSelected(position.toLong())
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
        return if (item.viewType == 0) HEADER else ITEM
    }

    fun removeItem(selection: Selection<Long>) {
//        val currentList = currentList.toMutableList()
//        selection.forEach {
//            currentList.removeAt(it.toInt())
//        }
//        submitList(currentList) 해당 방법으로 할 경우 다중삭제 시에 index가 밀리는 오류가 발생함
        val currentList = currentList.toMutableList()
        val itemList = mutableListOf<GitData>()
        selection.forEach {
            itemList.add(currentList[it.toInt()])
        }
        currentList.removeAll(itemList)
        submitList(currentList)
    }

    fun setTracker(selectionTracker: SelectionTracker<Long>) {
        this.selectionTracker = selectionTracker
    }

//    @SuppressLint("NotifyDataSetChanged")
//    fun setDataList(newdata : List<RepoData>){
//        repoList = newdata.toList()
//        notifyDataSetChanged()
//    }

    override fun getItemCount() = currentList.size

    companion object {
        const val HEADER = 0
        const val ITEM = 1
    }

}