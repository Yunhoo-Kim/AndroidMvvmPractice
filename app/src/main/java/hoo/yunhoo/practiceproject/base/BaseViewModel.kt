package hoo.yunhoo.practiceproject.base

import android.arch.lifecycle.ViewModel
import hoo.yunhoo.practiceproject.injection.component.DaggerViewModelInjector
import hoo.yunhoo.practiceproject.injection.component.ViewModelInjector
import hoo.yunhoo.practiceproject.injection.module.NetworkModule
import hoo.yunhoo.practiceproject.ui.post.PostListViewModel
import hoo.yunhoo.practiceproject.ui.post.PostViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when(this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }
}