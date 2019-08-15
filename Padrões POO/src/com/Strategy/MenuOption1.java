package com.Strategy;

import com.company.Funcoes;

public class MenuOption1 implements MenuOption {
    @Override
    public void option() {
        System.out.print("Opção [Adicionar Empregado] selecionada!\n");
        Funcoes.addFuncionario();
        Funcoes.ListarFuncionarios();
    }
}
