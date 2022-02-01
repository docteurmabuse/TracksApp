package com.tizzone.albumapp.presentation

import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.tizzone.albumapp.data.MockWebserverResponse.mockTrackList
import com.tizzone.albumapp.domain.data.TrackViewState
import com.tizzone.albumapp.presentation.ui.components.TrackList
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TrackListTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val tracksData = mockTrackList

    @Test
    fun areTracksShown() {
        composeTestRule.setContent {
            val state = remember {
                TrackViewState(
                    data = tracksData
                )
            }
            TrackList(state = state, onNavigateToTrackDetail = {})
        }
        composeTestRule.onNodeWithText("delectus").assertIsDisplayed()
        composeTestRule.onNodeWithText("deserunt").assertIsDisplayed()
        composeTestRule.onNodeWithText("quidem").assertIsDisplayed()
    }
}
