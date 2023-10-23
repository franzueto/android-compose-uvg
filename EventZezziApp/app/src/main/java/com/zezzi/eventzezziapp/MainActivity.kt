package com.zezzi.eventzezziapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zezzi.eventzezziapp.navigation.Navigation
import com.zezzi.eventzezziapp.ui.theme.EventZezziAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventZezziAppTheme {
                Navigation()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MealsAppPreview() {
    EventZezziAppTheme {
        Navigation()
    }
}
