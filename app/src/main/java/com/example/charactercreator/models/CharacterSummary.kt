package com.example.charactercreator.models

import android.net.Uri
import com.example.charactercreator.R

data class CharacterSummary(
    val id: Long,
    val characterName: String,
    val sheetType: String,
    val characterImage: String?
    ) {}

