package hoo.yunhoo.practiceproject.model.albums

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


@Dao
interface AlbumDao {
    @get:Query("SELECT * FROM album")
    val all: List<Album>

    @Insert
    fun insertAll(vararg albums: Album)
}