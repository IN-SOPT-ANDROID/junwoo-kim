package org.sopt.sample.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.sample.R
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.home.adapter.SampleAdapter
import org.sopt.sample.model.RepoData

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

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
        val adapter = SampleAdapter(requireContext())
        adapter.setDataList(
            listOf(
                RepoData("","OB","",0),
                RepoData("", "권용민", "OB",1),
                RepoData("","YB","",0),
                RepoData("", "김준우", "YB",1),
                RepoData("", "김지영", "YB",1),
                RepoData("", "김우남", "YB",1),
            )
        )
        binding.rcvHome.adapter = adapter
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}