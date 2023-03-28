package com.example.android_1_lesson_7.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_1_lesson_7.Adapters.MoviesAdapter
import com.example.android_1_lesson_7.R
import com.example.android_1_lesson_7.ui.Detail.MoviesDetailFragment
import com.example.android_1_lesson_7.ui.Interface.OnItemClickForMovies
import com.example.android_1_lesson_7.ui.Repository.MoviesRepository
import com.example.android_1_lesson_7.data.MoviesModel

class MoviesFragment : Fragment() , OnItemClickForMovies {

    private var recyclerView: RecyclerView? = null
    private var repository = MoviesRepository()
    private var moviesAdapter = MoviesAdapter(this, repository.getListOfMovies())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view_fragment_movies)

        initialization()

    }

    private fun initialization() {

        recyclerView?.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL, false
        )
        recyclerView?.adapter = moviesAdapter

    }

    override fun onShortClickForMovies(moviesModel: MoviesModel) {
        val bundle = Bundle()
        bundle.putSerializable("Dan", moviesModel)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, MoviesDetailFragment().javaClass, bundle)
            .addToBackStack(null)
            .commit()
    }


}