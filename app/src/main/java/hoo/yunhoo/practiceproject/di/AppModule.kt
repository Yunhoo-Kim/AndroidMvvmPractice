package hoo.yunhoo.practiceproject.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import hoo.yunhoo.practiceproject.model.albums.AlbumDao
import hoo.yunhoo.practiceproject.model.database.AppDatabase
import hoo.yunhoo.practiceproject.model.post.PostDao
import hoo.yunhoo.practiceproject.model.user.UserDao
import javax.inject.Named
import javax.inject.Singleton


@Module
@Suppress("unused")
class AppModule(val app: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    @Named("appContext")
    fun provideContext(app: Application): Context = app

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
            Room.databaseBuilder(app , AppDatabase::class.java, "app.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providePostDao(database: AppDatabase): PostDao{
       return database.postDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao{
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideAlbumDao(database: AppDatabase): AlbumDao {
        return database.albumDao()
    }

}