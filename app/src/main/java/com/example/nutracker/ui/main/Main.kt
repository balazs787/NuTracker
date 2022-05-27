package com.example.nutracker.ui.main

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nutracker.extensions.visible
import com.example.nutracker.ui.details.FruitDetails
import com.example.nutracker.ui.details.FruitList
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun Main(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val isLoading: Boolean by viewModel.isLoading
    val selectedTab = Tabs.getTabFromResource(viewModel.selectedTab.value)
    val fruits by viewModel.fruitList.collectAsState(initial = listOf())


    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Home.route, ) {
            composable(NavScreen.Home.route) {
                ConstraintLayout {
                    val (body, progress) = createRefs()
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = { viewModel.addClicked() }, Modifier.visible(!viewModel.details.value), backgroundColor = Color.Red) {
                                Icon(
                                    Icons.Filled.Add,
                                    contentDescription = "AddButton",
                                    modifier = Modifier.size(ButtonDefaults.IconSize)
                                )
                            }
                        },
                        backgroundColor = Color.White,
                        topBar = { Header(viewModel.title.value,
                            viewModel.details.value,
                            { _ -> viewModel.backClicked()},
                            { _ -> viewModel.saveClicked()},
                            { _ -> viewModel.deleteClicked()}) },
                        modifier = Modifier.constrainAs(body) {
                            top.linkTo(parent.top)
                        }
                    ){innerPadding ->
                        val modifier = Modifier.padding(innerPadding)
                        Crossfade(selectedTab) { destination ->
                            when (destination) {
                                Tabs.FRUITS -> FruitList(modifier, fruits ?: listOf(), { fruit -> viewModel.selectFruit(1, fruit)})
                                Tabs.DETAILS -> FruitDetails(modifier, viewModel.selectedFruit.value)
                            }
                        }
                    }
                    CircularProgressIndicator(
                        modifier = Modifier
                            .constrainAs(progress) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .visible(isLoading)
                    )
                }
            }
        }
    }
}

@Composable
private fun Header(name : String,
                   details : Boolean,
                   onBackClicked: (any : Any?) -> Unit,
                   onSaveClicked: (any : Any?) -> Unit,
                   onDeleteClicked: (any : Any?) -> Unit) {
    if(!details){

        TopAppBar(
            elevation = 4.dp,
            backgroundColor = Color.Blue,
            modifier = Modifier.height(50.dp),
        ) {

            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterVertically),
                text = name,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
    else{
        TopAppBar(
            elevation = 4.dp,
            backgroundColor = Color.Blue,
            modifier = Modifier.height(58.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = { onBackClicked(null) })
                {
                    Icon(
                        Icons.Filled.ArrowBackIos,
                        tint = Color.White,
                        contentDescription = "Back",
                        modifier = Modifier.size(ButtonDefaults.IconSize))
                }
                Text(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterVertically),
                    text = name,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                    onClick = { onSaveClicked(0) })
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Save",
                        modifier = Modifier.size(ButtonDefaults.IconSize))
                }
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = { onSaveClicked(0) })
                {
                    Icon(
                        Icons.Filled.Delete,
                        contentDescription = "Delete",
                        modifier = Modifier.size(ButtonDefaults.IconSize))
                }
            }
        }
    }

}

@Composable
private fun FloatingButton(details : Boolean) {
    if(!details) {
        FloatingActionButton(onClick = { }) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "AddButton",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
    }
}


enum class Tabs(
    val title: String,
) {
    FRUITS("Main"),
    DETAILS("Details");

    companion object {
        fun getTabFromResource(tab: Int): Tabs {
            return when (tab) {
                0 -> FRUITS
                1 -> DETAILS
                else -> FRUITS
            }
        }
    }
}

sealed class NavScreen(val route: String) {

    object Home : NavScreen("Home")
}