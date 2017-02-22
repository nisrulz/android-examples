package github.nisrulz.sample.snaphelper;

public class Item {

  String name;
  int imgRes;

  public Item(String name, int imgRes) {
    this.name = name;
    this.imgRes = imgRes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getImgRes() {
    return imgRes;
  }

  public void setImgRes(int imgRes) {
    this.imgRes = imgRes;
  }
}
