package hoo.yunhoo.practiceproject.ui.user

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import hoo.yunhoo.practiceproject.R
import hoo.yunhoo.practiceproject.databinding.ActivityUserListBinding
import hoo.yunhoo.practiceproject.injection.ViewModelFactory


class UserListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityUserListBinding
    private lateinit var viewModel: UserListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
//        binding.userList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//
//        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(UserListViewModel::class.java)
//        binding.viewModel = viewModel
    }
}