package com.example.gymapp3_0.ui.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymapp3_0.core.Constants.Companion.ROUNDED_CORNER
import com.example.gymapp3_0.domain.models.SetModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun UpdateSetContent(
    padding: PaddingValues,
    set: SetModel,
    updateWeight: (weight: String) -> Unit,
    updateReps: (reps: String) -> Unit,
    updateRestTime: (rest: String) -> Unit,
    updateSet: (set: SetModel) -> Unit,
    navigateBack: () -> Unit,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .padding(padding)
    ) {
        stickyHeader {
            UpdateSetHeader()
        }

        stickyHeader {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Update Weight", textAlign = TextAlign.Center)

                TextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    value = set.weight,
                    onValueChange = { weight ->
                        updateWeight(weight)
                    },
                    placeholder = {
                        Text(
                            text = "Weight"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 0.dp,
                            end = 0.dp,
                            top = 5.dp,
                            bottom = 16.dp
                        ),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                    shape = RoundedCornerShape(ROUNDED_CORNER)
                )
            }
        }

        stickyHeader {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Update Repetitions", textAlign = TextAlign.Center)

                TextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    value = set.reps,
                    onValueChange = { reps ->
                        updateReps(reps)
                    },
                    placeholder = {
                        Text(
                            text = "Reps"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 0.dp,
                            end = 0.dp,
                            top = 5.dp,
                            bottom = 16.dp
                        ),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                    shape = RoundedCornerShape(ROUNDED_CORNER)
                )
            }

        }

        stickyHeader {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Update Rest Time", textAlign = TextAlign.Center)

                TextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    value = set.restTime,
                    onValueChange = { restTime ->
                        updateRestTime(restTime)
                    },
                    placeholder = {
                        Text(
                            text = "Rest"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 0.dp,
                            end = 0.dp,
                            top = 5.dp,
                            bottom = 16.dp
                        ),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                    shape = RoundedCornerShape(ROUNDED_CORNER)
                )
            }

        }

    }
}