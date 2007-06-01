package com.lolcode;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author brianegge
 */
public class StatementWrite implements Statement {

    private List<Object> items = new ArrayList<Object>();
    private boolean visible;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void add(Object item) {
        items.add(item);
    }

    public int execute(Runtime runtime) {
        PrintStream stream = visible ? runtime.out() : runtime.err();
        for (Object item : items) {
            Object o;
            if (item instanceof Token) {
                Token t = (Token) item;
                o = runtime.variables.get(t.image);
            } else {
                o = item;
            }
            if (visible) {
                stream.print(o);
            } else {
                stream.print(o);
            }
        }
        stream.println();
        return 0;
    }
}
