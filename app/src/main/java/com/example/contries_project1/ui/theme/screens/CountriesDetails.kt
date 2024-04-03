package com.example.contries_project1.ui.theme.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.contries_project1.R
import com.example.contries_project1.ui.theme.TopAppBar

@Composable
fun CountryDetail(country: Country) {
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = country.name, fontSize = 60.sp, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.padding(10.dp))
        Image(painter = painterResource(id = country.collage), contentDescription = null)
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = stringResource(id = country.details))
    }
}

//@Composable
//fun CountriesDetails(countryName:String, countryCollage: Image,navController: NavHostController)
//{
//    val countryCollage = painterResource(R.drawable.india)
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = countryName,
//            color = Color.Black,
//            fontSize = 70.sp,
//            fontWeight = FontWeight.SemiBold,
//            modifier = Modifier
//                .padding(20.dp),
//            textAlign = TextAlign.Center
//        )
//        Image(
//            painter = countryCollage,
//            contentDescription = null,
//            modifier = Modifier
//                .padding(10.dp)
//        )
//        Text(
//            text = stringResource(R.string.india_m),
//            color = Color.Black,
//            fontSize = 20.sp,
//            modifier = Modifier.padding(10.dp),
//            textAlign = TextAlign.Justify
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CountriesDetailsPreview() {
//    CountriesDetails(rememberNavController())
//}