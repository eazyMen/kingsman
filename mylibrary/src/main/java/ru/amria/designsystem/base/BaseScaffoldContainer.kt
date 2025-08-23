package ru.amria.designsystem.base

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.amria.designsystem.common.CommonTopBar
import ru.amria.designsystem.theme.KingsmanTheme

@Composable
fun BaseScaffoldContainer(
    modifier: Modifier = Modifier,
    containerColor: Color = KingsmanTheme.extraColors.backgroundColor,
    title: String,
    scrollState: ScrollState = rememberScrollState(),
    onBackClick: (() -> Unit)? = null,
    content: @Composable (PaddingValues, ScrollState) -> Unit
) {
    Scaffold(
        topBar = {
            CommonTopBar(
                titleText = title,
                onBackClick = onBackClick
            )
        },
        containerColor = containerColor,
        modifier = modifier
    ) { innerPadding ->
        content(innerPadding, scrollState)
    }
}

@Preview
@Composable
fun BaseScaffoldContainerPreview(){
    KingsmanTheme {
        BaseScaffoldContainer(
            title = "Запоминашка"
        ) { pv, ss ->

        }
    }
}