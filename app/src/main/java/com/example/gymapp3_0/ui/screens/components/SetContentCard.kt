package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.ui.viewModels.SetsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetContentCard(
    set: SetModel,
    setsViewModel: SetsViewModel = hiltViewModel(),
    updateWeight: (weight: String) -> Unit,
    updateReps: (reps: String) -> Unit,
    updateRestTime: (rest: String) -> Unit,
    updateSet: (set: SetModel) -> Unit,
) {
    ElevatedCard(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .size(30.dp),
                shape = CircleShape,
            ) {
                Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                    Text(
                        text = "${set.id + 1}",
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                end = 10.dp,
                                bottom = 5.dp,
                                top = 5.dp
                            )
                    )
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                //Weight
                Card(
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.wrapContentHeight()
                    ) {
                        Card {
                            Text(text = "Poids", modifier = Modifier.padding(5.dp))
                        }

                        Row {
                            Card(
                                shape = RoundedCornerShape(15.dp),
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    TextField(
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        value = set.weight,
                                        onValueChange = { weight ->
                                            updateWeight(weight)
                                        },
                                        modifier = Modifier.width(70.dp),
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            textColor = MaterialTheme.colorScheme.onTertiary,

                                            focusedIndicatorColor = Color.Transparent,
                                            disabledIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            containerColor = Color.Transparent,
                                        ),
                                        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                                    )

                                    Text(
                                        text = "Kg",
                                        modifier = Modifier.padding(10.dp),
                                        color = MaterialTheme.colorScheme.onTertiary
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(
                    Modifier
                        .weight(1f)
                )

                //Reps
                Card(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.wrapContentHeight()
                    ) {
                        Card {
                            Text(text = "reps", modifier = Modifier.padding(5.dp))
                        }
                        Row {
                            Card(
                                shape = RoundedCornerShape(15.dp),
                            ) {
                                TextField(
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    value = set.reps,
                                    onValueChange = { reps ->
                                        updateReps(reps)
                                    },
                                    modifier = Modifier.width(70.dp),
                                    singleLine = true,
                                    colors = TextFieldDefaults.textFieldColors(
                                        textColor = MaterialTheme.colorScheme.onTertiary,

                                        focusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        containerColor = Color.Transparent,
                                    ),
                                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                                )
                            }
                        }
                    }
                }


                Spacer(
                    Modifier
                        .weight(1f)
                )

                Card(
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.wrapContentHeight()
                    ) {
                        Card {
                            Text(text = "Repos", modifier = Modifier.padding(5.dp))
                        }

                        Row {
                            Card(
                                shape = RoundedCornerShape(15.dp),
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    TextField(
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        value = set.restTime,
                                        onValueChange = { restTime ->
                                            updateRestTime(restTime)
                                        },
                                        modifier = Modifier.width(70.dp),
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            textColor = MaterialTheme.colorScheme.onTertiary,

                                            focusedIndicatorColor = Color.Transparent,
                                            disabledIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            containerColor = Color.Transparent,
                                        ),
                                        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                                    )
                                    Text(
                                        text = "min",
                                        modifier = Modifier.padding(10.dp),
                                    )
                                }
                            }
                        }
                    }
                }
            }

            IconButton(
                onClick = {
                    updateSet(set)
                },
                modifier = Modifier
                    .size(30.dp)
                    .padding(0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "",
                )
            }

        }
    }
}


