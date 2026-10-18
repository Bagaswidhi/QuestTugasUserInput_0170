package com.gas.pam_p5_tugas.ui.theme

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gas.pam_p5_tugas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KontenUtama(modifier : Modifier){
    // sementara
    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTanggalLahir by remember { mutableStateOf("") }
    var textPengalaman by remember { mutableStateOf("") }
    var textSkill by remember { mutableStateOf(setOf<String>()) }

    // hasil submit
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var pengalaman by remember { mutableStateOf("") }
    var skill by remember { mutableStateOf(setOf<String>()) }

    val listPengalaman = stringArrayResource(id = R.array.listPengalaman)
    val listSkill = stringArrayResource(id = R.array.listSkill)

    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    var expandedDropdown by remember { mutableStateOf(false) }
    var isSubmitted by remember { mutableStateOf(false) }

    // validasi
    val isFormValid = textNamaDepan.isNotEmpty() &&
            textNamaBelakang.isNotEmpty() &&
            textEmail.isNotEmpty() &&
            textTanggalLahir.isNotEmpty() &&
            textPengalaman.isNotEmpty() &&
            textSkill.isNotEmpty()
    Box(
        modifier = modifier.fillMaxSize()
    ){
        Image(
            painterResource(id = R.drawable.gambar1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 220.dp),
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ){
                    Text(
                        text = stringResource(R.string.judul),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 25.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = stringResource(R.string.caption),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, start = 20.dp, end = 20.dp, bottom = 5.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ){
                        OutlinedTextField(
                            value = textNamaDepan,
                            singleLine = true,
                            label = { Text(stringResource(R.string.depan)) },
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.outline_color),
                                focusedLabelColor = colorResource(id = R.color.outline_color)
                            ),
                            onValueChange = { textNamaDepan = it }
                        )
                        OutlinedTextField(
                            value = textNamaBelakang,
                            singleLine = true,
                            label = { Text(stringResource(R.string.belakang)) },
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.outline_color),
                                focusedLabelColor = colorResource(id = R.color.outline_color)
                            ),
                            onValueChange = { textNamaBelakang = it }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, start = 20.dp, end = 20.dp, bottom = 5.dp)
                    ){
                        OutlinedTextField(
                            value = textEmail,
                            singleLine = true,
                            label = { Text(stringResource(R.string.email)) },
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.outline_color),
                                focusedLabelColor = colorResource(id = R.color.outline_color)
                            ),
                            onValueChange = { textEmail = it }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, start = 20.dp, end = 20.dp, bottom = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        OutlinedTextField(
                            value = textTanggalLahir,
                            onValueChange = { },
                            readOnly = true,
                            singleLine = true,
                            label = { Text(stringResource(R.string.tglLahir)) },
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.outline_color),
                                focusedLabelColor = colorResource(id = R.color.outline_color)
                            ),
                            trailingIcon = {
                                IconButton(onClick = { showDatePicker = true }) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = null
                                    )
                                }
                            }
                        )

                        ExposedDropdownMenuBox(
                            expanded = expandedDropdown,
                            onExpandedChange = { expandedDropdown = !expandedDropdown },
                            modifier = Modifier.weight(1f)
                        ){

                        }
                    }
                }
            }
        }
    }
}