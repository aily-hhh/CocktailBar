package ru.mirea.cocktailbar.data.repository

import ru.mirea.cocktailbar.data.dao.IngredientDao
import ru.mirea.cocktailbar.data.model.Ingredient
import javax.inject.Inject

class IngredientRepository @Inject constructor(private val ingredientDao: IngredientDao) {

    suspend fun getIngredient(cocktailId: String) {
        ingredientDao.getIngredient(cocktailId)
    }

    suspend fun createIngredient(ingredient: Ingredient) {
        ingredientDao.insertIngredient(ingredient)
    }

    suspend fun deleteIngredient(ingredient: Ingredient) {
        ingredientDao.deleteIngredient(ingredient)
    }
}