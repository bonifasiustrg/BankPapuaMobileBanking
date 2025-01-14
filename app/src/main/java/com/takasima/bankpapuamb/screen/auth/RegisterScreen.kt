package com.takasima.bankpapuamb.screen.auth

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.AuthRouteScreens
import com.takasima.bankpapuamb.navigation.MainRouteScreens
import com.takasima.bankpapuamb.screen.common.CustomTopBar
import com.takasima.bankpapuamb.screen.common.OptTextField
import com.takasima.bankpapuamb.screen.common.Visibility
import com.takasima.bankpapuamb.screen.common.VisibilityOff
import com.takasima.bankpapuamb.ui.theme.circle
import com.takasima.bankpapuamb.ui.theme.circle2
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary

@Composable
fun RegisterScreen(viewmodel: MainViewModel, rootNavController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopBar("REGISTER", { rootNavController.navigateUp() })

        }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.White)
        ) {

            /*WALPAPER*/
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomStart)
                    .offset(x = -40.dp, y = 40.dp)
                    .clip(shape = CircleShape)
                    .background(circle)

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
                    .size(100.dp)
                    .align(Alignment.BottomStart)
                    .offset(x = 40.dp, y = 75.dp)
                    .clip(shape = CircleShape)
                    .background(circle)

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
                    .size(100.dp)
                    .align(Alignment.BottomStart)
                    .offset(x = -70.dp, y = -35.dp)
                    .clip(shape = CircleShape)
                    .background(circle)

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

            RegisterScreenSection1(rootNavController)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreenSection1(rootNavController: NavHostController, modifier: Modifier = Modifier) {
    val noKartu = remember { mutableStateOf("") }
    val tglLahir = remember { mutableStateOf("") }
    val noTelp = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current


    /*CONTENT*/
    Column(
        Modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,

        ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(
            text = "Nomor Kartu",
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 48.dp)
        )
        TextField(
            value = noKartu.value,
            onValueChange = { noKartu.value = it },
            shape = RoundedCornerShape(18.dp),
//                label = {
//                    Text("001234***",
//                        color = MaterialTheme.colorScheme.primary,
//                        style = MaterialTheme.typography.labelMedium,
//                    ) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.CreditCard,
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )
            },

            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White
            ),
            singleLine = true,
            modifier = modifier
                .fillMaxWidth(),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    // do something here
                }
            )

        )
        Spacer(modifier = Modifier.height(36.dp))
//            tanggal
        Text(
            text = "Tanggal Lahir",
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 48.dp)
        )
        TextField(
            value = noKartu.value,
            onValueChange = { noKartu.value = it },
            shape = RoundedCornerShape(18.dp),
//                label = {
//                    Text("001234***",
//                        color = MaterialTheme.colorScheme.primary,
//                        style = MaterialTheme.typography.labelMedium,
//                    ) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.CalendarMonth,
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)

                )
            },
            placeholder = { Text(text = "testing1") },

            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White
            ),
            singleLine = true,
            modifier = modifier
                .fillMaxWidth(),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    // do something here
                }
            )

        )
        Spacer(modifier = Modifier.height(36.dp))

