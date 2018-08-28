package hoo.yunhoo.practiceproject.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import hoo.yunhoo.practiceproject.model.database.AppDatabase
import hoo.yunhoo.practiceproject.ui.post.PostListViewModel


class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostListViewModel::class.java)){
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "posts").build()
            @Suppress
            return PostListViewModel(db.postDao()) as T
        }

        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}