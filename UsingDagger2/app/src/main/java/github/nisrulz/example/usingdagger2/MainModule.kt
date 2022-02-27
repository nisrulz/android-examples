package github.nisrulz.example.usingdagger2

import dagger.Module
import dagger.Provides

@Module
class MainModule(private val view: MainView) {
    @Provides
    fun providePresenter(): MainPresenter {
        return MainPresenter(view)
    }
}