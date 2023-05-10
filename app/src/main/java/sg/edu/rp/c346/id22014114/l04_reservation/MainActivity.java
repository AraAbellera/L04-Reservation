package sg.edu.rp.c346.id22014114.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText number;
    EditText pax;
    DatePicker date;
    TimePicker time;
    RadioGroup area;
    Button confirm;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        pax = findViewById(R.id.pax);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);
        area = findViewById(R.id.area);
        confirm = findViewById(R.id.confirm);
        reset = findViewById(R.id.reset);

        // setting the default date to 1 Jun 2020 and the default time to 7:30pm.
        time.setHour(19);
        time.setMinute(30);
        date.updateDate(2020,5,1);

        // when clicked, reservation details will be shown using toast for a short duration
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String iname = name.getText().toString();
                String inum = number.getText().toString();
                String ipax = pax.getText().toString();

                // reservation not made if any EditText field is empty, error msg displayed using toast
                if (iname.isEmpty())
                {
                    Toast cname = Toast.makeText(confirm.getContext(), "Please input name", Toast.LENGTH_SHORT);
                    cname.show();
                }
                else
                {
                    Toast cname = Toast.makeText(confirm.getContext(), "Name: " + name.getText().toString(), Toast.LENGTH_SHORT);
                    cname.show();

                    if (inum.isEmpty())
                    {
                        Toast cnum = Toast.makeText(confirm.getContext(), "Please input mobile number", Toast.LENGTH_SHORT);
                        cnum.show();
                    }
                    else
                    {
                        Toast cnum = Toast.makeText(confirm.getContext(), "Mobile Number: " + number.getText().toString(), Toast.LENGTH_SHORT);
                        cnum.show();

                        if (ipax.isEmpty())
                        {
                            Toast cpax = Toast.makeText(confirm.getContext(), "Please input pax", Toast.LENGTH_SHORT);
                            cpax.show();
                        }
                        else
                        {
                            Toast cpax = Toast.makeText(confirm.getContext(), "Pax: " + pax.getText().toString(), Toast.LENGTH_SHORT);
                            cpax.show();

                            Toast cdatetime = Toast.makeText(confirm.getContext(), "Date: " + date.getDayOfMonth() + "/" + (date.getMonth()+1) +"/" + date.getYear() + "\nTime: " + time.getHour() + ":" + time.getMinute(), Toast.LENGTH_SHORT);
                            cdatetime.show();

                            int checkedRadioId = area.getCheckedRadioButtonId();
                            if(checkedRadioId == R.id.nonSmoke){
                                Toast carea = Toast.makeText(confirm.getContext(), "Table Area: Non-Smoking Area", Toast.LENGTH_SHORT);
                                carea.show();


                            }
                            else if (checkedRadioId == R.id.smoke){
                                Toast carea = Toast.makeText(confirm.getContext(), "Table Area: Smoking Area", Toast.LENGTH_SHORT);
                                carea.show();
                            }
                        }
                    }

                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                number.setText("");
                pax.setText("");
                time.setHour(19);
                time.setMinute(30);
                date.updateDate(2020,5,1);
            }
        });

        // sets the Scenario 1: Restrict the reservation time to only between 8AM and 8:59PM inclusive.
        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                if ((time.getHour() > 20))
                {
                    time.setHour(20);
                } else if (time.getHour() < 8)
                {
                    time.setHour(8);
                }
            }
        });

    }
}