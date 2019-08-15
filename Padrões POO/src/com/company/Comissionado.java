package com.company;

public class Comissionado extends Funcionario {

    public Comissionado(String nome, String endereco)
    {
        super(nome, endereco);
        System.out.println("Funcionário é do tipo Comissionado!");
        Exception exc = new FPexc();
        Salario novo = new Salario();
        System.out.println("Digite o salário mensal: ");
        novo.setSalhor(exc.loaddouble());
        System.out.println("Digite a comissão: ");
        novo.setComis(exc.loaddouble());
        super.setSalario(novo);
    }

    public Comissionado(int ID, String nome, String endereco)
    {
        super(ID, nome, endereco);
        System.out.println("Funcionário é do tipo Comissionado!");
        Exception exc = new FPexc();
        Salario novo = new Salario();
        System.out.println("Digite o salário mensal: ");
        novo.setSalhor(exc.loaddouble());
        System.out.println("Digite a comissão: ");
        novo.setComis(exc.loaddouble());
        super.setSalario(novo);
    }



    @Override
    public String toString() {
        return "---------------Funcionário Comissionado---------------\n" + super.toString();
    }
}
