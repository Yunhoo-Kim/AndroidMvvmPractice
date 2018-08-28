package hoo.yunhoo.practiceproject.view

import android.databinding.DataBindingUtil
import android.content.Context
import android.databinding.ObservableList
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import hoo.yunhoo.practiceproject.R
import hoo.yunhoo.practiceproject.databinding.ActivityMainBinding
import hoo.yunhoo.practiceproject.model.Tweet
import hoo.yunhoo.practiceproject.viewmodel.MainViewModel


class MainActivity: AppCompatActivity(), MainViewModel.DataListener {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = MainViewModel(this, this)
        binding.recyclerView.adapter = TweetAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.tweetList = mainViewModel.loadTweets()
        binding.clickButton.setOnClickListener {
//            binding.tweetList = mainViewModel.loadTweets()
        }
    }

    override fun onTweetsChanged(tweets: List<Tweet>) {
    }
}