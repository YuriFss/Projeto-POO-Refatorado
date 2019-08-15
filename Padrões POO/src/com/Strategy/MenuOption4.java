package com.Strategy;

import com.company.Funcoes;

public class MenuOption4  implements MenuOption{
    @Override
    public void option() {
        System.out.print("Opção [Lançar um Resultado Venda] selecionada!\n");
        Funcoes.lancarVenda();
    }

}
