package ru.mirea.cocktailbar.data.repository

import androidx.lifecycle.LiveData
import ru.mirea.cocktailbar.data.dao.CocktailDao
import ru.mirea.cocktailbar.data.model.Cocktail
import javax.inject.Inject

class CocktailRepository @Inject constructor(private val cocktailDao: CocktailDao) {

    suspend fun createCocktail(cocktail: Cocktail) {
        cocktailDao.insertCocktail(cocktail)
    }

    suspend fun updateCocktail(cocktail: Cocktail) {
        cocktailDao.updateCocktail(cocktail)
    }

    suspend fun deleteCocktail(cocktail: Cocktail) {
        cocktailDao.deleteCocktail(cocktail)
    }

    val getAllCocktails: LiveData<List<Cocktail>> = cocktailDao.getAllCocktails()
    fun getCocktail(cocktailId: Long): LiveData<Cocktail> = cocktailDao.getCocktail(cocktailId)

}