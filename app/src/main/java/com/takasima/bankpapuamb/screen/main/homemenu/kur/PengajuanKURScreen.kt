package com.takasima.bankpapuamb.screen.main.homemenu.kur

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.ExpandCircleDown
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.screen.common.BSKUR
import com.takasima.bankpapuamb.screen.common.BottomSheetContentSamsat
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.ui.theme.lightgrey
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengajuanKURScreen(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    var openBottomSheet = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color(0xFFebe8e8),
                topBar = {
                    CustomTopBar("Pengajuan KUR", {
                        homeNavController.navigateUp()
                    })
                }
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(it)
                        .background(color = Color.White)
                        .padding(horizontal = 16.dp, vertical = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Kategori",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    val noRek = remember { mutableStateOf("") }
                    val nominal = remember { mutableStateOf("0") }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                openBottomSheet.value = true
                            }
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.kategori),
                                contentDescription = null,
                                modifier = modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))

                            Icon(
                                painter = painterResource(id = R.drawable.bankpapua_2),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth(0.1f)
                                    .height(48.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            Text(text = "KUR Supermikro")
                        }
                        IconButton(onClick = { openBottomSheet.value = true }) {
                            Icon(
                                imageVector = Icons.Outlined.ExpandCircleDown,
                                contentDescription = null,
                                modifier
                                    .rotate(-90f)
                                    .size(36.dp)
                            )
                        }
                    }
                    Divider(thickness = 1.dp, color = Color.Black)

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Jumlah",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = noRek.value,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        onValueChange = { noRek.value = it },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.coin_ic),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                                    .size(48.dp)
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        placeholder = { Text(text = "Rp. 50.000.OOO") },
                        visualTransformation = VisualTransformation.None,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        )
                    )


                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Tanggal Pengajuan",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                            }
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.data_ic),
                                contentDescription = null,
                                modifier = modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = "Pilih Tanggal",
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        }
                        IconButton(
                            onClick = {

                                      },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ExpandCircleDown,
                                contentDescription = null,
                                modifier
                                    .rotate(-90f)
                                    .size(48.dp)

                            )
                        }
                    }
                    Divider(thickness = 1.dp, color = Color.Black)

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Foto KTP",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                            }
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.ktp),
                                contentDescription = null,
                                modifier = modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Frederikus.png",
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        }
                        IconButton(
                            onClick = { openBottomSheet.value = true },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ExpandCircleDown,
                                contentDescription = null,
                                modifier
                                    .rotate(-90f)
                                    .size(48.dp)

                            )
                        }
                    }
                    Divider(thickness = 1.dp, color = Color.Black)
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Catatan",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = noRek.value,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        onValueChange = { noRek.value = it },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.note_ic),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                                    .size(48.dp)
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        placeholder = { Text(text = "Membuka usaha cilok") },
                        visualTransformation = VisualTransformation.None,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        modifier = Modifier
                            .width(200.dp)
                            .align(Alignment.CenterHorizontally),
                        onClick = {
                                  homeNavController.navigate("congrats")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = secondary,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Konfirmasi")
                    }
                    Spacer(modifier = Modifier.height(64.dp))
                }
            }

            if (openBottomSheet.value) {
                ModalBottomSheet(
                    containerColor = Color.White,
                    sheetState = bottomSheetState,
                    onDismissRequest = { openBottomSheet.value = false },
                    dragHandle = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
//                                    .background(color = Color.White)
                        ) {
                            BottomSheetDefaults.DragHandle()
                            Text(
                                text = "Kategori KUR",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 32.sp
                            )
                            Spacer(modifier = modifier.height(10.dp))
                            Divider()
                        }
                    }
                ) {
                    BSKUR(
                        onHideButtonClick = {
                            scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                if (!bottomSheetState.isVisible) openBottomSheet.value = false
                            }
                        },
                        modifier,
                        homeNavController,
                        openBottomSheet
                    )
                }
            }

        }
    }


}


@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun PengajuanKURPrev() {
    PengajuanKURScreen(homeNavController = rememberNavController())
}