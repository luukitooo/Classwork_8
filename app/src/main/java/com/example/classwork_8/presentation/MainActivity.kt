package com.example.classwork_8.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.classwork_8.common.extensions.asynchronously
import com.example.classwork_8.common.extensions.isNetworkAvailable
import com.example.classwork_8.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()

    private val outfitAdapter = OutfitAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        observers()

    }

    private fun init() {
        binding.rvOutfits.apply {
            adapter = outfitAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
        asynchronously { viewModel.getOutfits() }
    }

    private fun observers() {
        asynchronously {
            viewModel.outfitsFlow.collect { state ->
                state.value?.let { outfits ->
                    outfitAdapter.submitList(outfits.map { it.toOutfit() })
                }
                state.errorMessage?.let {
                    d("MyErrorLog", it,)
                }
                state.isLoading?.let {
                    binding.progressBar.isVisible = it
                }
            }
        }
    }

}