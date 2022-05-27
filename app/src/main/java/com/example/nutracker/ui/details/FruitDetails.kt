package com.example.nutracker.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.nutracker.model.Fruit
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FruitDetails (modifier: Modifier = Modifier, fruit: Fruit){
    var name by rememberSaveable { mutableStateOf(fruit?.name) }
    var family by rememberSaveable { mutableStateOf(fruit?.family) }
    var genus by rememberSaveable { mutableStateOf(fruit?.genus) }
    var order by rememberSaveable { mutableStateOf(fruit?.order) }
    var calories by rememberSaveable { mutableStateOf(fruit?.calories) }
    var carbohydrates by rememberSaveable { mutableStateOf(fruit?.carbohydrates) }
    var protein by rememberSaveable { mutableStateOf(fruit?.protein) }
    var fat by rememberSaveable { mutableStateOf(fruit?.fat) }


    Column(horizontalAlignment = Alignment.Start){
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                ){
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text =  "Name: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                value = name ?: "New fruit",
                onValueChange = {
                    name = it
                },
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                ){
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text =  "Family: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                placeholder = { Text(text = "family") },
                value = family ?: "",
                onValueChange = {
                    family = it
                },
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                ){
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text =  "Genus: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                placeholder = { Text(text = "genus") },
                value = genus ?: "",
                onValueChange = {
                    genus = it
                },
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                ){
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text =  "Order: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                placeholder = { Text(text = "order") },
                value = order ?: "",
                onValueChange = {
                    order = it
                },
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                ){
            Text(
                modifier = Modifier
                    .padding(12.dp),
                text =  "Calories: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                placeholder = { Text(text = "0.0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = if(calories==null){ "0.0" } else{ calories.toString() },
                onValueChange = {
                    calories = it.toFloat()
                },
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                ){
            Text(
                modifier = Modifier
                    .padding(12.dp),
                text =  "Carbohydrates: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                placeholder = { Text(text = "0.0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = if(carbohydrates==null){ "0.0" } else{ carbohydrates.toString() },
                onValueChange = {
                    carbohydrates = it.toFloat()
                },
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                ){
            Text(
                modifier = Modifier
                    .padding(12.dp),
                text =  "Protein: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                placeholder = { Text(text = "0.0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = if(protein==null){ "0.0" } else{ protein.toString() },
                onValueChange = {
                    protein = it.toFloat()
                },
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                ){
            Text(
                modifier = Modifier
                    .padding(12.dp),
                text =  "Fat: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                placeholder = { Text(text = "0.0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = if(fat==null){ "0.0" } else{ fat.toString() },
                onValueChange = {
                    fat = it.toFloat()
                },
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                onClick = { throw RuntimeException("Test Crash") }){
                Text("Test Crash");
            }
        }
    }
}