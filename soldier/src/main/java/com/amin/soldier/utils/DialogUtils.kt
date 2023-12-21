package com.amin.soldier.utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.amin.soldier.ui.theme.color_0xFF192A43

/**
 *Author: Amin
 *Data: 2023/12/21 16:06
 *
 *Description:
 *
 */

@Preview(showBackground = true)
@Composable
fun sksks(){
    DialogTwoBtn(content = "sss", lifeBtnStr = "ss", rightBtnStr = "sss", lifeBtnClick = { /*TODO*/ }) {

    }
}



@Composable
fun DialogTwoBtn(content:String,lifeBtnStr:String,rightBtnStr:String,lifeBtnClick:()->Unit,rightBtnClick:()->Unit){
    Dialog(onDismissRequest = { /*TODO*/ }) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color_0xFF192A43)
                    .padding(25.dp, 5.dp)
            ) {
                Text(text = content, color = Color.White, modifier = Modifier.padding(10.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier.fillMaxWidth(0.5f), contentAlignment = Alignment.Center) {
                        TextButton(onClick = {
                            lifeBtnClick.invoke()

                        }) {
                            Text(text = lifeBtnStr, color = Color.White)
                        }
                    }

                    Box(modifier = Modifier.fillMaxWidth(1f), contentAlignment = Alignment.Center) {
                        TextButton(onClick = {
                            rightBtnClick.invoke()

                        }) {
                            Text(text = rightBtnStr, color = Color.Red)
                        }
                    }

                }


            }



    }


}