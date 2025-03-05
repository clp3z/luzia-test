package com.clp3z.luziatest.feature.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.toErrorMessage

@Composable
fun ErrorMessage(error: Error) {
    Text(
        text = error.toErrorMessage(),
        color = Color.Red
    )
}

@Preview
@Composable
private fun ErrorMessagePreview() {
    ErrorMessage(error = Error.Unknown("An error has occurred"))
}
