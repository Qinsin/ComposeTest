package com.winspread.managespace

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.winspread.managespace.ui.PirChart
import com.winspread.managespace.ui.theme.ComposeTestTheme

val TAG: String = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ManageSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun ManageSpaceScreen() {


    var scaffoldState = remember { SnackbarHostState() }
    val viewModel = viewModel<ManageSpaceViewModel>()
    Log.e(TAG, "ManageSpaceScreen: 1")
    SideEffect {
        Log.e(TAG, "ManageSpaceScreen: SideEffect")
        viewModel.sendAction(ManageSpaceAction.LoadSpaceData)
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(viewModel.effect) {
        Log.e(TAG, "ManageSpaceScreen: LaunchedEffect")
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.effect.collect {
                if (it is ManageSpaceEffet.ShowToast) {
                    scaffoldState.showSnackbar(it.message)
                }
            }
        }
    }

    Log.e(TAG, "ManageSpaceScreen: 2")
    Scaffold(modifier = Modifier.fillMaxSize(), snackbarHost = { SnackbarHost(scaffoldState) }, floatingActionButton = {
        if (viewModel.state.value is ManageSpaceState.StorageSpace) {
            FloatingActionButton(onClick = {
                scaffoldState.currentSnackbarData?.dismiss()
                viewModel.sendAction(ManageSpaceAction.ClearCache)
            }) {
                Icon(Icons.Outlined.Delete, "Clear Cache")

            }
        }
    }) {

        /**
         *    remember 只执行一次 刷新不在调用
         *    SideEffect 在每次onCommit后执行， 且调用一次执行一次
         *
         */

        remember {
            Log.e(TAG, "ManageSpaceScreen: SideEffect122222")
        }
        SideEffect {
            Log.e(TAG, "ManageSpaceScreen: SideEffect121111")
        }

        Log.e(TAG, "ManageSpaceScreen: 3")
        when (val spaceState = viewModel.state.value) {
            ManageSpaceState.Loading -> CircularProgressIndicator()
            is ManageSpaceState.StorageSpace -> Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                val point = listOf(
                    spaceState.apkBytes.toFloat(), spaceState.dataBytes.toFloat(), spaceState.cacheBytes.toFloat()
                )

                val labels = listOf(
                    "应用大小：${spaceState.apkBytes}", "用户数据大小：${spaceState.dataBytes}", "缓存大小：${spaceState.cacheBytes}"
                )

                val color = listOf(
                    Color.Magenta, Color.Green, Color.Gray
                )
                PirChart(color, point, labels)

            }
        }
    }


}