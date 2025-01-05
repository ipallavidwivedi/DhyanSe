package com.xofficial.todolist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(){
    Column(modifier = Modifier.fillMaxSize()
        .padding(horizontal = 30.dp, vertical = 20.dp)
        .background(color = Color.White)
    ) {
        UsernameCard(username = "Pallavi", taskCount = 3)

        LazyColumn {
            //First card
            item {
                TaskCard(taskName = "Today")
            }

            //List of scrollable cards
            items(10){
                TaskCard(taskName = "Tomorrow")
            }

            //Last Card
            item{
                TaskCard(taskName = "Tomorrow")
            }
        }
    }
}

//Salutation Card
@Composable
fun UsernameCard(username: String, taskCount: Int = 0){
    Row(modifier = Modifier.fillMaxWidth()) {
        //Salutation
        Column {
            Text(
                text = "Hello $username",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 30.sp
            )
            Text(
                text = "Today you have $taskCount tasks",
                color = Color.Black,
                fontSize = 14.sp
            )
        }

        //Spacer
        Spacer(modifier = Modifier.weight(1f))

        //Image or Avatar
        Image(
            painter = painterResource(id = R.drawable.women_avatar),
            contentDescription = "Women Avatar",
            modifier = Modifier.size(70.dp)
        )

    }
}

//Card
@Composable
fun TaskCard(taskName: String){
    Card(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
        .padding(15.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.sun),
                contentDescription = "Todays Event",
                modifier = Modifier.size(40.dp)
            )

            Column {
                Text(
                    text = taskName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )
                Text(
                    text = "4 tasks",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.DarkGray
                )
            }

            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}