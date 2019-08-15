package com.company;

public class Assalariado extends Funcionario {

    public Assalariado(String nome, String endereco)
    {
        super(nome, endereco);
        System.out.println("Funcionário é do tipo Assalariado!");
        Exception exc = new FPexc();
        Salario novo = new Salario();
        System.out.println("Digite o salário mensal: ");
        novo.setSalmen(exc.loaddouble());
        super.setSalario(novo);
    }

    public Assalariado(int ID, String nome, String endereco)
    {
        super(ID, nome, endereco);
        System.out.println("Funcionário é do tipo Assalariado!");
        Exception exc = new FPexc();
        Salario novo = new Salario();
        System.out.println("Digite o salário mensal: ");
        novo.setSalhor(exc.loaddouble());
        super.setSalario(novo);
    }

    @Override
    public String toString() {
        return "---------------Funcionário Assalariado---------------\n" + super.toString();
    }
}
