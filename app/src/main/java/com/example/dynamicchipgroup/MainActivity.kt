package com.example.dynamicchipgroup

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.dynamicchipgroup.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupChipGroupDynamically()

    }

    private fun setupChipGroupDynamically() {

        val chipGroup = ChipGroup(this)
        chipGroup.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        chipGroup.isSingleSelection = true
        chipGroup.isSingleLine = false

        chipGroup.addView(createChip("Thyroid"))
        chipGroup.addView(createChip("Fertility"))
        chipGroup.addView(createChip("Glycometabolism"))
        chipGroup.addView(createChip("South Bone Metabolism"))
        chipGroup.addView(createChip("Anemia"))
        chipGroup.addView(createChip("Cardiac Markers"))
        chipGroup.addView(createChip("Autoimmune"))
        chipGroup.addView(createChip("Inflammation Markers"))

        binding.rootContainer.addView(chipGroup)

    }

    private fun createChip(label: String): Chip {
        val chip = Chip(this, null, R.style.Theme_DynamicChipGroup)
        chip.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        chip.text = label
        chip.isCloseIconVisible = false
        chip.isChipIconVisible = false
        chip.isCheckable = true
        chip.isClickable = true
        chip.isCheckedIconVisible = false

        chip.chipStrokeColor = ColorStateList.valueOf(
            Color.parseColor("#40A0A0A0")
        )
//        chip.chipStrokeWidth = 3.dpToPixels(this)
        chip.chipStrokeWidth = 3.0f

        chip.chipBackgroundColor = colorStates()

        chip.setOnCloseIconClickListener {

            Toast.makeText(this, "Chip deleted successfully", Toast.LENGTH_SHORT).show()
        }
        return chip

    }

    private fun colorStates(): ColorStateList? {
        val states = arrayOf(
            intArrayOf(android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_checked)
        )

        val colors = intArrayOf(
            // chip checked color
            Color.parseColor("#CB4CAF50"),
            // chip unchecked color
            Color.parseColor("#ffffff")
        )

        return ColorStateList(states, colors)
    }
}