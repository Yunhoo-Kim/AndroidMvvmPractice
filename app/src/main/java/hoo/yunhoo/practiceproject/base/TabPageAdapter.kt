package hoo.yunhoo.practiceproject.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import hoo.yunhoo.practiceproject.ui.album.AlbumFragment
import hoo.yunhoo.practiceproject.ui.post.PostFragment
import hoo.yunhoo.practiceproject.ui.user.UserFragment


class TabPageAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                UserFragment()
            }
            1 -> PostFragment()
            2 -> AlbumFragment()
            else -> PostFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Users"
            1 -> "Blogs"
            2 -> "Albums"
            else -> "Third Tab"
        }
    }
}