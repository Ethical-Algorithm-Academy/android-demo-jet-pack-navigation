package eu.jobernas.jetpacknavigation.helpers

import androidx.navigation.NavOptions
import eu.jobernas.jetpacknavigation.R

object NavigationConfig {
    val defaultNavigationBuilder: NavOptions.Builder =
            NavOptions.Builder()
                    .setEnterAnim(R.anim.nav_slide_in)
                    .setExitAnim(R.anim.nav_slide_out)
                    .setPopEnterAnim(R.anim.nav_fade_in)
                    .setPopExitAnim(R.anim.nav_fade_out)
}