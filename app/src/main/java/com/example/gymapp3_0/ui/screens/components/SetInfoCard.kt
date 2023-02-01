package com.example.gymapp3_0.ui.screens.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun SetInfoCard(
    @StringRes title: Int,
    content: String
) {
    Card(
        modifier = Modifier

    ) {
        Column(
            Modifier
                .padding(16.dp)
                .wrapContentWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = title))

            Divider(
                Modifier
                    .padding(8.dp)
                    .width(32.dp)
            )

            Text(
                text = content,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier

            )
        }
    }
}