package ru.mirea.cocktailbar.ui.addCocktail

import androidx.fragment.app.DialogFragment

interface DialogListener {
    fun onDialogAddClick(nameIngredient: String)
    fun onDialogCancelClick(dialog: DialogFragment)
}
