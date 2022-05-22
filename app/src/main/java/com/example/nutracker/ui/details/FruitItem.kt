package com.example.nutracker.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nutracker.model.Fruit
import com.example.nutracker.ui.theme.Blue600
import com.example.nutracker.ui.theme.Green700


@Composable
fun FruitItem (modifier: Modifier = Modifier, fruit: Fruit, onNameClicked: (fruit: Fruit) -> Unit){

    val gradient = Brush.horizontalGradient(listOf(Color(0xFF0077C7), Color(0xFF9AFA00)))

    GradientButton(
        text = fruit?.name ?: "Unknown",
        gradient = gradient,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        onClick = { onNameClicked(fruit) }
    )
}

@Composable
fun GradientButton(
    text: String,
    gradient : Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Box(modifier = Modifier
        .background(color = Color.Blue)
    ){
        Button(
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            contentPadding = PaddingValues(),
            onClick = { onClick() },
        ) {
            Box(
                modifier = Modifier
                    .background(gradient)
                    .then(modifier),
            ) {
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = text,
                    textAlign = TextAlign.Left,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}