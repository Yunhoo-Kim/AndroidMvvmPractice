package hoo.yunhoo.practiceproject.model.repository

import hoo.yunhoo.practiceproject.model.SharedPreferenceHelper
import hoo.yunhoo.practiceproject.model.user.User
import hoo.yunhoo.practiceproject.model.user.UserDao
import hoo.yunhoo.practiceproject.network.UserApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class UserRepository @Inject constructor(private val userDao: UserDao, private val userApi: UserApi, private val sharedPreferenceHelper: SharedPreferenceHelper) {

    fun loadUsers(): Observable<List<User>>{
        return Observable.fromCallable { userDao.all }
                .concatMap {
                    if(it.isEmpty())
                        userApi.getUsers().concatMap {
                            userDao.insertAll(*it.toTypedArray())
                            Observable.just(it)
                        }
                    else
                        Observable.just(it)
                }
                .subscribeOn(Schedulers.io())
    }
}