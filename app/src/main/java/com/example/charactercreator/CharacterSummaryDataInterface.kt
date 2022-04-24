package com.example.charactercreator

import com.example.charactercreator.models.CharacterSummary

sealed interface CharacterSummaryDataInterface {
    fun getModels(): List<CharacterSummary>
}