package com.example.artspaceapp

import com.example.artspaceapp.R

data class Artwork(
    val imageRes: Int,
    val title: String,
    val artist: String,
    val year: String
)
val artworkList = listOf(
    Artwork(
        imageRes = R.drawable.artwork1,
        title = "Starry Night",
        artist = "Vincent Van Gogh",
        year = "1889"
    ),
    Artwork(
        imageRes = R.drawable.artwork2,
        title = "The persistence of Memory",
        artist = "Salvandor Dali",
        year = "1931"
    ),
    Artwork(
        imageRes = R.drawable.artwork3,
        title = "Girl with a Pearl Earring",
        artist = "Johannes Vermeer",
        year = "1665"
    )
)