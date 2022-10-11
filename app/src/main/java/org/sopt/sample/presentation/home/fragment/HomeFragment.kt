package org.sopt.sample.presentation.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.presentation.home.adapter.SampleAdapter
import org.sopt.sample.presentation.home.model.RepoData

class HomeFragment : Fragment() {

    companion object {

        private lateinit var recyclerView : RecyclerView

        @JvmStatic
        fun newInstance() = HomeFragment()

        fun setScroll(){
            recyclerView.smoothScrollToPosition(0)
        }
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) {"${this.id} binding error"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        recyclerView = binding.rcvHome
        val adapter = SampleAdapter(requireContext())
        recyclerView.adapter = adapter
        adapter.submitList(
            listOf(
                RepoData("","OB","",0),
                RepoData("", "권용민", "OB",1),
                RepoData("","YB","",0),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김지영", "YB",1),
                RepoData("", "김우남", "YB",1),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김준우", "YB",1),
            )
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}