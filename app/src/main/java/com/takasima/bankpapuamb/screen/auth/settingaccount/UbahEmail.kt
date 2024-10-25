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
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import com.takasima.bankpapuamb.navigation.FeatureRouteScreens
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.MainBg
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import com.takasima.bankpapuamb.ui.theme.lightgrey
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2


@Composable
fun UbahEmailScreen(profileNavController: NavHostController, modifier: Modifier = Modifier) {
    var noLama by remember { mutableStateOf("") }
    var noBaru by remember { mutableStateOf("") }
    var isNoLamaHidden by rememberSaveable { mutableStateOf(false) }
    var isNoBaruHidden by rememberSaveable { mutableStateOf(false) }

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
                    CustomTopBar("Ubah Alamat Email", {
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

                        Text(text = "EMAIL ANDA SAAT INI", fontWeight = FontWeight.ExtraBold)
                        TextField(
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.White,
                                focusedContainerColor = Color.White
                            ),
                            value = noLama,
                            onValueChange = { newText ->
                                // Filter to allow only alphanumeric characters and limit to 12 characters
//                val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
                                noLama = /*filteredText*/newText
                            },
                            placeholder = { Text("RavnaldiManairi@gmail.com") },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email
                            ),
                            trailingIcon = {
                                IconButton(onClick = { isNoLamaHidden = !isNoLamaHidden }) {
                                    val visibilityIcon =
                                        if (isNoLamaHidden) Visibility else VisibilityOff
                                    // Please provide localized description for accessibility services
                                    val description =
                                        if (isNoLamaHidden) "Show password" else "Hide password"
                                    Icon(imageVector = visibilityIcon, contentDescription = description)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(32.dp))

                        Text(text = "MASUKKAN EMAIL ANDA SAAT INI", fontWeight = FontWeight.ExtraBold)
                        TextField(
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.White,
                                focusedContainerColor = Color.White
                            ),
                            value = noBaru,
                            onValueChange = { newText ->
                                // Filter to allow only alphanumeric characters and limit to 12 characters
//                val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
                                noBaru = /*filteredText*/newText
                            },
                            trailingIcon = {
                                IconButton(onClick = { isNoBaruHidden = !isNoBaruHidden }) {
                                    val visibilityIcon =
                                        if (isNoBaruHidden) Visibility else VisibilityOff
                                    // Please provide localized description for accessibility services
                                    val description =
                                        if (isNoBaruHidden) "Show password" else "Hide password"
                                    Icon(imageVector = visibilityIcon, contentDescription = description)
                                }
                            },
                            placeholder = { Text("081213234433") },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(32.dp))

                    }

                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(16.dp))
                            .wrapContentHeight()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(48.dp)
                                .padding(end = 10.dp),
                            imageVector = Icons.Outlined.Info,
                            tint = terniary,
                            contentDescription = null
                        )
                        Text(
                            text = "Kamu hanya dapat menggantikan alamat email satu kali setiap 90 hari. Kamu tidak akan bisa mengganti email anda sebelum nya lagi. Jika terdapat masalah silahkan hubungi Call Cnter",
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.height(32.dp))
                    }
                    Spacer(modifier = Modifier.height(64.dp))
                    Button(
                        shape = RoundedCornerShape(25),

                        modifier = modifier.align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = secondary,
                            contentColor = Color.White
                        ),
                        onClick = {
//                            profileNavController.popBackStack()
                            profileNavController.navigate("${FeatureRouteScreens.KodeOTP.route}/${ProfileRouteScreens.UbahEmail.route}")
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
private fun UbahEmailScreenPrev() {
    UbahEmailScreen(profileNavController = rememberNavController())
}