package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymapp3_0.core.Constants.Companion.ROUNDED_CORNER

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExerciseCard(
    navigateToAddExercises: () -> Unit,
    label: Int
) {
    ElevatedCard(
        shape = RoundedCornerShape(ROUNDED_CORNER),
        modifier = Modifier
            .width(intrinsicSize = IntrinsicSize.Max)
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 10.dp,
                bottom = 10.dp
            ),
        onClick = navigateToAddExercises

    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Card(
                shape = CircleShape,
                modifier = Modifier
                    .size(30.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add",
                    )
                }
            }

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                stringResource(label),
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}