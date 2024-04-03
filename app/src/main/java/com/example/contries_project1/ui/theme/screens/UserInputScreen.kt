package com.example.contries_project1.ui.theme.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.contries_project1.R
import com.example.contries_project1.ui.theme.TopAppBar

//onLogin: () -> Unit = {},

@Composable
fun LoginScreen( navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var isValidEmail by remember { mutableStateOf(false) }
    var isValidPassword by remember { mutableStateOf(false) }
    var isValid by remember { mutableStateOf(false) }
    val image = painterResource(R.drawable.gradientbg)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(50.dp)
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome!",
            color = Color.White,
            fontSize = 40.sp,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "To login, enter",
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "person") },
            label = { Text("Email") },
            isError = !isValidEmail(email.text),
            singleLine = true,
            modifier = Modifier.padding(8.dp)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(Icons.Default.Info, contentDescription = "password") },
            label = { Text("Password") },
            isError = !isValidPassword(password.text),
            singleLine = true,
            modifier = Modifier.padding(10.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        val context = LocalContext.current
        val emailText = email.text.toString()
        val passwordText = password.text.toString()
        Button(
            onClick = { navController.navigate(Routes.COUNTRIES_SCREEN) }
        )
        {
            Text("Login")
        }


        if (emailText.isEmpty() and passwordText.isNotEmpty()) {
            Toast.makeText(context, "Username is Empty", Toast.LENGTH_SHORT).show()
        }
        if (passwordText.isEmpty() and emailText.isNotEmpty()) {
            Toast.makeText(context, "Password is Empty", Toast.LENGTH_SHORT).show()
        }
        if (emailText.isEmpty() and passwordText.isEmpty()) {
            Toast.makeText(context, "Username and Password are Empty", Toast.LENGTH_SHORT)
                .show()
        }
        if (emailText.isNotEmpty() and passwordText.isNotEmpty()) {
            if (isValidEmail(email.text) and isValidPassword(password.text)) {
                Toast.makeText(context, "Successfully Validated", Toast.LENGTH_SHORT).show()
                isValid = true



            }
            if (!isValidEmail(email.text)) {
                Toast.makeText(context, "Please enter a valid email", Toast.LENGTH_SHORT)
                    .show()
            }
            if (!isValidPassword(password.text)) {
                Toast.makeText(context, "Please enter a valid password", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    return email.matches(emailRegex)
}
fun isValidPassword(password: String): Boolean {
    return password.length >= 8
}


@Preview
@Composable
fun UserInputScreenPreview(){
    LoginScreen(rememberNavController())
}