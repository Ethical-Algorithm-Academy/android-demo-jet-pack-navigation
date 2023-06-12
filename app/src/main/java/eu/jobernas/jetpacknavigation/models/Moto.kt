package eu.jobernas.jetpacknavigation.models

import android.os.Parcelable
import androidx.annotation.ColorInt
import kotlinx.parcelize.Parcelize

@Parcelize
data class Moto(
    override val name: String,
    @ColorInt override val color: Int,
    override val brand: String,
    val isFourWheels: Boolean): Vehicle(name, color, brand), Parcelable