package com.dylee.cryptoinfo.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.dylee.cryptoinfo.R
import com.dylee.cryptoinfo.databinding.ActivityMainBinding
import com.dylee.cryptoinfo.dto.GetLatestInfoForSymbolOut
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {
    var symbol = "BTCUSDT"
    var getLastestInfoForSymbolOut: GetLatestInfoForSymbolOut? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    fun init() {
        getLastestInfoForSymbol()

        btn.setOnClickListener(this)
    }

    fun getLastestInfoForSymbol() {
        api !!.getLatestInfoForSymbol("BTCUSDT").enqueue(this) {
//            getLastestInfoForSymbolOut = it.body().result
            for (i in it.body()!!.result!!) {
                getLastestInfoForSymbolOut = i
            }
        }
        symbolTv.text = getLastestInfoForSymbolOut?.symbol ?: "no result"
        priceTv.text = getLastestInfoForSymbolOut?.bidPrice ?: "no result"
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn -> {
                getLastestInfoForSymbol()
            }
        }
    }

}