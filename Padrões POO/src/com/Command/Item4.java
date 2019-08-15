package com.Command;

public class Item4 implements Command{
    @Override
    public void print(int sem, int dia) {
        System.out.println(sem + " Semana | " + dia + " - Quinta.\n");
    }
}
