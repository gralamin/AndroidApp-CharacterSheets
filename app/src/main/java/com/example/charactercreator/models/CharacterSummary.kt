package com.example.charactercreator.models

import android.net.Uri
import com.example.charactercreator.R

data class CharacterSummary(
    val characterName: String,
    val sheetType: String,
    val characterImage: Int
    ) {}

val CHARACTER_ONE = CharacterSummary("Joe", "FATE", R.drawable.ic_launcher_foreground)
val CHARACTER_TWO = CharacterSummary("Raphaël Ambrosius Costeau", "Disco Elysium", R.drawable.ic_placeholder)
val CHARACTER_ThREE = CharacterSummary("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM", "MMMMMMMMMMMMMMMMMMMMMMMMM", R.drawable.ic_launcher_foreground)
val CHARACTER_FOUR = CharacterSummary("Abasdasdasdasdasdasdasdsadasdasdads", "FATE", R.drawable.ic_placeholder)
val CHARACTER_FIVE = CharacterSummary("Cdzbcxcxxcxcxccxcxcxcxcxcxcxcxcxcxcxcxcxcx", "FATE", R.drawable.ic_placeholder)
val CHARACTER_SIX = CharacterSummary("Ef", "FATE", R.drawable.ic_placeholder)

val ALL_CHARACTERS =  listOf(CHARACTER_ONE, CHARACTER_TWO, CHARACTER_ThREE, CHARACTER_FOUR,
CHARACTER_FIVE, CHARACTER_SIX)