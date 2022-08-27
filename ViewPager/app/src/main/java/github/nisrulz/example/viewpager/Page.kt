package github.nisrulz.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import github.nisrulz.example.viewpager.databinding.FragmentPageBinding

class Page : Fragment() {
    // Store instance variables
    private var title: String? = null
    private var page = 0

    private lateinit var binding: FragmentPageBinding
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
        binding = FragmentPageBinding.inflate(inflater, container, false)
        with(binding) {
            textView.text = "$page - $title"
        }

        return binding.root
    }

    companion object {
        fun newInstance(page_number: Int, title: String?): Page {
            val fragment = Page()
            val args = Bundle().apply {
                putInt("page", page_number)
                putString("title", title)
            }
            fragment.arguments = args
            return fragment
        }
    }
}