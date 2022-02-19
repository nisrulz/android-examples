package github.nisrulz.example.usingmpchartslib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.snackbar.Snackbar
import github.nisrulz.example.usingmpchartslib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Library at  : https://github.com/PhilJay/MPAndroidChart/

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setupChart(this)
        }

    }

    private fun setupChart(binding: ActivityMainBinding) {
        binding.apply {
            fab.setOnClickListener { view ->
                Snackbar.make(
                    view,
                    "Using MPAndroidCharts 3.0.1",
                    Snackbar.LENGTH_LONG
                ).show()
            }

            // Data Sets
            val entries = ArrayList<BarEntry>()
            entries.add(BarEntry(4f, 0f))
            entries.add(BarEntry(8f, 1f))
            entries.add(BarEntry(6f, 2f))
            entries.add(BarEntry(12f, 3f))
            entries.add(BarEntry(18f, 4f))
            entries.add(BarEntry(9f, 5f))
            val dataset = BarDataSet(entries, "# of Calls")

            // Declare the bar chart and set it as the view for this activity
            // Set data for the bar chart
            val data = BarData(dataset)
            barChart.data = data
            barChart.setFitBars(true) // make the x-axis fit exactly all bars

            // Set description
            val description = Description()
            description.text = "# of times Alice called Bob"
            barChart.description = description

            // Set themes
            dataset.setColors(*ColorTemplate.COLORFUL_COLORS)

            // Animate
            barChart.animateY(5000)

            // Save the chart after its drawn to gallery/path
            barChart.saveToGallery("mychart.jpg", 85) // 85 is the quality of the image
        }
    }
}