package com.example.tugas_pertemuan9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tugas_pertemuan9.databinding.FragmentDetailBinding

class Detail : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val filmTitle = arguments?.getString("film_title")

        binding.beliTiketButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("film_title", filmTitle)
            val orderFragment = Order()
            orderFragment.arguments = bundle

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, orderFragment)
                .addToBackStack(null)
                .commit()

            (activity as MainActivity).setSelectedNavItem(R.id.nav_Order)
        }

        return binding.root
    }
}
