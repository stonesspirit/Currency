package com.example.currency.view

import com.example.currency.model.CurrencyListResponse

interface CurrencyView {
    fun showProgress()
    fun hideProgress()
    fun setCurrencyData(currencyItem: CurrencyListResponse)
    fun getDataFailed(strError: String)
}