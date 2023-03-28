package com.example.android_1_lesson_7.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_1_lesson_7.Adapters.CatAdapter
import com.example.android_1_lesson_7.R
import com.example.android_1_lesson_7.ui.Detail.CatDetailFragment
import com.example.android_1_lesson_7.ui.Interface.OnItemClickForCat
import com.example.android_1_lesson_7.ui.Repository.CatRepository
import com.example.android_1_lesson_7.data.CatModel
import com.example.android_1_lesson_7.databinding.FragmentCatBinding

class CatFragment : Fragment() , OnItemClickForCat {

    private lateinit var binding: FragmentCatBinding
    private var repository = CatRepository()
    private var catAdapter = CatAdapter(this, repository.getListOfCat())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()

    }

    private fun initialization() {

        binding.recyclerViewFragmentCat.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL, false
        )
        binding.recyclerViewFragmentCat.adapter = catAdapter

    }


    override fun onShortClickForCat(catModel: CatModel) {
        val bundle = Bundle()
        bundle.putSerializable("Dan", catModel)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, CatDetailFragment().javaClass, bundle)
            .addToBackStack(null)
            .commit()

    }
}