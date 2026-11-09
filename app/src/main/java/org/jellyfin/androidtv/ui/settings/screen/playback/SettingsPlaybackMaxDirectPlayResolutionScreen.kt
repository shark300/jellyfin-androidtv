package org.jellyfin.androidtv.ui.settings.screen.playback

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.jellyfin.androidtv.R
import org.jellyfin.androidtv.preference.UserPreferences
import org.jellyfin.androidtv.preference.constant.MaxDirectPlayResolution
import org.jellyfin.androidtv.ui.base.Text
import org.jellyfin.androidtv.ui.base.form.RadioButton
import org.jellyfin.androidtv.ui.base.list.ListButton
import org.jellyfin.androidtv.ui.base.list.ListSection
import org.jellyfin.androidtv.ui.navigation.LocalRouter
import org.jellyfin.androidtv.ui.navigation.focus.focusKey
import org.jellyfin.androidtv.ui.settings.compat.rememberPreference
import org.jellyfin.androidtv.ui.settings.composable.SettingsColumn
import org.koin.compose.koinInject

@Composable
fun SettingsPlaybackMaxDirectPlayResolutionScreen() {
    val router = LocalRouter.current
    val userPreferences = koinInject<UserPreferences>()
    var selection by rememberPreference(userPreferences, UserPreferences.maxDirectPlayResolution)

    SettingsColumn {
        item {
            ListSection(
                overlineContent = { Text(stringResource(R.string.pref_playback_advanced).uppercase()) },
                headingContent = { Text(stringResource(R.string.preference_max_direct_play_resolution)) },
                captionContent = { Text(stringResource(R.string.preference_max_direct_play_resolution_summary)) },
            )
        }
        items(MaxDirectPlayResolution.entries) { value ->
            ListButton(
                headingContent = { Text(stringResource(value.nameRes)) },
                trailingContent = { RadioButton(checked = selection == value) },
                onClick = {
                    selection = value
                    router.back()
                },
                modifier = Modifier.focusKey("max_direct_play_resolution_${value.name}", initialFocus = selection == value)
            )
        }
    }
}
