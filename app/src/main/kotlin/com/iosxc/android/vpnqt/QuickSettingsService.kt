package com.iosxc.android.vpnqt

import android.content.Intent
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class QuickSettingsService : TileService() {
    companion object {
        const val VPN_ACTION = "android.settings.VPN_SETTINGS"
    }

    override fun onTileAdded() {
        super.onTileAdded()
        qsTile.state = Tile.STATE_INACTIVE
        qsTile.updateTile()
    }

    override fun onClick() {
        if (isLocked) {
            return
        }
        connect()
    }

    private fun connect() {
        val intent = Intent(VPN_ACTION)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}