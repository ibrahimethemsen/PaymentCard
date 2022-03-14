package com.ibrahimethem.paymentcard

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun AddPaymentCard() {
    var nameText by remember{ mutableStateOf(TextFieldValue())}
    var cardNumber by remember{ mutableStateOf(TextFieldValue())}
    var expiryNumber by remember{ mutableStateOf(TextFieldValue())}
    var cvcNumber by remember{ mutableStateOf(TextFieldValue())}

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PaymentCard(
            nameText = nameText,
            cardNumber =cardNumber,
            expiryNumber = expiryNumber,
            cvcNumber = cvcNumber
        )

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            item { 
                InputItem(
                    textFieldValue = nameText,
                    label = stringResource(id = R.string.card_holder_name),
                    onTextChange = {nameText = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
                InputItem(
                    textFieldValue = cardNumber,
                    label = stringResource(id = R.string.card_holder_number),
                    onTextChange = {cardNumber = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    keyboardType = KeyboardType.Number,
                    visualTransformation = CreditCardFilter
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InputItem(
                        textFieldValue = expiryNumber,
                        label = stringResource(id = R.string.expiry_date),
                        onTextChange = {expiryNumber = it},
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        keyboardType = KeyboardType.Number
                    )

                    InputItem(
                        textFieldValue = cvcNumber,
                        label = stringResource(id = R.string.cvc),
                        onTextChange = {cvcNumber = it},
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),
                        keyboardType = KeyboardType.Number
                    )
                }
            }

            item {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.save),
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .padding(horizontal = 30.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}