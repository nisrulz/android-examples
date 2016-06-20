package sample.github.nisrulz.usingdagger2;

import dagger.Component;

@Component(modules = MainModule.class) public interface MainComponent {
  void inject(MainFragment fragment);
}
