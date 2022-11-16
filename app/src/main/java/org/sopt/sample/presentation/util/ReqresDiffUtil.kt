package org.sopt.sample.presentation.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import org.sopt.sample.data.model.dto.ResponseReqresListDTO

object ReqresDiffUtil : DiffUtil.ItemCallback<ResponseReqresListDTO.Data>() {
    override fun areItemsTheSame(oldItem: ResponseReqresListDTO.Data, newItem: ResponseReqresListDTO.Data): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ResponseReqresListDTO.Data, newItem: ResponseReqresListDTO.Data): Boolean {
        return oldItem === newItem
    }
}