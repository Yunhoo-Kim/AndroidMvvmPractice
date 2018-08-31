package hoo.yunhoo.practiceproject.ui.album

import android.arch.lifecycle.MutableLiveData
import hoo.yunhoo.practiceproject.base.BaseViewModel
import hoo.yunhoo.practiceproject.model.albums.Album


class AlbumViewModel: BaseViewModel() {
    private val title = MutableLiveData<String>()

    fun bind(album: Album){
        title.value = album.title
    }

    fun getTitle(): MutableLiveData<String>{
        return title
    }
}