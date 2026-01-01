package com.marossolutions.data.repository

import com.marossolutions.common.DataResult
import com.marossolutions.common.DispatcherProvider
import com.marossolutions.domain.model.Airport
import com.marossolutions.domain.model.AirportDetail
import com.marossolutions.domain.repository.AirportRepository
import com.marossolutions.network.datasource.AirportRemoteDataSource
import com.marossolutions.network.model.toDomain
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AirportRepositoryImpl @Inject constructor(
    private val airportRemoteDataSource: AirportRemoteDataSource,
    private val dispatcherProvider: DispatcherProvider
) : AirportRepository {

    private val _airports = MutableStateFlow<DataResult<List<Airport>>?>(null)

    private val _airportDetail = MutableStateFlow<DataResult<AirportDetail>?>(null)

    override val airports: StateFlow<DataResult<List<Airport>>?> = _airports.asStateFlow()

    override val airportDetail: StateFlow<DataResult<AirportDetail>?> = _airportDetail.asStateFlow()

    override suspend fun fetchAirports(country: String) {
        withContext(dispatcherProvider.default) {
            _airports.value = try {
                val airportList = airportRemoteDataSource.getAirportsByCountry(country).map {
                    it.toDomain()
                }
                DataResult.Success(airportList)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                DataResult.Error(e)
            }
        }
    }

    override suspend fun fetchAirport(airportIcao: String) {
        withContext(dispatcherProvider.default) {
            _airportDetail.value = try {
                val airport = airportRemoteDataSource.getAirportByICAO(airportIcao)?.toDomain()
                if (airport != null) {
                    DataResult.Success(airport)
                } else {
                    DataResult.Error(NoSuchElementException("Airport with ICAO code $airportIcao not found"))
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                DataResult.Error(e)
            }
        }
    }

    override fun clearAirportDetail() {
        _airportDetail.value = null
    }
}