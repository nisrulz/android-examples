package sample.github.nisrulz.usingdagger2;

import dagger.Module;
import dagger.Provides;

@Module public class MainModule {

  private final MainView view;

  public MainModule(MainView view) {
    this.view = view;
  }

  @Provides public MainPresenter providePresenter() {
    return new MainPresenter(view);
  }
}
