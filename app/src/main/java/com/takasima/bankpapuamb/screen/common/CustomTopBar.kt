package com.takasima.bankpapuamb.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.takasima.bankpapuamb.ui.theme.terniary

@Composable
fun CustomTopBar(title:String="Title", navAction: ()->Unit ={},modifier: Modifier = Modifier) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.10f)
            .background(color = Color(0xFFAAE4F6))
            .padding(top = 24.dp)
            .padding(horizontal = 16.dp)
    ) {
        Box() {

            IconButton(onClick = navAction) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                    contentDescription = null,
                    Modifier.size(32.dp)
                )
            }
        }
        Box() {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = title,
                    color = terniary,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                )
            }

        }
    }
}