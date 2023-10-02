package com.example.trabprogdispositivosmoveis01.modelos;

public class ProdutoLancamento {

    private int codigoP;
    private ProdutoCadastro produto;
    private int quantidade;
    private double valorVenda;

    public ProdutoLancamento() {
    }

    public ProdutoLancamento(int codigoP, ProdutoCadastro produto, int quantidade, double valorVenda) {
        this.codigoP = codigoP;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

    public ProdutoCadastro getProduto() {
        return produto;
    }

    public void setProduto(ProdutoCadastro produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
