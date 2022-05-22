package com.example.nutracker.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nutracker.model.Fruit

@Composable
fun FruitList (
    modifier: Modifier = Modifier,
    fruits: List<Fruit>,
    onNameClicked: (fruit: Fruit) -> Unit,
){

    LazyColumn {
        items(fruits) { fruit ->
            Column(horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)) {
                FruitItem(modifier, fruit, onNameClicked)
            }
        }
    }

}
