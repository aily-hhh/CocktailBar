package ru.mirea.cocktailbar.ui.cocktailList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.mirea.cocktailbar.R
import ru.mirea.cocktailbar.data.viewModel.CocktailViewModel
import ru.mirea.cocktailbar.databinding.FragmentCocktailListBinding


@AndroidEntryPoint
class CocktailListFragment : Fragment() {

    private var _binding: FragmentCocktailListBinding? = null
    private val binding get() = _binding!!
    private val viewModelCocktail by viewModels<CocktailViewModel>()
    private var cocktailsListAdapter: CocktailsListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCocktailListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

        cocktailsListAdapter?.setOnItemClickListener {
            val bundle = bundleOf("cocktail" to it)
            view.findNavController().navigate(
                R.id.action_cocktailList_to_detailCocktailFragment,
                bundle
            )
        }

        viewModelCocktail.allCocktails().observe(viewLifecycleOwner) {
            cocktailsListAdapter?.differ?.submitList(it)
            if (viewModelCocktail.allCocktails().value?.isEmpty() == true) {
                binding.imgEmptyList.visibility = View.VISIBLE
                binding.txtAddCocktail.visibility = View.VISIBLE
                binding.icArrowEmptyList.visibility = View.VISIBLE
            } else {
                binding.imgEmptyList.visibility = View.GONE
                binding.txtAddCocktail.visibility = View.GONE
                binding.icArrowEmptyList.visibility = View.GONE
            }
        }

        binding.fabAddCocktail.setOnClickListener {
            view.findNavController().navigate(
                R.id.action_cocktailList_to_addCocktailFragment
            )
        }
    }

    private fun initAdapter() {
        cocktailsListAdapter = CocktailsListAdapter()
        binding.rvCocktailList.apply {
            adapter = cocktailsListAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}