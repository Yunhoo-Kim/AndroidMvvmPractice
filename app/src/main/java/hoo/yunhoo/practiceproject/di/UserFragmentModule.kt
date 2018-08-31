package hoo.yunhoo.practiceproject.di

import dagger.Binds
import dagger.Module
import hoo.yunhoo.practiceproject.model.repository.UserRepository
import hoo.yunhoo.practiceproject.ui.user.UserFragment


@Module
abstract class UserFragmentModule {

    @FragmentScope
    @Binds
    abstract fun bindUserFragment(userFragment: UserFragment): UserFragment

    @FragmentScope
    @Binds
    abstract fun bindUserRepository(userRepository: UserRepository): UserRepository
}