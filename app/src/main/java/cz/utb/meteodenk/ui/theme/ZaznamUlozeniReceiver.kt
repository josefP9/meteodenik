package cz.utb.meteodenk.ui.theme

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ZaznamUlozenReceiver : BroadcastReceiver() {
    companion object {
        const val ACTION_ZAZNAM_ULOZEN = "cz.utb.meteodenk.ACTION_ZAZNAM_ULOZEN"
        private const val TAG = "Cyklus"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val mesto = intent?.getStringExtra("EXTRA_MESTO") ?: "Neznámé"
        Log.d(TAG, "Receiver onReceive mesto=$mesto")
    }
}
