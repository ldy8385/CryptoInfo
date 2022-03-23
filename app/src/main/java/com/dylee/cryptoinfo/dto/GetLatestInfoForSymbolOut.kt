package com.dylee.cryptoinfo.dto

import com.google.gson.annotations.SerializedName

data class GetLatestInfoForSymbolResultOut (
    @SerializedName("ret_code")
    var retCode : Int? = null,
    @SerializedName("ret_msg")
    var retMsg : String? = null,
    @SerializedName("ext_code")
    var extCode : String? = null,
    @SerializedName("ext_info")
    var extInfo : String? = null,
    @SerializedName("result")
    var result : List<GetLatestInfoForSymbolOut>? = null
)

data class GetLatestInfoForSymbolOut (
    @SerializedName("symbol")
    val symbol : String? = null, //	Symbol
    @SerializedName("bid_price")
    val bidPrice : String? = null, //	Purchase price of the first order
    @SerializedName("ask_price")
    val askPrice : String? = null, //	Selling price of the first order
    @SerializedName("last_price")
    val lastPrice : String? = null, //	Latest transaction price
    @SerializedName("tick_direction")
    val tickDirection : String? = null, //	Direction of price change
    @SerializedName("prev_price_24h")
    val prevPrice24h : String? = null, //	Price of 24 hours ago
    @SerializedName("price_24h_pcnt")
    val price24hPcnt : String? = null, //	Percentage change of market price relative to 24h
    @SerializedName("high_price_24h")
    val highPrice24h : String? = null, //	The highest price in the last 24 hours
    @SerializedName("low_price_24h")
    val lowPrice24h : String? = null, //	Lowest price in the last 24 hours
    @SerializedName("prev_price_1h")
    val prevPrice1h : String? = null, //	Hourly market price an hour ago
    @SerializedName("price_1h_pcnt")
    val price1hPcnt : String? = null, //	Percentage change of market price relative to 1 hour ago
    @SerializedName("mark_price")
    val markPrice : String? = null, //	Mark price
    @SerializedName("index_price")
    val indexPrice : String? = null, //	Index_price
    @SerializedName("open_interest")
    val openInterest : Double? = null, //	Open interest
    @SerializedName("open_value")
    val openValue : String? = null, //	Open position value
    @SerializedName("total_turnover")
    val totalTurnover : String? = null, //	Total turnover
    @SerializedName("turnover_24h")
    val turnover24h : String? = null, //	Turnover for 24H
    @SerializedName("total_volume")
    val totalVolume : Double? = null, //	Total volume
    @SerializedName("volume_24h")
    val volume24h : Double? = null, //	Trading volume in the last 24 hours
    @SerializedName("funding_rate")
    val fundingRate : String? = null, //	Funding rate
    @SerializedName("predicted_funding_rate")
    val predictedFundingRate : String? = null, //	Predicted funding rate
    @SerializedName("next_funding_time")
    val nextFundingTime : String? = null, //	Next settlement time of capital cost
    @SerializedName("countdown_hour")
    val countdownHour : Double? = null, //	Countdown of settlement capital cost
    @SerializedName("delivery_fee_rate")
    val deliveryFeeRate : String? = null, //	Delivery fee rate of Futures contract
    @SerializedName("predicted_delivery_price")
    val predictedDeliveryPrice : String? = null, //	Predicted delivery price of Futures contract
    @SerializedName("delivery_time")
    val deliveryTime : String? = null //	Delivery time of Futures contract
)