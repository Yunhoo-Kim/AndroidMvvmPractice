package hoo.yunhoo.practiceproject.di

import dagger.Binds
import dagger.Module
import hoo.yunhoo.practiceproject.ui.MainActivity

@Module
abstract class MainActivityModule {

    @ActivityScope
    @Binds
    abstract fun provideMainView(activity: MainActivity): MainActivity

}