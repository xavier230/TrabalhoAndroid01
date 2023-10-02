package com.example.trabprogdispositivosmoveis01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btCriarPedido;
    private Button btCadastrarCliente;
    private Button btCadastrarProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btCriarPedido = findViewById(R.id.btCriarPedido);
        btCadastrarCliente = findViewById(R.id.btCadastrarCliente);
        btCadastrarProduto = findViewById(R.id.btCadastrarProduto);


        btCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroClienteActivity.class);
            }
        });
        btCriarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                abrirActivity(LancamentoPedidoActivity.class);
            }

        });
        btCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroProdutoActivity.class);
            }
        });
    }
        private void abrirActivity(Class<?> activity) {
            Intent intent = new Intent(MainActivity.this,
                    activity);
            startActivity(intent);
        }

}