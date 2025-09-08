package com.example.favoriteevent.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.favoriteevent.R
import com.example.favoriteevent.databinding.FragmentSettingBinding
import com.example.favoriteevent.utils.ThemePrefs

class Setting : Fragment(R.layout.fragment_setting) {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentSettingBinding.bind(view)

        binding.switchTheme.isChecked = ThemePrefs.isDark(requireContext())

        binding.switchTheme.setOnCheckedChangeListener { _, checked ->
            ThemePrefs.setDark(requireContext(), checked)
            ThemePrefs.applyNightMode(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}