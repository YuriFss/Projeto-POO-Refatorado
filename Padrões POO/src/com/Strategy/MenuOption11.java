package com.Strategy;

import com.company.Exception;
import com.company.FPexc;
import com.company.Funcoes;

public class MenuOption11 implements MenuOption{
    @Override
    public void option() {
        Exception exc = new FPexc();
        System.out.println("Digite o ID do Funcionário: ");
        Funcoes.printFunc(exc.loadint());
    }
}
