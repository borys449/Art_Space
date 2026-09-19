package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtwork by remember { mutableStateOf(1) }
    val totalArtworks = 3

    val imageResource: Int
    val titleResource: Int
    val artistResource: Int
    val yearResource: Int

    when (currentArtwork) {
        1 -> {
            imageResource = R.drawable.art_1
            titleResource = R.string.title_1
            artistResource = R.string.artist_1
            yearResource = R.string.year_1
        }
        2 -> {
            imageResource = R.drawable.art_2
            titleResource = R.string.title_2
            artistResource = R.string.artist_2
            yearResource = R.string.year_2
        }
        else -> {
            imageResource = R.drawable.art_3
            titleResource = R.string.title_3
            artistResource = R.string.artist_3
            yearResource = R.string.year_3
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shadowElevation = 8.dp,
            color = Color.White
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(titleResource),
                contentScale = ContentScale.Fit,
                modifier = Modifier.padding(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Surface(
            color = Color(0xFFECEBF4),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(titleResource),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light
                )
                Row {
                    Text(
                        text = stringResource(artistResource),
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = " (${stringResource(yearResource)})")
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentArtwork =
                        if (currentArtwork == 1) totalArtworks else currentArtwork - 1
                },
                modifier = Modifier.width(140.dp)
            ) {
                Text(stringResource(R.string.previous))
            }

            Button(
                onClick = {
                    currentArtwork =
                        if (currentArtwork == totalArtworks) 1 else currentArtwork + 1
                },
                modifier = Modifier.width(140.dp)
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}