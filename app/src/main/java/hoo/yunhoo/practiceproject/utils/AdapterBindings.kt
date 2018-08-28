package hoo.yunhoo.practiceproject.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import hoo.yunhoo.practiceproject.model.Tweet
import hoo.yunhoo.practiceproject.utils.extension.getParentActivity
import hoo.yunhoo.practiceproject.view.TweetAdapter


@BindingAdapter("bind:item")
fun bindItem(recyclerView: RecyclerView, tweets: List<Tweet>) {
    if(tweets.isEmpty()) return
    var adapter: TweetAdapter = recyclerView.adapter as TweetAdapter
    adapter.setItem(tweets)
    Log.d("TweetBindItem", "binding!!")
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null){
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:""})
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}