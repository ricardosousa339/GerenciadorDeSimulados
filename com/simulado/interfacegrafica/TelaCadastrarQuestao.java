package com.simulado.interfacegrafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaCadastrarQuestao extends JFrame {

    private JPanel panelPrincipal;
    private JTextField txtFieldAssunto;
    private JComboBox tipoQuestao;
    private JButton buttonOk;
    private JLabel texto;

    //array para teste apenas
    String [] assuntos = {"Geografia", "Física", "Ciências"};

    GridBagConstraints posicoes;

    public TelaCadastrarQuestao(){

        //inicialização de todos os componentes possíveis
        panelPrincipal = new JPanel(new FlowLayout());
        texto = new JLabel("Assunto");
        txtFieldAssunto = new JTextField(20);
        tipoQuestao = new JComboBox(assuntos);
        buttonOk = new JButton("OK");

        txtFieldAssunto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        txtFieldAssunto.setSize(100,20);

        panelPrincipal.add(txtFieldAssunto);
        panelPrincipal.add(tipoQuestao);
        panelPrincipal.add(buttonOk);

        add(panelPrincipal);

        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarQuestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
