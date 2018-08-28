package hoo.yunhoo.practiceproject.ui.user

import android.arch.lifecycle.MutableLiveData
import hoo.yunhoo.practiceproject.base.BaseViewModel
import hoo.yunhoo.practiceproject.model.user.UserDao
import hoo.yunhoo.practiceproject.network.UserApi
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class UserListViewModel(private val userDao: UserDao): BaseViewModel(){
    @Inject
    lateinit var userApi: UserApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
}