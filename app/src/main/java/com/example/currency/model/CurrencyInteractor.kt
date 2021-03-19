package com.example.currency.model

import com.example.currency.network.Api
import io.reactivex.Single

class CurrencyInteractor(private val api: Api) {

    fun requestCurrencyData() : Single<CurrencyListResponse> {
        return api.getCurrency()
    }
}

