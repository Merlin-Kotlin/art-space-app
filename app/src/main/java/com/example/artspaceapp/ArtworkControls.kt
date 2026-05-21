package com.example.artspaceapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text

@Composable
fun ArtworkControls(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = "Previous")
        }

        Button(
            onClick = onNextClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = "Next")
        }
    }
}