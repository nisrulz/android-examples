package github.nisrulz.example.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyFragmentPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Page.newInstance(0, "Page Type 1")
            1 -> Page2.newInstance(1, "Page Type 2")
            2 -> Page.newInstance(2, "Page Type 1")
            else -> Page2.newInstance(3, "Page Type 2")
        }
    }
}