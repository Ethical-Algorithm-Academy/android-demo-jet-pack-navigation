package com.beatstars.testingjetpacknavigation.helpers

import androidx.navigation.NavOptions
import com.beatstars.testingjetpacknavigation.R

object NavigationConfig {
    val defaultNavigationBuilder: NavOptions.Builder =
            NavOptions.Builder()
                    .setEnterAnim(R.animator.nav_default_enter_anim)
                    .setExitAnim(R.animator.nav_default_exit_anim)
                    .setPopEnterAnim(R.animator.nav_default_pop_enter_anim)
                    .setPopExitAnim(R.animator.nav_default_pop_exit_anim)
}