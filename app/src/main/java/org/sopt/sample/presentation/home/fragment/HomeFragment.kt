package org.sopt.sample.presentation.home.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.R
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.presentation.base.BindingFragment
import org.sopt.sample.presentation.home.adapter.GitAdapter
import org.sopt.sample.presentation.home.adapter.GitDetailsLookUp
import org.sopt.sample.presentation.home.model.GitData

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    companion object {

        private lateinit var recyclerView: RecyclerView

        @JvmStatic
        fun newInstance() = HomeFragment()

        fun setScroll() {
            recyclerView.smoothScrollToPosition(0)
        }
    }

    private val gitList = listOf(
        GitData(1, "", "OB", "", 0),
        GitData(2, "", "레포1", "IslandOfDream", 1),
        GitData(3, "", "레포2", "IslandOfDream", 1),
        GitData(4, "", "레포3", "IslandOfDream", 1),
        GitData(5, "", "레포4", "IslandOfDream", 1),
        GitData(6, "", "레포5", "IslandOfDream", 1),
        GitData(7, "", "레포6", "IslandOfDream", 1),
        GitData(8, "", "레포7", "IslandOfDream", 1),
        GitData(9, "", "레포8", "IslandOfDream", 1),
        GitData(10, "", "레포9", "IslandOfDream", 1),
        GitData(11, "", "레포10", "IslandOfDream", 1),
        GitData(12, "", "더미레포", "IslandOfDream", 1),
        GitData(13, "", "더미레포", "IslandOfDream", 1),
        GitData(14, "", "더미레포", "IslandOfDream", 1),
        GitData(15, "", "더미레포", "IslandOfDream", 1),
        GitData(16, "", "더미레포", "IslandOfDream", 1),
        GitData(17, "", "더미레포", "IslandOfDream", 1),
        GitData(18, "", "더미레포", "IslandOfDream", 1),
        GitData(19, "", "더미레포", "IslandOfDream", 1),
        GitData(20, "", "더미레포", "IslandOfDream", 1),
        GitData(7, "", "더미레포", "IslandOfDream", 1),
        GitData(8, "", "더미레포", "IslandOfDream", 1),
        GitData(9, "", "더미레포", "IslandOfDream", 1),
        GitData(10, "", "더미레포", "IslandOfDream", 1),
        GitData(11, "", "더미레포", "IslandOfDream", 1),
        GitData(12, "", "더미레포", "IslandOfDream", 1),
        GitData(13, "", "더미레포", "IslandOfDream", 1),
        GitData(14, "", "더미레포", "IslandOfDream", 1),
        GitData(15, "", "더미레포", "IslandOfDream", 1),
        GitData(16, "", "더미레포", "IslandOfDream", 1),
        GitData(17, "", "더미레포", "IslandOfDream", 1),
        GitData(18, "", "더미레포", "IslandOfDream", 1),
        GitData(19, "", "더미레포", "IslandOfDream", 1),
        GitData(20, "", "더미레포", "IslandOfDream", 1),
        GitData(7, "", "더미레포", "IslandOfDream", 1),
        GitData(8, "", "더미레포", "IslandOfDream", 1),
        GitData(9, "", "더미레포", "IslandOfDream", 1),
        GitData(10, "", "더미레포", "IslandOfDream", 1),
        GitData(11, "", "더미레포", "IslandOfDream", 1),
        GitData(12, "", "더미레포", "IslandOfDream", 1),
        GitData(13, "", "더미레포", "IslandOfDream", 1),
        GitData(14, "", "더미레포", "IslandOfDream", 1),
        GitData(15, "", "더미레포", "IslandOfDream", 1),
        GitData(16, "", "더미레포", "IslandOfDream", 1),
        GitData(17, "", "더미레포", "IslandOfDream", 1),
        GitData(18, "", "더미레포", "IslandOfDream", 1),
        GitData(19, "", "더미레포", "IslandOfDream", 1),
        GitData(20, "", "더미레포", "IslandOfDream", 1),
        GitData(4, "", "더미레포", "IslandOfDream", 1),
        GitData(7, "", "더미레포", "IslandOfDream", 1),
        GitData(8, "", "더미레포", "IslandOfDream", 1),
        GitData(9, "", "더미레포", "IslandOfDream", 1),
        GitData(10, "", "더미레포", "IslandOfDream", 1),
        GitData(11, "", "더미레포", "IslandOfDream", 1),
        GitData(12, "", "더미레포", "IslandOfDream", 1),
        GitData(13, "", "더미레포", "IslandOfDream", 1),
        GitData(14, "", "더미레포", "IslandOfDream", 1),
        GitData(15, "", "더미레포", "IslandOfDream", 1),
        GitData(16, "", "더미레포", "IslandOfDream", 1),
        GitData(17, "", "더미레포", "IslandOfDream", 1),
        GitData(18, "", "더미레포", "IslandOfDream", 1),
        GitData(19, "", "더미레포", "IslandOfDream", 1),
        GitData(20, "", "더미레포", "IslandOfDream", 1),
        GitData(7, "", "더미레포", "IslandOfDream", 1),
        GitData(8, "", "더미레포", "IslandOfDream", 1),
        GitData(9, "", "더미레포", "IslandOfDream", 1),
        GitData(10, "", "더미레포", "IslandOfDream", 1),
        GitData(11, "", "더미레포", "IslandOfDream", 1),
        GitData(12, "", "더미레포", "IslandOfDream", 1),
        GitData(13, "", "더미레포", "IslandOfDream", 1),
        GitData(14, "", "더미레포", "IslandOfDream", 1),
        GitData(15, "", "더미레포", "IslandOfDream", 1),
        GitData(16, "", "더미레포", "IslandOfDream", 1),
        GitData(17, "", "더미레포", "IslandOfDream", 1),
        GitData(18, "", "더미레포", "IslandOfDream", 1),
        GitData(19, "", "더미레포", "IslandOfDream", 1),
        GitData(20, "", "더미레포", "IslandOfDream", 1),
        GitData(7, "", "더미레포", "IslandOfDream", 1),
        GitData(8, "", "더미레포", "IslandOfDream", 1),
        GitData(9, "", "더미레포", "IslandOfDream", 1),
        GitData(10, "", "더미레포", "IslandOfDream", 1),
        GitData(11, "", "더미레포", "IslandOfDream", 1),
        GitData(12, "", "더미레포", "IslandOfDream", 1),
        GitData(13, "", "더미레포", "IslandOfDream", 1),
        GitData(14, "", "더미레포", "IslandOfDream", 1),
        GitData(15, "", "더미레포", "IslandOfDream", 1),
        GitData(16, "", "더미레포", "IslandOfDream", 1),
        GitData(17, "", "더미레포", "IslandOfDream", 1),
        GitData(18, "", "더미레포", "IslandOfDream", 1),
        GitData(19, "", "더미레포", "IslandOfDream", 1),
        GitData(20, "", "더미레포", "IslandOfDream", 1),
        GitData(7, "", "더미레포", "IslandOfDream", 1),
        GitData(8, "", "더미레포", "IslandOfDream", 1),
        GitData(9, "", "더미레포", "IslandOfDream", 1),
        GitData(10, "", "더미레포", "IslandOfDream", 1),
        GitData(11, "", "더미레포", "IslandOfDream", 1),
        GitData(12, "", "더미레포", "IslandOfDream", 1),
        GitData(13, "", "더미레포", "IslandOfDream", 1),
        GitData(14, "", "더미레포", "IslandOfDream", 1),
        GitData(15, "", "더미레포", "IslandOfDream", 1),
        GitData(16, "", "더미레포", "IslandOfDream", 1),
        GitData(17, "", "더미레포", "IslandOfDream", 1),
        GitData(18, "", "더미레포", "IslandOfDream", 1),
        GitData(19, "", "더미레포", "IslandOfDream", 1),
        GitData(20, "", "더미레포", "IslandOfDream", 1),
        GitData(7, "", "더미레포", "IslandOfDream", 1),
        GitData(8, "", "더미레포", "IslandOfDream", 1),
        GitData(9, "", "더미레포", "IslandOfDream", 1),
        GitData(10, "", "더미레포", "IslandOfDream", 1),
        GitData(11, "", "더미레포", "IslandOfDream", 1),
        GitData(12, "", "더미레포", "IslandOfDream", 1),
        GitData(13, "", "더미레포", "IslandOfDream", 1),
        GitData(14, "", "더미레포", "IslandOfDream", 1),
        GitData(15, "", "더미레포", "IslandOfDream", 1),
        GitData(16, "", "더미레포", "IslandOfDream", 1),
        GitData(17, "", "더미레포", "IslandOfDream", 1),
        GitData(18, "", "더미레포", "IslandOfDream", 1),
        GitData(19, "", "더미레포", "IslandOfDream", 1),
        GitData(20, "", "더미레포", "IslandOfDream", 1),
    ) // position 정보 기억 테스트를 위한 더미데이터
    private lateinit var gitadapter: GitAdapter
    private lateinit var tracker: SelectionTracker<Long>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        binding.floatingBtnDelete.setOnClickListener {
            gitadapter.removeItem(tracker.selection)
            tracker.clearSelection()
        }

    }

    private fun initRecycler() {
        recyclerView = binding.rcvHome
        gitadapter = GitAdapter(requireContext()) { }
        recyclerView.adapter = gitadapter
        setSelectionTracker()
        gitadapter.submitList(gitList.toList())
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
        gitadapter.setTracker(tracker)
    }
}