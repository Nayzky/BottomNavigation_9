package com.example.tugas_pertemuan9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.tugas_pertemuan9.databinding.FragmentHomeBinding

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.film1Layout1.setOnClickListener {
            openDetailPage("Film 1")
        }

        binding.film1Layout2.setOnClickListener {
            openDetailPage("Film 2")
        }

        return binding.root
    }

    private fun openDetailPage(filmTitle: String) {
        val bundle = Bundle()
        bundle.putString("film_title", filmTitle)
        val detailFragment = Detail()
        detailFragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, detailFragment)
            .addToBackStack(null)
            .commit()

        (activity as MainActivity).setSelectedNavItem(R.id.nav_Detail)
    }
}
