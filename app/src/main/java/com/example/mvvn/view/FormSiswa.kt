package com.example.mvvn.view

import android.graphics.Paint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
        }){
        isiRuang->
        Column (
            modifier= Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            OutlinedTextField(
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier= Modifier .width(width = 250.dp).padding(top=20.dp),
                label = {Text(stringResource(R.string.nama))},
                value = textNama,
                onValueChange = {
                    textNama=it
                }
            )
            HorizontalDivider(
                modifier = Modifier
                    .padding(all=12.dp)
                    .width(width =250.dp),
                thickness = dimensionResource(R.dimen.thickness_divider),
                color =Color.Blue
            )
            Row {
                pilihanJK.forEach {
                    item->
                Row(
                    modifier=Modifier .selectable(
                    selected =textGender == item,
                    onClick = { textGender= item }),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textGender == item,
                        onClick = {
                            textGender = item
                        }
                    )
                    Text(text=item) }

                }
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .padding(all=5.dp)
                .width(250.dp),
            thickness=dimensionResource(R.dimen.thickness_divider),
            color=Color.Blue
        )
        OutlinedTextField(
            value =textAlamat,
            singleLine = true,
            shape =MaterialTheme.shapes.medium,
            modifier=Modifier .width(250.dp),
            label = {Text(text=stringResource(R.string.alamat))},
            onValueChange = {
                textAlamat = it
            }
        )
    }
}
