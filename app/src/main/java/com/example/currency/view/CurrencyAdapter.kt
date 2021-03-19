package com.example.currency.view

import androidx.recyclerview.widget.RecyclerView
import com.example.currency.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currency.model.CurrencyListResponse
import kotlinx.android.synthetic.main.currency_list_item.view.*

class CurrencyAdapter(
    private val context: Context,
    private val currencyList: CurrencyListResponse
) : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return currencyList.valute.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.currency_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currencyList = ArrayList(currencyList.valute.values)
        viewHolder.fullName.text = currencyList[position].fullName
        viewHolder.shortName.text = currencyList[position].shortName
        viewHolder.value.text = currencyList[position].value.toString()
        viewHolder.flagImage.setImageResource(viewHolder.getFlagImage(currencyList[position].shortName))

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullName = itemView.fullName
        val value = itemView.value
        val shortName = itemView.shortName
        val flagImage = itemView.flagImage

        fun getFlagImage(shortName: String?): Int {
            return when (shortName) {
                "AMD" -> R.drawable.flag_amd
                "AUD" -> R.drawable.flag_aud
                "AZN" -> R.drawable.flag_azn
                "BGN" -> R.drawable.flag_bgn
                "BRL" -> R.drawable.flag_brl
                "BYN" -> R.drawable.flag_byn
                "CAD" -> R.drawable.flag_cad
                "CHF" -> R.drawable.flag_chf
                "CNY" -> R.drawable.flag_cny
                "CZK" -> R.drawable.flag_czk
                "DKK" -> R.drawable.flag_dkk
                "EUR" -> R.drawable.flag_eur
                "GBP" -> R.drawable.flag_gbp
                "HKD" -> R.drawable.flag_hkd
                "HUF" -> R.drawable.flag_huf
                "INR" -> R.drawable.flag_inr
                "JPY" -> R.drawable.flag_jpy
                "KGS" -> R.drawable.flag_kgs
                "KRW" -> R.drawable.flag_krw
                "KZT" -> R.drawable.flag_kzt
                "MDL" -> R.drawable.flag_mdl
                "NOK" -> R.drawable.flag_nok
                "PLN" -> R.drawable.flag_pln
                "RON" -> R.drawable.flag_ron
                "SEK" -> R.drawable.flag_sek
                "SGD" -> R.drawable.flag_sgd
                "TJS" -> R.drawable.flag_tjs
                "TMT" -> R.drawable.flag_tmt
                "TRY" -> R.drawable.flag_try
                "UAH" -> R.drawable.flag_uah
                "USD" -> R.drawable.flag_usd
                "UZS" -> R.drawable.flag_uzs
                "XDR" -> R.drawable.flag_xdr
                "ZAR" -> R.drawable.flag_zar

                else -> R.drawable.ic_launcher_foreground
            }
        }
    }
}
