package org.sopt.sample.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.BR
import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import org.sopt.sample.databinding.ItemReqresBinding
import org.sopt.sample.presentation.util.ReqresDiffUtil

class ReqresListAdapter(context: Context) :
    ListAdapter<ResponseReqresListDTO.Data, RecyclerView.ViewHolder>(ReqresDiffUtil) {

    private val inflater by lazy { LayoutInflater.from(context) }

    class ItemViewHolder(val binding: ItemReqresBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(ItemReqresBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as ItemViewHolder) {
            binding.setVariable(BR.reqres, getItem(position) as ResponseReqresListDTO.Data)
        }
    }
    override fun getItemCount() = currentList.size

}

