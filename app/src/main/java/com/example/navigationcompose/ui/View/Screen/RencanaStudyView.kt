package com.example.navigationcompose.ui.View.Screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onBackButtonClicked: () -> Unit

){
    var chosenDropdown by remember {
        mutableStateOf(

        )
    }
    var checked by remember { mutableStateOf(false)}
    var pilihanKelas by remember {
        mutableStateOf("")
    }
    var listData: MutableList<String> = mutableListOf(chosenDropdown, pilihanKelas)

}