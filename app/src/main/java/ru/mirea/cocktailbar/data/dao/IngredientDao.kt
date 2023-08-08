package ru.mirea.cocktailbar.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.mirea.cocktailbar.data.model.Ingredient


@Dao
interface IngredientDao {
    @Query("SELECT * FROM ingredient WHERE cocktail_id = :cocktailId")
    suspend fun getIngredient(cocktailId: String): Ingredient

    @Insert
    suspend fun insertIngredient(ingredient: Ingredient)

    @Delete
    suspend fun deleteIngredient(ingredient: Ingredient)
}