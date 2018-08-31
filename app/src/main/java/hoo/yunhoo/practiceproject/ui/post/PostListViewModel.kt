package hoo.yunhoo.practiceproject.ui.post

import android.arch.lifecycle.MutableLiveData
import android.view.View
import hoo.yunhoo.practiceproject.R
import hoo.yunhoo.practiceproject.base.BaseViewModel
import hoo.yunhoo.practiceproject.model.post.Post
import hoo.yunhoo.practiceproject.model.post.PostDao
import hoo.yunhoo.practiceproject.network.PostApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class PostListViewModel @Inject constructor(private val postDao: PostDao): BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()

    val postListAdapter: PostListAdapter = PostListAdapter()

    init {
        loadPosts()
    }

    private fun loadPosts(){
        subscription = Observable.fromCallable { postDao.all }
                .concatMap { dbPostList ->
                    if(dbPostList.isEmpty())
                        postApi.getPosts().concatMap { apiPostList -> postDao.insertAll(*apiPostList.toTypedArray())
                            Observable.just(apiPostList)
                        }
                    else
                        Observable.just(dbPostList)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{onRetrievePostListStart()}
                .doOnTerminate{onRetrievePostListFinish()}
                .subscribe({onRetrievePostListSuccess(it)}, {
                    onRetrievePostListError()
                })
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList: List<Post>){
        postListAdapter.updatePostList(postList)
        errorMessage.value = R.string.post_error
    }

    private fun onRetrievePostListError(){
        errorMessage.value = R.string.post_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}