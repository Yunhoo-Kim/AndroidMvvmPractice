package hoo.yunhoo.practiceproject.model.albums

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import hoo.yunhoo.practiceproject.model.user.User


@Entity(foreignKeys = arrayOf(ForeignKey(entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("userId"),
        onDelete = ForeignKey.CASCADE)))
data class Album(
        val userId: Int,
        @PrimaryKey
        var id: Int,
        val title: String
)

@Entity(foreignKeys = arrayOf(ForeignKey(entity = Album::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("albumId"),
        onDelete = ForeignKey.CASCADE)))
data class Photo(
        @PrimaryKey
        val id: Int,
        val albumId: Int,
        val url: String,
        val thumbnailUrl: String
)