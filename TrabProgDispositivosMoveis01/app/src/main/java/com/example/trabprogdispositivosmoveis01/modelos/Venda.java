package com.example.trabprogdispositivosmoveis01.modelos;

import java.util.ArrayList;

public class Venda {


    private Cliente cliente;
    private ProdutoCadastro produto;
    private double quantidade;
    private double vlUnitario;
    private int numParcelas;
    private int tipoPagamento;

    public Venda() {
    }

    public Venda(Cliente cliente, ProdutoCadastro produto, double quantidade, double vlUnitario, int numParcelas, int tipoPagamento) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.vlUnitario = vlUnitario;
        this.numParcelas = numParcelas;
        this.tipoPagamento = tipoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ProdutoCadastro getProduto() {
        return produto;
    }

    public void setProduto(ProdutoCadastro produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getVlUnitario() {
        return vlUnitario;
    }

    public void setVlUnitario(double vlUnitario) {
        this.vlUnitario = vlUnitario;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public int getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
