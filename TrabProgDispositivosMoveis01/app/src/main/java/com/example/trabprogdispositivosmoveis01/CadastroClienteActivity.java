package com.example.trabprogdispositivosmoveis01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabprogdispositivosmoveis01.modelos.Cliente;

public class CadastroClienteActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edCpf;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);


        edNome = findViewById(R.id.edNome);
        edCpf = findViewById(R.id.edCpf);
        btSalvar = findViewById(R.id.btSalvar);


        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCliente();
            }
        });
    }


            private void salvarCliente() {

                if(edNome.getText().toString().isEmpty()){
                    edNome.setError("Informe o nome do cliente!!");
                    return;

                }
                if(edCpf.getText().toString().isEmpty()){
                    edCpf.setError("Informe o cpf do cliente!!");
                    return;

                }
                Cliente cliente = new  Cliente();
                cliente.setNome(edNome.getText().toString());
                cliente.setCpf(edCpf.getText().toString());


                Controller.getInstancia().salvarCliente(cliente);

                Toast.makeText(CadastroClienteActivity.this,
                        "Cliente Cadastrado com Sucesso!!!",
                        Toast.LENGTH_LONG).show();


                this.finish();
                edNome.setText("");
                edCpf.setText("");
            }








}