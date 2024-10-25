package com.takasima.bankpapuamb.screen.auth.settingaccount

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import com.takasima.bankpapuamb.ui.theme.lightgrey
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.screen.common.CustomTopBar


@Composable
fun UbahPINScreen(profileNavController: NavHostController, modifier: Modifier = Modifier) {
    var pinLama by remember { mutableStateOf("") }
    var pinBaru by remember { mutableStateOf("") }
    var pinBaruConfirm by remember { mutableStateOf("") }
    var ispinLamaHidden by rememberSaveable { mutableStateOf(false) }
    var ispinBaruHidden by rememberSaveable { mutableStateOf(false) }
    var ispinBaruConfirmHidden by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(terniary2)
    ) {
        MainBg()

        Box(
            modifier = Modifier
        ) {

            Scaffold(modifier = Modifier, containerColor = Color.Transparent,
                topBar = {
                    CustomTopBar("Ubah PIN Security", {
                        profileNavController.popBackStack()
                        profileNavController.navigate(ProfileRouteScreens.SettingAkun.route)
                    })
                }
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(Color(0xFFebe8e8))
                        .padding(vertical = 32.dp)
                        .verticalScroll(rememberScrollState())

                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .wrapContentHeight()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {

                        Text(text = "MASUKKAN PIN LAMA", fontWeight = FontWeight.ExtraBold)
                        TextField(
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.White,
                                focusedContainerColor = Color.White
                            ),
                            value = pinLama,
                            onValueChange = { newText ->
                                // Filter to allow only alphanumeric characters and limit to 12 characters
//                val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
                                pinLama = /*filteredText*/newText
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Ascii
                            ),
                            trailingIcon = {
                                IconButton(onClick = { ispinLamaHidden = !ispinLamaHidden }) {
                                    val visibilityIcon =
                                        if (ispinLamaHidden) Visibility else VisibilityOff
                                    // Please provide localized description for accessibility services
                                    val description =
                                        if (ispinLamaHidden) "Show password" else "Hide password"
                                    Icon(imageVector = visibilityIcon, contentDescription = description)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(32.dp))



                        Text(text = "MASUKKAN PIN BARU", fontWeight = FontWeight.ExtraBold)
                        TextField(
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.White,
                                focusedContainerColor = Color.White
                            ),
                            value = pinBaru,
                            onValueChange = { newText ->
                                // Filter to allow only alphanumeric characters and limit to 12 characters
//                val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
                                pinBaru = /*filteredText*/newText
                            },
                            trailingIcon = {
                                IconButton(onClick = { ispinBaruHidden = !ispinBaruHidden }) {
                                    val visibilityIcon =
                                        if (ispinBaruHidden) Visibility else VisibilityOff
                                    // Please provide localized description for accessibility services
                                    val description =
                                        if (ispinBaruHidden) "Show password" else "Hide password"
                                    Icon(imageVector = visibilityIcon, contentDescription = description)
                                }
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Ascii
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(32.dp))



                        Text(text = "MASUKKAN ULANG PIN BARU", fontWeight = FontWeight.ExtraBold)
                        TextField(
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.White,
                                focusedContainerColor = Color.White
                            ),
                            value = pinBaruConfirm,
                            onValueChange = { newText ->
                                // Filter to allow only alphanumeric characters and limit to 12 characters
//                val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
                                pinBaruConfirm = /*filteredText*/newText
                            },
                            placeholder = { Text("Masukkan Ulang Password Baru") },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Ascii
                            ),
                            trailingIcon = {
                                IconButton(onClick = { ispinBaruConfirmHidden = !ispinBaruConfirmHidden }) {
                                    val visibilityIcon =
                                        if (ispinBaruConfirmHidden) Visibility else VisibilityOff
                                    // Please provide localized description for accessibility services
                                    val description =
                                        if (ispinBaruConfirmHidden) "Show password" else "Hide password"
                                    Icon(imageVector = visibilityIcon, contentDescription = description)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(32.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Informasi")
                            Icon(
                                modifier = Modifier.size(18.dp),
                                imageVector = Icons.Outlined.Info,
                                tint = terniary,
                                contentDescription = null
                            )
                        }
                        Text(
                            text = "PIN terdiri dari 6 angka",
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    Spacer(modifier = Modifier.height(48.dp))
                    Button(
                        shape = RoundedCornerShape(25),
                        modifier = modifier.align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = secondary,
                            contentColor = Color.White
                        ),
                        onClick = {
//                            profileNavController.navigate(ProfileRouteScreens.SettingAkun.route)

                            profileNavController.navigate("${FeatureRouteScreens.Security2.route}/${ProfileRouteScreens.UbahPIN.route}")
//                            profileNavController.popBackStack()

                        }) {
                        Text(
                            modifier = Modifier.padding(horizontal = 32.dp),
                            text = "Konfirmasi",
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }
        }
    }



}


@Preview(showBackground = true)
@Composable
private fun UbahPINScreenPrev() {
    UbahPINScreen(profileNavController = rememberNavController())
}