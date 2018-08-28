package hoo.yunhoo.practiceproject.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import hoo.yunhoo.practiceproject.model.post.Post
import hoo.yunhoo.practiceproject.model.post.PostDao
import hoo.yunhoo.practiceproject.model.user.User
import hoo.yunhoo.practiceproject.model.user.UserDao


@Database(entities = arrayOf(Post::class, User::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao
}