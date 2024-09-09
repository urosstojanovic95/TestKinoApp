package com.example.testkinoapp.ui_components.drop_down

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.testkinoapp.R
import com.example.testkinoapp.ui_components.buttons.ActionButton
import com.example.testkinoapp.ui_components.texts.RegularText

@Preview
@Composable
fun RandomDropDown(
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit = {}
) {

    val expanded = remember { mutableStateOf(false) }
    val numbers = remember {
        mutableListOf(1, 2, 3, 4, 5, 6, 7, 8)
    }
    Box(
        contentAlignment = Alignment.TopCenter // Center the content on the screen
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ActionButton(text = stringResource(id = R.string.slucajno),
                onClick = {
                    expanded.value = true
                })
            DropdownMenu(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.colorPrimary),
                    ),
                offset = DpOffset(x = 90.dp, y = 0.dp),
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
            ) {
                numbers.forEach {
                    DropdownMenuItem(
                        modifier = Modifier
                            .background(color = colorResource(id = R.color.colorPrimary))
                            .width(50.dp),
                        onClick = {
                            expanded.value = false
                            onItemClick(it)
                        },
                        text = {
                            RegularText(
                                modifier = Modifier.fillMaxSize(),
                                text = it.toString(),
                                color = colorResource(id = R.color.colorSecondary)
                            )
                        }
                    )
                }
            }
        }
    }

}