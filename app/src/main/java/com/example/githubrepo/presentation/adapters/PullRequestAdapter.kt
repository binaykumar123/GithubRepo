package com.example.githubrepo.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo.data.models.PullRequest
import com.example.githubrepo.databinding.ItemPullRequestBinding
import com.example.githubrepo.utils.CircleTransform
import com.example.githubrepo.utils.formattedDate
import com.squareup.picasso.Picasso

class PullRequestAdapter : RecyclerView.Adapter<PullRequestAdapter.PullRequestViewHolder>() {

    private var pullRequests = ArrayList<PullRequest>()

    inner class PullRequestViewHolder(val binding: ItemPullRequestBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val binding = ItemPullRequestBinding.inflate(LayoutInflater.from(parent.context))
        return PullRequestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        with(holder) {
            with(pullRequests[position]) {
                binding.userNameTV.text = this.user.login
                binding.closedDateTV.text = formattedDate(this.updatedAt)
                binding.createdDateTV.text = formattedDate(this.updatedAt)
                binding.titleTV.text = this.title
                Picasso.get().load(this.user.avatarUrl).transform(CircleTransform()).into(binding.profileIV)
            }
        }
    }

    override fun getItemCount(): Int {
        return pullRequests.size
    }

    fun addItems(pullRequests : ArrayList<PullRequest>){
        this.pullRequests.addAll(pullRequests)
        notifyDataSetChanged()
    }
}