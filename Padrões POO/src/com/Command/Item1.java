package com.Command;

public class Item1 implements Command {
    @Override
    public void print(int sem, int dia) {
        System.out.println(sem + " Semana | " + dia + " - Segunda.\n");
    }
}
