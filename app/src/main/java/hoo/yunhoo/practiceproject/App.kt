package hoo.yunhoo.practiceproject

import android.app.Activity
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.google.android.gms.ads.MobileAds
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import hoo.yunhoo.practiceproject.di.AppModule
import hoo.yunhoo.practiceproject.di.DaggerAppComponent
import hoo.yunhoo.practiceproject.injection.module.NetworkModule
import javax.inject.Inject


class App: Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        instance = this
        DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule(this))
                .networkModule(NetworkModule)
                .build()
                .inject(this)
        MobileAds.initialize(this)
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

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}