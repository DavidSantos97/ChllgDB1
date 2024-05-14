package br.com.fiap.chllgdb1.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chllgdb1.R

@Composable
fun EntradaSenha(
    placeHolder:String,
    value: String,
    modifier: Modifier,
    keyboardtype: KeyboardType,
    icon: Int,
    descricaoIcon: String,
    atualizarEstadoSenha: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val keyboardController = LocalSoftwareKeyboardController.current
        val senhaVisibility = remember { mutableStateOf(false) }
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = atualizarEstadoSenha,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = icon ),
                    contentDescription = descricaoIcon,
                    tint = Color.Gray,
                    modifier = Modifier.size(25.dp)
                )
            },
            placeholder = {
                Text(
                    text = placeHolder,
                    color = Color.Gray
                )
            },
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF17DB2E),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(size = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = keyboardtype
            ),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            ),
            maxLines = 1,
            trailingIcon = {
                IconButton(onClick = { senhaVisibility.value = !senhaVisibility.value })
                {
                    val icon = if (senhaVisibility.value) {
                        painterResource(id = R.drawable.olho_abre)
                    } else {
                        painterResource(id = R.drawable.olho_fecha)
                    }
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = icon,
                        tint = Color.Gray,
                        contentDescription = if (senhaVisibility.value) "Esconder Senha" else "Visualizar Senha"
                    )
                }
            },
            visualTransformation = if (senhaVisibility.value) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = true
        )
    }

}