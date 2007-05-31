package com.lolcode;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author brianegge
 */
public class StatementWrite extends Statement {

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

    public void execute(Runtime runtime) {
        PrintStream stream = visible ? runtime.out() : runtime.err();
        for (Object item : items) {
            if (visible) {
                stream.print(item);
            } else {
                stream.print(item);
            }
        }
        stream.println();
    }
}
