package com.winspread.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.winspread.compose.bean.ThemeBean
import com.winspread.compose.config.CHANGED_THEME
import com.winspread.compose.ui.theme.ComposeTestTheme
import com.winspread.compose.bean.ThemeType
import com.winspread.compose.utlis.DataStoreUtils
import com.winspread.compose.utlis.loge

class MainActivity : ComponentActivity() {


    private val themeTypeState: MutableState<Int> by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        DataStoreUtils.init(this@MainActivity)
        mutableStateOf(getDefaultThemeId())
    }

    private fun getDefaultThemeId(): Int = DataStoreUtils.getSyncData(CHANGED_THEME, ThemeType.SKY_BLUE_THEME.type)


    // 主题列表
    private val themeList = mutableListOf(
        ThemeBean(ThemeType.SKY_BLUE_THEME),
        ThemeBean(ThemeType.GRAY_THEME),
        ThemeBean(ThemeType.DEEP_BLUE_THEME),
        ThemeBean(ThemeType.GREEN_THEME),
        ThemeBean(ThemeType.PURPLE_THEME),
        ThemeBean(ThemeType.ORANGE_THEME),
        ThemeBean(ThemeType.BROWN_THEME),
        ThemeBean(ThemeType.RED_THEME),
        ThemeBean(ThemeType.CYAN_THEME),
        ThemeBean(ThemeType.MAGENTA_THEME)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme(themeTypeState.value) {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {


                    "${MaterialTheme.colorScheme.primary}".loge()
                    Greeting(themeList, themeTypeState)
                }
            }
        }
    }
}

@Composable
fun Greeting(themeList: MutableList<ThemeBean>, themeTypeState: MutableState<Int>) {

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .padding(20.dp)
                .background(Color.LightGray)
                .padding(top = 20.dp, bottom = 20.dp)


        ) {
            items(themeList) { item: ThemeBean ->
                ThemeItem(themeTypeState.value, item) {
                    val playTheme = item.themeType.type
                    themeTypeState.value = playTheme
                    DataStoreUtils.putSyncData(CHANGED_THEME, playTheme)
                }
            }
        }
    }
}

@Composable
fun ThemeItem(playTheme: Int, item: ThemeBean, content: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                content.invoke()
            }, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(item.themeType.color)
                .size(50.dp)
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            if (playTheme == item.themeType.type) {
                Image(
                    painter = painterResource(id = R.mipmap.duihao),
                    contentDescription = "",
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = item.themeType.title,
            Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(item.themeType.color)
                .padding(4.dp)
        )
    }
}




