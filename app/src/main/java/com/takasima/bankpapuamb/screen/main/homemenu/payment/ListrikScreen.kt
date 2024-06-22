package com.takasima.bankpapuamb.screen.main.homemenu.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.ContactMail
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.data.ListrikMethodOption
import com.takasima.bankpapuamb.data.viewmodel.Payment2ViewModel
import com.takasima.bankpapuamb.navigation.PaymentMenuScreens
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.SingleSelectionCard
import com.takasima.bankpapuamb.screen.common.SingleSelectionCard2
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2


@Composable
fun ListrikScreen(
    paymentNavController: NavHostController,
    paymentViewModel: Payment2ViewModel,
    modifier: Modifier = Modifier
) {
    val options = paymentViewModel.options


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color(0xA1063E71),
                topBar = {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.08f)
                            .background(color = Color(0xB3AAE4F6))
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            paymentNavController.navigateUp()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = null,
                                Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "PEMBAYARAN LISTRIK",
                            color = terniary,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        )
                    }
                }
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    ListrikScreenSection1(paymentNavController, options, paymentViewModel)
                }
            }
        }
    }
}

@Composable
fun ColumnScope.ListrikScreenSection1(
    paymentNavController: NavHostController,
    options: List<ListrikMethodOption>,
    paymentViewModel: Payment2ViewModel,
    modifier: Modifier = Modifier
) {
    val noRek = remember { mutableStateOf("") }

    Text(
        text = "PRODUK LISTRIK",
        color = terniary,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 20.sp
    )

    Spacer(modifier = Modifier.height(32.dp))

    SingleSelectionList2(
        options,
        onOptionClicked = { paymentViewModel.selectionOptionSelected(it) }
    )


    Spacer(modifier = Modifier.height(16.dp))
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = noRek.value,
        onValueChange = { noRek.value = it },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.ContactMail,
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .size(48.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        placeholder = { Text(text = "NOMOR PELANGGAN ") }
    )

    Spacer(modifier = Modifier.height(100.dp))
    Button(
        modifier = Modifier
            .width(200.dp)
            .align(Alignment.CenterHorizontally),
        onClick = {
            paymentNavController.navigate(PaymentMenuScreens.PaymentSummary.route)
        },
        colors = ButtonDefaults.buttonColors(containerColor = secondary)
    ) {
        Text(text = "Konfirmasi")
    }

}

@Composable
fun SingleSelectionList2(
    options: List<ListrikMethodOption>,
    onOptionClicked: (ListrikMethodOption) -> Unit
) {

    LazyColumn {
        items(options) { option -> SingleSelectionCard2(option, onOptionClicked) }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListrikScreenPrev() {
    ListrikScreen(
        rememberNavController(), viewModel()
    )
}
