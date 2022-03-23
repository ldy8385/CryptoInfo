package com.dylee.cryptoinfo.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dylee.cryptoinfo.Api
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

abstract class BaseActivity : Activity() {
    var api: Api? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        api = Api.create(this)
    }

}