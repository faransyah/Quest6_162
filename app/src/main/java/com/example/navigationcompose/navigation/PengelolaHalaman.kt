package com.example.navigationcompose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.ui.View.Screen.MahasiswaFormView
import com.example.navigationcompose.ui.View.Screen.SplashView
import com.example.navigationcompose.ui.View.ViewModel.MahasiswaViewModel

@Composable
fun MahasiswaApp(
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswauiState.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(route = Halaman.Splash.name){
            SplashView(onMulaiButton = {
                navController.navigation(
                    Halaman.Mahasiswa.name
                )
            }) {  }

        }
        composable(route = Halaman.Splash.name){
            MahasiswaFormView(onSubmitButton = {},
                onbackButton) {  }
        }
    }

}