package ru.mirea.cocktailbar.data.repository

import androidx.lifecycle.LiveData
import ru.mirea.cocktailbar.data.dao.IngredientDao
import ru.mirea.cocktailbar.data.model.Ingredient
import javax.inject.Inject

class IngredientRepository @Inject constructor(private val ingredientDao: IngredientDao) {

    fun getIngredient(cocktailId: Long): LiveData<List<Ingredient>> =
        ingredientDao.getIngredient(cocktailId)


    suspend fun createIngredient(ingredient: Ingredient) {
        ingredientDao.insertIngredient(ingredient)
    }

    suspend fun deleteIngredient(ingredient: Ingredient) {
        ingredientDao.deleteIngredient(ingredient)
    }
}