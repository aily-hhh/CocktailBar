package ru.mirea.cocktailbar.ui.addCocktail

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import ru.mirea.cocktailbar.R

@AndroidEntryPoint
class AddIngredientFragment : DialogFragment() {

    private var nameNewIngredient: TextInputEditText? = null
    private var btnAddIngredient: Button? = null
    private var btnCancelIngredient: Button? = null
    private lateinit var listener: DialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as DialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.fragment_add_ingredient, null)

            nameNewIngredient = view.findViewById(R.id.nameNewIngredient)
            btnAddIngredient = view.findViewById(R.id.btnAddIngredient)
            btnCancelIngredient = view.findViewById(R.id.btnCancelIngredient)

            btnAddIngredient?.setOnClickListener {
                listener.onDialogAddClick(nameNewIngredient?.text.toString())
            }

            btnCancelIngredient?.setOnClickListener {
                listener.onDialogCancelClick(this)
            }

            builder.setView(view)
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}