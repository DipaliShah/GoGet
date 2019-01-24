package com.goget.webservice

import com.goget.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Dipali Shah on 24/1/19
 */
class RetrofitSingleton {

    companion object {
        @Volatile
        private var instance: RetrofitSingleton? = null

        fun getInstance(): RetrofitSingleton {
            if (instance == null) {
                instance = RetrofitSingleton()
            }
            return instance as RetrofitSingleton
        }
    }

    private fun getOkHttpClient(): OkHttpClient.Builder {

        try {
            val builder = OkHttpClient.Builder()
            builder.hostnameVerifier { hostname, session -> true }
            builder.connectTimeout(80, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val original = chain.request()
                    val request = original.newBuilder()
                        .header(WSConstants.HEADER_CONTENT_TYPE, WSConstants.CONTENT_TYPE)
                        .header(WSConstants.HEADER_ACCEPT, WSConstants.CONTENT_TYPE)
                        .method(original.method(), original.body())
                        .build()
                    chain.proceed(request)
                }

            return builder
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }


    private fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(provideGson())
    }

    private fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    private fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(provideGsonConverterFactory())
            .addCallAdapterFactory(provideRxJavaCallAdapterFactory())
            .client(getOkHttpClient().build())
            .build()
    }

    fun provideApiService(): ApiInterface {
        return provideRetrofit().create(ApiInterface::class.java)
    }
}