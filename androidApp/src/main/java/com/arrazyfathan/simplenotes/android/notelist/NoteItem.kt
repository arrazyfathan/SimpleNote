package com.arrazyfathan.simplenotes.android.notelist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arrazyfathan.simplenotes.domain.note.Note
import com.arrazyfathan.simplenotes.domain.time.DateTimeUtil

/**
 * Created by Ar Razy Fathan Rabbani on 05/10/22.
 */

@Composable
fun NoteItem(
    note: Note,
    backgroundColor: Color,
    onNoteClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val formattedDate = remember(note.createdAt) {
        DateTimeUtil.formatNoteDate(note.createdAt)
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(backgroundColor)
            .clickable { onNoteClick() }
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = note.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Delete Note",
                modifier = Modifier
                    .clickable { onDeleteClick() }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = note.content,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = formattedDate,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.End)
        )
    }
}
