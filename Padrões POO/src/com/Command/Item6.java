package com.Command;

public class Item6 implements Command {
    @Override
    public void print(int sem, int dia) {
        System.out.println(sem + " Semana | " + dia + " - Sábado.\n");
    }
}
