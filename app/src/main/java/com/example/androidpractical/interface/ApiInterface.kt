package com.example.androidpractical.`interface`

import com.example.androidpractical.Models.AddUserDataClass
import com.example.androidpractical.Models.LoginRequest
import com.example.androidpractical.Models.RetrofitUserListModelClass
import com.example.androidpractical.Models.SingleUserDataClass
import com.example.androidpractical.presenter.LoginModelClass
import com.example.androidpractical.presenter.LoginModelInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @POST("api/login")
    fun verifyLogin(@Body loginRequest: LoginRequest): Call<Any>

    @POST("api/login")
    fun loginWithMVC(@Body loginRequest: LoginModelClass): Call<Any>

    @GET("api/users?delay=3")
    fun getUserList(): Call<RetrofitUserListModelClass>

    @POST("api/users")
    fun addUser(@Body addUser: AddUserDataClass): Call<Any>

    @GET("api/users/{ID}")
    fun getSingleUser(@Path(value = "ID", encoded = true) ID: String?): Call<SingleUserDataClass>

    companion object {
        fun getRetrofitObject(): Retrofit {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor)
                .addInterceptor(
                    Interceptor { chain ->
                        val builder = chain.request().newBuilder()
                        builder.header("Content-Type", "application/json")
                        return@Interceptor chain.proceed(builder.build())
                    }
                )
            val build: OkHttpClient = client.build()
            return Retrofit.Builder().baseUrl("https://reqres.in/")
                .client(build)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}