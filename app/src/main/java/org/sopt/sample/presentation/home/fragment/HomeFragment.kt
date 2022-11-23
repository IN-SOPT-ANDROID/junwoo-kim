package org.sopt.sample.presentation.home.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.R
import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.domain.getJsonData
import org.sopt.sample.presentation.base.BindingFragment
import org.sopt.sample.presentation.home.adapter.GitAdapter
import org.sopt.sample.presentation.home.adapter.ReqresListAdapter
import org.sopt.sample.presentation.home.adapter.setSelectionTracker
import org.sopt.sample.presentation.home.model.GitData
import org.sopt.sample.presentation.home.viewmodel.HomeViewModel

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    companion object {

        private lateinit var recyclerView: RecyclerView

        fun newInstance() = HomeFragment()

        fun setScroll() {
            recyclerView.scrollToPosition(0)
            //recyclerView.smoothScrollToPosition(0)
        }
    }

    private val repoList = mutableListOf(
        GitData(0, "", "Repos from local json", "", 0), // 헤더타입 지정
    )

    private var reqresList = listOf<ResponseReqresListDTO.Data>()
    private val homeViewModel: HomeViewModel by activityViewModels()

    private lateinit var gitAdapter: GitAdapter
    private lateinit var tracker: SelectionTracker<Long>
    private lateinit var reqresListAdapter: ReqresListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reqresListAdapter = ReqresListAdapter(requireContext())
        binding.rcvHome.adapter = reqresListAdapter
        binding.lifecycleOwner = viewLifecycleOwner

        homeViewModel.reqresList.observe(viewLifecycleOwner) {
            if (it != null) {
                reqresListAdapter.submitList(it)
            }
        }
        //loadData()
    }

    // 이하 항목은 Seminar3까지만 사용했던 함수들
    private fun initSetData() {
        with(repoList) {
            addAll(requireContext().getJsonData()) // json 파일로부터 데이터를 받아옴
            add(GitData(1, "", "DummyRepos", "", 0))
            repeat(100) { // selection을 통한 key 저장 작동을 확인하기 위해 뷰홀더가 재사용될 정도로 더미 데이터 추가
                add(GitData(it + 2, "", "더미 레포${it + 1}", "Jun-wooKim"))
            }
        }
    }

    private fun initRecycler() {
        recyclerView = binding.rcvHome
        gitAdapter = GitAdapter(requireContext()) { }
        recyclerView.adapter = gitAdapter
        addTrackerObserver()
        gitAdapter.submitList(repoList.toList())

        binding.floatingBtnDelete.setOnClickListener {
            gitAdapter.removeItem(tracker.selection)
            tracker.clearSelection()
        }
    }

    private fun addTrackerObserver() {
        tracker = setSelectionTracker("gitSelectionTracker", recyclerView)
        tracker.addObserver((object : SelectionTracker.SelectionObserver<Long>() {
            override fun onSelectionChanged() {
                super.onSelectionChanged()
                val items = tracker.selection.size()
                if (items == 0) binding.enabled = false
                else binding.enabled = items >= 1 // 선택된 아이템이 1개 이상일 경우 floating button 활성화

            }
        }))

        gitAdapter.setTracker(tracker)
    }

}