package com.jaipeh.mascotasapp2.Activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jaipeh.mascotasapp2.R;
import com.jaipeh.mascotasapp2.Clases.SendMail;

public class ContactoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText inputNombre;
    private TextInputEditText inputEmail;
    private TextInputEditText inputMensaje;

    private Button botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        inputNombre = (TextInputEditText) findViewById(R.id.textInputNombre);
        inputEmail = (TextInputEditText) findViewById(R.id.textInputCorreo);
        inputMensaje = (TextInputEditText) findViewById(R.id.textInputMensaje);

        botonEnviar = (Button) findViewById(R.id.buttonEnviar);

        botonEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }

    private void sendEmail() {
        //Getting content for email
        String email = inputEmail.getText().toString().trim();
        String subject = "JAIPEHSYSTEM Inc";
        String message = "Estimado " + inputNombre.getText().toString().trim() + ":\n" +  inputMensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sendMail = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sendMail.execute();
    }

}