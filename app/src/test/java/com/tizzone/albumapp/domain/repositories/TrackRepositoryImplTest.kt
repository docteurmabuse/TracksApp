package com.tizzone.albumapp.domain.repositories

import com.google.gson.GsonBuilder
import com.tizzone.albumapp.data.network.MockWebserverResponse.trackListResponse
import com.tizzone.albumapp.data.network.TracksApi
import com.tizzone.albumapp.domain.model.Track
import com.tizzone.albumapp.domain.model.mappers.TrackDtoMapper
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.net.ssl.HttpsURLConnection

class TrackRepositoryImplTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var baseUrl: HttpUrl

    // System in test
    private lateinit var apiService: TracksApi

    // Dependencies
    private val dtoMapper = TrackDtoMapper()

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        baseUrl = mockWebServer.url("")

        apiService = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .create()
                )
            )
            .build()
            .create(TracksApi::class.java)
    }

    @Test
    fun testGetTRacksFromNetworkIsWorking(): Unit = runBlocking {
        // Condition the response
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpsURLConnection.HTTP_OK)
                .setBody(trackListResponse)
        )
        var tracks = listOf<Track>()
        // Track list should be empty
        assert(tracks.isEmpty())
        // Adding api result of tracks in the list
        tracks = apiService.getAsyncAlbums().let { it ->
            dtoMapper.toDomainAlbumsList(it)
        }
        // Track list should not be empty
        assert(tracks.isNotEmpty())
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
