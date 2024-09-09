package com.example.testkinoapp.ui_components.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testkinoapp.R

@Preview
@Composable
fun ActionButton(
    iconId: Int = R.drawable.ic_result,
    text: String = "",
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(36),
        modifier = Modifier
            .height(48.dp),
        colors = ButtonColors(
            containerColor = colorResource(id = R.color.colorPrimary),
            contentColor = colorResource(id = R.color.colorSecondary),
            disabledContentColor = colorResource(id = R.color.colorSecondary),
            disabledContainerColor = colorResource(id = R.color.colorPrimary)
        ),
        content = {
            Icon(
                painter = painterResource(iconId),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                fontSize = 16.sp,
            )

        }
    )
}