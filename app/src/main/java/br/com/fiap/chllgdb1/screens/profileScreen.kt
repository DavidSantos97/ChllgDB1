package br.com.fiap.chllgdb1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.chllgdb1.R
import br.com.fiap.chllgdb1.components.CaixaDeEntrada


@Composable
fun profileScreen(
    profileScreenViewModel: CadastroScreenViewModel,
    navController: NavController
) {
    val expState = profileScreenViewModel.expState.observeAsState(initial = "")
    val habilState = profileScreenViewModel.habilState.observeAsState(initial = "")
    val interesseState = profileScreenViewModel.interesseState.observeAsState(initial = "")
    val formacaoState = profileScreenViewModel.formacaoState.observeAsState(initial = "")

    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(Color.White)){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center,

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
                        onClick = { navController.navigate("Home") },
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
                        text = "Perfil",
                        fontSize = 23.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                }

            }
            Spacer(modifier = Modifier.padding(20.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "foto de perfil",
                    modifier = Modifier
                        .size(180.dp)
                        .clip(shape = CircleShape)
                        .border(2.dp, Color.Black, CircleShape)
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            CaixaDeEntrada(
                placeHolder = "Experiência",
                value = expState.value,
                keyboardtype = KeyboardType.Text,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                icon = R.drawable.person,
                descricaoIcon = "icone pessoa",
                atualizarEstado = {
                    profileScreenViewModel.onExpCapitalChanged(it)
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CaixaDeEntrada(
                placeHolder = "Habilidades",
                value = habilState.value,
                keyboardtype = KeyboardType.Text,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                icon = R.drawable.person,
                descricaoIcon = "icone pessoa",
                atualizarEstado = {
                    profileScreenViewModel.onHabilCapitalChanged(it)
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CaixaDeEntrada(
                placeHolder = "Area de interesse",
                value = interesseState.value,
                keyboardtype = KeyboardType.Text,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                icon = R.drawable.person,
                descricaoIcon = "icone pessoa",
                atualizarEstado = {
                    profileScreenViewModel.onInteresseCapitalChanged(it)
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CaixaDeEntrada(
                placeHolder = "Formação Acadêmica",
                value = formacaoState.value,
                keyboardtype = KeyboardType.Text,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                icon = R.drawable.person,
                descricaoIcon = "icone pessoa",
                atualizarEstado = {
                    profileScreenViewModel.onFormacaoCapitalChanged(it)
                }
            )

        }
    }



}