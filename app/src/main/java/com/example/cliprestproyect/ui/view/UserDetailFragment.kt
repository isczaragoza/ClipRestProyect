package com.example.cliprestproyect.ui.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cliprestproyect.data.model.Results
import com.example.cliprestproyect.databinding.FragmentUserDetailBinding
import com.squareup.picasso.Picasso

class UserDetailFragment : Fragment(){

    lateinit var _binding : FragmentUserDetailBinding;
    lateinit var _context : Context;
    lateinit var mainActivity: MainActivity
    lateinit var detailResults: Results;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _context = context;
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false);
        return _binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = _context as MainActivity;
        detailResults = mainActivity.dataToFragment();

        _binding.imgUserDetail.setOnClickListener {
            Log.d("Test","Test Click Card");
        }


        Picasso.get().load(detailResults.picture.medium).into(_binding.imgUserDetail);
        _binding.title.text = detailResults.name.title;
        _binding.name.text = detailResults.name.first;
        _binding.last.text = detailResults.name.last;
        _binding.gender.text = detailResults.gender;
        _binding.email.text = detailResults.email;
    }
}