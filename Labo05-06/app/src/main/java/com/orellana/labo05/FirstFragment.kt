package com.orellana.labo05

import android.os.Bundle
import android.system.Os.bind
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FirstFragment : Fragment() {

    private lateinit var addButton: FloatingActionButton
    private lateinit var star_wars_card : CardView

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        addButton = view.findViewById(R.id.addButton)
        star_wars_card = view.findViewById(R.id.STcard)

        Log.d("Movies", viewModel.getMovies().toString())

        addButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        star_wars_card.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }


    }

    private fun bind() {
        addButton = view?.findViewById(R.id.addButton) as FloatingActionButton
    }
}