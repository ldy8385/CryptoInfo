package com.dylee.cryptoinfo

import android.app.Activity
import android.content.Context
import android.os.Build
import com.dylee.cryptoinfo.dto.GetLatestInfoForSymbolOut
import com.dylee.cryptoinfo.dto.GetLatestInfoForSymbolResultOut
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/v2/public/tickers")
    fun getLatestInfoForSymbol(@Query("symbol") symbol: String?): Call<GetLatestInfoForSymbolResultOut>

    companion object {
        fun create(context: Context): Api {
            var referrer: String? = null
            try {
                referrer = (context as Activity).localClassName.split(".").last()
            } catch (e: Exception) {
                e.printStackTrace()
            }

//            val client = OkHttpClient.Builder()
//                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.URL_BYBIT)
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }
}