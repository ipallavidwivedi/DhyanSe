package com.xofficial.DhyanSe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AuthenticationScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color(0xFF121212))
            .padding(top = 50.dp, start = 18.dp, end = 24.dp, bottom = 74.dp)
    ) {
        //Back Icon
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(top = 50.dp, bottom = 24.dp, start = 6.dp)
                .align(Alignment.Center)
        ) {

            //Spacer
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Welcome to DhyanSe",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            //Spacer
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "Please login to your account or create new account to continue",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White.copy(alpha = 0.5f),
                textAlign = TextAlign.Center,
            )
            //Spacer
            Spacer(modifier = Modifier.weight(1f))
            //Login Button
            OutlinedButton(
                onClick = { navController.navigate("login") },
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8875FF),
                    contentColor = Color.White
                )
            ) {
                Text(text = "LOGIN", fontSize = 16.sp)
            }
            //Spacer
            Spacer(modifier = Modifier.height(28.dp))
            //Create New Account Button
            OutlinedButton(
                onClick = { navController.navigate("register") },
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White,
                ),
                border = androidx.compose.foundation.BorderStroke(2.dp, Color(0xFF8875FF))
            ) {
                Text(text = "CREATE NEW ACCOUNT", fontSize = 16.sp)
            }
        }
    }
}