package com.wearerommies.roomie.presentation.ui.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.ui.filter.component.ColumnWithTitle
import com.wearerommies.roomie.presentation.ui.filter.component.FilterTextField
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RentScreen(
    monthlyRentStart: Int,
    monthlyRentEnd: Int,
    depositStart: Int,
    depositEnd: Int,
    setMonthlyRangeStart: (String) -> Unit,
    setMonthlyRangeEnd: (String) -> Unit,
    setDepositRangeStart: (String) -> Unit,
    setDepositRangeEnd: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(RoomieTheme.colors.grayScale1)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(28.dp))

        ColumnWithTitle(
            title = R.string.deposit,
            spacerValue = 8.dp,
            content = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    FilterTextField(
                        modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.436).dp),
                        paddingValues = PaddingValues(12.dp),
                        textFieldValue = depositStart.toString(),
                        onValueChange = setDepositRangeStart,
                        content = {
                            Text(
                                text = stringResource(R.string.ten_thousand_won),
                                style = RoomieTheme.typography.body3M14,
                                color = RoomieTheme.colors.grayScale10
                            )
                        }
                    )

                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .width(6.dp)
                            .background(RoomieTheme.colors.grayScale5)
                    )

                    FilterTextField(
                        modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.436).dp),
                        paddingValues = PaddingValues(12.dp),
                        textFieldValue = depositEnd.toString(),
                        onValueChange = setDepositRangeEnd,
                        content = {
                            Text(
                                text = stringResource(R.string.ten_thousand_won),
                                style = RoomieTheme.typography.body3M14,
                                color = RoomieTheme.colors.grayScale10
                            )
                        }
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        ColumnWithTitle(
            title = R.string.monthly_rent,
            spacerValue = 8.dp,
            content = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    FilterTextField(
                        modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.436).dp),
                        paddingValues = PaddingValues(12.dp),
                        textFieldValue = monthlyRentStart.toString(),
                        onValueChange = setMonthlyRangeStart,
                        content = {
                            Text(
                                text = stringResource(R.string.ten_thousand_won),
                                style = RoomieTheme.typography.body3M14,
                                color = RoomieTheme.colors.grayScale10
                            )
                        }
                    )

                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .width(6.dp)
                            .background(RoomieTheme.colors.grayScale5)
                    )

                    FilterTextField(
                        modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.436).dp),
                        paddingValues = PaddingValues(12.dp),
                        textFieldValue = monthlyRentEnd.toString(),
                        onValueChange = setMonthlyRangeEnd,
                        content = {
                            Text(
                                text = stringResource(R.string.ten_thousand_won),
                                style = RoomieTheme.typography.body3M14,
                                color = RoomieTheme.colors.grayScale10
                            )
                        }
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun RentScreenPreview() {
    RoomieAndroidTheme {
        RentScreen(
            monthlyRentStart = 0,
            monthlyRentEnd = 0,
            depositStart = 0,
            depositEnd = 0,
            setMonthlyRangeStart = {},
            setMonthlyRangeEnd = {},
            setDepositRangeStart = {},
            setDepositRangeEnd = {},
        )
    }
}
