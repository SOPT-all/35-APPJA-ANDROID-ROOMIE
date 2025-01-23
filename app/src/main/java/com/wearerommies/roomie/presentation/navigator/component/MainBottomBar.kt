package com.wearerommies.roomie.presentation.navigator.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.topBorder
import com.wearerommies.roomie.presentation.core.util.convertDpToFloat
import com.wearerommies.roomie.presentation.type.MainTabType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainBottomBar(
    isVisible: Boolean,
    tabs: ImmutableList<MainTabType>,
    currentTabSelected: MainTabType?,
    onTabSelected: (MainTabType) -> Unit,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = EnterTransition.None + fadeIn(),
        exit = ExitTransition.None + fadeOut()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = RoomieTheme.colors.grayScale1)
                .topBorder(height = convertDpToFloat(1.dp), color = RoomieTheme.colors.grayScale4),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = (LocalConfiguration.current.screenWidthDp * 0.189).dp,
                Alignment.CenterHorizontally
            ),
        ) {
            tabs.forEach { tabItem ->
                MainBottomBarItem(
                    isSelected = currentTabSelected == tabItem,
                    tabType = tabItem,
                    onTabSelected = onTabSelected,
                    tabIcon = tabItem.tabIcon,
                    tabTitle = tabItem.tabTitle,
                )
            }
        }
    }
}

@Composable
private fun MainBottomBarItem(
    isSelected: Boolean,
    tabType: MainTabType,
    onTabSelected: (MainTabType) -> Unit,
    @DrawableRes tabIcon: Int,
    @StringRes tabTitle: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(top = 12.dp, bottom = 10.dp)
            .width((LocalConfiguration.current.screenWidthDp * 0.133).dp)
            .noRippleClickable {
                onTabSelected(tabType)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = tabIcon),
            contentDescription = stringResource(id = R.string.app_name),
            tint = if (isSelected) {
                RoomieTheme.colors.primary
            } else {
                RoomieTheme.colors.grayScale10
            },
        )

        Text(
            text = stringResource(tabTitle),
            style = RoomieTheme.typography.caption2Sb10,
            color = if (isSelected) {
                RoomieTheme.colors.primary
            } else {
                RoomieTheme.colors.grayScale12
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainBottomBarPreview() {
    RoomieAndroidTheme {
        MainBottomBar(
            isVisible = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(RoomieTheme.colors.grayScale1)
                .padding(vertical = 12.dp),
            tabs = MainTabType.entries.toPersistentList(),
            currentTabSelected = MainTabType.HOME,
            onTabSelected = {},
        )
    }
}
