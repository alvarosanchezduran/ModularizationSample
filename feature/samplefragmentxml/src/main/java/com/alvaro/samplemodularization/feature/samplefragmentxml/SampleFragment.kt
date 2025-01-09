package com.alvaro.samplemodularization.feature.samplefragmentxml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SampleFragment : Fragment() {

    private var param1: String? = null

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.tv_sample)

        text.text = param1?:"Empty"
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