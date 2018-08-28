package hoo.yunhoo.practiceproject.data

import hoo.yunhoo.practiceproject.model.Tweet
import io.reactivex.Observable
import retrofit2.http.GET


interface RESTApi {
    @GET("tweet/list/")
    fun getTweetList(): Observable<List<Tweet>>
}