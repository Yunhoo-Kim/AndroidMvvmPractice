package hoo.yunhoo.practiceproject.ui.user

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import hoo.yunhoo.practiceproject.R
import hoo.yunhoo.practiceproject.databinding.ItemUserBinding
import hoo.yunhoo.practiceproject.model.user.User


class UserListAdapter: RecyclerView.Adapter<UserListAdapter.ViewHolder>(){
    private lateinit var userList: List<User>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val binding: ItemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_user,
                parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return if(::userList.isInitialized) userList.size else 0
    }

    class ViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        private val viewModel = UserViewModel()
        fun bind(user:User){
            viewModel.bind(user)
            binding.viewModel = viewModel
        }
    }
}