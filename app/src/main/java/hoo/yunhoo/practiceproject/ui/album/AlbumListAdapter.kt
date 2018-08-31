package hoo.yunhoo.practiceproject.ui.album

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import hoo.yunhoo.practiceproject.R
import hoo.yunhoo.practiceproject.databinding.ItemAlbumBinding
import hoo.yunhoo.practiceproject.model.albums.Album
import hoo.yunhoo.practiceproject.utils.extension.getParentActivity
import kotlinx.android.synthetic.main.item_album.view.*


class AlbumListAdapter: RecyclerView.Adapter<AlbumListAdapter.ViewHolder>(){
    private lateinit var albumList:List<Album>

    override fun getItemCount(): Int {
        return if(::albumList.isInitialized) albumList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(albumList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemAlbumBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_album, parent,false)
        return ViewHolder(binding)
    }

    fun updateAlbumList(albumList: List<Album>){
        this.albumList = albumList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root) {
        private val viewModel: AlbumViewModel = AlbumViewModel()

        fun bind(album: Album){
            viewModel.bind(album)
            binding.viewModel = viewModel
            binding.title.setOnClickListener { view ->
                println("Title is ${album.title}")
                println("Title is ${album.id}")
            }

        }
    }
}