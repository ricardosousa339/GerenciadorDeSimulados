package com.simulado.interfacegrafica.personalizacao;

import java.awt.*;

public class ColoredItem implements Colorable {
    Object  object;
    Color color;

    public ColoredItem(Object object, Color color) {
        this.object = object;
        this.color = color;
    }

    ColoredItem(Object object) {
        this(object, Color.black);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String toString() {
        return object.toString();
    }
}
