package ru.mirea.cocktailbar.ui.addCocktail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.mirea.cocktailbar.R
import ru.mirea.cocktailbar.data.model.Cocktail
import ru.mirea.cocktailbar.data.viewModel.CocktailViewModel
import ru.mirea.cocktailbar.data.viewModel.IngredientViewModel
import ru.mirea.cocktailbar.databinding.FragmentAddCocktailBinding


@AndroidEntryPoint
class AddCocktailFragment : Fragment(), DialogListener {

    private var _binding: FragmentAddCocktailBinding? = null
    private val binding get() = _binding!!
    private val viewModelCocktail by viewModels<CocktailViewModel>()
    private val viewModelIngredient by viewModels<IngredientViewModel>()
    private val listIngredients = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddCocktailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnAddIngredient.setOnClickListener {
            showIngredientDialog()
        }

        binding.btnSaveCocktail.setOnClickListener {
            val cocktail = Cocktail()
            cocktail.name = binding.nameNewGroup.text.toString()
            cocktail.description = binding.descNewGroup.text.toString()
            cocktail.recept = binding.recipeNewGroup.text.toString()
            // TODO: добавление картинки

        }

        binding.btnCancelCocktail.setOnClickListener {
            view.findNavController().popBackStack()
        }


    }

    private fun showIngredientDialog() {
        val dialog = DialogFragment()
        dialog.show(requireActivity().supportFragmentManager, "IngredientDialogFragment")
    }

    override fun onDialogAddClick(nameIngredient: String) {
        listIngredients.add(nameIngredient)
        Log.d("Ingredient", "new = $nameIngredient")
    }

    override fun onDialogCancelClick(dialog: DialogFragment) {
        dialog.dismiss()
    }

}