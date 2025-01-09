package com.alvaro.samplemodularization.feature.samplefragmentxml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alvaro.samplemodularization.feature.samplefragmentxml.databinding.FragmentSampleBinding

class SampleFragment : Fragment() {

    private var param1: String? = null

    private var _binding: FragmentSampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(PARAM_ONE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSample.text = param1?:"Empty"
    }

    companion object {
        fun newInstance(param1: String) =
            SampleFragment().apply {
                arguments = Bundle().apply {
                    putString(PARAM_ONE, param1)
                }
            }

        const val PARAM_ONE = "PARAM_ONE"
    }
}