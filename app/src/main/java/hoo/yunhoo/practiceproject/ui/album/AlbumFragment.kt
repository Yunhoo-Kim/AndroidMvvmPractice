package hoo.yunhoo.practiceproject.ui.album

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
import hoo.yunhoo.practiceproject.databinding.FragmentAlbumListBinding
import hoo.yunhoo.practiceproject.injection.ViewModelFactory
import javax.inject.Inject


class AlbumFragment: BaseFragment(){
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: FragmentAlbumListBinding
    private lateinit var mViewModel: AlbumListViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album_list, container, false)
        binding.albumList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(AlbumListViewModel::class.java)
        binding.viewModel = mViewModel

        return binding.root
    }

}
