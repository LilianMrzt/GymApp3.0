package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AddExerciseHeader(
    navigateToCreateExercise: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = RectangleShape
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.width(48.dp))

                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Select the exercises to add",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = navigateToCreateExercise,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(0.dp)
                    )
                }

                IconButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .size(30.dp)
                        .padding(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(0.dp)
                    )
                }
            }

            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 64.dp,
                        end = 64.dp,
                        top = 16.dp,
                        bottom = 0.dp
                    )
            )
        }
    }
}