package com.Strategy;

import com.company.Funcoes;

public class MenuOption9 implements MenuOption {
    @Override
    public void option() {
        System.out.print("Opção [Agenda de Pagamento] selecionada!\n");
        Funcoes.agendaPagamento();
    }
}
