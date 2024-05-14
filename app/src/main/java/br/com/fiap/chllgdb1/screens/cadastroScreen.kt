package br.com.fiap.chllgdb1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.chllgdb1.R
import br.com.fiap.chllgdb1.components.CaixaDeEntrada
import br.com.fiap.chllgdb1.components.EntradaSenha

@Composable
fun cadastroScreen(
    cadastroScreenViewModel: cadastroScreenViewModel,
    navController: NavController
) {

    val nameState = cadastroScreenViewModel.nomeState.observeAsState(initial = "")

    val telefoneState = cadastroScreenViewModel.telefoneState.observeAsState(initial = "")

    val docState = cadastroScreenViewModel.docState.observeAsState(initial = "")

    val emailState = cadastroScreenViewModel.emailState.observeAsState(initial = "")

    val senhaState = cadastroScreenViewModel.senhaState.observeAsState(initial = "")

    var chekedState = remember {
        mutableStateOf(false)
    }

    val camposPreenchidos =
        (telefoneState.value.isNotBlank() &&
                docState.value.isNotBlank() &&
                nameState.value.isNotBlank() &&
                telefoneState.value.isNotBlank() &&
                emailState.value.isNotBlank() &&
                senhaState.value.isNotBlank() &&
                chekedState.value)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
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
                        text = "Cadastro",
                        fontSize = 23.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                }

            }
            Spacer(modifier = Modifier.padding(40.dp))
            CaixaDeEntrada(
                placeHolder = "Nome Completo",
                value = nameState.value,
                keyboardtype = KeyboardType.Text,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                icon = R.drawable.person,
                descricaoIcon = "icone pessoa",
                atualizarEstado = {
                    cadastroScreenViewModel.onNomeCapitalChanged(it)
                }
            )
            CaixaDeEntrada(
                placeHolder = "CPF",
                value = docState.value,
                keyboardtype = KeyboardType.Number,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                icon = R.drawable.doc,
                descricaoIcon = "icone documento",
                atualizarEstado = {
                    cadastroScreenViewModel.onDocCapitalChanged(it)
                }
            )
            CaixaDeEntrada(
                placeHolder = "Telefone",
                value = telefoneState.value,
                keyboardtype = KeyboardType.Number,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                icon = R.drawable.telefone,
                descricaoIcon = "icone telefone",
                atualizarEstado = {
                    cadastroScreenViewModel.onTelefoneCapitalChanged(it)
                }
            )
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
                    cadastroScreenViewModel.onEmailCapitalChanged(it)
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
                    cadastroScreenViewModel.onSenhaCapitalChanged(it)
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                Checkbox(
                    checked = chekedState.value,
                    onCheckedChange = { chekedState.value = it },
                    modifier = Modifier.padding(horizontal = 8.dp),
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = Color(0xFF17DB2E),
                        checkedColor = Color.White,
                        uncheckedColor = Color.Gray
                    )
                )
                Column {
                    val text = buildAnnotatedString {
                        append("I agree to the healtcare ")
                        withStyle(style = SpanStyle(color = Color(0xFF17DB2E))) {
                            addStringAnnotation(
                                tag = "terms",
                                annotation = "terms_of_service",
                                start = length,
                                end = length + 16
                            )
                            append("Terms of Service ")
                        }
                        append("and ")
                        withStyle(style = SpanStyle(color = Color(0xFF17DB2E))) {
                            addStringAnnotation(
                                tag = "privacy",
                                annotation = "privacy_policy",
                                start = length,
                                end = length + 21
                            )
                            append("Privacy Policy ")
                        }
                        append(".")
                    }
                    ClickableText(
                        text = text,
                        onClick = { offset ->
                            val termsAnnotations = text.getStringAnnotations(
                                tag = "terms",
                                start = offset,
                                end = offset
                            )
                            if (termsAnnotations.isNotEmpty()) {
                                val url = termsAnnotations.first().item
                                navController.navigate("")
                                return@ClickableText
                            }
                            val privacyAnnotations = text.getStringAnnotations(
                                tag = "privacy",
                                start = offset,
                                end = offset
                            )
                            if (privacyAnnotations.isNotEmpty()) {
                                val url = privacyAnnotations.first().item
                                navController.navigate("")
                                return@ClickableText
                            }

                        },
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
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
                    onClick = {
                        navController.navigate("Login")
                    },
                    enabled = camposPreenchidos,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF17DB2E),
                        disabledContainerColor = Color.Gray
                    )
                ) {
                    Text(
                        text = "Registrar",
                        color = if (camposPreenchidos) Color.White else Color.Black,
                        fontSize = 18.sp
                    )

                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Já possui cadastro ?  ",
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Text(
                    text = "Entre",
                    color = Color(0xFF17DB2E),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clickable(onClick = { navController.navigate("Login") })
                )
            }
        }
    }

}