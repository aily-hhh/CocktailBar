package ru.mirea.cocktailbar.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.mirea.cocktailbar.data.model.Cocktail
import ru.mirea.cocktailbar.data.repository.CocktailRepository
import javax.inject.Inject


@HiltViewModel
class CocktailViewModel @Inject constructor(private val cocktailRepository: CocktailRepository): ViewModel() {

    fun create(cocktail: Cocktail) =
        viewModelScope.launch {
            cocktailRepository.createCocktail(cocktail)
        }

    fun update(cocktail: Cocktail) =
        viewModelScope.launch {
            cocktailRepository.updateCocktail(cocktail)
        }

    fun delete(cocktail: Cocktail) =
        viewModelScope.launch {
            cocktailRepository.deleteCocktail(cocktail)
        }

    fun allCocktails() =
        viewModelScope.launch {
            cocktailRepository.getAllCocktails()
        }

    fun cocktail(id: String) =
        viewModelScope.launch {
            cocktailRepository.getCocktail(id)
        }
}