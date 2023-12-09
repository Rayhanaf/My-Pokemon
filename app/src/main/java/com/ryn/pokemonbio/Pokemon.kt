package com.ryn.pokemonbio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
