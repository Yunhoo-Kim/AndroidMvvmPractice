package hoo.yunhoo.practiceproject.model

import android.databinding.BaseObservable


class Tweet: BaseObservable() {
    var id: Long = 0
    var content: String? = null
}
