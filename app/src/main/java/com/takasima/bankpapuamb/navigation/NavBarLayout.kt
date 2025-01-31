package com.takasima.bankpapuamb.navigation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemGestures
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.takasima.bankpapuamb.R
import com.takasima.bankpapuamb.ui.theme.biru2

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onClickQRScan: () -> Unit,
//    onDoubleTap: (NavigationItem) -> Unit,
    mainNavController: NavHostController = rememberNavController(),
    onClick: (NavigationItem) -> Unit,

    ) {
    val colorStops = arrayOf(
        0.0f to Color.Transparent,
        0.3f to Color.Transparent,
        0.5f to Color(0xFF3D9EF8),
        1f to Color(0xFF0E6DC5)
    )
    val gradientBrush = Brush.verticalGradient(
        colorStops = colorStops,
    )

    NavigationBar(
//        containerColor= Color.Blue
        containerColor = Color.Transparent,
        windowInsets = WindowInsets.systemBars.exclude(WindowInsets.navigationBars),
        modifier = Modifier.background(gradientBrush)

    ) {
//        Box(modifier = Modifier.fillMaxWidth().height(24.dp).background(Color.White))
        items.forEachIndexed { index, navigationItem ->

            if (index == 2) {
                FloatingActionButton(
                    onClick = { onClickQRScan() },
                    modifier = Modifier
                        .size(72.dp)
//                        .padding(16.dp)
                        .offset(y = -16.dp),
                    shape = CircleShape,
                    containerColor = Color(0xFF025a82),
                    contentColor = Color.White
                ) {

                    Icon(
//                        painter = painterResource(id = R.drawable.qris),
                        imageVector = ImageVector.vectorResource(id = R.drawable.qris_png),
//                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            } else {
                var i = 0
                NavigationBarItem(
//                    modifier = Modifier
//                        .combinedClickable(
//                            onClick = { Log.d("onclick", "Click in combinedClickable") },
//                            onDoubleClick = {
//                                mainNavController.popBackStack()
//                                mainNavController.navigate(MainRouteScreens.Home.route)
//                            },
////                            onLongClick = {
////                                Log.d("onclick", “Long click in combinedClickable”)
////                            }
//                        )
//                        .clickable { Log.d("onclick", "Click in clickable") },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.Black,
                        unselectedTextColor = Color.Black,
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        indicatorColor = biru2
                    ),
                    selected = currentRoute == navigationItem.route,
                    onClick = {
                        i += 1
                        onClick(navigationItem)
                        if (i == 2) {
                            mainNavController.popBackStack()
                            mainNavController.navigate(MainRouteScreens.Home.route)
                            i = 0
                        }
                    },
                    icon = {
//                        BadgedBox(badge = {
//                            if (navigationItem.badgeCount != null) {
//                                Badge {
//                                    Text(text = navigationItem.badgeCount.toString())
//                                }
//                            } else if (navigationItem.hasBadgeDot) {
//                                Badge()
//                            }
//                        }) {
                        Icon(
                            /*imageVector*/painterResource(
                                id = if (currentRoute == navigationItem.route) {
                                    navigationItem.selectedIcon
                                } else {
                                    navigationItem.unSelectedIcon
                                }
                            ),
                            contentDescription = navigationItem.title,
                            modifier = Modifier.size(32.dp)
                        )
//                        }
                    },
                    label = {
                        Text(text = navigationItem.title)
                    },
                    alwaysShowLabel = false,

                    )
            }
        }
    }
} 