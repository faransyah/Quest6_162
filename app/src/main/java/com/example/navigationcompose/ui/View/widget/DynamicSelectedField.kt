package com.example.navigationcompose.ui.View.widget

import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import java.util.prefs.NodeChangeEvent

@Composable
fun DynamicSelectedTextField(
    selectedValue: String,
    options: List<String>,
    label: String,
    onValueChangeEvent: (String) -> Unit,
    modifier: Modifier = Modifier

){
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox() { }
}