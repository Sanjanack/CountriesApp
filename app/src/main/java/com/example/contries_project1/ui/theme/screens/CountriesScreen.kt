package com.example.contries_project1.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.contries_project1.R
import com.example.contries_project1.ui.theme.TopAppBar


// Data class representing a country
data class Country(val flag:Int, val name: String, val collage: Int, val details: Int)
    // Sample list of countries
    val countryList = listOf(
        Country(R.drawable.indiaflag,"India",R.drawable.india, R.string.india_m),
        Country(R.drawable.franceflag,"France", R.drawable.france, R.string.france_m),
        Country(R.drawable.usaflag,"United States", R.drawable.usa, R.string.usa_m),
        Country(R.drawable.germanyflag,"Germany", R.drawable.germany, R.string.germany_m),
        Country(R.drawable.italyflag,"Italy", R.drawable.italy, R.string.italy_m),
        Country(R.drawable.canadaflag,"Canada", R.drawable.canada, R.string.canada_m),
        Country(R.drawable.japanflag,"Japan", R.drawable.japan, R.string.japan_m),
        Country(R.drawable.russiaflag,"Russia", R.drawable.russia, R.string.russia_m),
        Country(R.drawable.belgiumflag,"Belgium", R.drawable.belgium, R.string.belgium_m),
        Country(R.drawable.polandflag,"Poland", R.drawable.poland, R.string.poland_m)
    )
@Composable
fun CountryList(onCountryClicked: (Country) -> Unit) {
//    TopAppBar(rememberNavController())
    Text(
        text = "Choose a country!",
        color = Color.White,
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
    )
    LazyColumn {
        items(countryList) { country ->
            CountryListItem(country = country, onCountryClicked)
        }
    }
}

@Composable
fun CountryListItem(country: Country, onCountryClicked: (Country) -> Unit) {
//    val image = painterResource(R.drawable.gradientbg)
//    Image(
//        painter = image,
//        contentDescription = null,
//        contentScale = ContentScale.FillBounds,
//        modifier = Modifier
//            .fillMaxSize()
//    )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clickable { onCountryClicked(country) },
            color = MaterialTheme.colorScheme.surface
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = country.flag),
                    contentDescription = null,
                    modifier = Modifier
                        .size(45.dp)
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = country.name,
                    color = Color.Blue,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
}


@Composable
fun Countries(navController: NavHostController) {
//    TopAppBar("Countries", rememberNavController())
    Column {
        TopAppBar("Countries", rememberNavController(),onBackIconClick = {
            navController.navigateUp()}, onLoginIconClick = {
            navController.navigate(Routes.USER_INPUT_SCREEN)})
        val selectedCountry = remember { mutableStateOf<Country?>(null) }
        if (selectedCountry.value == null) {

            CountryList(onCountryClicked = { country ->
                selectedCountry.value = country
            }
            )
        } else {
//            navController.navigate(Routes.COUNTRIES_DETAILS_SCREEN)
        CountryDetail(country = selectedCountry.value!!)
        }
    }
}

//TopAppBar("Countries", rememberNavController(),onBackIconClick = {
//    navController.navigateUp()}, onLoginIconClick = {
//    navController.navigate(Routes.USER_INPUT_SCREEN)})


