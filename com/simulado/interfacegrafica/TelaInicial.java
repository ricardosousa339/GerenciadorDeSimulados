package com.simulado.interfacegrafica;

import com.simulado.interfacegrafica.personalizacao.ColoredCellRenderer;
import com.simulado.interfacegrafica.personalizacao.TileListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class TelaInicial extends JFrame{


    //'tile' sao os quadrados que agem como botoes, mas sao JPanel

    private JPanel tileCadastrar;
    private JPanel tileListar;
    private JPanel tileListarPorAssunto;
    private JPanel tileBuscar;

    private JPanel tileCadastrarAssunto;
    private JPanel tileListarAssunto;

    private JPanel tileGerarFormulario;
    private JPanel tileGerarProva;
    private JPanel tileGerarTXT;

    private JPanel tileEnviarEmail;

    private String opcoes[] = {"Questões", "Assuntos", "Gerar", "Enviar"};

    //'telas' sao as partes visíveis
    private JPanel menuEsquerda;    //menu que da acesso as quatro categorias de operacoes diferentes
    private JPanel principalDireita;    //parte maior onde ficam os tiles
    private JPanel telaQuestoes;    //tela referente ao primeiro botao do menu
    private JPanel telaAssuntos;    //tela referente ao segundo botao do menu
    private JPanel telaGerar;   //tela referente ao terceiro botao do menu
    private JPanel telaEnviar;  //tela referente ao quarto botao do menu
    private JList listMenu;     //a lista com as opcoes do menu

    //cores mais utilizadas no programa
    private Color azulEscuro;
    private Color rotulosTiles;

    //card layout usado para as trocas de tela no inicio
    private CardLayout cartoes;
    private GridBagConstraints posicoes;

    private EmptyBorder bordaTiles;
    private Font fonteTiles;

    public TelaInicial(){

        setLayout(new BorderLayout());

        //inicializacao de todos os componentes possiveis
        azulEscuro = new Color(0, 53, 101);
        rotulosTiles = new Color(0, 0, 0);

        menuEsquerda = new JPanel();
        tileCadastrar = new JPanel(new BorderLayout());
        tileListar = new JPanel(new BorderLayout());
        tileListarPorAssunto = new JPanel(new BorderLayout());
        tileBuscar = new JPanel(new BorderLayout());

        tileCadastrarAssunto = new JPanel(new BorderLayout());
        tileListarAssunto = new JPanel(new BorderLayout());

        tileGerarFormulario = new JPanel(new BorderLayout());
        tileGerarProva = new JPanel(new BorderLayout());
        tileGerarTXT = new JPanel(new BorderLayout());

        tileEnviarEmail = new JPanel(new BorderLayout());

        fonteTiles = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        principalDireita = new JPanel(new CardLayout());
        telaQuestoes = new JPanel(new GridBagLayout());
        telaAssuntos = new JPanel(new GridBagLayout());
        telaGerar = new JPanel(new GridBagLayout());
        telaEnviar = new JPanel(new GridBagLayout());
        posicoes = new GridBagConstraints();
        bordaTiles = new EmptyBorder(20,15,20,45);

        posicoes.gridx = 0;
        posicoes.gridy = 0;

        posicoes.anchor = GridBagConstraints.CENTER;
        posicoes.weightx = 0;
        posicoes.weighty = 0;
        posicoes.fill = GridBagConstraints.BOTH;
        posicoes.insets = new Insets(10,10,10,10);
        //a JList e inicializada com o array de String opcoes
        listMenu = new JList(opcoes);

        //a borda da lista e configurada
        listMenu.setBorder(new EmptyBorder(25,0,0,0));
        //o metodo setCellRenderer recebe um objeto da classe que foi criada especificamente para isso, ela personaliza as celulas do JList como se fossem um JLabel
        listMenu.setCellRenderer(new ColoredCellRenderer());
        //o JPanel da esquerda recebe a lista
        menuEsquerda.add(listMenu);
        menuEsquerda.setBackground(azulEscuro);
        listMenu.setBackground(azulEscuro);
        listMenu.setFixedCellWidth(150);
        listMenu.setFixedCellHeight(35);

        cartoes = (CardLayout) principalDireita.getLayout();

        //metodos que configuram os tiles de cada tela
        iniciaTelaQuestoes();
        posicoes.gridx = 0;
        posicoes.gridy = 0;
        iniciaTelaAssuntos();
        posicoes.gridx = 0;
        posicoes.gridy = 0;
        iniciaTelaGerar();
        posicoes.gridx = 0;
        posicoes.gridy = 0;
        iniciaTelaEnviar();

        //chama os listeners
        listeners();

        //as telas sao adicionadas ao cardlayout com um identificador que permite que sejam chamadas depois
        principalDireita.add("Questoes",telaQuestoes);
        principalDireita.add("Assuntos", telaAssuntos);
        principalDireita.add("Gerar", telaGerar);
        principalDireita.add("Enviar", telaEnviar);
        //o listener da lista que muda a tela de acordo com a opcao clicada
        telaQuestoes.setBackground(new Color(214, 214, 214));
        telaAssuntos.setBackground(new Color(214, 214, 214));
        telaGerar.setBackground(new Color(214, 214, 214));
        telaEnviar.setBackground(new Color(214, 214, 214));
        add(menuEsquerda,BorderLayout.WEST);
        add(principalDireita, BorderLayout.CENTER);

        this.setIconImage(new ImageIcon(getClass().getResource("passed-exam.png")).getImage());
        setTitle("Gerenciador de Simulados");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void listeners(){
        listMenu.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                switch (listMenu.getSelectedIndex()){
                    case 0: cartoes.show(principalDireita,"Questoes");break;
                    case 1: cartoes.show(principalDireita,"Assuntos");break;
                    case 2: cartoes.show(principalDireita,"Gerar");break;
                    case 3: cartoes.show(principalDireita, "Enviar");
                }
            }
        });
    }

    private void iniciaTelaQuestoes(){

        //o tile com o texto e configurado
        JLabel cadastrar = new JLabel(new ImageIcon(getClass().getResource("cadastrar_icon_black.png")));
        cadastrar.setText("Cadastrar");
        //outra classe criada e chamada, para identificar o clique, a TileListener. O construtor dela recebe o nome do tile sendo clicado, para identifica-lo
        tileCadastrar.addMouseListener(new TileListener("Cadastrar", tileCadastrar, cadastrar));
        cadastrar.setFont(fonteTiles);
        cadastrar.setForeground(rotulosTiles);
        cadastrar.setBorder(new EmptyBorder(10,25,0,0));
        tileCadastrar.add(cadastrar, BorderLayout.CENTER);
        tileCadastrar.setBorder(bordaTiles);

        //o mesmo e feito nos outros tiles
        JLabel listar = new JLabel(new ImageIcon(getClass().getResource("listar_icon_black.png")));
        tileListar.addMouseListener(new TileListener("Listar", tileListar, listar));
        listar.setText("Listar");
        listar.setFont(fonteTiles);
        listar.setForeground(rotulosTiles);
        listar.setBorder(new EmptyBorder(10,0,0,0));
        tileListar.add(listar,BorderLayout.CENTER);
        tileListar.setBorder(bordaTiles);

        JLabel listarPorAssunto = new JLabel(new ImageIcon(getClass().getResource("listar_assuntos_icon_black.png")));
        tileListarPorAssunto.addMouseListener(new TileListener("ListarPorAssuntos", tileListarPorAssunto, listarPorAssunto));
        listarPorAssunto.setText("Listar por assunto");
        listarPorAssunto.setFont(fonteTiles);
        listarPorAssunto.setForeground(rotulosTiles);
        listarPorAssunto.setBorder(new EmptyBorder(10,0,0,0));
        tileListarPorAssunto.add(listarPorAssunto, BorderLayout.CENTER);
        tileListarPorAssunto.setBorder(bordaTiles);

        JLabel buscar = new JLabel(new ImageIcon(getClass().getResource("buscar_icon_black.png")));
        tileBuscar.addMouseListener(new TileListener("Buscar", tileBuscar,buscar));
        buscar.setText("Buscar");
        buscar.setFont(fonteTiles);
        buscar.setForeground(rotulosTiles);
        buscar.setBorder(new EmptyBorder(10,0,0,0));
        tileBuscar.add(buscar, BorderLayout.CENTER);
        tileBuscar.setBorder(bordaTiles);

        //os tiles sao posicionados dentro do gribBag layout atraves do objeto do tipo GridBagConstraints posicoes

        telaQuestoes.add(tileCadastrar,posicoes);
        posicoes.gridx = 1;
        posicoes.gridy = 0;

        telaQuestoes.add(tileListar, posicoes);
        posicoes.gridx = 0;
        posicoes.gridy = 1;

        telaQuestoes.add(tileListarPorAssunto, posicoes);
        posicoes.gridx = 1;
        posicoes.gridy = 1;

        telaQuestoes.add(tileBuscar, posicoes);

        tileCadastrar.setBackground(TileListener.estadoPadrao);
        tileListar.setBackground(TileListener.estadoPadrao);
        tileListarPorAssunto.setBackground(TileListener.estadoPadrao);
        tileBuscar.setBackground(TileListener.estadoPadrao);
    }

    private void iniciaTelaAssuntos(){

        JLabel cadastrar = new JLabel(new ImageIcon(getClass().getResource("cadastrar_icon_black.png")));
        cadastrar.setText("Cadastrar");
        tileCadastrarAssunto.addMouseListener(new TileListener("CadastrarAssuntos", tileCadastrarAssunto, cadastrar));
        cadastrar.setFont(fonteTiles);
        cadastrar.setForeground(rotulosTiles);
        cadastrar.setBorder(new EmptyBorder(10,0,0,0));
        tileCadastrarAssunto.add(cadastrar, BorderLayout.CENTER);
        tileCadastrarAssunto.setBorder(bordaTiles);

        JLabel listar = new JLabel(new ImageIcon(getClass().getResource("listar_icon_black.png")));
        tileListarAssunto.addMouseListener(new TileListener("ListarAssuntos", tileListarAssunto, listar));
        listar.setText("Listar");
        listar.setFont(fonteTiles);
        listar.setForeground(rotulosTiles);
        listar.setBorder(new EmptyBorder(10,0,0,0));
        tileListarAssunto.add(listar,BorderLayout.CENTER);
        tileListarAssunto.setBorder(bordaTiles);

        telaAssuntos.add(tileCadastrarAssunto,posicoes);
        posicoes.gridx = 1;
        posicoes.gridy = 0;
        telaAssuntos.add(tileListarAssunto, posicoes);
        posicoes.gridx = 0;
        posicoes.gridy = 1;

        tileCadastrarAssunto.setBackground(TileListener.estadoPadrao);
        tileListarAssunto.setBackground(TileListener.estadoPadrao);

    }

    private void iniciaTelaGerar(){

        JLabel gerarFormulario = new JLabel(new ImageIcon(getClass().getResource("formulario_icon_black.png")));
        gerarFormulario.setText("Gerar formulário");
        tileGerarFormulario.addMouseListener(new TileListener("GerarFormulario", tileGerarFormulario, gerarFormulario));
        gerarFormulario.setFont(fonteTiles);
        gerarFormulario.setForeground(rotulosTiles);
        gerarFormulario.setBorder(new EmptyBorder(10,0,0,0));
        tileGerarFormulario.add(gerarFormulario, BorderLayout.CENTER);
        tileGerarFormulario.setBorder(bordaTiles);

        JLabel gerarProva = new JLabel(new ImageIcon(getClass().getResource("prova_icon_black.png")));
        gerarProva.setText("Gerar prova");
        tileGerarProva.addMouseListener(new TileListener("GerarProva", tileGerarProva, gerarProva));
        gerarProva.setFont(fonteTiles);
        gerarProva.setForeground(rotulosTiles);
        gerarProva.setBorder(new EmptyBorder(10,0,0,0));
        tileGerarProva.add(gerarProva, BorderLayout.CENTER);
        tileGerarProva.setBorder(bordaTiles);

        JLabel gerarTxt = new JLabel(new ImageIcon(getClass().getResource("txt_icon_black.png")));
        gerarTxt.setText("Gerar txt");
        tileGerarTXT.addMouseListener(new TileListener("GerarTxt", tileGerarTXT, gerarTxt));
        gerarTxt.setFont(fonteTiles);
        gerarTxt.setForeground(rotulosTiles);
        gerarTxt.setBorder(new EmptyBorder(10,0,0,0));
        tileGerarTXT.add(gerarTxt, BorderLayout.CENTER);
        tileGerarTXT.setBorder(bordaTiles);

        tileGerarProva.setBackground(TileListener.estadoPadrao);
        tileGerarFormulario.setBackground(TileListener.estadoPadrao);
        tileGerarTXT.setBackground(TileListener.estadoPadrao);

        telaGerar.add(tileGerarFormulario,posicoes);
        posicoes.gridx = 1;
        posicoes.gridy = 0;
        telaGerar.add(tileGerarProva, posicoes);
        posicoes.gridx = 0;
        posicoes.gridy = 1;
        posicoes.gridwidth = 2;

        telaGerar.add(tileGerarTXT, posicoes);
        posicoes.gridwidth = 1;
    }

    private void iniciaTelaEnviar(){

        bordaTiles = new EmptyBorder(10,10,10,10);
        JLabel enviarEmail = new JLabel(new ImageIcon(getClass().getResource("email_icon_black.png")));
        enviarEmail.setText("Email");
        tileEnviarEmail.addMouseListener(new TileListener("EnviarEmail", tileEnviarEmail, enviarEmail));
        enviarEmail.setFont(fonteTiles);
        enviarEmail.setForeground(rotulosTiles);
        enviarEmail.setBorder(bordaTiles);
        JTextField email = new JTextField(20);
        email.setFont(fonteTiles);
        email.setBorder(BorderFactory.createLineBorder(rotulosTiles, 1));
        JButton enviar = new JButton();
        enviar.setIcon(new ImageIcon(getClass().getResource("enviar_icon_black.png")));
        enviar.setBackground(TileListener.semClicar);
        tileEnviarEmail.add(enviarEmail, BorderLayout.NORTH);
        tileEnviarEmail.add(email, BorderLayout.CENTER);
        tileEnviarEmail.add(enviar, BorderLayout.EAST);
        tileEnviarEmail.setBorder(bordaTiles);
        tileEnviarEmail.setBackground(TileListener.estadoPadrao);

        telaEnviar.add(tileEnviarEmail, posicoes);

    }

    public static void main(String[] args) {
        TelaInicial inicio = new TelaInicial();

    }
}


