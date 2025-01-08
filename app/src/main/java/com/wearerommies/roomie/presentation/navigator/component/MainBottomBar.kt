package com.wearerommies.roomie.presentation.navigator.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.type.MainTabType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import kotlinx.collections.immutable.toImmutableList

@Composable
fun BottomNavigationBar(
    isVisible: Boolean,
    bottomNaviBarItems: List<MainTabType>,
    currentNavItemSelected: MainTabType?,
    onBottomNaviBarItemSelected: (MainTabType) -> Unit,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(visible = isVisible) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            bottomNaviBarItems.forEach { navItem ->
                BottomNavigationItem(
                    isSelected = currentNavItemSelected == navItem,
                    bottomNaviType = navItem,
                    onBottomNaviBarItemSelected = onBottomNaviBarItemSelected,
                    bottomNaviIcon = navItem.navIcon,
                    bottomNaviTitle = navItem.navTitle,
                )
            }
        }
    }
}

@Composable
private fun BottomNavigationItem(
    isSelected: Boolean,
    bottomNaviType: MainTabType,
    onBottomNaviBarItemSelected: (MainTabType) -> Unit,
    @DrawableRes bottomNaviIcon: Int,
    bottomNaviTitle: String,
    modifier: Modifier = Modifier,
    spacing: Dp = 4.dp,
) {
    Column(
        modifier =
        modifier.noRippleClickable {
            onBottomNaviBarItemSelected(bottomNaviType)
        },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = bottomNaviIcon),
            contentDescription = stringResource(id = R.string.app_name),
            tint =
            if (isSelected) {
                Color(0xFF626CF6)
            } else {
                Color(0xFF4D4D4D)
            },
        )

        Spacer(modifier = Modifier.height(spacing))

        Text(
            text = bottomNaviTitle,
            color =
            if (isSelected) {
                Color(0xFF626CF6)
            } else {
                Color(0xFF4D4D4D)
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    RoomieAndroidTheme {
        BottomNavigationBar(
            isVisible = true,
            modifier = Modifier
                .background(Color.White)
                .padding(vertical = 12.dp),
            bottomNaviBarItems = MainTabType.entries.toImmutableList(),
            currentNavItemSelected = MainTabType.HOME,
            onBottomNaviBarItemSelected = {},
        )
    }
}