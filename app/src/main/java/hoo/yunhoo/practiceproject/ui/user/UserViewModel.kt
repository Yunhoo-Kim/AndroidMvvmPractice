package hoo.yunhoo.practiceproject.ui.user

import android.arch.lifecycle.MutableLiveData
import hoo.yunhoo.practiceproject.base.BaseViewModel
import hoo.yunhoo.practiceproject.model.user.User


class UserViewModel: BaseViewModel(){
    private val user_name = MutableLiveData<String>()
    private val name = MutableLiveData<String>()
    private val email = MutableLiveData<String>()

    fun bind(user: User){
        user_name.value = user.username
        name.value = user.name
        email.value = user.email
    }

    fun getUserName():MutableLiveData<String>{
        return this.user_name
    }
    fun getName():MutableLiveData<String> {
        return this.name
    }
}