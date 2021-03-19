package com.example.currency.model

import com.google.gson.annotations.SerializedName

data class CurrencyListResponse(
    @SerializedName("Date")
    val date: String,

    @SerializedName("Valute")
    val valute: Map<String, CurrencyListItem>
)

data class CurrencyListItem(
    @SerializedName("ID")
    val id: String? = null,

    @SerializedName("NumCode")
    val code: Int? = null,

    @SerializedName("CharCode")
    val shortName: String? = null,

    @SerializedName("Nominal")
    val nominal: Int? = null,

    @SerializedName("Name")
    val fullName: String? = null,

    @SerializedName("Value")
    val value: Double? = null,

    @SerializedName("Previous")
    val previous: Double? = null
)

