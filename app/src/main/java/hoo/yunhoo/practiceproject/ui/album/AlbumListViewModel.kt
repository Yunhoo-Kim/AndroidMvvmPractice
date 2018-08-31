package hoo.yunhoo.practiceproject.ui.album

import android.content.SharedPreferences
import dagger.android.AndroidInjection
import hoo.yunhoo.practiceproject.base.BaseViewModel
import hoo.yunhoo.practiceproject.model.albums.Album
import hoo.yunhoo.practiceproject.model.albums.AlbumDao
import hoo.yunhoo.practiceproject.network.AlbumApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AlbumListViewModel @Inject constructor(private val albumDao: AlbumDao): BaseViewModel() {

    @Inject
    lateinit var albumApi: AlbumApi

    private lateinit var subscription: Disposable
    private lateinit var settings:SharedPreferences

    val albumListAdapter: AlbumListAdapter = AlbumListAdapter()

    init {
        loadAlbums()
//        settings = getShare
    }

    private fun loadAlbums(){
        subscription = Observable.fromCallable { albumDao.all }
                .concatMap {
                    if(it.isEmpty())
                        albumApi.getAlbums().concatMap {
                            albumDao.insertAll(*it.toTypedArray())
                            Observable.just(it)
                        }
                    else
                        Observable.just(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                   updateAlbumList(it)
                }, {
                   it.printStackTrace()
                })
    }

    private fun updateAlbumList(albumList: List<Album>){
        albumListAdapter.updateAlbumList(albumList)
    }


}