package org.jellyfin.androidtv.preference.constant

import org.jellyfin.androidtv.R

/**
 * User-selected maximum resolution allowed for direct video playback.
 */
enum class MaxDirectPlayResolution(
	val nameRes: Int,
	val maxWidth: Int?,
	val maxHeight: Int?,
) {
    AUTO(R.string.max_direct_play_resolution_auto, null, null),
    P720(R.string.max_direct_play_resolution_720p,1280, 720),
    P1080(R.string.max_direct_play_resolution_1080p,1920, 1080),
    P1440(R.string.max_direct_play_resolution_1440p,2560, 1440),
    P2160(R.string.max_direct_play_resolution_2160p,3840, 2160),
}
