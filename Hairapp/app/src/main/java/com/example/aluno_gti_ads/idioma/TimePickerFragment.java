package com.example.aluno_gti_ads.idioma;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by tiago.nakamura on 07/11/2017.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // Get a Calendar instance
        final Calendar calendar = Calendar.getInstance();
        // Get the current hour and minute
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        /*
            Creates a new time picker dialog.
                TimePickerDialog(Context context, TimePickerDialog.OnTimeSetListener listener,
                    int hourOfDay, int minute, boolean is24HourView)
         */
        // Create a TimePickerDialog with current time
        TimePickerDialog tpd = new TimePickerDialog(getActivity(),this,hour,minute,false);
        // Return the TimePickerDialog
        return tpd;
    }



    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //Feito com Format devido o horario aparecer 11:01 => 11:1
        TextView tv = (TextView) getActivity().findViewById(R.id.txtHora);
        tv.setText(String.format("%02d:%02d", hourOfDay, minute));
    }
}
