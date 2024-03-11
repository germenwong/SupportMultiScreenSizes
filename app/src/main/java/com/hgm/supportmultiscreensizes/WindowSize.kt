package com.hgm.supportmultiscreensizes

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

/**
 * 屏幕的尺寸信息
 **/
data class WindowSize(
      val width: WindowType,
      val height: WindowType
)

/**
 * 屏幕的类型
 **/
enum class WindowType {
      // 紧凑、中等、折叠
      Compact, Medium, Expanded
}

@Composable
fun rememberWindowSize(): WindowSize {
      // 获取本地的配置信息，里面包含关于屏幕的数据
      val configuration = LocalConfiguration.current

      // 通过判断屏幕的大小划分类型，继而使用不同的布局方式
      return WindowSize(
            width = when {
                  configuration.screenWidthDp < 600 -> WindowType.Compact
                  configuration.screenWidthDp < 840 -> WindowType.Medium
                  else -> WindowType.Expanded
            },
            height = when {
                  configuration.screenHeightDp < 600 -> WindowType.Compact
                  configuration.screenHeightDp < 840 -> WindowType.Medium
                  else -> WindowType.Expanded
            }
      )
}