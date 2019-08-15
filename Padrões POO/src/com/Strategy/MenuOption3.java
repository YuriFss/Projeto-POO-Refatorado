package com.Strategy;

import com.company.Funcoes;

public class MenuOption3 implements MenuOption{
    @Override
    public void option() {
        System.out.print("Opção [Lançar um Cartão de Ponto] selecionada!\n");
        Funcoes.lancarPonto();
    }
}
