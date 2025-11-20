package com.example.mvvn.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.mvvn.R

@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClick:(MutableList<String>)->Unit,
    modifier: Modifier=Modifier
    ){
    var textNama by remember { mutableStateOf(value = "") }
    var textAlamat by remember { mutableStateOf(value = "") }
    var textGender by remember { mutableStateOf(value = "") }
    val listData: MutableList<String> = mutableListOf(textNama, textAlamat, textGender)
    Scaffold (modifier= Modifier,
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name), color= Color.White)},
            colors= TopAppBarDefaults.mediumTopAppBarColors(colorResource(R.color.purple_500)))
        }){}
}
