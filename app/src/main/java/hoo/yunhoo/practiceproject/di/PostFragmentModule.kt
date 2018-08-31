package hoo.yunhoo.practiceproject.di

import dagger.Binds
import dagger.Module
import hoo.yunhoo.practiceproject.ui.album.AlbumFragment
import hoo.yunhoo.practiceproject.ui.post.PostFragment
import hoo.yunhoo.practiceproject.ui.user.UserFragment


@Module
abstract class PostFragmentModule {

    @FragmentScope
    @Binds
    abstract fun bindPostFragment(postFragment: PostFragment): PostFragment
}