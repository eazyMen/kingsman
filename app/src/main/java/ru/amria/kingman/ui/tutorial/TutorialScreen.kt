package ru.amria.kingman.ui.tutorial

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.amria.designsystem.base.BaseScaffoldContainer
import ru.amria.designsystem.common.PagerWithIndicator

@Composable
fun TutorialScreen(
    onClick: () -> Unit = {}
) {
    BaseScaffoldContainer(
        title = "",
        containerColor = Color(0xFF142030)
    ) { pv, sc ->
        PagerWithIndicator(
            modifier = Modifier
                .padding(pv)
                .padding(bottom = 32.dp),
            onClick = onClick
        )
    }
}