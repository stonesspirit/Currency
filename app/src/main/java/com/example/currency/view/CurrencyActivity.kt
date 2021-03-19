package com.example.currency.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.currency.R
import com.example.currency.model.CurrencyInteractor
import com.example.currency.model.CurrencyListResponse
import com.example.currency.network.Api
import com.example.currency.presenter.CurrencyPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CurrencyView {

    private lateinit var currencyPresenter: CurrencyPresenter
    private lateinit var currencyAdapter: CurrencyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        currencyPresenter = CurrencyPresenter(this, CurrencyInteractor(Api.create()))
        currencyPresenter.onCreate()

        val refreshButton = findViewById<Button>(R.id.refreshButton)
        refreshButton.setOnClickListener {
            currencyPresenter.onRefresh()
        }
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun setCurrencyData(currencyItem: CurrencyListResponse) {
        currencyAdapter = CurrencyAdapter(this, currencyItem)
        recyclerCurrencyList.adapter = currencyAdapter
    }

    override fun getDataFailed(strError: String) {
        Toast.makeText(this, strError, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        currencyPresenter.onDestroy()
        super.onDestroy()
    }
}
