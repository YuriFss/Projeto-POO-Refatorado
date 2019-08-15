package com.company;

public class Horista extends Funcionario{

    public Horista(String nome, String endereco)
    {
        super(nome, endereco);
        System.out.println("Funcionário é do tipo Horista!");
        Exception exc = new FPexc();
        Salario novo = new Salario();
        System.out.println("Digite o salário hora: ");
        novo.setSalhor(exc.loaddouble());
        super.setSalario(novo);
    }

    public Horista(int ID, String nome, String endereco)
    {
        super(ID, nome, endereco);
        System.out.println("Funcionário é do tipo Horista!");
        Exception exc = new FPexc();
        Salario novo = new Salario();
        System.out.println("Digite o salário hora: ");
        novo.setSalhor(exc.loaddouble());
        super.setSalario(novo);
    }
    @Override
    public String toString() {
        return "---------------Funcionário Horista---------------\n" + super.toString();
    }

}