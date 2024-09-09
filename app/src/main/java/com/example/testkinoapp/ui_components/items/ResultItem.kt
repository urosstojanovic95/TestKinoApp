package com.example.testkinoapp.ui_components.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testkinoapp.R
import com.example.testkinoapp.model.Result
import com.example.testkinoapp.ui_components.texts.RegularText
import com.example.testkinoapp.utils.DummyData

@Composable
fun ResultItem(
    result: Result
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            RegularText(
                text =
                stringResource(id = R.string.vreme_izvlacenja)
                        + "${result.time} | ${stringResource(id = R.string.kolo)}" +
                        ": ${result.drawId}"

            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        result.winningNumbers?.list?.chunked(8)?.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                it.forEach { item ->
                    TableItem(
                        number = item,
                        preSelected = true
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ResultItemPreview(
) {
    ResultItem(result = DummyData.result)
}

