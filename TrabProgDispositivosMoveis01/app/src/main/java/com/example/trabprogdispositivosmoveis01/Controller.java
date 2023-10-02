package com.example.trabprogdispositivosmoveis01;

import com.example.trabprogdispositivosmoveis01.modelos.Cliente;
import com.example.trabprogdispositivosmoveis01.modelos.ProdutoCadastro;
import com.example.trabprogdispositivosmoveis01.modelos.ProdutoLancamento;
import com.example.trabprogdispositivosmoveis01.modelos.Venda;

import java.util.ArrayList;

public class Controller {

    private static Controller instancia;
    private ArrayList<Cliente> listCliente;
    private ArrayList<ProdutoCadastro> listProdutoCadastro;
    private ArrayList<Venda> listVendas;
    private ArrayList<ProdutoLancamento> listProduto;


    public static Controller getInstancia() {
        if (instancia == null) {
            return instancia = new Controller();
        } else {
            return instancia;
        }
    }
    private Controller(){
            listCliente = new ArrayList<>();
            listProdutoCadastro = new ArrayList<>();
            listProduto = new ArrayList<>();
            listVendas = new ArrayList<>();
        }

    public void salvarCliente(Cliente clinte){

        listCliente.add(clinte);}

    public ArrayList<Cliente> retornarCliente(){

        return listCliente;
    }

    public void salvarCadastroProduto(ProdutoCadastro produto){
        listProdutoCadastro.add(produto);}

    public ArrayList<ProdutoCadastro> retornaProdutoCadastro(){
        return listProdutoCadastro;}

    public void salvarProduto(ProdutoLancamento produtos){
        listProduto.add(produtos);}

    public ArrayList<ProdutoLancamento> retornarProduto(){
        return listProduto;}

    public void salvarVenda(Venda venda){
        listVendas.add(venda);}
    public ArrayList<Venda> retornaVenda(){
        return listVendas;

    }




}
