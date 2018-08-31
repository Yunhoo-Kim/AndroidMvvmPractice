package hoo.yunhoo.practiceproject.injection.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import hoo.yunhoo.practiceproject.injection.module.NetworkModule
import hoo.yunhoo.practiceproject.ui.album.AlbumListViewModel
import hoo.yunhoo.practiceproject.ui.post.PostListViewModel
import hoo.yunhoo.practiceproject.ui.post.PostViewModel
import hoo.yunhoo.practiceproject.ui.user.UserListViewModel
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun inject(postListViewModel: PostListViewModel)
    fun inject(userListViewModel: UserListViewModel)
    fun inject(albumListViewModel: AlbumListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}