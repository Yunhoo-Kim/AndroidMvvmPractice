package hoo.yunhoo.practiceproject.injection.component

import dagger.Component
import hoo.yunhoo.practiceproject.injection.module.NetworkModule
import hoo.yunhoo.practiceproject.ui.post.PostListViewModel
import hoo.yunhoo.practiceproject.ui.post.PostViewModel
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun inject(postListViewModel: PostListViewModel)
    fun inject(postViewModel: PostViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}