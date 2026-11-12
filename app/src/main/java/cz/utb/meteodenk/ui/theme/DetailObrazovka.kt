package cz.utb.meteodenk.ui.theme

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.utb.meteodenk.R
private const val TAG = "Cyklus"

@Composable
fun DetailObrazovka(
    modifier: Modifier = Modifier,
    mesto: String = "",
    teplota: Double? = null
) {
    // Ošetření zobrazení teploty podle formátu nebo chybové hlášky
    val zobrazenaTeplota = if (teplota != null) {
        stringResource(R.string.teplota_format, teplota)
    } else {
        stringResource(R.string.teplota_chybi)
    }

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Město: $mesto")
        Text(text = "Teplota: $zobrazenaTeplota")

        Spacer(modifier = Modifier.height(16.dp))

        // Tlačítko pro sdílení (implicitní Intent) podle zadání
        SdiletTlacitko(mesto = mesto, teplota = teplota)
    }
}

@Composable
fun SdiletTlacitko(mesto: String, teplota: Double?) {
    val context = LocalContext.current

    Button(onClick = {
        Log.d(TAG, "SdiletTlacitko clicked")
        val textKeSdilení = "Počasí v městu $mesto je $teplota"

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, textKeSdilení)
        }

        val shareIntent = Intent.createChooser(intent, null)
        context.startActivity(shareIntent)
    }) {
        Text(text = "Sdílet počasí")
    }
}