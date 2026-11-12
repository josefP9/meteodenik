package cz.utb.meteodenk.ui.theme

import android.content.Intent
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
import cz.utb.meteodenk.DetailMestaActivity
import cz.utb.meteodenk.R

@Composable
fun SeznamMestObrazovka(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier.padding(all = 16.dp)) {
        Text(text = "Seznam měst")

        Spacer(modifier = Modifier.height(16.dp))

        // Původní tlačítko pro detail
        Button(onClick = {
            val intent = Intent(context, DetailMestaActivity::class.java).apply {
                putExtra("EXTRA_MESTO", "Zlín")
                putExtra("EXTRA_TEPLOTA", 21.5)
            }
            context.startActivity(intent)
        }) {
            Text(text = "Otevřít detail Zlína")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // NOVÉ TLAČÍTKO PRO BROADCAST PODLE ZADÁNÍ
        Button(onClick = {
            val broadcastIntent = Intent(ZaznamUlozenReceiver.ACTION_ZAZNAM_ULOZEN).apply {
                putExtra("EXTRA_MESTO", "Zlín")
                setPackage(context.packageName)
            }
            context.sendBroadcast(broadcastIntent)
        }) {
            Text(text = stringResource(R.string.poslat_zpravu))
        }
    }
}