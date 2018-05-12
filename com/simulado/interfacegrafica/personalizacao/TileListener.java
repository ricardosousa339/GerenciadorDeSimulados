package com.simulado.interfacegrafica.personalizacao;

import com.simulado.interfacegrafica.TelaInicial;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TileListener implements MouseListener {

    String id;
    JPanel content;
    public static Color estadoPadrao = new Color(0, 99, 177);
    public static Color clicado = new Color(0, 74, 148);
    public static Color semClicar = new Color(0, 115, 204);

    public TileListener(String id, JPanel tile){
        this.id = id;
        this.content = tile;
    }

    public void mouseClicked(MouseEvent arg0) {
        System.out.println("TileClicado");
        if(id.equals("Cadastrar")){
            System.out.println("Cadastrando...");
        }
        else if(id.equals("Listar")){
            System.out.println("Listando...");
        }
        else if(id.equals("ListarPorAssuntos")){
            System.out.println("Listando Assuntos...");
        }
        else if(id.equals("Buscar")){
            System.out.println("Buscando...");
        }

    }// evento q sera executado caso o mouse click no label
    public void mouseEntered(MouseEvent arg0) {
        content.setBackground(semClicar);
    }// evento q sera executado caso o mouse entre no label
    public void mouseExited(MouseEvent arg0) {
        content.setBackground(estadoPadrao);
    }// evento q sera executado caso o mouse saia do label
    public void mousePressed(MouseEvent arg0) {
        content.setBackground(clicado);
    }// evento q sera executado caso o mouse seja pressionado no label
    public void mouseReleased(MouseEvent arg0) {

    }// evento q sera executado caso o mouse seja largado no label
}
