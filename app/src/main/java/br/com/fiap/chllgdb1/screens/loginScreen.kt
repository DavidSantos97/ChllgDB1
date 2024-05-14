package br.com.fiap.chllgdb1.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.navigation.NavHostController
import br.com.fiap.chllgdb1.R
import br.com.fiap.chllgdb1.components.CaixaDeEntrada
import br.com.fiap.chllgdb1.components.EntradaSenha

@Composable
fun loginScreen(loginScreenViewModel: loginScreenViewModel, navController: NavController) {

    val emailState = loginScreenViewModel.emailState.observeAsState(initial = "")
    val senhaState = loginScreenViewModel.senhaState.observeAsState(initial = "")
    val senhaVisibility = remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(modifier =
    Modifier
        .fillMaxWidth()
        .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    Button(
                        modifier = Modifier.align(Alignment.BottomStart),
                        onClick = { navController.navigate("Home")},
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                            contentDescription = "Seta Voltar",
                            tint = Color.Black
                        )

                    }
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Login",
                        fontSize = 23.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                }

            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, bottom = 20.dp)
                .size(width = 200.dp, height = 100.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.olho_abre),
                    contentDescription = "Logo ChatMED"
                )
            }
            CaixaDeEntrada(
                placeHolder = "E-mail",
                value = emailState.value,
                keyboardtype = KeyboardType.Email,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                icon = R.drawable.email,
                descricaoIcon = "icone email",
                atualizarEstado = {
                    loginScreenViewModel.onEmailCapitalChanged(it)
                }
            )
            EntradaSenha(
                placeHolder = "Senha",
                value = senhaState.value,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                keyboardtype = KeyboardType.Text,
                icon = R.drawable.senha,
                descricaoIcon = "icone senha",
                atualizarEstadoSenha = {
                    loginScreenViewModel.onSenhaCapitalChanged(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "Esqueceu a senha?",
                    color = Color(0xFF17DB2E),
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable(onClick = {})
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Button(
                    modifier = Modifier
                        .size(width = 300.dp, height = 48.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF17DB2E)
                    )
                ) {
                    Text(
                        text = "Entrar",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Não tem uma conta ? ",
                    color = Color.Black,
                    fontSize = 15.sp
                )
                Text(text = "Cadastre-se",
                    color = Color(0xFF17DB2E),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clickable (onClick = { navController.navigate("Cadastro") })
                )
            }

            Spacer(modifier = Modifier.padding(15.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Divider(modifier = Modifier.weight(1f), color = Color(0x92B1B1B1))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "ou",
                    color = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Divider(modifier = Modifier.weight(1f), color = Color(0x92B1B1B1))
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(width = 300.dp, height = 48.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0x92B1B1B1))

                ) {
                    Image(painter = painterResource(
                        id = R.drawable.google),
                        contentDescription = "G da Google",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(4.dp, end = 10.dp),

                        )
                    Text(
                        text = "Entre com Google",
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(width = 300.dp, height = 48.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0x92B1B1B1))

                ) {
                    Image(painter = painterResource(
                        id = R.drawable.outlook),
                        contentDescription = "Simbolo do Outlook",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(2.dp, end = 10.dp),

                        )
                    Text(
                        text = "Entre com Outlook",
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                }
            }

        }
    }
}