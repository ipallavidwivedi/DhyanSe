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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xofficial.todolist.R
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut



@Composable
fun WelcomeScreen(){
    // State variable to track the current image
    val contentList  = listOf(
        CarouselContent(
            image = R.drawable.task_img,
            title = "Manage your tasks",
            description = "You can easily manage all of your daily tasks in DoMe for free"
        ),
        CarouselContent(
            image = R.drawable.routine_img,
            title = "Create daily routine",
            description = "In DhyanSe  you can create your personalized routine to stay productive"
        ),
        CarouselContent(
            image = R.drawable.organize_img,
            title = "Organize your tasks",
            description = "You can organize your daily tasks by adding your tasks into separate categories"
        ),
    )
    val currentIndex = remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize().background(color = Color(0xFF121212))){
        Column(modifier = Modifier.fillMaxSize()
            .padding(top = 50.dp, start = 24.dp, end = 24.dp, bottom = 74.dp)
        ) {
            Text(
                text = "SKIP",
                modifier = Modifier.align(Alignment.Start).alpha(0.5f),
                color = Color(0xFFffffff)
            )
            Carousel(
                contentList = contentList,
                currentIndex = currentIndex.value,
                onNextClick = {
                    if (currentIndex.value < contentList.size - 1) {
                        currentIndex.value += 1
                    }
                },
                onBackClick = {
                    if (currentIndex.value > 0) {
                        currentIndex.value -= 1
                    }
                }
            )
        }
    }
}

//Dynamic data change Card
@Composable
fun Carousel(
    contentList: List<CarouselContent>,
    currentIndex: Int,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit
){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Image
        Image(
            painter = painterResource(id = contentList[currentIndex].image),
            contentDescription = contentList[currentIndex].title,
            modifier = Modifier.size(250.dp)
        )
        //Spacer
        Spacer(modifier = Modifier.height(50.dp))
        //Slide Counter
        Row {
            contentList.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .height(4.dp)
                        .width(26.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(
                            if (index == currentIndex) Color(0xFFffffff) else Color(0xFFAFAFAF)
                        )
                        .padding(end = 8.dp)
                )
            }
        }
        //Spacer
        Spacer(modifier = Modifier.height(50.dp))
        //Title
        Text(
            text = contentList[currentIndex].title,
            color = Color(0xFFffffff).copy(0.8f),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
        )
        //Spacer
        Spacer(modifier = Modifier.height(42.dp))
        //Description
        Text(
            text = contentList[currentIndex].description,
            color = Color(0xFFffffff).copy(0.8f),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        //Spacer
        Spacer(modifier = Modifier.height(100.dp))

        //Buttons
        Crossfade(targetState = currentIndex) { targetIndex ->
            when (targetIndex) {
                0 -> { // First slide
                    OutlinedButton(
                        onClick = { onNextClick() },
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF8875FF),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Next", fontSize = 16.sp)
                    }
                }
                contentList.size - 1 -> { // Last slide
                    Row(modifier = Modifier.fillMaxWidth()) {
                        // Back Button
                        TextButton(
                            onClick = { onBackClick() },
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White.copy(alpha = 0.5f)
                            )
                        ) {
                            Text(text = "Back", fontSize = 16.sp)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        // Get Started Button
                        OutlinedButton(
                            onClick = { /* Navigate to next screen */ },
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF8875FF),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Get Started", fontSize = 16.sp)
                        }
                    }
                }
                else -> { // Middle slides
                    Row(modifier = Modifier.fillMaxWidth()) {
                        // Back Button
                        TextButton(
                            onClick = { onBackClick() },
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White.copy(alpha = 0.5f)
                            )
                        ) {
                            Text(text = "Back", fontSize = 16.sp)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        // Next Button
                        OutlinedButton(
                            onClick = { onNextClick() },
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF8875FF),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Next", fontSize = 16.sp)
                        }
                    }
                }
            }
        }
    }
}

// Data class for carousel content
data class CarouselContent(
    val image: Int,
    val title: String,
    val description: String
)
