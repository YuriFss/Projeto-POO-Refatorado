package com.Strategy;

import com.company.Funcoes;

public class MenuOption2 implements MenuOption {
    @Override
    public void option() {
        System.out.print("Opção [Remover Empregado] selecionada!\n");
        Funcoes.delFuncionario();
    }
}
