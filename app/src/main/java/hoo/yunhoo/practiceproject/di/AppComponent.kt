package hoo.yunhoo.practiceproject.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import hoo.yunhoo.practiceproject.App
import hoo.yunhoo.practiceproject.injection.module.NetworkModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilder::class, NetworkModule::class, ViewModelModule::class))
interface AppComponent{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder
        fun appModule(appModule: AppModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}