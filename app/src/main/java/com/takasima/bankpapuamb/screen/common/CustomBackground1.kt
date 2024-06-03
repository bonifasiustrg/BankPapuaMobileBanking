package com.takasima.bankpapuamb.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.ui.theme.biru2
import com.takasima.bankpapuamb.ui.theme.circle
import com.takasima.bankpapuamb.ui.theme.circle2
import com.takasima.bankpapuamb.ui.theme.terniary2




@Composable
fun BoxScope.MainBg(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(width = 400.dp, height = 670.dp)
            .offset(x = -20.dp)
            .align(Alignment.TopCenter)
            .scale(1.2f)
            .clip(shape = CircleShape)
            .background(Color(0xFFAAE4F6))

    )
    Box(
        modifier = Modifier
            .size(width = 400.dp, height = 770.dp)
            .offset(y = -170.dp)
            .align(Alignment.TopCenter)
//                .scale(1.2f)
            .clip(shape = CircleShape)
            .background(Color.White)

    )
    Box(
        modifier = Modifier
            .size(60.dp)
            .align(Alignment.Center)
            .offset(x = 55.dp, y = 135.dp)
            .clip(shape = CircleShape)
            .background(circle)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    biru2
                )
        )
    }
    /*WALPAPER*/


    Box(
        modifier = Modifier
            .size(120.dp)
            .align(Alignment.TopEnd)
            .offset(x = 75.dp, y = (-15).dp)
            .clip(shape = CircleShape)
            .background(circle)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    biru2
                )
        )
    }


    Box(
        modifier = Modifier
            .size(110.dp)
            .align(Alignment.CenterStart)
            .offset(x = -55.dp, y = (-125).dp)
            .clip(shape = CircleShape)
            .background(circle)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    biru2
                )
        )
    }
    Box(
        modifier = Modifier
            .size(100.dp)
            .align(Alignment.CenterEnd)
            .offset(x = 40.dp, y = (-115).dp)
            .clip(shape = CircleShape)
            .background(circle)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    biru2
                )
        )
    }
}

@Preview
@Composable
private fun MainBgPrev() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()
    }
}

















@Composable
fun BoxScope.CustomBackground1(modifier: Modifier = Modifier) {


    Box(
        modifier = Modifier
            .size(60.dp)
            .align(Alignment.TopStart)
            .offset(x = 75.dp, y = 20.dp)
            .clip(shape = CircleShape)
            .background(circle.copy(alpha = 0.6f))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    circle2
                )
        )
    }

    Box(
        modifier = Modifier
            .size(130.dp)
            .align(Alignment.TopEnd)
            .offset(x = 25.dp, y = (-35).dp)
            .clip(shape = CircleShape)
            .background(circle.copy(alpha = 0.6f))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    circle2
                )
        )
    }


    Box(
        modifier = Modifier
            .size(120.dp)
            .align(Alignment.CenterStart)
            .offset(x = 25.dp, y = (-125).dp)
            .clip(shape = CircleShape)
            .background(circle.copy(alpha = 0.6f))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    circle2
                )
        )
    }
    Box(
        modifier = Modifier
            .size(120.dp)
            .align(Alignment.CenterEnd)
            .offset(x = 40.dp, y = (-115).dp)
            .clip(shape = CircleShape)
            .background(circle.copy(alpha = 0.6f))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    circle2
                )
        )
    }

    Image(
        modifier = Modifier
            .size(width = 66.dp, height = 166.dp)
            .align(Alignment.CenterStart)
            .offset(y = 32.dp),
        painter = painterResource(id = R.drawable.ornamen),
        contentDescription = null
    )
    Image(
        modifier = Modifier
            .size(width = 66.dp, height = 166.dp)
            .align(Alignment.CenterEnd)
            .offset(y = 32.dp),
        painter = painterResource(id = R.drawable.ornamen),
        contentDescription = null
    )

    Box(
        modifier = Modifier
            .size(400.dp)
            .offset(y = 120.dp)
            .align(Alignment.BottomCenter)
            .scale(1.35f)
            .clip(shape = CircleShape)
            .background(Color(0xFFAAE4F6))

    )
    Box(
        modifier = Modifier
            .size(400.dp)
            .offset(y = 200.dp)
            .align(Alignment.BottomCenter)
            .scale(1.3f)
            .clip(shape = CircleShape)
            .background(Color(0xFF4CCAF2))

    )
}

@Preview(showBackground = true)
@Composable
private fun CustomBgPrev() {
    Box {
        CustomBackground1()
    }
}
@Composable
fun BoxScope.CustomBackground2(modifier: Modifier = Modifier) {


    Box(
        modifier = Modifier

//            .size(60.dp)
            .align(Alignment.TopStart)
            .offset(x = 75.dp, y = 20.dp)
            .clip(shape = CircleShape)
            .background(circle.copy(alpha = 0.6f))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    circle2
                )
        )
    }

    Box(
        modifier = Modifier
            .size(130.dp)
            .align(Alignment.TopEnd)
            .offset(x = 25.dp, y = (-35).dp)
            .clip(shape = CircleShape)
            .background(circle.copy(alpha = 0.6f))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    circle2
                )
        )
    }


    Box(
        modifier = Modifier
            .size(120.dp)
            .align(Alignment.CenterStart)
            .offset(x = 25.dp, y = (-125).dp)
            .clip(shape = CircleShape)
            .background(circle.copy(alpha = 0.6f))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    circle2
                )
        )
    }
    Box(
        modifier = Modifier
            .size(120.dp)
            .align(Alignment.CenterEnd)
            .offset(x = 40.dp, y = (-115).dp)
            .clip(shape = CircleShape)
            .background(circle.copy(alpha = 0.6f))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clip(shape = CircleShape)
                .align(Alignment.Center)
                .background(
                    circle2
                )
        )
    }

    Image(
        modifier = Modifier
            .size(width = 66.dp, height = 166.dp)
            .align(Alignment.CenterStart)
            .offset(y = 32.dp),
        painter = painterResource(id = R.drawable.ornamen),
        contentDescription = null
    )
    Image(
        modifier = Modifier
            .size(width = 66.dp, height = 166.dp)
            .align(Alignment.CenterEnd)
            .offset(y = 32.dp),
        painter = painterResource(id = R.drawable.ornamen),
        contentDescription = null
    )

    Box(
        modifier = Modifier
            .size(400.dp)
            .offset(y = 120.dp)
            .align(Alignment.BottomCenter)
            .scale(1.35f)
            .clip(shape = CircleShape)
            .background(Color(0xFFAAE4F6))

    )
    Box(
        modifier = Modifier
            .size(400.dp)
            .offset(y = 200.dp)
            .align(Alignment.BottomCenter)
            .scale(1.3f)
            .clip(shape = CircleShape)
            .background(Color(0xFF4CCAF2))

    )
}

@Preview(showBackground = true)
@Composable
private fun CustomBgPrev2() {
    Box {
        CustomBackground2()
    }
}