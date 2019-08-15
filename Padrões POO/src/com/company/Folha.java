package com.company;

import java.util.ArrayList;

public class Folha {
    ArrayList<Funcionario> ListaFuncionarios = new ArrayList<Funcionario>();
    int dia = 1;

    public ArrayList<Funcionario> getListaFuncionarios() {
        return ListaFuncionarios;
    }

    public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
        ListaFuncionarios = listaFuncionarios;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
