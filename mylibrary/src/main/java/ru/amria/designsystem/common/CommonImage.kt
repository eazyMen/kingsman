package ru.amria.designsystem.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import ru.amria.designsystem.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CommonImage(modifier: Modifier = Modifier.fillMaxSize(), imageUrl: String) {
    GlideImage(
        model = imageUrl,
        contentDescription = null,
        failure = placeholder(R.drawable.logo_transparent),
        modifier = modifier,
        contentScale = ContentScale.Crop,
    )
}