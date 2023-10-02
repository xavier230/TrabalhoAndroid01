package com.example.trabprogdispositivosmoveis01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabprogdispositivosmoveis01.modelos.ProdutoCadastro;

import java.util.Random;

public class CadastroProdutoActivity extends AppCompatActivity {


    private EditText edCod;
    private EditText edDescricao;
    private EditText edValorProduto;

    private Button btSalvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);


        edCod = findViewById(R.id.edCod);
        edDescricao = findViewById(R.id.edDescricao);
        edValorProduto = findViewById(R.id.edValorProduto);
        btSalvar = findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ salvarProduto();}
         });
    }
    private void salvarProduto(){
        if(edCod.getText().toString().isEmpty()){
            edCod.setError("Informe o codigo do cliente");
            return;

        }
        if(edCod.getText().toString().length() > 10){
            edCod.setError("Limite de caracteres atingido ");
            return;
        }
        if(edDescricao.getText().toString().isEmpty()){
            edDescricao.setError("Informe a descrição do produto");
            return;
        }
        if(edValorProduto.getText().toString().isEmpty()){
            edValorProduto.setError("Informe o valor unitario");
            return;
        }

       ProdutoCadastro prod = new ProdutoCadastro();

        prod.setItem(edCod.getText().toString());

        prod.setDescricao(edDescricao.getText().toString());

        prod.setValorUnit(Double.parseDouble(edValorProduto.getText().toString()));

        Controller.getInstancia().salvarCadastroProduto(prod);

        Toast.makeText(CadastroProdutoActivity.this,"Produto cadastrado com sucesso",
        Toast.LENGTH_LONG).show();

        this.finish();
    }
    private void geraCodigo(){

        int cod = new Random().nextInt(1000);
        edCod.setText(""+cod);
    }
}
