package com.suncere.kotlin.mvp.api.protocol

/**
 * @author lys
 * @time 2019/12/16 09:44
 * @desc:
 */
data class TestBean(
        val AQI: String,
        val AQI_Level: Int,
        val AirPress: String,
        val AirTemperature: String,
        val CO: String,
        val CO_Level: Int,
        val Lat: String,
        val Level: Int,
        val LevelText: String,
        val Lon: String,
        val NO2: String,
        val NO2_Level: Int,
        val O3: String,
        val O3_Level: Int,
        val PM10: String,
        val PM10_Level: Int,
        val PM2_5: String,
        val PM2_5_Level: Int,
        val PrimaryPollutant: String,
        val RelHumidity: String,
        val SO2: String,
        val SO2_Level: Int,
        val StationId: String,
        val StationName: String,
        val StationType: String,
        val TimePoint: String,
        val WindDirection: String,
        val WindSpeed: String
)