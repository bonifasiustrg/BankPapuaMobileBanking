package com.takasima.bankpapuamb.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PermContactCalendar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.common.OptTextField
import com.takasima.bankpapuamb.ui.theme.circle
import com.takasima.bankpapuamb.ui.theme.circle2
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary
import com.takasima.bankpapuamb.ui.theme.terniary2

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.10f)
                    .background(color = Color(0xFFAAE4F6))
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = null,
                    Modifier.size(32.dp)
                )
                Text(
                    text = "REGISTER",
                    color = terniary,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp
                )
            }
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

            RegisterScreenSection1()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreenSection1(modifier: Modifier = Modifier) {
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
            text = "Username",
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
                    imageVector = Icons.Filled.Person,
                    contentDescription = null
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
//            tanggal
        Text(
            text = "Password",
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
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null
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
            text = "Konfirmasi Password",
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
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null
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
            onClick = { /*TODO*/ },
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
    RegisterScreen()
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPrev1() {
    RegisterScreenSection1()
}


@Composable
fun RegisterScreenSection2(modifier: Modifier = Modifier) {

    /*CONTENT*/
    Column(
        Modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))

        Text(
            text = "Silahkan cek SMS anda untuk mendapatkan kode OTP",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
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
            onClick = { /*TODO*/ },
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

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPrev2() {
    RegisterScreenSection2()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreenSection3(modifier: Modifier = Modifier) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val pswdConfirm = remember { mutableStateOf("") }
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
                    imageVector = Icons.Outlined.CreditCard,
                    contentDescription = null
                )
            },

            placeholder = { Text(text = "placeholder") },
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
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = null
                )
            },

            placeholder = { Text(text = "DD/MM/YYYY") },
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
                    imageVector = Icons.Filled.Contacts,
                    contentDescription = null
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
            onClick = { /*TODO*/ },
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
private fun RegisterScreenPrev3() {
    RegisterScreenSection3()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreenSection4(modifier: Modifier = Modifier) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val pswdConfirm = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current


    /*CONTENT*/
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
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
            onClick = { /*TODO*/ },
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
    RegisterScreenSection4()
}