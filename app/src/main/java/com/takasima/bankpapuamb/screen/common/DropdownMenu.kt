package com.takasima.bankpapuamb.screen.common

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SignalCellularConnectedNoInternet4Bar
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.SignalCellularAlt
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.utils.daftarUnivIndo
import com.takasima.bankpapuamb.utils.jenisBpjs
import com.takasima.bankpapuamb.utils.lokasiList
import com.takasima.bankpapuamb.utils.providers
import com.takasima.bankpapuamb.utils.provinces

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenu(
    condition: String,
    icon: ImageVector = Icons.Default.SignalCellularConnectedNoInternet4Bar,
    isLeadiconActive: Boolean = false
) {
    val context = LocalContext.current
//    val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(/*provinces[0]*/"") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(horizontal = 16.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {

                    if (condition != "provider") {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = CircleShape
                            )
                        ) {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)

                        }
                    }
                },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                leadingIcon = {
                    if (condition == "provider") {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = CircleShape
                            )
                        ) {
                            Icon(imageVector = icon, contentDescription = null)
                        }
                    } else if (condition == "lokasi") {
                        Image(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                    } else if (condition == "universitas") {
                        Icon(
                            imageVector = Icons.Outlined.School,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
//                    .padding(8.dp)
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(16.dp)),
                placeholder = {
                    Text(
                        text = when (condition) {
                            "province" -> "Pilh provinsi"
                            "provider" -> "Pilih provider"
                            "lokasi" -> "Pilih lokasi"
                            "universitas" -> "Pilih universitas"
                            else -> "Pilih..."
                        }
                    )
                },

                )



            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                if (condition == "lokasi" || condition == "universitas") {
                    var text by remember { mutableStateOf("") }
                    var active by remember { mutableStateOf(false) }
                    SearchBar(
                        query = text,
                        onQueryChange = { text = it },
                        onSearch = {
//                    items.add(text)
                            active = false
                            text = ""
                        },
                        active = false,
                        onActiveChange = { active = it },
                        placeholder = { Text("Cari...") },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.search_location_ic),
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            if (active) {
                                Icon(modifier = Modifier.clickable {
                                    if (text.isNotEmpty()) {
                                        text = ""
                                    } else active = false
                                }, imageVector = Icons.Default.Close, contentDescription = null)
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = SearchBarDefaults.colors(
                            containerColor = Color.White
                        )
                    ) {
                        lokasiList.forEach {
                            Row(modifier = Modifier.padding(14.dp)) {
                                Icon(
                                    modifier = Modifier.padding(end = 10.dp),
                                    imageVector = Icons.Default.History,
                                    contentDescription = null
                                )

                                Text(text = it)
                            }
                        }
                    }

                    Divider(Modifier.fillMaxWidth())
                }

                if (condition == "provider") {
                    providers.forEach { item ->
                        DropdownMenuItem(
                            leadingIcon = {
                                Image(
                                    painter = painterResource(id = item.second),
                                    contentDescription = null,
                                    modifier = Modifier.width(50.dp)
                                )
                            },
                            text = { Text(text = item.first, color = Color.Black) },
                            onClick = {
                                selectedText = item.first
                                expanded = false
//                                 Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                } else if (condition == "jenisBpjs") {
                    jenisBpjs.forEach { item ->
                        DropdownMenuItem(
                            leadingIcon = {
                                Image(
                                    painter = painterResource(id = R.drawable.bpjs),
                                    contentDescription = null,
                                    modifier = Modifier.width(50.dp)
                                )
                            },
                            text = { Text(text = item, color = Color.Black) },
                            onClick = {
                                selectedText = item
                                expanded = false
//                                 Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                } else {
                    when (condition) {
                        "province" -> provinces
                        "lokasi" -> lokasiList
                        "universitas" -> daftarUnivIndo
//                        "jenisBpjs" -> jenisBpjs
                        else -> provinces
                    }.forEach { item ->
                        DropdownMenuItem(
                            leadingIcon = {
                                if (condition == "lokasi") {
                                    Icon(
                                        painter = painterResource(id = R.drawable.city_ic),
                                        contentDescription = null,
                                        modifier = Modifier.size(48.dp)
                                    )
                                } else if (condition == "universitas") {
                                    Icon(
                                        imageVector = Icons.Outlined.School,
                                        contentDescription = null,
                                        modifier = Modifier.size(48.dp)
                                    )
                                } else if (condition == "provider") {
                                    Icon(
                                        imageVector = Icons.Outlined.SignalCellularAlt,
                                        contentDescription = null,
                                        modifier = Modifier.size(48.dp)
                                    )
                                }
                            },
                            text = { Text(text = item, color = Color.Black) },
                            onClick = {
                                selectedText = item
                                expanded = false
                                Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DDMenuPrev() {
    ExposedDropdownMenu("province")
}