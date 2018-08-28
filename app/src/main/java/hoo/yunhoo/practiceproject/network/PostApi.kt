package hoo.yunhoo.practiceproject.network

import hoo.yunhoo.practiceproject.model.post.Post
import io.reactivex.Observable
import retrofit2.http.GET


interface PostApi {
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}