package github.nisrulz.example.git_versioning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import github.nisrulz.example.git_versioning.ui.theme.GitVersioningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitVersioningTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ContentBody()
                }
            }
        }
    }
}

@Composable
fun ContentBody() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Version Code ${BuildConfig.VERSION_CODE}")
        Text(text = "Version Name ${BuildConfig.VERSION_NAME}")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GitVersioningTheme {
        ContentBody()
    }
}