package hoo.yunhoo.practiceproject.ui.post

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import hoo.yunhoo.practiceproject.R
import hoo.yunhoo.practiceproject.base.BaseFragment
import hoo.yunhoo.practiceproject.databinding.FragmentPostListBinding
import hoo.yunhoo.practiceproject.injection.ViewModelFactory
import javax.inject.Inject


class PostFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: FragmentPostListBinding
    private lateinit var mViewModel: PostListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_list, container, false)
        binding.postList.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostListViewModel::class.java)
        binding.viewModel = mViewModel
        return binding.root
    }

}