//            no telp
        Text(
            text = "Nomor Telepon",
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 48.dp)
        )
        TextField(
            value = noKartu.value,
            onValueChange = { noKartu.value = it },
            shape = RoundedCornerShape(18.dp),
//                label = {
//                    Text("001234***",
//                        color = MaterialTheme.colorScheme.primary,
//                        style = MaterialTheme.typography.labelMedium,
//                    ) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Contacts,
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)

                )
            },

            placeholder = { Text(text = "(+62) 8124 5678 910") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White
            ),
            singleLine = true,
            modifier = modifier
                .fillMaxWidth(),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    // do something here
                }
            )

        )

        Spacer(modifier = Modifier.height(90.dp))
        Button(
            onClick = {
                rootNavController.navigate("registersect2")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = secondary
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)

        ) {
            Text(text = "Konfirmasi")
        }

        Spacer(modifier = Modifier.fillMaxHeight(0.1f))

    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPrev() {
    RegisterScreen(viewModel(), rememberNavController())
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPrev1() {
    RegisterScreenSection1(rememberNavController())
}


@Composable
fun RegisterScreenSection2(rootNavController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CustomTopBar("REGISTER", { rootNavController.navigateUp() })
        }
    ) {

        /*CONTENT*/
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

            Text(
                text = "Silahkan cek SMS anda untuk mendapatkan kode OTP",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.height(45.dp))
            OptTextField()

            Spacer(modifier = Modifier.height(45.dp))
            Text(
                text = "03:20",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.height(90.dp))
            Button(
                onClick = {
                    rootNavController.navigate("registersect3")
    //                navController.navigate(Graph.HOME) {
    //                    popUpTo(AuthRouteScreens.SignUp.route) {
    //                        inclusive = true
    //                    }
    //                }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = secondary
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(200.dp)

            ) {
                Text(text = "Konfirmasi")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Kirim Ulang Kode", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPrev2() {
    RegisterScreenSection2(rememberNavController())
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreenSection3(rootNavController: NavHostController, modifier: Modifier = Modifier) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val pswdConfirm = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        topBar = {
            CustomTopBar("REGISTER", { rootNavController.navigateUp() })
        }
    ) {

        /*CONTENT*/
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            Text(
                text = "Username",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 48.dp)
            )
            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                shape = RoundedCornerShape(18.dp),
//                label = {
//                    Text("001234***",
//                        color = MaterialTheme.colorScheme.primary,
//                        style = MaterialTheme.typography.labelMedium,
//                    ) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null
                    )
                },

                placeholder = { Text(text = "username") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White
                ),
                singleLine = true,
                modifier = modifier
                    .fillMaxWidth(),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        // do something here
                    }
                )

            )
            Spacer(modifier = Modifier.height(36.dp))
//            tanggal
            Text(
                text = "Password",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 48.dp)
            )

            var passwordHidden1 by rememberSaveable { mutableStateOf(true) }

            TextField(
                value = username.value,
                onValueChange = { pswdConfirm.value = it },
                shape = RoundedCornerShape(18.dp),
//                label = {
//                    Text("001234***",
//                        color = MaterialTheme.colorScheme.primary,
//                        style = MaterialTheme.typography.labelMedium,
//                    ) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordHidden1 = !passwordHidden1 }) {
                        val visibilityIcon =
                            if (passwordHidden1) Visibility else VisibilityOff
                        // Please provide localized description for accessibility services
                        val description = if (passwordHidden1) "Show password" else "Hide password"
                        Icon(imageVector = visibilityIcon, contentDescription = description)
                    }
                },
                placeholder = { Text(text = "**************") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White
                ),
                singleLine = true,
                modifier = modifier
                    .fillMaxWidth(),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        // do something here
                    }
                )

            )
            Spacer(modifier = Modifier.height(36.dp))

//            no telp
            Text(
                text = "Konfirmasi Password",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 48.dp)
            )

            var passwordHidden by rememberSaveable { mutableStateOf(true) }

            TextField(
                value = pswdConfirm.value,
                onValueChange = { pswdConfirm.value = it },
                shape = RoundedCornerShape(18.dp),
//                label = {
//                    Text("001234***",
//                        color = MaterialTheme.colorScheme.primary,
//                        style = MaterialTheme.typography.labelMedium,
//                    ) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        val visibilityIcon =
                            if (passwordHidden) Visibility else VisibilityOff
                        // Please provide localized description for accessibility services
                        val description = if (passwordHidden) "Show password" else "Hide password"
                        Icon(imageVector = visibilityIcon, contentDescription = description)
                    }
                },
                placeholder = { Text(text = "************") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White
                ),
                singleLine = true,
                modifier = modifier
                    .fillMaxWidth(),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        // do something here
                    }
                )

            )

            Spacer(modifier = Modifier.height(90.dp))
            Button(
                onClick = {
                    rootNavController.navigate("registersect4")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = secondary
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(200.dp)

            ) {
                Text(text = "Konfirmasi")
            }

            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPrev3() {
    RegisterScreenSection3(rememberNavController())
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreenSection4(rootNavController: NavHostController, modifier: Modifier = Modifier) {

    /*CONTENT*/
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Image(
            painter = painterResource(id = R.drawable.congrats_ic),
            contentDescription = null,
            modifier = modifier.size(width = 187.dp, height = 213.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = modifier
                .fillMaxWidth(0.8f),
            text = "Selamat Akun Mobile Banking Papua Anda sudah jadi. \n" +
                    "Silahkan klik tombol Beranda untuk melakukan transaksi",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                rootNavController.popBackStack()
                rootNavController.navigate(AuthRouteScreens.Login.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = secondary
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)

        ) {
            Text(text = "BERANDA", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.fillMaxHeight(0.1f))

    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPrev4() {
    RegisterScreenSection4(rememberNavController())
}