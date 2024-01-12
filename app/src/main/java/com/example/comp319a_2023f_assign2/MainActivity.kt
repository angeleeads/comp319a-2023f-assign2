package com.example.comp319a_2023f_assign2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30daysofinspiration.ui.theme._30DaysOfInspirationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysOfInspirationTheme {
                MainScreen(wellnessTips)
            }
        }
    }
}

// Define your color scheme for light and dark themes
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006C4C),
    onPrimary = Color.White,
    // Define other colors for your theme
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4CAF50),
    onPrimary = Color.Black,
    // Define other colors for your theme
)

// Define typography
private val AppTypography = Typography(
    headlineLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 36.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    // Define other text styles for your theme
)

// Define shapes
private val AppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp)
)

// Apply theming using the MaterialTheme composable
@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = AppShapes
    ) {
        content()
    }
}

// Main Screen with theme applied
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(wellnessTips: List<WellnessTip>) {
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("30 Days of Wellness") })
            }
        ) {
            WellnessTipList(tips = wellnessTips)
        }
    }
}

// Data class for wellness tips
data class WellnessTip(
    val id: Int,
    val title: String,
    val description: String,
    val imageResId: Int
)

// Sample wellness tips
val wellnessTips = listOf(
    WellnessTip(1, "Drink Water", "Start your day with a glass of water.", R.drawable.water),
    WellnessTip(2, "Eat Vegetables", "Include a variety of colorful vegetables.", R.drawable.vegetables),
    WellnessTip(3, "High-Fiber Foods", "Add whole grains, fruits, and legumes.", R.drawable.fiberfoods),
    WellnessTip(4, "Daily Physical Activity", "Take a brisk 10-minute walk, whether it's around your neighborhood or during a break at work.", R.drawable.physical_activity),
    WellnessTip(5, "Limit Screen Time Before Bed", "Turn off all screens at least an hour before bedtime to improve sleep quality.", R.drawable.screen_time),
    WellnessTip(6, "Practice Self-Care", "Dedicate a few minutes to an activity you enjoy, like reading or meditating.", R.drawable.self_care),
    WellnessTip(7, "Prioritize Sleep", "Aim for 7-9 hours of sleep each night for optimal health.", R.drawable.sleep),
    WellnessTip(8, "Try a New Healthy Recipe", "Cook a meal using whole, unprocessed ingredients.", R.drawable.healthy_recipe),
    WellnessTip(9, "Engage in Mindfulness", "Spend 5 minutes practicing mindfulness or deep breathing exercises.", R.drawable.mindfulness),
    WellnessTip(10, "Take a Nature Walk", "Spend time outdoors, in a park or nature reserve, to reduce stress.", R.drawable.nature_walk),
    WellnessTip(11, "Add Steps to Your Day", "Park farther away or take the stairs to increase daily step count.", R.drawable.add_steps),
    WellnessTip(12, "Read a Book", "Dedicate 30 minutes to reading to relax and boost brain health.", R.drawable.read_book),
    WellnessTip(13, "Meditate", "Start with a 5-minute meditation to calm the mind and improve focus.", R.drawable.meditate),
    WellnessTip(14, "Eat Plant-Based Snacks", "Swap out processed snacks for fruits, nuts, or vegetables.", R.drawable.plant_based_snacks),
    WellnessTip(15, "Reduce Alcohol Intake", "Try to have alcohol-free days or opt for non-alcoholic beverages.", R.drawable.reduce_alcohol),
    WellnessTip(16, "Quit Smoking", "Seek support to stop smoking for better health and longevity.", R.drawable.quit_smoking),
    WellnessTip(17, "Connect with Loved Ones", "Spend quality time with friends or family to boost your mood.", R.drawable.connect_loved_ones),
    WellnessTip(18, "Digital Detox", "Take a break from electronics for a set period each day.", R.drawable.digital_detox),
    WellnessTip(19, "Start a New Hobby", "Engage in an activity you've wanted to try, like painting or playing an instrument.", R.drawable.new_hobby),
    WellnessTip(20, "Focus on Posture", "Be mindful of sitting up straight to prevent back pain and improve alignment.", R.drawable.focus_on_posture),
    WellnessTip(21, "Balance Exercises", "Practice standing on one leg to improve stability and core strength.", R.drawable.balance_exercises),
    WellnessTip(22, "Weekly Weigh-In", "Keep track of your weight to maintain a healthy lifestyle.", R.drawable.weekly_weigh_in),
    WellnessTip(23, "Healthy Breakfast", "Begin your day with a nutritious, high-fiber breakfast.", R.drawable.healthy_breakfast),
    WellnessTip(24, "Creative Food Substitutions", "Use healthier alternatives in your cooking, like whole grains and healthy oils.", R.drawable.food_substitutions),
    WellnessTip(25, "Drink an Extra Glass of Water", "Increase your daily water intake for better hydration.", R.drawable.extra_water),
    WellnessTip(26, "Swap Diet Soda", "Replace diet soda with carbonated water to reduce the intake of artificial sweeteners.", R.drawable.swap_diet_soda),
    WellnessTip(27, "Correct Your Posture", "Regularly check and correct your posture throughout the day.", R.drawable.correct_posture),
    WellnessTip(28, "Go to Bed Earlier", "Adjust your bedtime to ensure you're well-rested.", R.drawable.bed_earlier),
    WellnessTip(29, "Choose Integrity", "Make decisions that align with your values and beliefs.", R.drawable.choose_integrity),
    WellnessTip(30, "Listen to Your Body", "Pay attention to what your body needs, whether it's rest, food, or exercise.", R.drawable.listen_to_body)
    // Add additional tips...
)


// Composable for displaying a wellness tip card with animation
@Composable
fun WellnessTipCard(tip: WellnessTip) {
    var selected by remember { mutableStateOf(false) }
    val elevation by animateDpAsState(if (selected) 10.dp else 2.dp, spring(Spring.DampingRatioMediumBouncy))

    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { selected = !selected },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            DayIndicator(day = tip.id) // Day indicator on top of each card
            Image(
                painter = painterResource(id = tip.imageResId),
                contentDescription = tip.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
            Text(
                text = tip.title,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(8.dp)
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = tip.description,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun DayIndicator(day: Int) {
    Surface(
        modifier = Modifier
            .size(32.dp)
            .padding(8.dp),
        color = MaterialTheme.colorScheme.primary,
        shape = CircleShape
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "$day", fontSize = 14.sp, color = Color.White)
        }
    }
}

// Composable for displaying a scrollable list of wellness tips
@Composable
fun WellnessTipList(tips: List<WellnessTip>) {
    LazyColumn {
        items(tips) { tip ->
            WellnessTipCard(tip = tip)
        }
    }
}

// Preview of MainScreen
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    _30DaysOfInspirationTheme {
        MainScreen(wellnessTips = wellnessTips)
    }
}
