package com.example.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profil(windowClass: WindowSizeClass, onClick : () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (windowClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Portrait()
                    Spacer(modifier = Modifier.height(20.dp))
                    Presentation()
                    Spacer(modifier = Modifier.height(40.dp))
                    Resaux()
                    Spacer(modifier = Modifier.height(90.dp))
                    Button(onClick = onClick) {
                        Text("Démarrer")
                    }
                }
            }

            else -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Portrait()
                        Column() {
                            Presentation()
                            Spacer(modifier = Modifier.height(30.dp))
                            Resaux()
                        }
                    }
                    Button(onClick = onClick) {
                        Text("Démarrer")
                    }
                }
            }
        }
    }
}
@Composable
fun Resau(icon : ImageVector, lien : String){
    Row(horizontalArrangement = Arrangement.Start){
        Icon(icon,
            contentDescription = "logo $icon",
            modifier = Modifier
                .size(25.dp)
        )
        Spacer(modifier = Modifier.width((5.dp)))
        Text(
            text=lien
        )
    }
}

@Composable
fun Resaux(){
    Column() {
        Resau(Icons.Rounded.Email, "fabian.larwa@etu.iut-tlse3.fr" )
        Resau(Icons.Rounded.Phone, "06.85.20.57.93")
        Resau(Icons.Rounded.PlayArrow, "www.youtube.com/@Joyca")
    }
}

@Composable
fun Portrait(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            painterResource(id = R.drawable.hector),
            contentDescription = "GreatingImage",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .border(
                    BorderStroke(
                        6.dp, Brush.sweepGradient(
                            listOf(
                                Color(0xFF9575CD),
                                Color(0xFFBA68C8),
                                Color(0xFFE57373),
                                Color(0xFFFFB74D),
                                Color(0xFFFFF176),
                                Color(0xFFAED581),
                                Color(0xFF4DD0E1),
                                Color(0xFF9575CD)
                            )
                        )
                    ),
                    CircleShape
                )
                .padding(6.dp)
                .clip(CircleShape)
                .fillMaxSize()
        )
        Text(
            text="Larwa Fabian",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }

}

@Composable
fun Presentation(){
    Text(
        text="Etudiant en 3ème Année de MMI"
    )
    Text(
        text="IUT Toulouse 3 - Paul Sabatier",
        fontStyle = FontStyle.Italic
    )}