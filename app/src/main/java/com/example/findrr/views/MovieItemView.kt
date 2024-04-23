package com.example.findrr.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.findrr.R
import com.example.findrr.data.Movie

@Composable
fun MovieItem(movie: Movie) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.size(120.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = "https://image.tmdb.org/t/p/w500/${movie.posterPath}")
                            .apply(block = fun ImageRequest.Builder.() {
                                placeholder(R.drawable.ic_launcher_background)
                                error(R.drawable.ic_launcher_background)
                            }).build()
                    ),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Release Date: ${movie.releaseDate}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Rating: ${movie.voteAverage}/10",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}