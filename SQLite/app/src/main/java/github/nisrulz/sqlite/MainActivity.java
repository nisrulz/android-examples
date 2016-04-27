package github.nisrulz.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edt_name, edt_address, edt_phn;
    Button add_btn, del_btn, query_btn;

    //DB
    private DBController dbcon;

    //ListView
    private ListView lv;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI
        add_btn = (Button) findViewById(R.id.button_add);
        del_btn = (Button) findViewById(R.id.button_del);
        query_btn = (Button) findViewById(R.id.button_query);
        edt_name = (EditText) findViewById(R.id.editText_name);
        edt_address = (EditText) findViewById(R.id.editText_address);
        edt_phn = (EditText) findViewById(R.id.editText_phn);


        // Listview
        lv = (ListView) findViewById(R.id.listView);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

        //DB
        dbcon = new DBController(this);

        // OnClickListeners
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edt_name.getText().toString();
                String address = edt_address.getText().toString();
                String phn = edt_phn.getText().toString();

                if (name == null || TextUtils.isEmpty(name)) {
                    edt_name.setError("Name field is empty/not valid");
                    return;
                }
                if (address == null || TextUtils.isEmpty(address)) {
                    edt_address.setError("Address field is empty/not valid");
                    return;
                }
                if (phn == null || TextUtils.isEmpty(phn)) {
                    edt_phn.setError("Phone field is empty/not valid");
                    return;
                }

                Employee employee = new Employee(name, address, phn);
                dbcon.addEmployee(employee);
                Toast.makeText(MainActivity.this, "Record Added", Toast.LENGTH_SHORT).show();
            }
        });

        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_name.getText().toString();
                if (name == null || TextUtils.isEmpty(name)) {
                    edt_name.setError("Name field is empty/not valid");
                    return;
                }

                List<Employee> empList = dbcon.getAllEmployee();

                for (int i = 0; i < empList.size(); i++) {
                    if (empList.get(i).get_name().equals(name)) {
                        Employee e = empList.get(i);
                        dbcon.deleteEmployee(e);
                    }
                }
                Toast.makeText(MainActivity.this, "Record Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        query_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edt_name.getText().toString();
                if (name == null || TextUtils.isEmpty(name)) {
                    edt_name.setError("Name field is empty/not valid");
                    return;
                }

                data.clear();
                adapter.notifyDataSetChanged();

                List<Employee> empList = dbcon.getAllEmployee();

                for (int i = 0; i < empList.size(); i++) {
                    if (empList.get(i).get_name().equals(name)) {
                        Employee e = empList.get(i);
                        String info = "ID : " + e.get_id() + ", " + "Name : " + e.get_name()
                                + ", " + "Address : " + e.get_address() + ", " + "Phone : "
                                + e.get_phone();
                        data.add(info);
                        System.out.println(info);
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }
}
