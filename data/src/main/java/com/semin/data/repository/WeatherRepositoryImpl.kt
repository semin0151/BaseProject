package com.semin.data.repository

import com.semin.data.repository.source.WeatherLocalDataSource
import com.semin.data.repository.source.WeatherRemoteDataSource
import com.semin.domain.repository.WeatherRepository

class WeatherRepositoryImpl: WeatherRepository {
    private val localDataSource = WeatherLocalDataSource()
    private val remoteDataSource = WeatherRemoteDataSource()

}