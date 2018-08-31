package hoo.yunhoo.practiceproject.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hoo.yunhoo.practiceproject.ui.MainActivity
import hoo.yunhoo.practiceproject.ui.album.AlbumFragment
import hoo.yunhoo.practiceproject.ui.post.PostFragment
import hoo.yunhoo.practiceproject.ui.user.UserFragment


@Module
abstract class ActivityBuilder{
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(AlbumFragmentModule::class))
    abstract fun bindAlbumFragment(): AlbumFragment

    @ContributesAndroidInjector(modules = arrayOf(PostFragmentModule::class))
    abstract fun bindPostFragment(): PostFragment

    @ContributesAndroidInjector(modules = arrayOf(UserFragmentModule::class))
    abstract fun bindUserFragment(): UserFragment
}