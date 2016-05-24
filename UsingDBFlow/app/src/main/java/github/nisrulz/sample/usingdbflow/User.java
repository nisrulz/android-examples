package github.nisrulz.sample.usingdbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class User extends BaseModel {

  @Column @PrimaryKey int id;

  @Column String name;

  @Column @ForeignKey(saveForeignKeyModel = false) Organization organization;

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Organization getOrganization() {
    return organization;
  }
}
