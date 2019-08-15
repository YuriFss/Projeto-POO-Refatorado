package com.Strategy;

import com.company.Funcoes;

public class MenuOption6  implements MenuOption{
    @Override
    public void option() {
        System.out.print("Opção [Alterar detalhes de um empregado] selecionada!\n");
        Funcoes.editFunc();
    }
}
