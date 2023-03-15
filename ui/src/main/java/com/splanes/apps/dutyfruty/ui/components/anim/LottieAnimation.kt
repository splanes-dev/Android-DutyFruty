package com.splanes.apps.dutyfruty.ui.components.anim

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LottieAnimation(
    @RawRes resource: Int,
    modifier: Modifier = Modifier,
    iterations: Int = LottieConstants.IterateForever,
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(resource))
    val animState by animateLottieCompositionAsState(
        composition = composition,
        iterations = iterations,
    )

    com.airbnb.lottie.compose.LottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = { animState }
    )
}
