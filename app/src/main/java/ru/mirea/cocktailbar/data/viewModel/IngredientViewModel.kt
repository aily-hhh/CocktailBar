package ru.mirea.cocktailbar.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.mirea.cocktailbar.data.dao.IngredientDao
import ru.mirea.cocktailbar.data.model.Ingredient
import ru.mirea.cocktailbar.data.repository.IngredientRepository
import javax.inject.Inject


@HiltViewModel
class IngredientViewModel @Inject constructor(private val ingredientRepository: IngredientRepository): ViewModel() {

    fun create(ingredient: Ingredient) =
        viewModelScope.launch {
            ingredientRepository.createIngredient(ingredient)
        }

    fun delete(ingredient: Ingredient) =
        viewModelScope.launch {
            ingredientRepository.deleteIngredient(ingredient)
        }

    fun getIngredients(cocktailId: Long) = ingredientRepository.getIngredient(cocktailId)
}