package hoo.yunhoo.practiceproject.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import dagger.android.AndroidInjection
import hoo.yunhoo.practiceproject.R
import hoo.yunhoo.practiceproject.base.BaseActivity
import hoo.yunhoo.practiceproject.base.TabPageAdapter
import hoo.yunhoo.practiceproject.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var fragmentPageAdapter = TabPageAdapter(supportFragmentManager)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.tabPageAdapter = fragmentPageAdapter
        tabs_main.setupWithViewPager(viewpager_main)
    }
}