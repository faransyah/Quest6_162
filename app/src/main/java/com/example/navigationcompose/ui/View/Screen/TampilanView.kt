package com.example.navigationcompose.ui.View.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationcompose.R
import com.example.navigationcompose.model.Mahasiswa
import com.example.navigationcompose.model.RencanaStudi

@Composable
fun TampilScreen(
    mahasiswa: Mahasiswa,
    rencanaStudi: RencanaStudi,
    onBackButton: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(50.dp)
            )
            Spacer(modifier = Modifier .padding(start = 16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = mahasiswa.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.White
                )
                Text(
                    text = mahasiswa.nim,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.White
                )
                Box {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .background( color = Color.White,
                            shape = RoundedCornerShape(
                                topEnd = 15.dp,
                                topStart = 15.dp
                            )
                        )
                        .fillMaxSize()
                ){
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Text(
                            text = "Data Diri",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                        Text(
                            text = "Hasil rencana studi",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        TampilData(
                            judul = "Nama",
                            isinya = mahasiswa.nama
                        )
                        TampilData(
                            judul = "NIM",
                            isinya = mahasiswa.nim
                        )
                        TampilData(
                            judul = "Email",
                            isinya = mahasiswa.email
                        )
                        TampilData(
                            judul = "MataKuliah",
                            isinya = rencanaStudi.namaMK
                        )
                        TampilData(
                            judul = "Nama",
                            isinya = rencanaStudi.kelas
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button(
                                onClick = {onBackButton()}
                            ) {
                                Text("Kembali")
                            }
                        }
                    }
                }
            }
        }
    }
}