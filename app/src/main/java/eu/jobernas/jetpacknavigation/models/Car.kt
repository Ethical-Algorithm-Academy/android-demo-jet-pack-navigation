package eu.jobernas.jetpacknavigation.models

import android.os.Parcelable
import androidx.annotation.ColorInt
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(val id: String,
               override val name: String,
               @ColorInt override val color: Int,
               override val brand: String,
               val isCommercial: Boolean): Vehicle(name, color, brand), Parcelable
