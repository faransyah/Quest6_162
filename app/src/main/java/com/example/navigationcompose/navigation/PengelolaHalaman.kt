package com.example.navigationcompose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.ui.View.Screen.MahasiswaFormView
import com.example.navigationcompose.ui.View.Screen.RencanaStudyView
import com.example.navigationcompose.ui.View.Screen.SplashView
import com.example.navigationcompose.ui.View.ViewModel.MahasiswaViewModel
import com.example.navigationcompose.ui.View.ViewModel.RencanaStudyViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}
@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()



){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswauiState.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(route = Halaman.Splash.name){
            SplashView(onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name)
        MahasiswaFormView(
            onSubmitButtonClicked = {
                mahasiswaViewModel.saveDataMahasiswa(it)
                navController.navigate(Halaman.Matakuliah.name)
            },
            onBackButtonClicked = {
                navController.popBackStack()
            }
        )
    }
    composable(route = Halaman.Matakuliah.name){
        RencanaStudyView(
            mahasiswa = mahasiswaUiState,
            onSubmitButtonClicked = { krsViewModel.saveDataKRS(it)},
            onBackButtonClicked = {navController.popBackStack()}
        ) { }
    }


}