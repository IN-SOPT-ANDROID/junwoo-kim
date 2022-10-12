package org.sopt.sample.presentation.home.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.R
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.presentation.base.BindingFragment
import org.sopt.sample.presentation.home.adapter.GitAdapter
import org.sopt.sample.presentation.home.model.GitData

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    companion object {

        private lateinit var recyclerView : RecyclerView

        @JvmStatic
        fun newInstance() = HomeFragment()

        fun setScroll(){
            recyclerView.smoothScrollToPosition(0)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.rcvHome
        val adapter = GitAdapter(requireContext()) { }
        recyclerView.adapter = adapter
        adapter.submitList(
            listOf(
                GitData(1,"","OB","",0),
                GitData(2,"", "권용민", "OB",1),
                GitData(3,"","YB","",0),
                GitData(4,"", "김준우", "YB",1),
                GitData(5,"", "김지영", "YB",1),
                GitData(6,"", "김우남", "YB",1),
                GitData(7,"", "김준우", "YB",1),
                GitData(8,"", "김준우", "YB",1),
                GitData(9,"", "김준우", "YB",1),
                GitData(10,"", "김준우", "YB",1),
                GitData(11,"", "김준우", "YB",1),
                GitData(12,"", "김준우", "YB",1),
                GitData(13,"", "김준우", "YB",1),
                GitData(14,"", "김준우", "YB",1),
                GitData(15,"", "김준우", "YB",1),
                GitData(16,"", "김준우", "YB",1),
                GitData(17,"", "김준우", "YB",1),
                GitData(18,"", "김준우", "YB",1),
                GitData(19,"", "김준우", "YB",1),
                GitData(20,"", "김준우", "YB",1),
            )
        )
    }
}