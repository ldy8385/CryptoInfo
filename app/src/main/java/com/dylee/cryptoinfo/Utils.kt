package com.dylee.cryptoinfo.activity

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.dylee.cryptoinfo.R
import com.dylee.cryptoinfo.view.IndicatorDialog
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 토스트
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// 통신할때 인디케이터 뿌려줌
fun <T> Call<T>.enqueue(context: Context, onResponse: (it: Response<T>) -> Unit) {
    val indicatorDialog = IndicatorDialog(context)
    indicatorDialog.show()

    val callback = object : Callback<T> {

        override fun onFailure(call: Call<T>, t: Throwable) {
            indicatorDialog.dismiss()
            Log.e(
                "fail-connection",
                "url = ${t.printStackTrace()}"
            )
            context.toast("통신 실패")
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            indicatorDialog.dismiss()
            if (response.code() != 200) {
                Log.e("error", "${response.code()} ${response.body()}")

//                val builder = android.app.AlertDialog.Builder(context)
//                builder.setTitle("에러: ${response.code()}")
//                builder.setMessage("${response.body()}")
//                    .setPositiveButton(context.getString(R.string.DIALOG_CLOSE)) { errorDialog, _ ->
//                        errorDialog.dismiss()
//                    }
//                builder.show()
                return
            }
            Log.e("call", "${call.request()}")
            Log.e("response", "${response.code()} ${response.body()}")
            onResponse.invoke(response)
        }
    }
    this.enqueue(callback)
}