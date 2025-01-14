@Composable
fun DetailMoodTagChips(
    roomMoodTag: PersistentList<String>,
    modifier: Modifier = Modifier
) {
    LazyRow (
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(roomMoodTag) { index, item ->
            val isMainMoodTag = index == 0
            RoomieTextChip(
                text = item,
                textColor = if(isMainMoodTag) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale9,
                backgroundColor = if(isMainMoodTag) RoomieTheme.colors.primaryLight4 else RoomieTheme.colors.grayScale3
            )
        }
    }
}
