package org.sopt.sample.presentation.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import org.sopt.sample.presentation.home.model.GitData

object GitDiffUtil : DiffUtil.ItemCallback<GitData>() {
    override fun areItemsTheSame(oldItem: GitData, newItem: GitData): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GitData, newItem: GitData): Boolean {
        return oldItem === newItem
    }
}

