package com.example.mvvn.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mvvn.model.Siswa
import com.example.mvvn.R

@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUISiswa :Siswa,
    onBackButtonClick:()-> Unit
){
    val items = listOf(
        Pair (first = stringResource(R.string.nama), second = statusUISiswa.nama),
        Pair (first = stringResource(R.string.gender), second = statusUISiswa.gender),
        Pair (first = stringResource(R.string.alamat), second = statusUISiswa.alamat),

    )
    Scaffold (modifier = Modifier,
        topBar = {TopAppBar(
            title = { Text(text=stringResource(R.string.detail), color= Color.White)},
            colors = TopAppBarDefaults.mediumTopAppBarColors(colorResource(R.color.purple_500))
        )}
    ){
        isiRuang->
        Column (modifier = Modifier
            .padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Column (
                modifier = Modifier .padding(all= dimensionResource(R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ){
                items.forEach { item->
                    Column{
                        Text(text=item.first.uppercase(), fontSize = 16.sp)
                        Text(text=item.second, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Divider(thickness = dimensionResource(R.dimen.thickness_divider))
                }
            }
        }
    }
}