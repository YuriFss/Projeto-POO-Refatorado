package com.Strategy;

import com.company.Funcoes;

public class MenuOption5 implements MenuOption{
    @Override
    public void option() {
        System.out.print("Opção [Lançar uma taxa de serviço] selecionada!\n");
        Funcoes.lancarTaxas();
    }
}
