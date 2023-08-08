package ru.mirea.cocktailbar.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.mirea.cocktailbar.data.model.Cocktail


@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktail")
    suspend fun getAllCocktails(): List<Cocktail>

    @Insert
    suspend fun insertCocktail(cocktail: Cocktail)

    @Update
    suspend fun updateCocktail(cocktail: Cocktail)

    @Delete
    suspend fun deleteCocktail(cocktail: Cocktail)

    @Query("SELECT * FROM cocktail WHERE name = :cocktailId")
    suspend fun getCocktail(cocktailId: String): Cocktail
}