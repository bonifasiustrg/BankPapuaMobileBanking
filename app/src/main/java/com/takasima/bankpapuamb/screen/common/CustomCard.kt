package com.takasima.bankpapuamb.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.data.ListrikMethodOption
import com.takasima.bankpapuamb.data.NominalMethodOption
import com.takasima.bankpapuamb.data.PaymentMethodOption

@Composable
fun SingleSelectionCard(selectionOption: PaymentMethodOption, onOptionClicked: (PaymentMethodOption) -> Unit) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 4.dp), shape = RoundedCornerShape(16.dp)
    ) {
        Surface(
            modifier = Modifier
//                .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
                .clickable(true, onClick = { onOptionClicked(selectionOption) }),
            color = if (selectionOption.selected) { Color(0xFF4797e1)/*MaterialTheme.colorScheme.primary*/ } else { MaterialTheme.colorScheme.background },
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(imageVector = ImageVector.vectorResource(id = selectionOption.logo), contentDescription = null, modifier = Modifier
                    .height(24.dp)
                    .width(110.dp), alignment = Alignment.CenterStart)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = selectionOption.option,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
@Composable
fun SingleSelectionCard3(selectionOption: NominalMethodOption, onOptionClicked: (NominalMethodOption) -> Unit, numberOpt: Int) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 8.dp)
        .padding(end = if (numberOpt % 2 == 0) 8.dp else 0.dp)
        .padding(start = if (numberOpt % 2 == 1) 8.dp else 0.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Surface(
            modifier = Modifier
//                .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
                .clickable(true, onClick = { onOptionClicked(selectionOption) }),
            color = if (selectionOption.selected) { Color(0xFF4797e1)/*MaterialTheme.colorScheme.primary*/ } else { MaterialTheme.colorScheme.background },
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
            ) {
//                Image(imageVector = ImageVector.vectorResource(id = selectionOption.logo), contentDescription = null, modifier = Modifier.height(24.dp).width(150.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = selectionOption.option,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun SingleSelectionCard2(selectionOption: ListrikMethodOption, onOptionClicked: (ListrikMethodOption) -> Unit) {
    Surface(modifier = Modifier
        .padding(horizontal = 16.dp)
        .fillMaxSize()
        .padding(vertical = 4.dp), shape = RoundedCornerShape(16.dp)
    ) {
        Surface(
            modifier = Modifier
//                .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
                .clickable(true, onClick = { onOptionClicked(selectionOption) }),
            color = if (selectionOption.selected) { MaterialTheme.colorScheme.primary } else { Color.White},
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = selectionOption.logo), contentDescription = null, modifier = Modifier
                    .height(24.dp)
                    .width(50.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = selectionOption.option,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
@Preview
@Composable
private fun SingleSelectionCardPrev() {
}

