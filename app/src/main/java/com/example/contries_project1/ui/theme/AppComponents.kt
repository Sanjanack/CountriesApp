

package com.example.contries_project1.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.contries_project1.ui.theme.screens.Routes
import java.lang.reflect.Modifier




//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TopAppBar(navController: NavHostController){
//    Surface(
//        modifier = androidx.compose.ui.Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background
//                ) {
//                    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//                    Scaffold(
//                        modifier = androidx.compose.ui.Modifier
//                            .fillMaxSize()
//                            .nestedScroll(scrollBehavior.nestedScrollConnection),
//                        topBar = {
//                            TopAppBar(
//                                title = {
//                                    Text(text = "Countries")
//                                },
//                                navigationIcon = {
//                                    IconButton(onClick = { /*TODO*/ }) {
//                                        Icon(
//                                            imageVector = Icons.Default.Menu,
//                                            contentDescription = "Go back"
//                                        )
//                                    }
//                                },
//                                actions = {
//                                    IconButton(onClick = {navController.navigate(Routes.USER_INPUT_SCREEN) }) {
//                                        Icon(
//                                            imageVector = Icons.Default.AccountCircle,
//                                            contentDescription = "Mark as favorite"
//                                        )
//                                    }
//
//                                },
//                                scrollBehavior = scrollBehavior,
//                            )
//                        }
//                    ) { values ->
//                        LazyColumn(
//                            modifier = androidx.compose.ui.Modifier
//                                .fillMaxSize()
//                                .padding(values)
//                        ) {
//
//                        }
//                    }
//    }
//}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(heading:String, navController: NavController? = null, onBackIconClick: (() -> Unit)? = null,onLoginIconClick: (() -> Unit)? = null) {
    Surface(
        modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = heading,
                    fontSize = 25.sp,
                    color = Color.Black,

                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                containerColor =Color.Blue
//                containerColor = MaterialTheme.colorScheme.background
                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp)
            ),
            navigationIcon =
            {
                IconButton(onClick = { onBackIconClick?.invoke()}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Go back"
                    )
                }
            },
            actions =
            {
                IconButton(onClick = {onLoginIconClick?.invoke()}) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                }

            },
        )
    }
}
// navController.navigate(Routes.COUNTRIES_SCREEN)


@Preview
@Composable
fun TopBarPreview(){
    TopAppBar(heading ="Countries",rememberNavController())
}
