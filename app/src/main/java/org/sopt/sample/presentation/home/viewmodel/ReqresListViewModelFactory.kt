package org.sopt.sample.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.sample.data.repository.ReqresRepositoryImpl

@Suppress("UNCHECKED_CAST")
class ReqresListViewModelFactory( // 의존성 주입은 추후에 더 공부해서 하는걸로ㅠㅠ
    private val ReqresRepository: ReqresRepositoryImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(ReqresRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}
