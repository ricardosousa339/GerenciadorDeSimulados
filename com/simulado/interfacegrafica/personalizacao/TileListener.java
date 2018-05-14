package com.simulado.interfacegrafica.personalizacao;

import com.simulado.interfacegrafica.TelaCadastrarQuestao;
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
    JLabel rotulo;
    public static Color estadoPadrao = new Color(239, 239, 239);
    public static Color clicado = new Color(115, 0, 0);
    public static Color semClicar = new Color(177, 0, 0);

    public TileListener(String id, JPanel tile, JLabel rotulo){
        this.id = id;
        this.content = tile;
        this.rotulo = rotulo;
    }

    public void mouseClicked(MouseEvent arg0) {
        JDialog quick = new JDialog();
        quick.add(new JLabel("Tile "+ id +" Clicado"));
        quick.setSize(400,200);
        quick.setVisible(true);

    }// evento q sera executado caso o mouse click no label
    public void mouseEntered(MouseEvent arg0) {
        content.setBackground(semClicar);
        rotulo.setForeground(Color.WHITE);
        if(id.equals("Cadastrar")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("cadastrar_icon_white.png")));
        }
        else if(id.equals("Listar")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("listar_icon_white.png")));
        }
        else if(id.equals("ListarPorAssuntos")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("listar_assuntos_icon_white.png")));
        }
        else if(id.equals("Buscar")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("buscar_icon_white.png")));
        }
        else if(id.equals("CadastrarAssuntos")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("cadastrar_icon_white.png")));
        }
        else if(id.equals("ListarAssuntos")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("listar_assuntos_icon_white.png")));

        }
        else if(id.equals("GerarFormulario")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("formulario_icon_white.png")));

        }
        else if(id.equals("GerarProva")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("prova_icon_white.png")));

        }
        else if(id.equals("GerarTxt")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("txt_icon_white.png")));

        }
        else if(id.equals("EnviarEmail")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("email_icon_white.png")));

        }
    }// evento q sera executado caso o mouse entre no label
    public void mouseExited(MouseEvent arg0) {
        content.setBackground(estadoPadrao);
        rotulo.setForeground(Color.BLACK);

        if(id.equals("Cadastrar")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("cadastrar_icon_black.png")));
        }
        else if(id.equals("Listar")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("listar_icon_black.png")));
        }
        else if(id.equals("ListarPorAssuntos")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("listar_assuntos_icon_black.png")));
        }
        else if(id.equals("Buscar")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("buscar_icon_black.png")));
        }
        else if(id.equals("CadastrarAssuntos")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("cadastrar_icon_black.png")));
        }
        else if(id.equals("ListarAssuntos")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("listar_assuntos_icon_black.png")));

        }
        else if(id.equals("GerarFormulario")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("formulario_icon_black.png")));

        }
        else if(id.equals("GerarProva")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("prova_icon_black.png")));

        }
        else if(id.equals("GerarTxt")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("txt_icon_black.png")));

        }
        else if(id.equals("EnviarEmail")){
            rotulo.setIcon(new ImageIcon(getClass().getResource("email_icon_black.png")));

        }
    }// evento q sera executado caso o mouse saia do label
    public void mousePressed(MouseEvent arg0) {
        content.setBackground(clicado);
        rotulo.setForeground(Color.WHITE);

    }// evento q sera executado caso o mouse seja pressionado no label
    public void mouseReleased(MouseEvent arg0) {

    }// evento q sera executado caso o mouse seja largado no label
}
