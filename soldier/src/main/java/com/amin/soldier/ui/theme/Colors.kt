package com.amin.soldier.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


val Transparent = Color(0x00000000)

//LightColorPalette
val white = Color(0xFFFFFFFF)


val color_FFF1F4F8 = Color(0xFFF1F4F8)

val color_FF072140 = Color(0xFF072140)
val color_FF0A1022 = Color(0xFF0A1022)
val color_0xFF192A43 = Color(0xFF192A43)
val color_0xFF070C15 = Color(0xFF070C15)

val colorDailRed = Color(0xFFFF5A5A)
val colorDailRed0 = Color(0x00FF5A5A)
val colorDailBlue = Color(0xFF00A3FF)
val colorDailBlue0 = Color(0x004A1DFF)
val colorDailText = Color(0x80FFFFFF)
val colorDailTextBule = Color(0xFF10D2DE)
val color_0x0FFFFFFF = Color(0x0FFFFFFF)
val color_0xFF10D2DE = Color(0xFF10D2DE)
val color_0xFFD9D9D9 = Color(0xFFD9D9D9)
val color_0x99FFFFFF = Color(0x99FFFFFF)
val color_0xFF141F42 = Color(0xFF141F42)
val color_0xFF6E727A = Color(0xFF6E727A)
val color_0xFF070C1A = Color(0xFF070C1A)
val color_0xFF050915 = Color(0xFF050915)
val color_0x0DFFFFFF = Color(0x0DFFFFFF)
val color_0x3B0075FF = Color(0x3B0075FF)
val color_0x00E7ECF1 = Color(0x00E7ECF1)
val color_0x63B843FF = Color(0x63B843FF)
val color_0x00FFFFFF = Color(0x00FFFFFF)
val color_0xFFCEDCEC = Color(0xFFCEDCEC)
val color_0xFFE5EBF3 = Color(0xFFE5EBF3)
val color_0xFF979DA9 = Color(0xFF979DA9)
val color_0xFFD6DFE8 = Color(0xFFD6DFE8)
val color_0xFFFF4646 = Color(0xFFFF4646)
val color_0xFF0167FF = Color(0xFF0167FF)
val color_0xFF868B94 = Color(0xFF868B94)
val color_0x870F1C48 = Color(0x870F1C48)
val color_0xFF52688F = Color(0xFF52688F)
val color_0xff00ffcc = Color(0xff00ffcc)
val color_0xFF192548 = Color(0xFF192548)
val color_0x00192548 = Color(0x00192548)
val color_0x960167FF = Color(0x960167FF)
val color_0x00405EFF = Color(0x00405EFF)
val color_0xFFE6EBF2 = Color(0xFFE6EBF2)
val color_0xFFB2C3DE = Color(0xFFB2C3DE)
val color_0xFF1F263C = Color(0xFF1F263C)
val color_0x0F000000 = Color(0x0F000000)






@Stable
class APPColors(
    themeUi: Color,
    primaryBtnBg: Color,
    border: Color,
    bgSwitch: Color,
    btColorno: Color,
    btColoroff: Color,
    Indicatorbg: Color,
    IndicatorBig: Color,
    IndicatorBig2: Color,
    IndicatorBig3: Color,
    Indicatortv: Color,
    Indicatortv2: Color,
    Indicatortv3: Color,
    Indicatortv4: Color,
    quantitycolor: Color,
    devicebg: Color,
    devicetv: Color,
    lineChart:Color,
    lineChartbg:Color,
    lineChartbg2:Color,
    versiontv:Color,
    dialogbuttonbg:Color,
    dialogbuttonbg2:Color,
    dialogtv:Color,
    dialogedit:Color,
    bluetootv:Color,
    dialogbg2:Color
) {
    var themeUi: Color by mutableStateOf(themeUi)
        internal set
    var primaryBtnBg: Color by mutableStateOf(primaryBtnBg)
        internal set
    var border: Color by mutableStateOf(border)
        internal set
    var bgSwitch: Color by mutableStateOf(bgSwitch)
        internal set
    var btColorno: Color by mutableStateOf(btColorno)
        internal set
    var btColoroff: Color by mutableStateOf(btColoroff)
        internal set
    var Indicatorbg: Color by mutableStateOf(Indicatorbg)
        internal set
    var IndicatorBig: Color by mutableStateOf(IndicatorBig)
        internal set
    var IndicatorBig2: Color by mutableStateOf(IndicatorBig2)
        internal set
    var IndicatorBig3: Color by mutableStateOf(IndicatorBig3)
        internal set
    var Indicatortv: Color by mutableStateOf(Indicatortv)
        internal set
    var Indicatortv2: Color by mutableStateOf(Indicatortv2)
        internal set
    var Indicatortv3: Color by mutableStateOf(Indicatortv3)
        internal set
    var Indicatortv4: Color by mutableStateOf(Indicatortv4)
        internal set
    var quantitycolor: Color by mutableStateOf(quantitycolor)
        internal set
    var devicebg: Color by mutableStateOf(devicebg)
        internal set
    var devicetv: Color by mutableStateOf(devicetv)
        internal set
    var lineChart: Color by mutableStateOf(lineChart)
        internal set
    var lineChartbg: Color by mutableStateOf(lineChartbg)
        internal set
    var lineChartbg2: Color by mutableStateOf(lineChartbg2)
        internal set
    var versiontv: Color by mutableStateOf(versiontv)
        internal set
    var dialogbuttonbg: Color by mutableStateOf(dialogbuttonbg)
        internal set
    var dialogbuttonbg2: Color by mutableStateOf(dialogbuttonbg2)
        internal set
    var dialogtv: Color by mutableStateOf(dialogtv)
        internal set
    var dialogedit: Color by mutableStateOf(dialogedit)
        internal set
    var bluetootv: Color by mutableStateOf(bluetootv)
        internal set
    var dialogbg2: Color by mutableStateOf(dialogbg2)
        internal set



}



val lightColor = APPColors(
    themeUi = color_FFF1F4F8,
    primaryBtnBg = color_FF0A1022,
    border = color_0xFFCEDCEC,
    bgSwitch = color_0xFFE5EBF3,
    btColorno = color_FF0A1022,
    btColoroff = color_0xFF979DA9,
    Indicatorbg = color_0xFFD6DFE8,
    IndicatorBig = color_0x870F1C48,
    IndicatorBig2 = color_FF0A1022,
    IndicatorBig3 = color_0xFFFF4646,
    Indicatortv = color_0xFF0167FF,
    Indicatortv2 = color_0xFF868B94,
    Indicatortv3 = color_0xFFFF4646,
    Indicatortv4 = color_0xFF52688F,
    quantitycolor = color_FF0A1022,
    devicebg = white,
    devicetv = color_0x870F1C48,
    lineChart = color_0xFF0167FF,
    lineChartbg = color_0x960167FF,
    lineChartbg2=color_0x00405EFF,
    versiontv = color_0x870F1C48,
    dialogbuttonbg = white,
    dialogbuttonbg2 =color_0xFFE5EBF3,
    dialogtv = color_0xFFE5EBF3,
    dialogedit = color_0xFFE6EBF2,
    bluetootv = color_FF0A1022,
    dialogbg2 = white
)


