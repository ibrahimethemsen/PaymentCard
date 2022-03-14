package com.ibrahimethem.paymentcard

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun InputItem(
    textFieldValue : TextFieldValue,
    label : String,
    onTextChange : (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    visualTransformation : VisualTransformation = VisualTransformation.None,
    textStyle : TextStyle = MaterialTheme.typography.body1.copy(color = androidx.compose.ui.graphics.Color.Black),
    keyboardType : KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = textFieldValue,
        onValueChange = {onTextChange(it)},
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        textStyle = textStyle,
        maxLines = 1,
        singleLine = true,
        label = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.body2
                )
            }
        },
        modifier = modifier,
        visualTransformation = visualTransformation
    )
}