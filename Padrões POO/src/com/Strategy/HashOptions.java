package com.Strategy;

import java.util.HashMap;
import java.util.Map;

public class HashOptions {
    public static Map<String, MenuOption> strat = new HashMap<String, MenuOption>();

    static
    {
        strat.put("0", new MenuOption0());
        strat.put("1", new MenuOption1());
        strat.put("2", new MenuOption2());
        strat.put("3", new MenuOption3());
        strat.put("4", new MenuOption4());
        strat.put("5", new MenuOption5());
        strat.put("6", new MenuOption6());
        strat.put("7", new MenuOption7());
        strat.put("8", new MenuOption8());
        strat.put("9", new MenuOption9());
        strat.put("10", new MenuOption10());
        strat.put("11", new MenuOption11());
    }

    public MenuOption item(String option)
    {
        return strat.get(option);
    }
}
