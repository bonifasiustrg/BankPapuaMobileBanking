package com.takasima.bankpapuamb.screen.common

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.ui.theme.secondary
import com.takasima.bankpapuamb.ui.theme.terniary2


@Composable
fun OptTextField(modifier: Modifier = Modifier, bgColor: Color = Color.Transparent) {
    var otpText by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpText,
        onValueChange = {
            if (it.length <= 4) {
                otpText = it
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = { /* Handle done action */ }
        ),
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {

            repeat(4) { index ->
                val number = when {
                    index >= otpText.length -> ""
                    else -> otpText[index]
                }

                Column(
                    modifier = modifier
                        .background(bgColor, shape = RoundedCornerShape(16.dp))
                        .border(1.dp, terniary2, shape = RoundedCornerShape(20.dp))
                        .padding(4.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = number.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 42.sp
                    )

                    Box(
                        modifier = modifier
                            .width(64.dp)
//                            .height(32.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OptPrev() {
    OptTextField()
}

@Composable
fun OptTextFieldPIN(modifier: Modifier = Modifier, bgColor: Color = Color.Transparent) {
    var otpText by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpText,
        onValueChange = {
            if (it.length <= 6) {
                otpText = it
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = { /* Handle done action */ }
        ),
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {

            repeat(6) { index ->
                val number = when {
                    index >= otpText.length -> ""
                    else -> otpText[index]
                }

                Column(
                    modifier = modifier
                        .background(bgColor, shape = RoundedCornerShape(16.dp))
                        .border(1.dp, terniary2, shape = RoundedCornerShape(20.dp))
                        .padding(4.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = number.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 32.sp
                    )

                    Box(
                        modifier = modifier
                            .width(40.dp)
//                            .height(32.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OptTextFieldPINPrev() {
    Column(Modifier.fillMaxWidth()) {
        OptTextFieldPIN()
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField1(
    textState: MutableState<String>,
    placeholder: String = "Nomor Telepon atau username",
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
//    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        shape = RoundedCornerShape(18.dp),
//        label = {
//            Text("Name or Email Address",
//                color = MaterialTheme.colorScheme.primary,
//                style = MaterialTheme.typography.labelMedium,
//            ) },
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.profile_ic),
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        ),
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        ),


    )
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField2(
    passwordState: MutableState<String>,
    placeholder: String = "Password",
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        shape = RoundedCornerShape(18.dp),
//        label = {
//            Text("Enter Password",
//                color = MaterialTheme.colorScheme.primary,
//                style = MaterialTheme.typography.labelMedium,
//            ) },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
        ),
        leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (passwordHidden) Visibility else VisibilityOff
                // Please provide localized description for accessibility services
                val description = if (passwordHidden) "Show password" else "Hide password"
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        },
        placeholder = { Text(text = placeholder) },

        modifier = modifier.width(256.dp),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun CustomField1Prev() {
    CustomTextField1(textState = remember { mutableStateOf("tes@mail.com") })
}

@Preview(showBackground = true)
@Composable
private fun CustomField2Prev() {
    CustomTextField2(
        passwordState = remember { mutableStateOf("pasw123") },
        placeholder = "Password"
    )
}

/*KHUSUS*/
/** We copy the implementation of Visibility and VisibilityOff icons to showcase them in the
 * password text field sample but to avoid adding material-icons-extended library as a dependency
 * to the samples not to increase the build time
 */
val Visibility: ImageVector
    get() {
        if (_visibility != null) {
            return _visibility!!
        }
        _visibility = materialIcon(name = "Filled.Visibility") {
            materialPath {
                moveTo(12.0f, 4.5f)
                curveTo(7.0f, 4.5f, 2.73f, 7.61f, 1.0f, 12.0f)
                curveToRelative(1.73f, 4.39f, 6.0f, 7.5f, 11.0f, 7.5f)
                reflectiveCurveToRelative(9.27f, -3.11f, 11.0f, -7.5f)
                curveToRelative(-1.73f, -4.39f, -6.0f, -7.5f, -11.0f, -7.5f)
                close()
                moveTo(12.0f, 17.0f)
                curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f)
                reflectiveCurveToRelative(2.24f, -5.0f, 5.0f, -5.0f)
                reflectiveCurveToRelative(5.0f, 2.24f, 5.0f, 5.0f)
                reflectiveCurveToRelative(-2.24f, 5.0f, -5.0f, 5.0f)
                close()
                moveTo(12.0f, 9.0f)
                curveToRelative(-1.66f, 0.0f, -3.0f, 1.34f, -3.0f, 3.0f)
                reflectiveCurveToRelative(1.34f, 3.0f, 3.0f, 3.0f)
                reflectiveCurveToRelative(3.0f, -1.34f, 3.0f, -3.0f)
                reflectiveCurveToRelative(-1.34f, -3.0f, -3.0f, -3.0f)
                close()
            }
        }
        return _visibility!!
    }
private var _visibility: ImageVector? = null

val VisibilityOff: ImageVector
    get() {
        if (_visibilityOff != null) {
            return _visibilityOff!!
        }
        _visibilityOff = materialIcon(name = "Filled.VisibilityOff") {
            materialPath {
                moveTo(12.0f, 7.0f)
                curveToRelative(2.76f, 0.0f, 5.0f, 2.24f, 5.0f, 5.0f)
                curveToRelative(0.0f, 0.65f, -0.13f, 1.26f, -0.36f, 1.83f)
                lineToRelative(2.92f, 2.92f)
                curveToRelative(1.51f, -1.26f, 2.7f, -2.89f, 3.43f, -4.75f)
                curveToRelative(-1.73f, -4.39f, -6.0f, -7.5f, -11.0f, -7.5f)
                curveToRelative(-1.4f, 0.0f, -2.74f, 0.25f, -3.98f, 0.7f)
                lineToRelative(2.16f, 2.16f)
                curveTo(10.74f, 7.13f, 11.35f, 7.0f, 12.0f, 7.0f)
                close()
                moveTo(2.0f, 4.27f)
                lineToRelative(2.28f, 2.28f)
                lineToRelative(0.46f, 0.46f)
                curveTo(3.08f, 8.3f, 1.78f, 10.02f, 1.0f, 12.0f)
                curveToRelative(1.73f, 4.39f, 6.0f, 7.5f, 11.0f, 7.5f)
                curveToRelative(1.55f, 0.0f, 3.03f, -0.3f, 4.38f, -0.84f)
                lineToRelative(0.42f, 0.42f)
                lineTo(19.73f, 22.0f)
                lineTo(21.0f, 20.73f)
                lineTo(3.27f, 3.0f)
                lineTo(2.0f, 4.27f)
                close()
                moveTo(7.53f, 9.8f)
                lineToRelative(1.55f, 1.55f)
                curveToRelative(-0.05f, 0.21f, -0.08f, 0.43f, -0.08f, 0.65f)
                curveToRelative(0.0f, 1.66f, 1.34f, 3.0f, 3.0f, 3.0f)
                curveToRelative(0.22f, 0.0f, 0.44f, -0.03f, 0.65f, -0.08f)
                lineToRelative(1.55f, 1.55f)
                curveToRelative(-0.67f, 0.33f, -1.41f, 0.53f, -2.2f, 0.53f)
                curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f)
                curveToRelative(0.0f, -0.79f, 0.2f, -1.53f, 0.53f, -2.2f)
                close()
                moveTo(11.84f, 9.02f)
                lineToRelative(3.15f, 3.15f)
                lineToRelative(0.02f, -0.16f)
                curveToRelative(0.0f, -1.66f, -1.34f, -3.0f, -3.0f, -3.0f)
                lineToRelative(-0.17f, 0.01f)
                close()
            }
        }
        return _visibilityOff!!
    }
private var _visibilityOff: ImageVector? = null