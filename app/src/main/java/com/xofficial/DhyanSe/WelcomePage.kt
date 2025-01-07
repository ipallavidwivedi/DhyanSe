package com.xofficial.DhyanSe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xofficial.todolist.R


@Composable
fun WelcomeScreen(){
    Box(modifier = Modifier.fillMaxSize().background(color = Color(0xFF121212))){
        Column(modifier = Modifier.fillMaxSize()
            .padding(top = 50.dp, start = 24.dp, end = 24.dp, bottom = 74.dp)
        ) {
            Text(
                text = "SKIP",
                modifier = Modifier.align(Alignment.Start).alpha(0.5f),
                color = Color(0xFFffffff)
            )
            Carousel()
        }
    }
}

//Salutation Card
@Composable
fun Carousel(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        //Image or Avatar
        Image(
            painter = painterResource(id = R.drawable.task_img),
            contentDescription = "Manage your tasks",
            modifier = Modifier.size(213.dp)
        )
        //Spacer
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Manage your tasks",
            color = Color(0xFFffffff).copy(0.8f),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
        )
        //Spacer
        Spacer(modifier = Modifier.height(42.dp))

        Text(
            text = "You can easily manage all of your daily tasks in DoMe for free",
            color = Color(0xFFffffff).copy(0.8f),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        //Spacer
        Spacer(modifier = Modifier.height(100.dp))

        //Buttons
        Button(
            onClick = /*TODO*/{},
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth().height(50.dp)
                .background(color = Color(0xFF8875FF)),
        ) {
            Text(
                text = "Next",
                color = Color(0xFFffffff),
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth()
                    .background(color = Color(0xFF8875FF))
            )
        }
    }
}
