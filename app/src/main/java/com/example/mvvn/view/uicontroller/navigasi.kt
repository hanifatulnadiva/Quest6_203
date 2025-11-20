package com.example.mvvn.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvn.viewmodel.SiswaViewModel
import com.example.mvvn.view.TampilSiswa
import com.example.mvvn.view.FormSiswa
import com.example.mvvn.model.DataJK.JenisK

enum class Navigasi{
    Formulir,
    Detail
}
@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController= rememberNavController()
){
    Scaffold {
        isiRuang->
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController =navController,
            startDestination = Navigasi.Formulir.name,
            modifier= Modifier.padding(paddingValues = isiRuang)
        ){
            composable (route = Navigasi.Formulir.name)
            {
                val konteks = LocalContext.current
                FormSiswa(
                    pilihanJK = JenisK.map { id -> konteks.resources.getString(id) }, onSubmitButtonClick = {
                        viewModel.setSiswa(it)
                        navController.navigate (route= Navigasi.Detail.name)
                    }
                )
            }
        }
    }
}
