package github.nisrulz.example.customonboardingintro

import android.annotation.TargetApi
import android.os.Build
import android.view.View
import androidx.viewpager.widget.ViewPager.PageTransformer
import kotlin.math.abs

class IntroPageTransformer : PageTransformer {
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun transformPage(page: View, position: Float) {

        // Get the page index from the tag. This makes
        // it possible to know which page index you're
        // currently transforming - and that can be used
        // to make some important performance improvements.
        val pagePosition = page.tag as Int

        // Here you can do all kinds of stuff, like get the
        // width of the page and perform calculations based
        // on how far the user has swiped the page.
        val pageWidth = page.width
        val pageWidthTimesPosition = pageWidth * position
        val absPosition = abs(position)

        // Now it's time for the effects
        if (position <= -1.0f || position >= 1.0f) {

            // The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.
        } else if (position == 0.0f) {

            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks to match up perfectly.
        } else {

            // The page is currently being scrolled / swiped. This is
            // a good place to show animations that react to the user's
            // swiping as it provides a good user experience.

            // Let's start by animating the title.
            // We want it to fade as it scrolls out
            val title = page.findViewById<View>(R.id.title)
            title.alpha = 1.0f - absPosition

            // Now the description. We also want this one to
            // fade, but the animation should also slowly move
            // down and out of the screen
            val description = page.findViewById<View>(R.id.description)
            description.translationY = -pageWidthTimesPosition / 2f
            description.alpha = 1.0f - absPosition

            // Now, we want the image to move to the right,
            // i.e. in the opposite direction of the rest of the
            // content while fading out
            val computer = page.findViewById<View>(R.id.computer)

            // We're attempting to create an effect for a View
            // specific to one of the pages in our ViewPager.
            // In other words, we need to check that we're on
            // the correct page and that the View in question
            // isn't null.
            if (pagePosition == 0 && computer != null) {
                computer.alpha = 1.0f - absPosition
                computer.translationX = -pageWidthTimesPosition * 1.5f
            }

            // Finally, it can be useful to know the direction
            // of the user's swipe - if we're entering or exiting.
            // This is quite simple:
            if (position < 0) {
                // Create your out animation here
            } else {
                // Create your in animation here
            }
        }
    }
}