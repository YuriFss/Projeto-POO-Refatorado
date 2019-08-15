package com.Strategy;

import com.company.Funcoes;

public class MenuOption0 implements MenuOption{

    @Override
    public void option() {
        System.out.print("Opção [Sair] selecionada!\n");
        System.exit(0);
    }
}
