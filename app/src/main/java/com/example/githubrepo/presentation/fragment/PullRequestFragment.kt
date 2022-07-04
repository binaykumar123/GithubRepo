package com.example.githubrepo.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubrepo.R
import com.example.githubrepo.databinding.FragmentPullRequestBinding
import com.example.githubrepo.presentation.adapters.PullRequestAdapter
import com.example.githubrepo.presentation.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class PullRequestFragment : Fragment() {

    private lateinit var binding: FragmentPullRequestBinding
    private lateinit var pullRequestAdapter: PullRequestAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_pull_request, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setObservers()
        fetchApi()
    }

    private fun setupRecyclerView() {
        pullRequestAdapter = PullRequestAdapter()
        binding.pullsRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pullRequestAdapter
        }
    }

    private fun setObservers() {
        mainViewModel.closedPullRequests.observe(this) {
            pullRequestAdapter.addAll(it)
        }
        mainViewModel.isDataLoading.observe(this) {
            binding.progressBar.isVisible = it
        }
        mainViewModel.isDataLoadingError.observe(this) {
            if (it) {
                Snackbar.make(binding.root, "Something went wrong", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", View.OnClickListener {
                        fetchApi()
                    }).show()
                mainViewModel.isDataLoadingError.value = false
            }
        }
    }

    private fun fetchApi() {
        mainViewModel.fetchAllClosedRequest()
    }

}