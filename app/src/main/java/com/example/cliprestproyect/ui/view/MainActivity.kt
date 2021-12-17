package com.example.cliprestproyect.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cliprestproyect.R
import com.example.cliprestproyect.data.model.Results
import com.example.cliprestproyect.databinding.ActivityMainBinding
import com.example.cliprestproyect.ui.adapters.UserAdapter
import com.example.cliprestproyect.ui.viewmodel.ResultsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnClickInterface {

    //vars
    private lateinit var binding: ActivityMainBinding;
    private val resultsViewModel: ResultsViewModel by viewModels();
    private lateinit var adapter: UserAdapter;
    private lateinit var detailResults: Results;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.rvUsers.layoutManager = LinearLayoutManager(this);
        adapter = UserAdapter(this, emptyList());
        binding.rvUsers.adapter = adapter;

        resultsViewModel.getResultsFromRoom();

        resultsViewModel.resultsModel.observe(this, Observer { results ->
            adapter.updateAdapater(results);
        });

        resultsViewModel.isLoading.observe(this, Observer { bool ->
            binding.mainProgressBar.isVisible = bool;
        });

        binding.cardRequest.setOnClickListener {
            resultsViewModel.requestApiNewResult()
        }

        binding.cardDelete.setOnClickListener {
            resultsViewModel.deleteAllResultsRoom()
        }
    }

    override fun onClickUserRowCallback(results: Results) {
        detailResults = results;
        supportFragmentManager.commit {
            setReorderingAllowed(true);
            add(R.id.main_container, UserDetailFragment(), "UserDetailFragment");
        }
    }

    public fun dataToFragment(): Results {
        Log.d("Dispatch", "Data");
        return detailResults;
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        val fragment = supportFragmentManager.findFragmentByTag("UserDetailFragment");
        if (fragment == null) {
            super.onBackPressed();
            return;
        }

        fragment.let {
            supportFragmentManager.commit {
                remove(it);
            }
        }

    }


}

interface OnClickInterface {
    fun onClickUserRowCallback(results: Results);
}