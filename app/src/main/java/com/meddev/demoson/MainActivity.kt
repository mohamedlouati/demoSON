package com.meddev.demoson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.meddev.demoson.ui.theme.DemoSONTheme
import com.meddev.demoson.ui.theme.greenColor
import android.media.AudioManager
import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.meddev.demoson.ui.theme.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoSONTheme {
                // on below line
                // we are specifying background color
                // for our application
                Surface(
                    // on below line we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {

                    // on below line we are specifying
                    // theme as scaffold.
                    Scaffold(

                        // in scaffold
                        // we are specifying top bar.
                        topBar = {

                            // inside top bar
                            // we are specifying background color.
                            TopAppBar(backgroundColor = greenColor,

                                // along with that we are specifying
                                // title for our top bar.
                                title = {

                                    // in the top bar we are specifying
                                    // tile as a text
                                    Text(

                                        // on below line we are specifying text
                                        // to display in top app bar.
                                        text = "Custom Toast in Android",

                                        // on below line we are specifying
                                        // modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying
                                        // text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {
                        // on below line we are calling custom toast ui method
                        // to display ui for our custom toast
                        customToastUI()
                    }
                }
            }
        }
    }
}

// on below line we are creating a composable function
// to display ui for custom toast
@Composable
fun customToastUI() {
    // on below line we are creating a variable for context
    val ctx = LocalContext.current
    val mediaPlayer = MediaPlayer()

    // on below line we are creating a column for our ui.
    Column(
        // in this column we are adding a modifier
        // for our column and specifying max width, height and size.
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()

            // on below line we are adding padding
            // from all sides to our column.
            .padding(6.dp),

        // on below line we are adding vertical arrangement
        // for our column as bottom
        verticalArrangement = Arrangement.Center,

        // on below line we are adding horizontal alignment
        // for our column.
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line we are
        // displaying a simple text
        Text(

            // on below line we are specifying
            // modifier as padding for our text.
            modifier = Modifier.padding(6.dp),

            // on below line we are specifying
            // text as normal image.
            text = "Play Audio from URL",

            // on below line we are specifying
            // font weight as bold.
            fontWeight = FontWeight.Bold,

            // on below line we are
            // setting color for our text
            color =greenColor,

            // on below line we are
            // setting font size.
            fontSize = 20.sp
        )

        // on below line we are creating a simple spacer
        // with height 20
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a
        // button for displaying error toast
        Button(
            // on below line we are adding
            // width for our button and padding to it.
            modifier = Modifier
                .width(300.dp)
                .padding(7.dp),

            // in this button we are
            // adding on click for it on below line.
            onClick = {

                // on below line we are creating a variable for our audio url
                var audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

                // on below line we are setting audio stream type as
                // stream music on below line.
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

                // on below line we are running a try and catch block
                // for our media player.
                try {
                    // on below line we are setting audio source
                    // as audio url on below line.
                    mediaPlayer.setDataSource(audioUrl)

                    // on below line we are preparing
                    // our media player.
                    mediaPlayer.prepare()

                    // on below line we are starting
                    // our media player.
                    mediaPlayer.start()

                } catch (e: Exception) {

                    // on below line we are
                    // handling our exception.
                    e.printStackTrace()
                }

                // on below line we are displaying a toast message as audio player.
                Toast.makeText(ctx, "Audio started playing..", Toast.LENGTH_SHORT).show()

            }) {
            // on below line we are specifying
            // text for button.
            Text(text = "Play Audio")
        }

        // on below line we are creating a spacer of height 20
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are
        // creating a button for displaying a toast
        Button(
            // on below line we are
            // adding width for our button and padding to it.
            modifier = Modifier
                .width(300.dp)
                .padding(7.dp),

            // in this button we are adding
            // on click for it on below line.
            onClick = {
                // on below line we are checking
                // if media player is playing.
                if (mediaPlayer.isPlaying) {
                    // if media player is playing
                    // we are stopping it on below line.
                    mediaPlayer.stop()

                    // on below line we are reseting
                    // our media player.
                    mediaPlayer.reset()

                    // on below line we are calling release
                    // to release our media player.
                    mediaPlayer.release()

                    // on below line we are displaying a toast message to pause audio
                    Toast.makeText(ctx, "Audio has been  paused..", Toast.LENGTH_SHORT).show()
                } else {
                    // if audio player is not displaying we are displaying
                    // below toast message
                    Toast.makeText(ctx, "Audio not played..", Toast.LENGTH_SHORT).show()
                }


            }) {
            // on below line we are specifying text for button.
            Text(text = "Pause Audio")
        }


    }
}