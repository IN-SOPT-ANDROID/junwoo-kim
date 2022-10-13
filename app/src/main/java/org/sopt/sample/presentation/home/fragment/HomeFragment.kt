package org.sopt.sample.presentation.home.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import org.json.JSONArray
import org.sopt.sample.R
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.presentation.base.BindingFragment
import org.sopt.sample.presentation.home.adapter.GitAdapter
import org.sopt.sample.presentation.home.adapter.GitDetailsLookUp
import org.sopt.sample.presentation.home.model.FakeGitItem
import org.sopt.sample.presentation.home.model.GitData
import timber.log.Timber

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    companion object {

        private lateinit var recyclerView: RecyclerView

        @JvmStatic
        fun newInstance() = HomeFragment()

        fun setScroll() {
            recyclerView.scrollToPosition(0)
            //recyclerView.smoothScrollToPosition(0)
        }
    }

    private val dummyGitList = mutableListOf(
        GitData(0,"", "Header", "", 0), // 헤더타입 지정
    )

    private lateinit var gitAdapter: GitAdapter
    private lateinit var tracker: SelectionTracker<Long>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        binding.floatingBtnDelete.setOnClickListener {
            gitAdapter.removeItem(tracker.selection)
            tracker.clearSelection()
        }
    }

    private fun initRecycler() {
        repeat(100) { // selection을 통한 key 저장 작동을 확인하기 위해 뷰홀더가 재사용될 정도로 데이터 추가
            dummyGitList.add(it + 1, GitData(it+1, "", "더미 레포${it + 1}", "Jun-wooKim"))
        }
        recyclerView = binding.rcvHome
        gitAdapter = GitAdapter(requireContext()) { }
        recyclerView.adapter = gitAdapter
        setSelectionTracker()
        gitAdapter.submitList(dummyGitList.toList())
    }

    private fun setSelectionTracker() {
        tracker = SelectionTracker.Builder<Long>(
            "gitSelection",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            GitDetailsLookUp(recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(object : SelectionTracker.SelectionPredicate<Long>() {
            override fun canSetStateForKey(key: Long, nextState: Boolean): Boolean {
                return true
            }

            override fun canSetStateAtPosition(
                position: Int, nextState: Boolean
            ): Boolean {
                return true
            }

            override fun canSelectMultiple(): Boolean {
                return true
            }
        }).build()
        tracker.addObserver(object : SelectionTracker.SelectionObserver<Long>() {
            override fun onSelectionChanged() {
                super.onSelectionChanged()
                val items = tracker.selection.size()
                binding.enabled = items >= 1 // 선택된 아이템이 1개 이상일 경우 floating button 활성화
            }
        })
        gitAdapter.setTracker(tracker)
    }

}