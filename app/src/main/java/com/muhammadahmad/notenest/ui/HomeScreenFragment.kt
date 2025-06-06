package com.muhammadahmad.notenest.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.muhammadahmad.notenest.R

class HomeScreenFragment : Fragment(R.layout.activity_home_screen_fragment) {

    private lateinit var bottomNav: BottomNavigationView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNav = view.findViewById(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_add_note -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AddNoteFragment())
                        .addToBackStack("home")
                        .commit()
                    true
                }

                R.id.menu_view_notes -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ViewNotesFragment())
                        .addToBackStack("home")
                        .commit()
                    true
                }
                else -> false
            }
        }

        // Handle back press with custom exit dialog
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    showCustomExitDialog()
                }
            }
        )
    }

    private fun showCustomExitDialog() {
        val inflater = LayoutInflater.from(requireContext())
        val dialogView = inflater.inflate(R.layout.exit_dialog_box, null)

        val alertDialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setCancelable(false)
            .create()

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val btnYes = dialogView.findViewById<View>(R.id.btn_yes)
        val btnNo = dialogView.findViewById<View>(R.id.btn_no)

        btnYes.setOnClickListener {
            requireActivity().finishAffinity() // Exit the app
            alertDialog.dismiss()
        }

        btnNo.setOnClickListener {
            alertDialog.dismiss() // Dismiss the dialog
        }

        alertDialog.show()
    }
}
