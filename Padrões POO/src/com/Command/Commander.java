package com.Command;

import java.util.HashMap;
import java.util.Map;

public class Commander
{
    public static Map<String, Command> commander = new HashMap<String, Command>();

    static
    {
        commander.put("1", new Item1());
        commander.put("2", new Item2());
        commander.put("3", new Item3());
        commander.put("4", new Item4());
        commander.put("5", new Item5());
        commander.put("6", new Item6());

    }

    public Command command(String cmd)
    {
       return commander.get(cmd);
    }

}
