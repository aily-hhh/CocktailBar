package ru.mirea.cocktailbar.ui.detailCocktail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.mirea.cocktailbar.R
import ru.mirea.cocktailbar.data.model.Cocktail
import ru.mirea.cocktailbar.data.model.Ingredient
import ru.mirea.cocktailbar.data.viewModel.CocktailViewModel
import ru.mirea.cocktailbar.data.viewModel.IngredientViewModel
import ru.mirea.cocktailbar.databinding.FragmentDetailCocktailBinding


@AndroidEntryPoint
class DetailCocktailFragment : Fragment() {

    private var _binding: FragmentDetailCocktailBinding? = null
    private val binding get() = _binding!!
    private val viewModelCocktail by viewModels<CocktailViewModel>()
    private val viewModelIngredient by viewModels<IngredientViewModel>()
    private val bundleArgs by navArgs<DetailCocktailFragmentArgs>()
    private var currentCocktail: Cocktail? = null
    private var listIngredient: List<Ingredient> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailCocktailBinding.inflate(inflater, container, false)
        currentCocktail = bundleArgs.currentCocktail
        listIngredient = viewModelIngredient.getIngredients(currentCocktail!!.id).value ?: listOf()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nameCocktailDetail.text = currentCocktail?.name
        binding.descriptionCocktailDetail.text = currentCocktail?.description
        binding.txtRecipeDetails.text = currentCocktail?.recept

        if (listIngredient.isNotEmpty()) {
            for (i in listIngredient) {
                var strIngredients: String = ""
                if (i.id == listIngredient.last().id) {
                    strIngredients.plus(i.name)
                } else {
                    strIngredients.plus(i.name + "\n•.•.•\n")
                }
            }
        }

        if (currentCocktail?.image != null) {
            binding.imgHeaderCocktailDetail.setImageURI(currentCocktail?.image!!.toUri())
        }

        binding.btnEditCocktail.setOnClickListener {
            val bundle = bundleOf("current_cocktail" to currentCocktail)
            view.findNavController().navigate(
                R.id.action_detailCocktailFragment_to_addCocktailFragment,
                bundle
            )
        }

        binding.btnDeleteCocktail.setOnClickListener {
            // TODO: dialog
            viewModelCocktail.delete(cocktail = currentCocktail!!)
            Toast.makeText(requireActivity(), "Deleted", Toast.LENGTH_SHORT).show()
            view.findNavController().popBackStack()
        }
    }
}