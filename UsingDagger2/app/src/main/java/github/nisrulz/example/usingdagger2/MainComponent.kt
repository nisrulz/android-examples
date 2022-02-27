package github.nisrulz.example.usingdagger2

import dagger.Component

@Component(modules = [MainModule::class])
interface MainComponent {
    fun inject(fragment: MainFragment?)
}