//    @Composable
//    fun Countries(navController: NavHostController) {
//        val image = painterResource(R.drawable.gradientbg)
//        val back = painterResource(R.drawable.back)
//        val person = painterResource(R.drawable.person)
//
//        Box() {
//            Image(
//                painter = image,
//                contentDescription = null,
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier
//                    .fillMaxSize()
//            )
//
//            Column(modifier = Modifier.fillMaxWidth()) {
////            Image(
////                painter = travelImage,
////                contentDescription = null,
////                contentScale = ContentScale.Crop,
////                modifier = Modifier
////                    .padding(0.dp)
////                    .size(550.dp, 100.dp)
////                    .fillMaxSize()
////            )
//                Row {
//                    Image(
//                        painter = back,
//                        contentDescription = null,
//                        alignment = Alignment.TopEnd,
//                        modifier = Modifier
//                            .padding(10.dp)
//                            .size(30.dp)
//                            .background(Color.LightGray)
//                            .clickable { navController.navigate(Routes.USER_INPUT_SCREEN) }
//
//                    )
//                    Image(
//                        painter = person,
//                        contentDescription = null,
//                        alignment = Alignment.TopEnd,
//                        modifier = Modifier
//                            .padding(10.dp)
//                            .size(30.dp)
//                            .clip(CircleShape)
//                            .clickable { navController.navigate(Routes.USER_INPUT_SCREEN) }
//
//                    )
//                }
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(20.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                )
//                {
////                Button(onClick = {navController.navigate(Routes.USER_INPUT_SCREEN)} ){
////                    Text("Log out")
////
////                }
//                    Text(
//                        text = "Choose a country!",
//                        color = Color.White,
//                        fontSize = 40.sp,
//                        textAlign = TextAlign.Center,
//                        fontStyle = FontStyle.Italic,
//                        modifier = Modifier
//                            .padding(0.dp)
//                            .fillMaxWidth()
//
//                    )
//                }
//
//                Image_text(image = painterResource(R.drawable.indiaflag),
//                    country_code = "+91",
//                    name = "India",
//                    click = { navController.navigate(Routes.INDIA_SCREEN) })
//                Image_text(image = painterResource(R.drawable.franceflag),
//                    country_code = "+91",
//                    name = "France",
//                    click = { navController.navigate(Routes.FRANCE_SCREEN) })
//                Image_text(image = painterResource(R.drawable.usaflag),
//                    country_code = "+91",
//                    name = "USA",
//                    click = { navController.navigate(Routes.USA_SCREEN) })
//                Image_text(image = painterResource(R.drawable.germanyflag),
//                    country_code = "+91",
//                    name = "Germany",
//                    click = { navController.navigate(Routes.GERMANY_SCREEN) })
//                Image_text(image = painterResource(R.drawable.japanflag),
//                    country_code = "+91",
//                    name = "Japan",
//                    click = { navController.navigate(Routes.JAPAN_SCREEN) })
//                Image_text(image = painterResource(R.drawable.italyflag),
//                    country_code = "+91",
//                    name = "Italy",
//                    click = { navController.navigate(Routes.ITALY_SCREEN) })
//                Image_text(image = painterResource(R.drawable.russiaflag),
//                    country_code = "+91",
//                    name = "Russia",
//                    click = { navController.navigate(Routes.RUSSIA_SCREEN) })
//                Image_text(image = painterResource(R.drawable.canadaflag),
//                    country_code = "+91",
//                    name = "Canada",
//                    click = { navController.navigate(Routes.CANADA_SCREEN) })
//                Image_text(image = painterResource(R.drawable.belgiumflag),
//                    country_code = "+91",
//                    name = "Belgium",
//                    click = { navController.navigate(Routes.BELGIUM_SCREEN) })
//                Image_text(image = painterResource(R.drawable.polandflag),
//                    country_code = "+91",
//                    name = "Poland",
//                    click = { navController.navigate(Routes.POLAND_SCREEN) })
//            }
//        }
//
//    }
//
//@Composable
//fun Image_text(image: Painter, country_code: String, name: String, click: () -> Unit = {}, modifier: Modifier = Modifier){
//    Row(modifier = Modifier
//        .fillMaxWidth()
//        .height(100.dp)
//        .padding(20.dp)
//        .clickable { click })
//        {
//        Image(
//            painter = image,
//            contentDescription = null,
//            modifier = modifier
//                .size(45.dp)
//                .clip(RoundedCornerShape(40))
//        )
//        Text(
//            text = country_code,
//            color = Color.White,
//            fontSize = 16.sp,
//            modifier = Modifier.padding(20.dp),
//            textAlign = TextAlign.Center
//        )
//        Text(
//            text = name,
//            color = Color.White,
//            fontSize = 16.sp,
//            modifier = Modifier.padding(16.dp),
//            textAlign = TextAlign.Center
//        )
////        Button(
////            onClick = click
////        )
////        {
////            Text ("To know more")
////        }
//    }
//}


//// Data class representing a country
//data class Country(val name: String, val capital: String, val population: Long)
//
//// Sample list of countries
//val countryList = listOf(
//    Country("United States", "Washington D.C.", 331449281),
//    Country("United Kingdom", "London", 67886011),
//    Country("Canada", "Ottawa", 37742154)
//)
//
//@Composable
//fun CountryList(onCountryClicked: (Country) -> Unit) {
//    LazyColumn {
//        items(countryList) { country ->
//            CountryListItem(country = country, onCountryClicked)
//        }
//    }
//}
//
//@Composable
//fun CountryListItem(country: Country, onCountryClicked: (Country) -> Unit) {
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 4.dp)
//            .clickable { onCountryClicked(country) },
//        color = MaterialTheme.colors.surface
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Column {
//                Text(text = country.name, style = MaterialTheme.typography.h6)
//                Text(text = "Capital: ${country.capital}", style = MaterialTheme.typography.body1)
//            }
//            Spacer(modifier = Modifier.weight(1f))
//            Text(text = "Population: ${country.population}", style = MaterialTheme.typography.body1)
//        }
//    }
//}
//
//@Composable
//fun CountryDetail(country: Country) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Country: ${country.name}", style = MaterialTheme.typography.h5)
//        Text(text = "Capital: ${country.capital}", style = MaterialTheme.typography.body1)
//        Text(text = "Population: ${country.population}", style = MaterialTheme.typography.body1)
//    }
//}
//
//@Composable
//fun App() {
//    val selectedCountry = remember { mutableStateOf<Country?>(null) }
//
//    if (selectedCountry.value == null) {
//        CountryList(onCountryClicked = { country ->
//            selectedCountry.value = country
//        })
//    } else {
//        CountryDetail(country = selectedCountry.value!!)
//    }
//}
//@Composable
//fun App() {
//    CountryList { country ->
//        // Handle country click
//    }
//}


@Preview(showBackground = true)
@Composable
fun PreviewCountryList() {
    MaterialTheme {
        CountryList(onCountryClicked = { /* Handle country click */ })
    }
}



//    @Preview
//    @Composable
//    fun CountriesScreenPreview(){
//        CountryList {
//
//            Countries(rememberNavController())
//        }