//package hoo.yunhoo.practiceproject.data
//
//import android.util.Log
//import hoo.yunhoo.practiceproject.BuildConfig
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//
//class Injector {
//    val BASE_URL = "http://localhost:8000"
//
//    private fun provideRetrofit(baseUrl: String): Retrofit {
//        return Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .client(provideOkhttpClient())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//    }
//
//    private fun provideOkhttpClient() : OkHttpClient {
//        return OkHttpClient.Builder()
//                .addInterceptor(provideHttpLoggingInterceptor())
//                .connectTimeout(45, TimeUnit.SECONDS)
//                .readTimeout(45, TimeUnit.SECONDS)
//                .writeTimeout(45, TimeUnit.SECONDS)
//                .build()
//    }
//
//    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
//        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d("injector", message) })
//        httpLoggingInterceptor.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
//        return httpLoggingInterceptor
//    }
//
//    fun provideApi(): RESTApi {
//        return provideRetrofit(BASE_URL).create(RESTApi::class.java)
//    }
//}