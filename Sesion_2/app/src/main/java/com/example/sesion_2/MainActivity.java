package com.example.sesion_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import Entity.Alumno;

public class MainActivity extends AppCompatActivity {

    EditText txtNom, txtApe, txtSue;
    Spinner spnCar;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNom = findViewById(R.id.idNombre);
        txtApe = findViewById(R.id.idApellido);
        txtSue = findViewById(R.id.idPension);
        spnCar = findViewById(R.id.idCarrera);




        btnEnviar = findViewById(R.id.idEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                String nom = txtNom.getText().toString();
                String ape = txtApe.getText().toString();
                String pen = txtSue.getText().toString();
                int idcar = spnCar.getSelectedItemPosition();
                String car = spnCar.getSelectedItem().toString();



                if (!nom.matches("[a-zA-Z\\sáéíóúÁÉÍÓÚnÑ]{2,30}")){

                    mensaje("Validación", "Nombre es de 2 a 30 caracteres");

                    return;

                }else if (!ape.matches("[a-zA-Z\\sáéíóúÁÉÍÓÚñÑ]{2,30}")){

                    mensaje("Validación", "Apellido es de 2 a 30 caracteres");

                    return;

                }else if (!pen.matches("([0-9]+)|[0-9]+[.][0-9]")){

                    mensaje("Validación", "Pensión es entero o real con un dígito");

                    return;

                }else if (idcar == 0){

                    mensaje("Validación", "Seleccione una carrera");

                    return;

                }else {

                    final Alumno obj = new Alumno();
                    obj.setNomnbre(nom);
                    obj.setApellido(ape);
                    obj.setPension(Double.parseDouble(pen));
                    obj.setCarrera(car);

                    String mensaje = "El alumno ingresado es : "+ "\n";

                    mensaje += "Nombre :" + obj.getNomnbre() + "\n";

                    mensaje += "Apellido :" + obj.getApellido() + "\n";

                    mensaje += "Pensión :" + obj.getPension() + "\n";

                    mensaje += "Carrera :" + obj.getCarrera();

                    mensaje("Validación ", mensaje);
                }
            }

        });

    }


    public void mensaje(String tit,String msg){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(msg);
        alert.setTitle(tit);
        alert.setCancelable(true);
        alert.show();

    }
}