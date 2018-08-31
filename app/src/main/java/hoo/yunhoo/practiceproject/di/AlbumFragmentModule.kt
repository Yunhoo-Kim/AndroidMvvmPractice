package hoo.yunhoo.practiceproject.di

import dagger.Binds
import dagger.Module
import hoo.yunhoo.practiceproject.ui.album.AlbumFragment
import hoo.yunhoo.practiceproject.ui.user.UserFragment


@Module
abstract class AlbumFragmentModule {

    @FragmentScope
    @Binds
    abstract fun bindAlbumFragment(albumFragment: AlbumFragment): AlbumFragment
}