package com.example.asyncapptest

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import com.example.asyncapptest.ui.theme.AsyncAppTestTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsyncAppTestTheme {
                MyButton()
            }
        }
    }
}

@Composable
fun MyButton() {

    val scope = rememberCoroutineScope()
    var susList by remember {
        mutableStateOf(listOf<String>())
    }
   // val myList = listOf("saeed", "masoud", "mina")
    Column (
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = {
            Log.d("TAG", Thread.currentThread().name)
            scope.launch(Dispatchers.Default) {
                Log.d("TAG", Thread.currentThread().name)
                val susList2= sus1().mapIndexed { i, v ->
                    "$v - ${sus2()[i]}"
                }
                susList=susList2
            }
        }) {
        }
        Text(text = susList.joinToString("\n"))
    }
    
}
suspend fun nameList(myList: List<String>) {
    Log.d("TAG", Thread.currentThread().name)
    myList.forEach {
        Log.d("TAG", it)
        delay(2000)
    }
}
suspend fun mathematic(){
    val myList2=List(1000){ Random.nextInt(10000) }
    myList2.forEach{
        if (it%2==0)
            Log.d("TAG", "${it*5000}")
    }
}