package hoo.yunhoo.practiceproject

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager


class App: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun checkInHasNetwork(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    companion object {
        var instance: App? = null
            private set

        fun hasNetwork(): Boolean {
            return instance!!.checkInHasNetwork()
        }
    }
}