package cz.utb.meteodenk

import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cz.utb.meteodenk.ui.theme.MeteoDeníkTheme
import cz.utb.meteodenk.ui.theme.SeznamMestObrazovka
import cz.utb.meteodenk.ui.theme.ZaznamUlozenReceiver

private const val TAG = "Cyklus"
private val receiver = ZaznamUlozenReceiver()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity onCreate (savedInstanceState = $savedInstanceState)")
        enableEdgeToEdge()
        setContent {
            MeteoDeníkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SeznamMestObrazovka(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(ZaznamUlozenReceiver.ACTION_ZAZNAM_ULOZEN)
        registerReceiver(receiver, filter, RECEIVER_NOT_EXPORTED)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeteoDeníkTheme {
        Greeting("Android")
    }
}