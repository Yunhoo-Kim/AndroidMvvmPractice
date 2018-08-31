package hoo.yunhoo.practiceproject.network

import hoo.yunhoo.practiceproject.model.albums.Album
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface AlbumApi {
    @GET("/albums")
    fun getAlbums(): Observable<List<Album>>
    @GET("/photos")
    fun getPhotos(@Query("albumId") query: Int): Observable<List<Album>>
}