package com.ibrahimethem.paymentcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ibrahimethem.paymentcard.ui.theme.PaymentCardTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentCardTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(
                                text = "Kart Detayları",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                        )
                    }
                ) {
                    AddPaymentCard()
                }
            }
        }
    }
}
