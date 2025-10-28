package com.example.truthortruth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.truthortruth.ui.theme.TruthOrTruthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TruthOrTruthTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TruthApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TruthApp(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }

    // Change these image names to your actual truth question images
    val imageResource = when (result) {
        1 -> R.drawable.screenshot_2025_10_28_at_2_03_56pm
        2 -> R.drawable.screenshot_2025_10_28_at_2_04_05pm
        3 -> R.drawable.screenshot_2025_10_28_at_2_04_21pm
        4 -> R.drawable.screenshot_2025_10_28_at_2_04_33pm
        5 -> R.drawable.screenshot_2025_10_28_at_2_04_42pm
        6 -> R.drawable.screenshot_2025_10_28_at_2_04_51pm
        else -> R.drawable.screenshot_2025_10_28_at_2_05_01pm
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Show your truth question image
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Truth Image"
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Button to change truth image
        Button(onClick = { result = (1..7).random() }) {
            Text(text = "Truth", fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TruthPreview() {
    TruthOrTruthTheme {
        TruthApp()
    }
}
