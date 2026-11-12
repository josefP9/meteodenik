package cz.utb.meteodenk

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import cz.utb.meteodenk.ui.theme.DetailObrazovka
import cz.utb.meteodenk.ui.theme.MeteoDeníkTheme

private const val TAG = "Cyklus"

class DetailMestaActivity : ComponentActivity() {

    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "DetailMestaActivity onCreate (savedInstanceState = $savedInstanceState)")

        // TADY SI VYTAHNOUT DATA Z INTENTU:
        val mesto = intent.getStringExtra("EXTRA_MESTO") ?: "Neznámé město"
        val teplota = if (intent.hasExtra("EXTRA_TEPLOTA")) {
            intent.getDoubleExtra("EXTRA_TEPLOTA", 0.0)
        } else {
            null
        }

        enableEdgeToEdge()
        setContent {
            MeteoDeníkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // A TADY JE PŘEDAT DO OBRAZOVKY:
                    DetailObrazovka(
                        mesto = mesto,
                        teplota = teplota,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "DetailMestaActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "DetailMestaActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "DetailMestaActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "DetailMestaActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "DetailMestaActivity onDestroy")
    }
}
