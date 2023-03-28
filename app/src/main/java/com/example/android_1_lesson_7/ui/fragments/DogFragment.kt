package com.example.android_1_lesson_7.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_1_lesson_7.Adapters.DogAdapter
import com.example.android_1_lesson_7.R
import com.example.android_1_lesson_7.ui.Detail.DogDetailFragment
import com.example.android_1_lesson_7.ui.Interface.OnItemClick
import com.example.android_1_lesson_7.ui.Repository.DogRepository
import com.example.android_1_lesson_7.data.DogModel
import com.example.android_1_lesson_7.databinding.FragmentDogsBinding

class DogFragment : Fragment() , OnItemClick {

    private lateinit var bindind: FragmentDogsBinding

    private var repository = DogRepository()
    private var dogAdapter = DogAdapter(this, repository.getLisOfDog())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindind = FragmentDogsBinding.inflate(inflater, container , false)
        return bindind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindind.recyclerViewFragmentDog
        initialization()

    }

    private fun initialization() {

        bindind.recyclerViewFragmentDog.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL, false
        )
        bindind.recyclerViewFragmentDog.adapter = dogAdapter

    }

    override fun onShortClickForDog(dogModel: DogModel) {
        val bundle = Bundle()
        bundle.putSerializable("Dan", dogModel)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, DogDetailFragment().javaClass, bundle)
            .addToBackStack(null)
            .commit()
    }
}


