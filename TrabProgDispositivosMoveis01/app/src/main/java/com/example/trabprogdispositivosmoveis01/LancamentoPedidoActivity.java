package com.example.trabprogdispositivosmoveis01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.trabprogdispositivosmoveis01.modelos.Cliente;
import com.example.trabprogdispositivosmoveis01.modelos.ProdutoCadastro;
import com.example.trabprogdispositivosmoveis01.modelos.ProdutoLancamento;

import java.util.ArrayList;
import java.util.Random;

public class LancamentoPedidoActivity extends AppCompatActivity {
    private ArrayList<Cliente> listaCliente;
    private ArrayList<ProdutoCadastro> listaProduto;
    private ArrayList<ProdutoLancamento> listaProdutoLanc;
    private Spinner spCliente;
    private Spinner spProduto;

    private TextView tvRetornaItens;
    private TextView tvRetornaQtdItens;
    private TextView tvRetornaTotalProd;
    private TextView tvRetornaParcela;
    private TextView tvRetornaTotalFinal;
    private TextView tvRetornaCodigo;

    private EditText edQuantProd;
    private EditText edValorProd;
    private EditText edQtdParcela;

    private ImageButton btAddProd;
    private ImageButton btCancela ;
    private ImageButton btFinaliza;

    private RadioButton rbVista;
    private RadioButton rbPrazo;
    private RadioGroup rgTipoPag;

    private TextView tvErroProduto;
    private TextView tvErroCliente;

    private int posicaoSelecionada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento);

        spCliente = findViewById(R.id.spCliente);
        spProduto = findViewById(R.id.spProduto);
        edQuantProd = findViewById(R.id.edQuantProd);
        edValorProd = findViewById(R.id.edValorProd);

        btCancela = findViewById(R.id.btCancela);
        btAddProd = findViewById(R.id.btAddProd);
        tvRetornaItens = findViewById(R.id.tvRetornaItens);
        tvRetornaQtdItens = findViewById(R.id.tvRetornaQtdItens);

        tvRetornaTotalProd = findViewById(R.id.tvRetornaTotalProd);
        rbVista = findViewById(R.id.rbVista);
        rbPrazo = findViewById(R.id.rbPrazo);
        edQtdParcela = findViewById(R.id.edQtdParcela);

        tvRetornaParcela = findViewById(R.id.tvRetornaParcela);
        tvRetornaTotalFinal = findViewById(R.id.tvRetornaTotalFinal);
        btFinaliza = findViewById(R.id.btFinaliza);

        tvErroCliente = findViewById(R.id.tvErroCliente);
        tvErroProduto = findViewById(R.id.tvErroProduto);
        tvRetornaCodigo = findViewById(R.id.tvRetornaCodigo);
        rgTipoPag = findViewById(R.id.rgTipoPag);


        carregaCliente();
        carregaProduto();

        spCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
            if(posicao > 0){
                posicaoSelecionada = posicao;
                tvErroCliente.setVisibility(View.GONE);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
        });


        spProduto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView,
                                   View view, int posicao, long l) {
            if(posicao > 0){
                posicaoSelecionada = posicao;
                tvErroProduto.setVisibility(View.GONE);
                exibeValorUnitario();


            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

        });





        btAddProd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            adicionarItemVenda();

        }
        });

        btFinaliza.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //finalizaVenda();
        }


        });
        gerarCod();
        }

    private void gerarCod() {
        int cod = new Random().nextInt(100);
        tvRetornaCodigo.setText((""+cod));
    }

    private void carregaCliente() {
        listaCliente = Controller.getInstancia().retornarCliente();
        String[]vetCli = new String[listaCliente.size() + 1];
        vetCli[0] = "Selecione o Cliente";
        for (int i = 0; i < listaCliente.size(); i++) {
            Cliente cliente1 = listaCliente.get(i);
            vetCli[i+1] = cliente1.getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter(
                LancamentoPedidoActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vetCli);

        spCliente.setAdapter(adapter);

    }



    /* Carrega Produto */
    private void carregaProduto() {
        listaProduto = Controller.getInstancia().retornaProdutoCadastro();
        String[]vetProd = new String[listaProduto.size() + 1];
        vetProd[0] = "Selecione o produto";
        for (int i = 0; i < listaProduto.size(); i++) {
            ProdutoCadastro produto1 = listaProduto.get(i);
            vetProd[i+1] = produto1.getItem()+" - "+produto1.getDescricao();
        }
        ArrayAdapter adapter = new ArrayAdapter(
                LancamentoPedidoActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vetProd);

        spProduto.setAdapter(adapter);

    }


    private void exibeValorUnitario() {
        ArrayList<ProdutoCadastro> lista = Controller.getInstancia().retornaProdutoCadastro();
        String exibeValorUni = "";
        exibeValorUni += lista.get(posicaoSelecionada -1).getValorUnit();

        edValorProd.setText(exibeValorUni);
    }


    private void atualizaListaProduto(){
        ArrayList<ProdutoLancamento> lista = Controller.getInstancia().retornarProduto();
        String texto = "";

        double vl =0;
        int count=0;


        for (ProdutoLancamento item : lista) {

            ProdutoCadastro prod = item.getProduto();

            texto += prod.getItem()+" - "+prod.getDescricao()+"\nQtd: "
                    +item.getQuantidade()+ " " +
                    "- VL Un.: "+item.getValorVenda() + "\nVL Total: "
                    +item.getValorVenda()*item.getQuantidade()+"\n";


            vl += item.getQuantidade() * item.getValorVenda();

            count += item.getQuantidade();


        }
        tvRetornaQtdItens.setText(Integer.toString(count));
        tvRetornaTotalProd.setText(Double.toString(vl));
        tvRetornaTotalFinal.setText(Double.toString(vl));

        tvRetornaItens.setText(texto);
    }






    private void adicionarItemVenda(){

        ProdutoLancamento itemPedido = new ProdutoLancamento();
        ProdutoCadastro prod = listaProduto.get(posicaoSelecionada -1);

        if(edQuantProd.getText().toString().isEmpty()){
            edQuantProd.setError("É necessario informar uma quantidade!");
            return;

        }
        if (edQuantProd.getText().toString().equals("0")) {
        edQuantProd.setError("A quantidade informada não pode ser igual a 0 ou menor que 0!");
        return;
        }
        if(edQuantProd.getText().toString().contains("-")){
            edQuantProd.setError("Não e possivel adicionarcom quantidade negativa!");
            return;

        }
        if(edValorProd.getText().toString().isEmpty()){
            edValorProd.setError("Valor do produto não pode estar em Branco!");
            return;
        }
        if(edValorProd.getText().toString().equals("0")){
            edValorProd.setError("Valor unitario zerado!");
            return;
        }
        if(edValorProd.getText().toString().contains("-")){
            edValorProd.setError("Valor unitario Negativo!");
            return;
        }

        itemPedido.setProduto(prod);
        itemPedido.setQuantidade(Integer.parseInt(edQuantProd.getText().toString()));
        itemPedido.setValorVenda(Double.parseDouble(edValorProd.getText().toString()));

        Controller.getInstancia().salvarProduto(itemPedido);

        atualizaListaProduto();
        edQuantProd.setText("");
        edValorProd.setText("");
    }



}