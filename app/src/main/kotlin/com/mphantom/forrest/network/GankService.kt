package com.mphantom.forrest.network

import com.mphantom.forrest.BuildConfig
import com.mphantom.forrest.model.Model
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by wushaorong on 3/12/16.
 */
interface GankService {
    companion object {
        fun create(): GankService {
            val client = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(
                            if (BuildConfig.LOG_DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()

            val gankAdapter = Retrofit.Builder()
                    .baseUrl("http://gank.io/api/")
                    .client(client)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return gankAdapter.create(GankService::class.java)
        }
    }

    @GET("day/history")
    fun getDayHistory(): Observable<Model.DataHistory>

    @GET("data/{type}/{count}/{page}")
    fun getDataByParams(@Path("type") type: String, @Path("count") count: String,
                        @Path("page") page: String): Observable<Model.TypeList>

    @GET("day/{year}/{month}/{day}")
    fun getDataByDate(@Path("year") year: String, @Path("month") month: String,
                      @Path("day") day: String): Observable<Model.GankDay>

    @GET("random/data/{type}/{count}")
    fun getDataRandom(@Path("type") type: String, @Path("count") count: String)
            : Observable<Model.TypeList>


}