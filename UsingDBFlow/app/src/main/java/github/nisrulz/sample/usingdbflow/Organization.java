package github.nisrulz.sample.usingdbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class Organization extends BaseModel {

  @Column
  @PrimaryKey
  int id;

  @Column
  String name;
}
