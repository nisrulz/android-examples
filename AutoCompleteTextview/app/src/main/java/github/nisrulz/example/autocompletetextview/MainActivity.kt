package github.nisrulz.example.autocompletetextview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.autocompletetextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var list: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            prepareBaseList()
            btnAdd.setOnClickListener {
                val item = editText.text.toString()
                list.add(item)
                addItemsToList()
                editText.text.clear()

                Toast.makeText(
                    baseContext, "Item Added",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }

    private fun addItemsToList() {
        val adapter = ArrayAdapter(
            baseContext,
            android.R.layout.simple_dropdown_item_1line, list
        )
        binding.autoCompleteTextView.apply {
            threshold = 1
            setAdapter(adapter)
        }
    }

    private fun prepareBaseList() {
        list.apply {
            add("Item 1")
            add("Item 2")
            add("Item 3")
        }
        addItemsToList()
    }
}