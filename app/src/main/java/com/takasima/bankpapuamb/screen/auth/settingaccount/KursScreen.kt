package com.takasima.bankpapuamb.screen.auth.settingaccount

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.data.model.Kurs
import com.takasima.bankpapuamb.screen.common.BottomSheetContentKurs
import com.takasima.bankpapuamb.screen.common.BottomSheetContentSamsat
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.RowHeader
import com.takasima.bankpapuamb.screen.common.Table
import com.takasima.bankpapuamb.ui.theme.lightgrey
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KursScreen(profileNavController: NavHostController, modifier: Modifier = Modifier) {
    var openBottomSheet = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(/*skipPartiallyExpanded = true*/)
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {
            Scaffold(modifier = Modifier, containerColor = lightgrey,
                topBar = {
                    Row(
                        Modifier
                            .background(terniary2.copy(alpha = 0.6f))
                            .fillMaxWidth()
                            .fillMaxHeight(0.08f)
                            .background(color = lightgrey)
                            .padding(top = 24.dp)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            profileNavController.navigateUp()

                        }) {

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = null,
                                Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = "INFORMASI KURS   ",
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
                        .padding(it)
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .verticalScroll(rememberScrollState())

                    ,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .requiredHeightIn(min = 100.dp, max = 400.dp),
                        ) {
                        Spacer(modifier = Modifier.height(32.dp))

                        val kursList = listOf(
                            Kurs(R.drawable.flag_usa, "USD", 16_367f, 16_204f),
                            Kurs(R.drawable.flag_uk, "GBP", 20_932f, 20_772f),
                            Kurs(R.drawable.flag_japan, "JPY", 10_407f, 10_302f),
                            Kurs(R.drawable.flag_sgf, "SGD", 12_137f, 12_008f),
                            Kurs(R.drawable.flag_hkd, "HKD", 2_095f, 2_075f),
                        )
                        val columnCount =
                            4 // We have 4 columns: Flag, Kurs Name, Sell Kurs, Buy Kurs

                        Table(
                            modifier = Modifier.padding(horizontal = 32.dp),
                            columnCount = 4,
                            rowCount = kursList.size + 1, // Including header row
                            beforeRow = { rowIndex ->
                                if (rowIndex == 0) {
                                    RowHeader()
                                }
                            },
                            cellContent = { columnIndex, rowIndex ->
                                if (rowIndex == 0) {
                                    // No need to handle here because it's handled by beforeRow
                                } else {
                                    val kurs = kursList[rowIndex - 1]
                                    when (columnIndex) {
                                        0 -> Image(
                                            painter = painterResource(kurs.iconCountryFlag),
                                            contentDescription = "Country Flag",
                                            modifier = Modifier
                                                .padding(8.dp)
                                                .size(48.dp),

                                        )

                                        1 -> Text(
                                            text = kurs.kursName,
                                            modifier = Modifier
                                                .padding(8.dp)
//                                                .weight(1f),
                                                .width(58.dp),
                                            textAlign = TextAlign.Center
                                        )

                                        2 -> Text(
                                            text = kurs.sellKurs.toString(),
                                            modifier = Modifier
                                                .padding(8.dp)
//                                                .weight(1f),
                                                .width(58.dp),
                                            textAlign = TextAlign.Center


                                        )

                                        3 -> Text(
                                            text = kurs.buyKurs.toString(),
                                            modifier = Modifier
                                                .padding(8.dp)
//                                                .weight(1f),
                                                .width(58.dp),
                                            textAlign = TextAlign.Center

                                        )
                                    }
                                }
                            }
                        )

                        /*endtable*/

                        Spacer(modifier = Modifier.height(48.dp))
                    }
                    Spacer(modifier = Modifier.height(24.dp))


                    Column(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(horizontal = 32.dp, vertical = 16.dp),
                    ) {
                        Text(
                            text = "Jumlah Nilai Tukar",
                            fontSize = 32.sp,
                            color = terniary
                        )
                        Text(text = "Hitung Jumlah uang saat anda membeli atau menjual mata uang asing ")

                        Row(
                            modifier = Modifier.padding(vertical = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Dari ")
                            Image(
                                painter = painterResource(id = R.drawable.flag_usa),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(36.dp)
                                    .clickable {
                                        openBottomSheet.value = true
                                    }
                            )
                            Text(text = "Ke ")
                            Image(
                                painter = painterResource(id = R.drawable.flag_indo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(36.dp)
                                    .clickable {
                                        openBottomSheet.value = true
                                    }
                            )

                            Image(
                                painter = painterResource(id = R.drawable.exchange_ic),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        Text(text = "Jumlah")
                        Text(text = "USD         0,00")
                        Divider(Modifier.fillMaxWidth(0.7f))

                        Text(text = "Nilai Jual USD = 14.870")
                        Text(text = "Jumlah", fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 16.dp))
                        Text(text = "Rp0", fontWeight = FontWeight.SemiBold)

                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }



                if (openBottomSheet.value) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openBottomSheet.value = false },
//                dragHandle = {
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
//                            .background(color = Color.White)
//                    ) {
//                        BottomSheetDefaults.DragHandle()
//                        Text(
//                            text = "TRANSFER",
//                            fontWeight = FontWeight.ExtraBold,
//                            fontSize = 32.sp
//                        )
//                        Spacer(modifier = modifier.height(10.dp))
//                        Divider()
//                    }
//                },
                    ) {
                        BottomSheetContentKurs(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) openBottomSheet.value = false
                                }
                            },
                            modifier,
                            profileNavController,
                            openBottomSheet
                        )
                    }
                }
            }

        }

    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun KursScreenPrev() {
    KursScreen(rememberNavController())
}