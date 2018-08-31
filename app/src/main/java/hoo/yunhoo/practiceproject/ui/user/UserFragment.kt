package hoo.yunhoo.practiceproject.ui.user

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import hoo.yunhoo.practiceproject.R
import hoo.yunhoo.practiceproject.base.BaseFragment
import hoo.yunhoo.practiceproject.databinding.FragmentUserListBinding
import hoo.yunhoo.practiceproject.injection.ViewModelFactory
import javax.inject.Inject


class UserFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: FragmentUserListBinding
    private lateinit var viewModel: UserListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)
        binding.userList.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserListViewModel::class.java)
        binding.viewModel = viewModel

        val adRequest = AdRequest.Builder().build()
        super.onAttach(context)
        val ad: AdView = binding.adView
        ad.loadAd(adRequest)

        return binding.root
    }

}