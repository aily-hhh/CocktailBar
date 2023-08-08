package ru.mirea.cocktailbar.data.repository

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

    suspend fun getAllCocktails() {
        cocktailDao.getAllCocktails()
    }

    suspend fun getCocktail(id: String) {
        cocktailDao.getCocktail(id)
    }
}