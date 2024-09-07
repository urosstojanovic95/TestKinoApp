package com.example.testkinoapp.ui_components.cards


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testkinoapp.R
import com.example.testkinoapp.ui_components.texts.RegularText
import com.example.testkinoapp.utils.Constants.FixMapping

@Preview
@Composable
fun FloatingCard(
    modifier: Modifier = Modifier,
    count: Int = 15,
) {
    Card(
        modifier = modifier
            .padding(16.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .width(200.dp)
                .height(70.dp)
                .background(color = Color.White)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.ballColor)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = count.toString(),
                    color = colorResource(id = R.color.textColor),
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            RegularText(
                text = stringResource(id = R.string.kvota) + " ${FixMapping[count] ?: FixMapping[8]}",
                color = colorResource(id = R.color.black)
            )
        }

    }
}
