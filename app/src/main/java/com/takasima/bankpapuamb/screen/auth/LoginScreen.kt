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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.data.viewmodel.MainViewModel
import com.takasima.bankpapuamb.navigation.AuthRouteScreens
import com.takasima.bankpapuamb.navigation.Graph
import com.takasima.bankpapuamb.screen.common.CustomTextField1
import com.takasima.bankpapuamb.screen.common.CustomTextField2
import com.takasima.bankpapuamb.ui.theme.circle
import com.takasima.bankpapuamb.ui.theme.circle2
import com.takasima.bankpapuamb.ui.theme.secondary

@Composable
fun LoginScreen(
    viewModel: MainViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Surface() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
//            CustomBackground()
            /*WALPAPER*/
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.TopStart)
                    .offset(x = 75.dp, y = 20.dp)
                    .clip(shape = CircleShape)
                    .background(circle.copy(alpha = 0.6f))

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
                    .size(130.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = 25.dp, y = (-35).dp)
                    .clip(shape = CircleShape)
                    .background(circle.copy(alpha = 0.6f))

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
                    .size(120.dp)
                    .align(Alignment.CenterStart)
                    .offset(x = 25.dp, y = (-125).dp)
                    .clip(shape = CircleShape)
                    .background(circle.copy(alpha = 0.6f))

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
                    .size(120.dp)
                    .align(Alignment.CenterEnd)
                    .offset(x = 40.dp, y = (-115).dp)
                    .clip(shape = CircleShape)
                    .background(circle.copy(alpha = 0.6f))

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

            Image(
                modifier = Modifier
                    .size(width = 66.dp, height = 166.dp)
                    .align(Alignment.CenterStart)
                    .offset(y = 32.dp),
                painter = painterResource(id = R.drawable.ornamen),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .size(width = 66.dp, height = 166.dp)
                    .align(Alignment.CenterEnd)
                    .offset(y = 32.dp),
                painter = painterResource(id = R.drawable.ornamen),
                contentDescription = null
            )

            Box(
                modifier = Modifier
                    .size(400.dp)
                    .offset(y = 120.dp)
                    .align(Alignment.BottomCenter)
                    .scale(1.35f)
                    .clip(shape = CircleShape)
                    .background(Color(0xFFAAE4F6))

            )
            Box(
                modifier = Modifier
                    .size(400.dp)
                    .offset(y = 200.dp)
                    .align(Alignment.BottomCenter)
                    .scale(1.3f)
                    .clip(shape = CircleShape)
                    .background(Color(0xFF4CCAF2))

            )

            /*CONTENT*/
            Column(Modifier.padding(horizontal = 48.dp)) {
                Spacer(modifier = Modifier.fillMaxHeight(0.20f))
                Image(
                    modifier = modifier
                        .fillMaxWidth(0.8f)
                        .padding(horizontal = 16.dp)
                        .align(Alignment.CenterHorizontally),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = R.drawable.bank_papur_logo2),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.fillMaxSize(0.38f))

                CustomTextField1(textState = emailState, "No Telp / username")
                Spacer(modifier = Modifier.height(16.dp))

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                    CustomTextField2(passwordState = passwordState, "Password")
                    Spacer(
                        modifier = Modifier
                            .width(8.dp)
//                            .weight(1f)
                    )

                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier
                            .clip(shape = RoundedCornerShape(24.dp))
                    ) {
                        Icon(
                            modifier = modifier
                                .size(128.dp)
                                .background(secondary),
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_fingerprint_24),
                            contentDescription = null
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                Button(modifier = Modifier.fillMaxWidth(),
                    onClick = {
//                    viewModel.login()
//                    navController.popBackStack()
//                    navController.navigate(Graph.HOME)
                        navController.navigate(Graph.HOME) {
                            popUpTo(AuthRouteScreens.Login.route) {
                                inclusive = true
                            }
                        }
                    }, colors = ButtonDefaults.buttonColors(containerColor = secondary)
                ) {
                    Text(text = "LOGIN", fontWeight = FontWeight.Bold)
                }

                TextButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {
                        navController.navigate(AuthRouteScreens.SignUp.route)
                    }) {
                    Text(text = "REGISTER", color = Color.White, textAlign = TextAlign.Center)

                }

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                modifier = Modifier.size(48.dp),
                                painter = painterResource(id = R.drawable.atm),
                                contentDescription = null
                            )
                        }
                        Text(text = "ATM")
                    }

                    Spacer(modifier = Modifier.width(24.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                modifier = Modifier.size(48.dp),
                                imageVector = Icons.Default.SupportAgent,
                                contentDescription = null
                            )
                        }
                        Text(text = "Call Center")
                    }
                }
            }

        }
    }
}


@Preview
@Composable
private fun LoginScreenPrev() {
    LoginScreen(viewModel(), rememberNavController())
}