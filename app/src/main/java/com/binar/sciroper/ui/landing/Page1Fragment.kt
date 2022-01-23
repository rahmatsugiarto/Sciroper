package com.binar.sciroper.ui.landing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.binar.sciroper.R
import com.binar.sciroper.databinding.FragmentPage1Binding
import com.binar.sciroper.databinding.FragmentPage2Binding
import com.bumptech.glide.Glide

class Page1Fragment : Fragment() {
    private var _binding: FragmentPage1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ivFirstPage = _binding?.ivFirstPage

    }
}