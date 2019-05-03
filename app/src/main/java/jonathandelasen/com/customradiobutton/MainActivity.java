package jonathandelasen.com.customradiobutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText acetStatus;
    private ListPopupWindow statusPopupList;
    private MyRadioButton acrbMale;
    private MyRadioButton acrbFemale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));

        acetStatus = findViewById(R.id.acet_status);
        acrbFemale = findViewById(R.id.acrb_female);
        acrbMale = findViewById(R.id.acrb_male);
        setPopupList();
        setListeners();
    }

    private void setListeners() {
        acetStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusPopupList.show();
            }
        });
        setRadiosListener();
    }

    private void setRadiosListener() {
        acrbFemale.setOwnOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });
        acrbMale.setOwnOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });
    }

    private void setPopupList() {
        final List<String> status = new ArrayList<>();
        status.add("Status 1");
        status.add("Status 2");
        status.add("Status 3");
        status.add("Status 4");

        statusPopupList = new ListPopupWindow(MainActivity.this);
        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, R.layout.item_simple_status, R.id.tv_element, status);
        statusPopupList.setAnchorView(acetStatus); //this let as set the popup below the EditText
        statusPopupList.setAdapter(adapter);
        statusPopupList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                acetStatus.setText(status.get(position));//we set the selected element in the EditText
                statusPopupList.dismiss();
            }
        });
    }
}
