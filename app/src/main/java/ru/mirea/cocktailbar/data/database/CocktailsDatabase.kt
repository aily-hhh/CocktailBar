package ru.mirea.cocktailbar.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mirea.cocktailbar.data.dao.CocktailDao
import ru.mirea.cocktailbar.data.dao.IngredientDao
import ru.mirea.cocktailbar.data.model.Cocktail
import ru.mirea.cocktailbar.data.model.Ingredient

@Database(entities = [Cocktail::class, Ingredient::class], version = 1)
abstract class CocktailsDatabase: RoomDatabase() {
    abstract fun getCocktailDao(): CocktailDao
    abstract fun getIngredientDao(): IngredientDao
}