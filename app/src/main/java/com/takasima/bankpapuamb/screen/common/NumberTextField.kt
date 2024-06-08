package com.takasima.bankpapuamb.screen.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VehicleNumberTextField() {
    var vehicleNumber by remember { mutableStateOf("") }

    OutlinedTextField(
        value = formatVehicleNumber(vehicleNumber),
        onValueChange = { newText ->
            // Filter to allow only alphanumeric characters and limit to 12 characters
            val filteredText = newText.filter { it.isLetterOrDigit() }.take(12)
            vehicleNumber = filteredText
        },
        label = { Text("Nomor Kendaraan") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Ascii
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

fun formatVehicleNumber(input: String): String {
    // Split the string into groups of 4 characters
    val parts = input.chunked(4)

    // Join the parts with ' - ' separator
    return parts.joinToString(" - ")
}

@Preview(showBackground = true)
@Composable
fun PreviewVehicleNumberTextField() {
    VehicleNumberTextField()
}

