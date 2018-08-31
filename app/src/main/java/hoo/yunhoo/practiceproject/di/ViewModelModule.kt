package hoo.yunhoo.practiceproject.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import hoo.yunhoo.practiceproject.injection.ViewModelFactory
import hoo.yunhoo.practiceproject.injection.ViewModelKey
import hoo.yunhoo.practiceproject.ui.album.AlbumListViewModel
import hoo.yunhoo.practiceproject.ui.post.PostListViewModel
import hoo.yunhoo.practiceproject.ui.user.UserListViewModel



@Module
@Suppress("unused")
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel::class)
    internal abstract fun  postListViewModel(viewModel: PostListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    internal abstract fun  userListViewModel(viewModel: UserListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlbumListViewModel::class)
    internal abstract fun  albumListViewModel(viewModel: AlbumListViewModel): ViewModel

}