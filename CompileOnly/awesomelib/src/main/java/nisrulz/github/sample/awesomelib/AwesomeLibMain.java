package nisrulz.github.sample.awesomelib;

import retrofit2.Retrofit;

public class AwesomeLibMain {

  public boolean init() {

    /* When retrofit is added as implementation in the app module's build.gradle , below will be a valid statement
     * and Retrofit class will exist on the classpath when this module is compiled. If the
     * implementation line is removed from app module's build.gradle
     * below will become invalid statement as Retrofit class will not exist on the classpath  when
     * this module is compiled.
     *
     * Having set Retrofit as compileOnly dependency for the awesomelib module, makes it dependent on
     * app module's dependency graph in terms of availability  of Retrofit class in the classpath
     * after compilation
     */
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://swapi.co/api/").build();

    return hasRetrofitOnClasspath();
  }

  private boolean hasRetrofitOnClasspath() {
    try {
      Class.forName("retrofit2.Retrofit");
      return true;
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    return false;
  }
}
