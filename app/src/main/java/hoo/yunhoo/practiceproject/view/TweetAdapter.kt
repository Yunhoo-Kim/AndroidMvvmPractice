package hoo.yunhoo.practiceproject.view

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hoo.yunhoo.practiceproject.BR
import hoo.yunhoo.practiceproject.databinding.TweetItemBinding
import hoo.yunhoo.practiceproject.model.Tweet


class TweetAdapter(): RecyclerView.Adapter<TweetAdapter.TweetViewHolder>() {
    var tweetList: List<Tweet> = emptyList()

    override fun getItemCount(): Int = tweetList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        var binding = TweetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TweetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        Log.d("onBindViewHOlder", "binding")
        holder.bind(tweetList.get(position))
    }
    fun setItem(tweetList: List<Tweet>){
        this.tweetList = tweetList
        notifyDataSetChanged()
    }
    fun clear(){
        tweetList = emptyList()
    }


    class TweetViewHolder(val binding: TweetItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(tweet: Tweet){
            binding.tweet = tweet
            binding.executePendingBindings()
        }
    }
}