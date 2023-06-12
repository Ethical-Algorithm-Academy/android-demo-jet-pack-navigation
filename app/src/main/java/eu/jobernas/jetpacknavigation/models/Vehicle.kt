package eu.jobernas.jetpacknavigation.models

import android.os.Parcelable
import androidx.annotation.ColorInt
import kotlinx.parcelize.Parcelize

@Parcelize
open class Vehicle(
    open val name: String,
    @ColorInt open val color: Int,
    open val brand: String): Parcelable