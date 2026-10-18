package com.gas.pam_p5_tugas.ui.theme

import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import com.gas.pam_p5_tugas.R

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
}