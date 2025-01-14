package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieSnackbar(
    message: String,
    modifier: Modifier = Modifier
) {
   Text(
       text = message,
       textAlign = TextAlign.Center,
       modifier = modifier
           .fillMaxWidth()
           .background(
               color = RoomieTheme.colors.transparentGray1180,
               shape = RoundedCornerShape(size = 8.dp)
           )
           .padding(vertical = 14.dp),
       style = RoomieTheme.typography.body2Sb14,
       color = RoomieTheme.colors.grayScale1
   )
}

@Preview(showBackground = true)
@Composable
fun RoomieSnackbarPreivew() {
    RoomieAndroidTheme {
        RoomieSnackbar(
            message = "찜 목록에서 삭제되었어요",
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}