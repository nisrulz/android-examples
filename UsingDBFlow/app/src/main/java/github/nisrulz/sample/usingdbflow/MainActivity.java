package github.nisrulz.sample.usingdbflow;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.raizlabs.android.dbflow.sql.language.Select;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Create organization
    Organization organization = new Organization();
    organization.setId(1);
    organization.setName("MyOrganization");
    organization.save();

    // Create user
    User user = new User();
    user.setName("Nishant Srivastava");
    user.setOrganization(organization);
    user.save();

    Organization newOrg = new Select().from(Organization.class)
        .where(Organization_Table.id.eq(1))
        .querySingle();
    System.out.println(newOrg.getName());
  }
}
