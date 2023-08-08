package ru.mirea.cocktailbar.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktail")
data class Cocktail(
    @PrimaryKey
    var name: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "recept")
    var recept: String
)
