package com.takasima.bankpapuamb.screen.auth.settingaccount

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.navigation.ProfileRouteScreens
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import com.takasima.bankpapuamb.ui.theme.lightgrey
import com.takasima.bankpapuamb.ui.theme.secondary

@Composable
fun UbahPasswordScreen(profileNavController: NavHostController, modifier: Modifier = Modifier) {
    var passLama by remember { mutableStateOf("") }
    var passBaru by remember { mutableStateOf("") }
    var passBaruConfirm by remember { mutableStateOf("") }
    var isPassLamaHidden by rememberSaveable { mutableStateOf(false) }
    var isPassBaruHidden by rememberSaveable { mutableStateOf(false) }
    var isPassBaruConfirmHidden by rememberSaveable { mutableStateOf(false) }



    Column(
        Modifier
            .fillMaxWidth()
            .background(color = lightgrey)
            .padding(vertical = 32.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .wrapContentHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = "MASUKKAN PASSWORD LAMA", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
            OutlinedTextField(
                value = passLama,
                onValueChange = { newText ->
                    // Filter to allow only alphanumeric characters and limit to 12 characters
//                val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
                    passLama = /*filteredText*/newText
                },
                placeholder = { Text("Masukkan Password Lama") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii
                ),
                trailingIcon = {
                    IconButton(onClick = { isPassLamaHidden = !isPassLamaHidden }) {
                        val visibilityIcon =
                            if (isPassLamaHidden) Visibility else VisibilityOff
                        // Please provide localized description for accessibility services
                        val description =
                            if (isPassLamaHidden) "Show password" else "Hide password"
                        Icon(imageVector = visibilityIcon, contentDescription = description)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )


            Text(text = "MASUKKAN PASSWORD BARU", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
            OutlinedTextField(
                value = passBaru,
                onValueChange = { newText ->
                    // Filter to allow only alphanumeric characters and limit to 12 characters
//                val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
                    passBaru = /*filteredText*/newText
                },
                trailingIcon = {
                    IconButton(onClick = { isPassBaruHidden = !isPassBaruHidden }) {
                        val visibilityIcon =
                            if (isPassBaruHidden) Visibility else VisibilityOff
                        // Please provide localized description for accessibility services
                        val description =
                            if (isPassBaruHidden) "Show password" else "Hide password"
                        Icon(imageVector = visibilityIcon, contentDescription = description)
                    }
                },
                placeholder = { Text("Masukkan Password Baru") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )


            Text(text = "MASUKKAN ULANG PASSWORD BARU", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
            OutlinedTextField(
                value = passBaruConfirm,
                onValueChange = { newText ->
                    // Filter to allow only alphanumeric characters and limit to 12 characters
//                val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
                    passBaruConfirm = /*filteredText*/passBaruConfirm
                },
                placeholder = { Text("Masukkan Ulang Password Baru") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii
                ),
                trailingIcon = {
                    IconButton(onClick = { isPassBaruConfirmHidden = !isPassBaruConfirmHidden }) {
                        val visibilityIcon =
                            if (isPassBaruConfirmHidden) Visibility else VisibilityOff
                        // Please provide localized description for accessibility services
                        val description =
                            if (isPassBaruConfirmHidden) "Show password" else "Hide password"
                        Icon(imageVector = visibilityIcon, contentDescription = description)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .wrapContentHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                Text(text = "Informasi")
                Icon(
                    imageVector = Icons.Outlined.Info,
                    tint = Color.Yellow,
                    contentDescription = null
                )
            }
            Text(
                text = "1. Password terdiri dari 8-12 karakter\n" +
                        "2. Terdiri dari kombinasi huruf dan angka\n" +
                        "3. Kombinasi huruf besar dan kecil diperbolehkan",
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
        Spacer(modifier = Modifier.height(64.dp))
        Button(
            modifier = modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = secondary,
                contentColor = Color.White
            ),
            onClick = {
                profileNavController.popBackStack()
                profileNavController.navigate(ProfileRouteScreens.SettingAkun.route)
            }) {
            Text(
                text = "Konfirmasi",
                fontWeight = FontWeight.Bold
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun UbahPassScreenPrev() {
    UbahPasswordScreen(profileNavController = rememberNavController())
}