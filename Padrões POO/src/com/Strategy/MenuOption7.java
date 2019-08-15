package com.Strategy;

import com.company.Funcoes;

public class MenuOption7 implements MenuOption
{
    @Override
    public void option() {
        System.out.print("Opção [Rodar a folha de pagamento para hoje] selecionada (finalizar expediente)!\n");
        Funcoes.zerarContabilizar();
        Funcoes.rodarFphj();
        Funcoes.folha.dia++;
        Funcoes.menu();
    }
}
