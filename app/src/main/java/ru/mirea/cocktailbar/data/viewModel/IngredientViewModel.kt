package ru.mirea.cocktailbar.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.mirea.cocktailbar.data.dao.IngredientDao
import ru.mirea.cocktailbar.data.model.Ingredient
import javax.inject.Inject


@HiltViewModel
class IngredientViewModel @Inject constructor(private val ingredientDao: IngredientDao): ViewModel() {

    fun create(ingredient: Ingredient) =
        viewModelScope.launch {
            ingredientDao.insertIngredient(ingredient)
        }

    fun delete(ingredient: Ingredient) =
        viewModelScope.launch {
            ingredientDao.deleteIngredient(ingredient)
        }

    fun getIngredient(cocktailId: String) =
        viewModelScope.launch {
            ingredientDao.getIngredient(cocktailId)
        }
}