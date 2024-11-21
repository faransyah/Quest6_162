package com.example.navigationcompose.ui.View.Screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onBackButtonClicked: () -> Unit

){
    var chosenDropdown by rember {
        mutableStateOf(

        )
    }
}