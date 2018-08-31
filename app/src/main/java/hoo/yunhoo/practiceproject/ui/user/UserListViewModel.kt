package hoo.yunhoo.practiceproject.ui.user

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import hoo.yunhoo.practiceproject.base.BaseViewModel
import hoo.yunhoo.practiceproject.model.repository.UserRepository
import hoo.yunhoo.practiceproject.model.user.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class UserListViewModel @Inject constructor(private val userRepository: UserRepository): BaseViewModel(){

    val userListAdapter: UserListAdapter = UserListAdapter()
    private val subscription: CompositeDisposable by lazy {
       CompositeDisposable()
    }

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()

//    val userListAdapter: UserListAdapter = UserListAdapter()

    init {
        loadUsers()
    }

    private fun loadUsers() {
        userRepository.loadUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{ onRetrieveUserListStart() }
                .doOnTerminate { onRetrieveUserListFinish() }
                .subscribe({ onRetrieveUserListSuccess(it) },
                        { Log.d("error", it.message)
                            onRetrieveUserListError()
                        })
                .apply { subscription.add(this) }
    }

    private fun onRetrieveUserListStart(){
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveUserListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveUserListSuccess(userList: List<User>){
        Log.d("onRetreive", userList.toString())
        userListAdapter.updateUserList(userList)
    }

    private fun onRetrieveUserListError(){
    }

    override fun onCleared() {
        super.onCleared()
        subscription.clear()
    }
}