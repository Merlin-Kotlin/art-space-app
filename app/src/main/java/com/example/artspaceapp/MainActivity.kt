package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceApp() {
    var currentIndex by remember { mutableIntStateOf(0) }
    val currentArtwork = artworkList[currentIndex]

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Art Space",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        ArtSpaceScreen(
            currentArtwork = currentArtwork,
            currentIndex = currentIndex,
            totalArtworks = artworkList.size,
            onPreviousClick = {
                currentIndex = if (currentIndex > 0)
                    currentIndex - 1
                else
                    artworkList.size - 1
            },
            onNextClick = {
                currentIndex = if (currentIndex < artworkList.size - 1)
                    currentIndex + 1
                else
                    0
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ArtSpaceScreen(
    currentArtwork: Artwork,
    currentIndex: Int,
    totalArtworks: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkWall(artwork = currentArtwork)

        Spacer(modifier = Modifier.height(24.dp))

        ArtworkInfo(artwork = currentArtwork)

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${currentIndex + 1} / $totalArtworks",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        ArtworkControls(
            onPreviousClick = onPreviousClick,
            onNextClick = onNextClick
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}