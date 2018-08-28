package hoo.yunhoo.practiceproject.network

import hoo.yunhoo.practiceproject.model.user.User
import io.reactivex.Observable
import retrofit2.http.GET


interface UserApi {
    @GET("/users")
    fun getUsers(): Observable<List<User>>
}