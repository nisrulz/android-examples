package github.nisrulz.example.usingdagger2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import github.nisrulz.example.usingdagger2.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : Fragment(), MainView {

    private lateinit var binding: FragmentMainBinding

    private val module by lazy { MainModule(this) }

    var presenter: MainPresenter? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup Dagger
        DaggerMainComponent
            .builder()
            .mainModule(module)
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Use the inflater to inflate the layout via the Binding class
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
}