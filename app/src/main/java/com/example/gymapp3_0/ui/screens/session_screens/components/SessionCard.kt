package com.example.gymapp3_0.ui.screens.session_screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.domain.models.SessionModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionCard(
    session: SessionModel,
    deleteSession: () -> Unit,
    navigateToViewSession: (sessionID: Int) -> Unit
) {

    ElevatedCard(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 5.dp),
        onClick = { navigateToViewSession(session.id) },
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)
                .fillMaxWidth(),
        ) {

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black
                ),
                shape = CircleShape,
                modifier = Modifier
                    .size(30.dp)
                    .clickable { },
            ) {
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {

                TextName(
                    sessionName = session.name,
                )

                Spacer(
                    Modifier
                        .height(5.dp)
                )

                TextDescription(
                    sessionDescription = session.description
                )


            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            DeleteIcon(
                deleteSession = deleteSession
            )

        }
    }
}

/*
@Composable
@ExperimentalMaterial3Api
fun SessionCard(
    session: SessionModel,
    deleteSession: () -> Unit,
    navigateToViewSession: (sessionID: Int) -> Unit
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth()
            .clickable { navigateToViewSession(session.id) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                TextName(
                    sessionName = session.name
                )
                TextDescription(
                    sessionDescription = session.description
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIcon(
                deleteSession = deleteSession
            )
        }
    }
}*/

