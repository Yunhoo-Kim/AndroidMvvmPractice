package hoo.yunhoo.practiceproject.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.util.Log
//import hoo.yunhoo.practiceproject.data.Injector
import hoo.yunhoo.practiceproject.model.Tweet
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver


class MainViewModel(var context: Context?, var dataListener: DataListener?): BaseViewModel(){
    var disposable: DisposableObserver<List<Tweet>>? = null
    var tweetList: ObservableArrayList<Tweet> = ObservableArrayList<Tweet>()
    var cnt:Int = 0

    init {

    }

    fun destory() {
        if(!disposable!!.isDisposed)
            disposable!!.dispose()
        disposable = null
        context = null
        dataListener = null
    }

//    fun loadTweets(): ObservableArrayList<Tweet>{
//        val injector = Injector()
//        val api = injector.provideApi()
//        tweetList = _loadTweetsMock()
////        disposable = api.getTweetList()
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribeWith(LongOperationObserver())
//        return tweetList
//    }
    private fun _loadTweetsMock() : ObservableArrayList<Tweet>{
        cnt++
       var tweet = Tweet()
        tweet.id = 1
        tweet.content = "abc $cnt"
        var _list = ObservableArrayList<Tweet>()
        _list.add(tweet)
        Log.d("Click Count", "$cnt Click")
        return _list
    }

    interface DataListener {
        fun onTweetsChanged(tweets: List<Tweet>)
    }

    private inner class LongOperationObserver : DisposableObserver<ObservableArrayList<Tweet>>() {
        override fun onNext(value: ObservableArrayList<Tweet>) {
            this@MainViewModel.tweetList = value
        }

        override fun onComplete() {
            dataListener?.onTweetsChanged(tweetList)

        }

        override fun onError(e: Throwable?) {

        }
    }

}