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
        GitData(2, "", "권용민", "OB", 1),
        GitData(3, "", "YB", "", 0),
        GitData(4, "", "김준우", "YB", 1),
        GitData(5, "", "김지영", "YB", 1),
        GitData(6, "", "김우남", "YB", 1),
        GitData(7, "", "김준우", "YB", 1),
        GitData(8, "", "김준우", "YB", 1),
        GitData(9, "", "김준우", "YB", 1),
        GitData(10, "", "김준우", "YB", 1),
        GitData(11, "", "김준우", "YB", 1),
        GitData(12, "", "김준우", "YB", 1),
        GitData(13, "", "김준우", "YB", 1),
        GitData(14, "", "김준우", "YB", 1),
        GitData(15, "", "김준우", "YB", 1),
        GitData(16, "", "김준우", "YB", 1),
        GitData(17, "", "김준우", "YB", 1),
        GitData(18, "", "김준우", "YB", 1),
        GitData(19, "", "김준우", "YB", 1),
        GitData(20, "", "김준우", "YB", 1),
        GitData(1, "", "OB", "", 0),
        GitData(2, "", "권용민", "OB", 1),
        GitData(3, "", "YB", "", 0),
        GitData(4, "", "김준우", "YB", 1),
        GitData(5, "", "김지영", "YB", 1),
        GitData(6, "", "김우남", "YB", 1),
        GitData(7, "", "김준우", "YB", 1),
        GitData(8, "", "김준우", "YB", 1),
        GitData(9, "", "김준우", "YB", 1),
        GitData(10, "", "김준우", "YB", 1),
        GitData(11, "", "김준우", "YB", 1),
        GitData(12, "", "김준우", "YB", 1),
        GitData(13, "", "김준우", "YB", 1),
        GitData(14, "", "김준우", "YB", 1),
        GitData(15, "", "김준우", "YB", 1),
        GitData(16, "", "김준우", "YB", 1),
        GitData(17, "", "김준우", "YB", 1),
        GitData(18, "", "김준우", "YB", 1),
        GitData(19, "", "김준우", "YB", 1),
        GitData(20, "", "김준우", "YB", 1),
        GitData(1, "", "OB", "", 0),
        GitData(2, "", "권용민", "OB", 1),
        GitData(3, "", "YB", "", 0),
        GitData(4, "", "김준우", "YB", 1),
        GitData(5, "", "김지영", "YB", 1),
        GitData(6, "", "김우남", "YB", 1),
        GitData(7, "", "김준우", "YB", 1),
        GitData(8, "", "김준우", "YB", 1),
        GitData(9, "", "김준우", "YB", 1),
        GitData(10, "", "김준우", "YB", 1),
        GitData(11, "", "김준우", "YB", 1),
        GitData(12, "", "김준우", "YB", 1),
        GitData(13, "", "김준우", "YB", 1),
        GitData(14, "", "김준우", "YB", 1),
        GitData(15, "", "김준우", "YB", 1),
        GitData(16, "", "김준우", "YB", 1),
        GitData(17, "", "김준우", "YB", 1),
        GitData(18, "", "김준우", "YB", 1),
        GitData(19, "", "김준우", "YB", 1),
        GitData(20, "", "김준우", "YB", 1),
        GitData(1, "", "OB", "", 0),
        GitData(2, "", "권용민", "OB", 1),
        GitData(3, "", "YB", "", 0),
        GitData(4, "", "김준우", "YB", 1),
        GitData(5, "", "김지영", "YB", 1),
        GitData(6, "", "김우남", "YB", 1),
        GitData(7, "", "김준우", "YB", 1),
        GitData(8, "", "김준우", "YB", 1),
        GitData(9, "", "김준우", "YB", 1),
        GitData(10, "", "김준우", "YB", 1),
        GitData(11, "", "김준우", "YB", 1),
        GitData(12, "", "김준우", "YB", 1),
        GitData(13, "", "김준우", "YB", 1),
        GitData(14, "", "김준우", "YB", 1),
        GitData(15, "", "김준우", "YB", 1),
        GitData(16, "", "김준우", "YB", 1),
        GitData(17, "", "김준우", "YB", 1),
        GitData(18, "", "김준우", "YB", 1),
        GitData(19, "", "김준우", "YB", 1),
        GitData(20, "", "김준우", "YB", 1),
        GitData(1, "", "OB", "", 0),
        GitData(2, "", "권용민", "OB", 1),
        GitData(3, "", "YB", "", 0),
        GitData(4, "", "김준우", "YB", 1),
        GitData(5, "", "김지영", "YB", 1),
        GitData(6, "", "김우남", "YB", 1),
        GitData(7, "", "김준우", "YB", 1),
        GitData(8, "", "김준우", "YB", 1),
        GitData(9, "", "김준우", "YB", 1),
        GitData(10, "", "김준우", "YB", 1),
        GitData(11, "", "김준우", "YB", 1),
        GitData(12, "", "김준우", "YB", 1),
        GitData(13, "", "김준우", "YB", 1),
        GitData(14, "", "김준우", "YB", 1),
        GitData(15, "", "김준우", "YB", 1),
        GitData(16, "", "김준우", "YB", 1),
        GitData(17, "", "김준우", "YB", 1),
        GitData(18, "", "김준우", "YB", 1),
        GitData(19, "", "김준우", "YB", 1),
        GitData(20, "", "김준우", "YB", 1),
        GitData(1, "", "OB", "", 0),
        GitData(2, "", "권용민", "OB", 1),
        GitData(3, "", "YB", "", 0),
        GitData(4, "", "김준우", "YB", 1),
        GitData(5, "", "김지영", "YB", 1),
        GitData(6, "", "김우남", "YB", 1),
        GitData(7, "", "김준우", "YB", 1),
        GitData(8, "", "김준우", "YB", 1),
        GitData(9, "", "김준우", "YB", 1),
        GitData(10, "", "김준우", "YB", 1),
        GitData(11, "", "김준우", "YB", 1),
        GitData(12, "", "김준우", "YB", 1),
        GitData(13, "", "김준우", "YB", 1),
        GitData(14, "", "김준우", "YB", 1),
        GitData(15, "", "김준우", "YB", 1),
        GitData(16, "", "김준우", "YB", 1),
        GitData(17, "", "김준우", "YB", 1),
        GitData(18, "", "김준우", "YB", 1),
        GitData(19, "", "김준우", "YB", 1),
        GitData(20, "", "김준우", "YB", 1),
        GitData(1, "", "OB", "", 0),
        GitData(2, "", "권용민", "OB", 1),
        GitData(3, "", "YB", "", 0),
        GitData(4, "", "김준우", "YB", 1),
        GitData(5, "", "김지영", "YB", 1),
        GitData(6, "", "김우남", "YB", 1),
        GitData(7, "", "김준우", "YB", 1),
        GitData(8, "", "김준우", "YB", 1),
        GitData(9, "", "김준우", "YB", 1),
        GitData(10, "", "김준우", "YB", 1),
        GitData(11, "", "김준우", "YB", 1),
        GitData(12, "", "김준우", "YB", 1),
        GitData(13, "", "김준우", "YB", 1),
        GitData(14, "", "김준우", "YB", 1),
        GitData(15, "", "김준우", "YB", 1),
        GitData(16, "", "김준우", "YB", 1),
        GitData(17, "", "김준우", "YB", 1),
        GitData(18, "", "김준우", "YB", 1),
        GitData(19, "", "김준우", "YB", 1),
        GitData(20, "", "김준우", "YB", 1),
        GitData(1, "", "OB", "", 0),
        GitData(2, "", "권용민", "OB", 1),
        GitData(3, "", "YB", "", 0),
        GitData(4, "", "김준우", "YB", 1),
        GitData(5, "", "김지영", "YB", 1),
        GitData(6, "", "김우남", "YB", 1),
        GitData(7, "", "김준우", "YB", 1),
        GitData(8, "", "김준우", "YB", 1),
        GitData(9, "", "김준우", "YB", 1),
        GitData(10, "", "김준우", "YB", 1),
        GitData(11, "", "김준우", "YB", 1),
        GitData(12, "", "김준우", "YB", 1),
        GitData(13, "", "김준우", "YB", 1),
        GitData(14, "", "김준우", "YB", 1),
        GitData(15, "", "김준우", "YB", 1),
        GitData(16, "", "김준우", "YB", 1),
        GitData(17, "", "김준우", "YB", 1),
        GitData(18, "", "김준우", "YB", 1),
        GitData(19, "", "김준우", "YB", 1),
        GitData(20, "", "김준우", "YB", 1),
    )
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