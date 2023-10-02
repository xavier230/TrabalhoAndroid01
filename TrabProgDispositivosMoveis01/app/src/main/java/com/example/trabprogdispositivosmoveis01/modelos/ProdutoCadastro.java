package com.example.trabprogdispositivosmoveis01.modelos;

public class ProdutoCadastro {

    private String Item;
    private String Descricao;
    private double ValorUnit;

    public ProdutoCadastro() {
    }

    public ProdutoCadastro(String item, String descricao, double valorProduto) {
        Item = item;
        Descricao = descricao;
        ValorUnit = valorProduto;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public double getValorUnit() {
        return ValorUnit;
    }

    public void setValorUnit(double valorUnit) {
        ValorUnit = valorUnit;
    }
}
