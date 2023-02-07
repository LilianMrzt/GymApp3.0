package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.core.Constants.Companion.ROUNDED_CORNER
import com.example.gymapp3_0.domain.models.SessionModel
import com.example.gymapp3_0.domain.models.toColor
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionCard(
    session: SessionModel,
    deleteSession: () -> Unit,
    navigateToViewSession: (sessionID: Int) -> Unit,
    sessionViewModel: SessionViewModel = hiltViewModel(),
) {
    ElevatedCard(
        shape = RoundedCornerShape(ROUNDED_CORNER),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 5.dp),
        onClick = { navigateToViewSession(session.id) },
    ) {
        Row(
            //horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {

            Card(
                modifier = Modifier
                    .padding(
                        start = 0.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                    .size(32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = session.sessionColor.toColor()
                ),
                shape = CircleShape
            ) {

            }

            Text(
                text = session.name,
                fontSize = 42.sp,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.weight(1f))

            DeleteSessionAlertDialog(
                deleteSession = deleteSession
            )
        }
    }
}

