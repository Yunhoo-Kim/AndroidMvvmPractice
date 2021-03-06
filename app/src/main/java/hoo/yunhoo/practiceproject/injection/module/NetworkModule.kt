package hoo.yunhoo.practiceproject.injection.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import hoo.yunhoo.practiceproject.BuildConfig
import hoo.yunhoo.practiceproject.network.AlbumApi
import hoo.yunhoo.practiceproject.network.PostApi
import hoo.yunhoo.practiceproject.network.UserApi
import hoo.yunhoo.practiceproject.utils.BASE_URL
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@Suppress("unused")
object NetworkModule {
    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideAlbumApi(retrofit: Retrofit): AlbumApi{
        return retrofit.create(AlbumApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofit(gson: Gson, client: OkHttpClient):Retrofit{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client)
                .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOkhttpClient(interceptor: Interceptor) : OkHttpClient {
        val logger: HttpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)
            logger.level = HttpLoggingInterceptor.Level.BODY
        else
            logger.level = HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
                .connectTimeout(45, TimeUnit.SECONDS)
                .readTimeout(45, TimeUnit.SECONDS)
                .writeTimeout(45, TimeUnit.SECONDS)
                .addInterceptor(logger)
                .addInterceptor(interceptor)
                .build()
    }
    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor {
            val builder: Request.Builder = it.request().newBuilder()
            builder.header("User-Agent", "Android")

            it.proceed(builder.build())
        }
    }
}