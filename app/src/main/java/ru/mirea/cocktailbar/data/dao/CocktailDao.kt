package ru.mirea.cocktailbar.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.mirea.cocktailbar.data.model.Cocktail


@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktail")
    fun getAllCocktails(): LiveData<List<Cocktail>>

    @Insert
    suspend fun insertCocktail(cocktail: Cocktail)

    @Update
    suspend fun updateCocktail(cocktail: Cocktail)

    @Delete
    suspend fun deleteCocktail(cocktail: Cocktail)

    @Query("SELECT * FROM cocktail WHERE id = :cocktailId")
    fun getCocktail(cocktailId: Long): LiveData<Cocktail>
}