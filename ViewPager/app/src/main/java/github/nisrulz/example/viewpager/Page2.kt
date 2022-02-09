package github.nisrulz.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import github.nisrulz.example.viewpager.databinding.FragmentPage2Binding

/**
 * A simple [Fragment] subclass.
 */
class Page2 : Fragment() {
    // Store instance variables
    private var title: String? = null
    private var page = 0

    private lateinit var binding: FragmentPage2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            page = getInt("page", 0)
            title = getString("title")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage2Binding.inflate(inflater, container, false)
        binding.apply {
            textView.text = "$page - $title"
        }

        return binding.root
    }

    companion object {
        fun newInstance(page_number: Int, title: String?): Page2 {
            val fragment = Page2()
            val args = Bundle().apply {
                putInt("page", page_number)
                putString("title", title)
            }
            fragment.arguments = args
            return fragment
        }
    }
}