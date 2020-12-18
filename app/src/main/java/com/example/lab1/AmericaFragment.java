package com.example.lab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Fragment;

public class AmericaFragment extends Fragment implements View.OnClickListener  {

    String[] currencies_am = {"Аргентинське песо ARS", "Бразильський реал BRL", "Чилійське песо CLP", "Панамський бальбоа PAB", "Ямайський долар JMD"};

    TextView result_field_am;
    TextView amount_input_am;

    String from_currency_am = "";
    String to_currency_am = "";


    public Button convert_am_button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.america_fragment, container, false);



        convert_am_button = (Button) view.findViewById(R.id.convert_am_button);
        convert_am_button.setOnClickListener((View.OnClickListener) this);


        result_field_am = (EditText) view.findViewById(R.id.result_field_am);
        amount_input_am = (EditText)view.findViewById(R.id.amount_input_am);


        Spinner spinner_from_am = (Spinner) view.findViewById(R.id.currencies_from_spinner_am);
        spinner_from_am.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, currencies_am));

        Spinner spinner_to_am = (Spinner) view.findViewById(R.id.currencies_to_spinner_am);
        spinner_to_am.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, currencies_am));


        spinner_from_am.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                from_currency_am = spinner_from_am.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) { }
        });

        spinner_to_am.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                to_currency_am = spinner_from_am.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });

        return view;
    }

    @Override
    public void onClick(View v)
    {
        onOperationClick_am(v);
    }

    public void onOperationClick_am(View view){

        String amount = amount_input_am.getText().toString();
        if(amount.length()>0){
            try{
                performOperation_am(Double.valueOf(amount));
            }catch (NumberFormatException ex){
                amount_input_am.setText("");
            }
        }
    }


    private void performOperation_am(double amount){
        double result = 0;

        if (from_currency_am == "Аргентинське песо ARS" && to_currency_am =="Аргентинське песо ARS"){
            result = amount;
        }
        else if (from_currency_am == "Аргентинське песо ARS" && to_currency_am =="Бразильський реал BRL"){
            result = amount * 0.062;
        }
        else if (from_currency_am == "Аргентинське песо ARS" && to_currency_am =="Чилійське песо CLP"){
            result = amount * 8.93;
        }
        else if (from_currency_am == "Аргентинське песо ARS" && to_currency_am =="Панамський бальбоа PAB"){
            result = amount * 0.012;
        }
        else if (from_currency_am == "Аргентинське песо ARS" && to_currency_am =="Ямайський долар JMD"){
            result = amount * 1.74;
        }


        else if (from_currency_am == "Бразильський реал BRL" && to_currency_am =="Аргентинське песо ARS"){
            result = amount * 16.23;
        }
        else if (from_currency_am == "Бразильський реал BRL" && to_currency_am =="Бразильський реал BRL"){
            result = amount;
        }
        else if (from_currency_am == "Бразильський реал BRL" && to_currency_am =="Чилійське песо CLP"){
            result = amount * 144.85;
        }
        else if (from_currency_am == "Бразильський реал BRL" && to_currency_am =="Панамський бальбоа PAB"){
            result = amount * 0.2;
        }
        else if (from_currency_am == "Бразильський реал BRL" && to_currency_am =="Ямайський долар JMD"){
            result = amount * 28.2;
        }


        else if (from_currency_am == "Чилійське песо CLP" && to_currency_am =="Аргентинське песо ARS"){
            result = amount * 0.11;
        }
        else if (from_currency_am == "Чилійське песо CLP" && to_currency_am =="Бразильський реал BRL"){
            result = amount * 0.0069;
        }
        else if (from_currency_am == "Чилійське песо CLP" && to_currency_am =="Чилійське песо CLP"){
            result = amount;
        }
        else if (from_currency_am == "Чилійське песо CLP" && to_currency_am =="Панамський бальбоа PAB"){
            result = amount * 0.0014;
        }
        else if (from_currency_am == "Чилійське песо CLP" && to_currency_am =="Ямайський долар JMD"){
            result = amount * 0.19;
        }


        else if (from_currency_am == "Панамський бальбоа PAB" && to_currency_am =="Аргентинське песо ARS"){
            result = amount * 82.49;
        }
        else if (from_currency_am == "Панамський бальбоа PAB" && to_currency_am =="Бразильський реал BRL"){
            result = amount * 5.08;
        }
        else if (from_currency_am == "Панамський бальбоа PAB" && to_currency_am =="Чилійське песо CLP"){
            result = amount * 736.27;
        }
        else if (from_currency_am == "Панамський бальбоа PAB" && to_currency_am =="Панамський бальбоа PAB"){
            result = amount;
        }
        else if (from_currency_am == "Панамський бальбоа PAB" && to_currency_am =="Ямайський долар JMD"){
            result = amount * 143.36;
        }


        else if (from_currency_am == "Ямайський долар JMD" && to_currency_am =="Аргентинське песо ARS"){
            result = amount * 0.58;
        }
        else if (from_currency_am == "Ямайський долар JMD" && to_currency_am =="Бразильський реал BRL"){
            result = amount * 0.035;
        }
        else if (from_currency_am == "Ямайський долар JMD" && to_currency_am =="Чилійське песо CLP"){
            result = amount * 5.14;
        }
        else if (from_currency_am == "Ямайський долар JMD" && to_currency_am =="Панамський бальбоа PAB"){
            result = amount * 0.0070;
        }
        else if (from_currency_am == "Ямайський долар JMD" && to_currency_am =="Ямайський долар JMD"){
            result = amount;
        }

        result_field_am.setText(Double.toString(result));

    };
}


