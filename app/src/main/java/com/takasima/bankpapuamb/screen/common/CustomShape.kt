package com.takasima.bankpapuamb.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.takasima.bankpapuamb.ui.theme.circle
import com.takasima.bankpapuamb.ui.theme.circle2
import com.takasima.bankpapuamb.ui.theme.secondary

@Composable
fun DoubleCircleShape(circleSize: Dp = 100.dp, xoffset:Int, yoffset:Int, alignment: Alignment = Alignment.Center ,modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(300.dp)
            .offset(x = xoffset.dp, y = (yoffset).dp)
            .clip(shape = CircleShape)
            .background(circle.copy(alpha = 0.6f))

    ){
        Box(modifier = Modifier
            .padding(36.dp)
            .fillMaxSize(0.85f)
            .clip(shape = CircleShape)
            .align(Alignment.Center)
            .background(
                circle2
            )
        )
    }
}

@Preview
@Composable
private fun DoubleCircleShapePrev() {
    DoubleCircleShape(xoffset = 20, yoffset = -30)
}