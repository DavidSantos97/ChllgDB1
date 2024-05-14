package br.com.fiap.chllgdb1.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.chllgdb1.R

@Composable
fun homeScreen(navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Logo ChatMED"
                )
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Challenge DB1",
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF1B44AC),
                    fontWeight = FontWeight.Bold

                )

            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(top = 1.dp),
                    text = "Vamos lá!",
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold

                )

            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(top = 1.dp, start = 10.dp, end = 10.dp),
                    text = "Faça o login e cuide da sua saúde com a gente.",
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold

                )

            }
            Spacer(modifier = Modifier.padding(5.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .size(width = 200.dp, height = 48.dp),
                    onClick = {
                        navController.navigate("Login")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF17DB2E)
                    )
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontSize = 18.sp
                    )

                }

            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(width = 200.dp, height = 48.dp),
                    onClick = {
                        navController.navigate("Cadastro")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFF17DB2E))

                ) {
                    Text(
                        text = "Sign Up",
                        color = Color(0xFF17DB2E),
                        fontSize = 18.sp
                    )

                }


            }


        }


    }
}