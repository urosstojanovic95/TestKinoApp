package com.example.testkinoapp.screens.table

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testkinoapp.R
import com.example.testkinoapp.ui_components.buttons.ActionButton
import com.example.testkinoapp.ui_components.cards.FloatingCard
import com.example.testkinoapp.ui_components.drop_down.RandomDropDown
import com.example.testkinoapp.ui_components.grids.TableGrid
import com.example.testkinoapp.ui_components.texts.RegularText
import com.example.testkinoapp.utils.Tools
import java.time.Instant

@Composable
fun TableScreen(
    drawId: Long = 0,
    openLiveDraw: () -> Unit = {},
) {
    val viewModel: TableViewModel = viewModel()
    var time = remember { mutableStateOf("00:00") }

    LaunchedEffect(Unit) {
        viewModel.getDraw(drawId)
        viewModel.eventFlow.collect {
            Tools.timer(
                endTime = Instant.ofEpochMilli(viewModel.draw.value.drawTime ?: 0),
                timeState = time,
                onTimeElapsed = {
                    openLiveDraw()
                }
            )
        }
    }
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.backgroundColor))
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            RegularText(
                text = stringResource(id = R.string.kolo) + " ${viewModel.draw.value.drawId ?: ""}. "
            )
            RegularText(text = stringResource(id = R.string.u) + " ${viewModel.draw.value.hourAndMinute}`")
            Spacer(modifier = Modifier.weight(1f))
            RegularText(
                text = time.value,
                color = colorResource(id = R.color.colorSecondary)
            )
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RandomDropDown(
                onItemClick = viewModel::choseRandomNumber
            )
            ActionButton(text = stringResource(id = R.string.obrisi), onClick = viewModel::clearAllNumbers)

        }
        TableGrid(
            selectedNumber = viewModel.selectedNumbers.value,
            onItemClick = viewModel::onItemClick,
            addingEnabled = viewModel.addingEnabled
        )
        AnimatedVisibility(
            visible = viewModel.selectedNumbers.value.isNotEmpty(),
            enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
                animationSpec = tween(300),
                initialOffsetY = { it }
            ),
            exit = fadeOut(animationSpec = tween(300)) + slideOutVertically(
                animationSpec = tween(300),
                targetOffsetY = { it }
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(3f)
            ) {
                FloatingCard(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    count = viewModel.selectedNumbers.value.size
                )
            }
        }
    }
}

@Preview
@Composable
fun TableScreenPreview(
    drawId: Long = 0,
    openLiveDraw: () -> Unit = {},
) {
    TableScreen()
}


