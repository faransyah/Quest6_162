package com.example.navigationcompose.ui.View.ViewModel

import androidx.lifecycle.ViewModel
import com.example.navigationcompose.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel(){

    private val _mahasiswaStatetUI = MutableStateFlow(Mahasiswa())

    val mahasiswauiState : StateFlow<Mahasiswa> = _mahasiswaStatetUI.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>){
        _mahasiswaStatetUI.update { statusSaatini ->
            statusSaatini.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2]
            )
        }
    }

}