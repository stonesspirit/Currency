package com.example.currency.presenter

import com.example.currency.model.CurrencyInteractor
import com.example.currency.model.CurrencyListResponse
import com.example.currency.view.CurrencyView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class CurrencyPresenter(
    private val currencyView: CurrencyView,
    private val currencyInteractor: CurrencyInteractor

)  {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun onCreate(){
        getCurrencyList()
    }

    private fun getCurrencyList() {
        currencyView.showProgress()
        compositeDisposable.add(currencyInteractor.requestCurrencyData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse, this::handleError))
    }

    private fun handleResponse(currencyItem: CurrencyListResponse) {
        currencyView.hideProgress()
        currencyView.setCurrencyData(currencyItem)
    }

    private fun handleError(error: Throwable) {
        currencyView.hideProgress()
        currencyView.getDataFailed(error.message!!)
    }

    fun onRefresh () {
        getCurrencyList()
    }

    fun onDestroy() {
        compositeDisposable.dispose()
    }
}