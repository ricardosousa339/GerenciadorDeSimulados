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

    String opcoes[] = {"Questões", "Assuntos", "Gerar", "Enviar"};

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
    private Color azulSuperClaro;

    //card layout usado para as trocas de tela no inicio
    private CardLayout cartoes;
    private GridBagConstraints posicoes;

    private Font fonteTiles;

    public TelaInicial(){

        setLayout(new BorderLayout());

        //inicializacao de todos os componentes possiveis
        azulEscuro = new Color(0, 53, 101);
        azulSuperClaro = new Color(207, 225, 224);

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

        //a JList e inicializada com o array de String opcoes
        listMenu = new JList(opcoes);

        //a borda da lista e configurada
        listMenu.setBorder(new EmptyBorder(25,10,0,0));
        //o metodo setCellRenderer recebe um objeto da classe que foi criada especificamente para isso, ela personaliza as celulas do JList como se fossem um JLabel
        listMenu.setCellRenderer(new ColoredCellRenderer());
        //o JPanel da esquerda recebe a lista
        menuEsquerda.add(listMenu);
        menuEsquerda.setBackground(azulEscuro);
        listMenu.setBackground(azulEscuro);
        listMenu.setFixedCellWidth(140);
        listMenu.setFixedCellHeight(35);

        cartoes = (CardLayout) principalDireita.getLayout();

        //metodos que configuram os tiles de cada tela
        iniciaTelaQuestoes();
        iniciaTelaAssuntos();
        iniciaTelaGerar();
        iniciaTelaEnviar();

        //chama os listeners
        listeners();

        //as telas sao adicionadas ao cardlayout com um identificador que permite que sejam chamadas depois
        principalDireita.add("Questoes",telaQuestoes);
        principalDireita.add("Assuntos", telaAssuntos);
        principalDireita.add("Gerar", telaGerar);
        principalDireita.add("Enviar", telaEnviar);
        //o listener da lista que muda a tela de acordo com a opcao clicada
        telaQuestoes.setBackground(new Color(230, 230, 230));
        telaAssuntos.setBackground(new Color(230, 230, 230));
        telaGerar.setBackground(new Color(230, 230, 230));
        telaEnviar.setBackground(new Color(230, 230, 230));
        add(menuEsquerda,BorderLayout.WEST);
        add(principalDireita, BorderLayout.CENTER);

        this.setIconImage(new ImageIcon(getClass().getResource("passed-exam.png")).getImage());
        setTitle("Gerenciador de Simulados");
        setSize(900,600);
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

    public void iniciaTelaQuestoes(){

        //um JLabel com apenas imagem e adicionado ao tile
        tileCadastrar.add(new JLabel(new ImageIcon(getClass().getResource("cadastrar_icon_white.png"))), BorderLayout.CENTER);
        //o tile com o texto e configurado
        JLabel cadastrar = new JLabel("Cadastrar");
        //outra classe criada e chamada, para identificar o clique, a TileListener. O construtor dela recebe o nome do tile sendo clicado, para identifica-lo
        tileCadastrar.addMouseListener(new TileListener("Cadastrar", tileCadastrar));
        cadastrar.setFont(fonteTiles);
        cadastrar.setForeground(Color.WHITE);
        cadastrar.setBorder(new EmptyBorder(10,25,0,0));
        tileCadastrar.add(cadastrar, BorderLayout.SOUTH);
        tileCadastrar.setBorder(new EmptyBorder(15,30,15,30));

        //o mesmo e feito nos outros tiles
        tileListar.add(new JLabel(new ImageIcon(getClass().getResource("listar_icon_white.png"))), BorderLayout.CENTER);
        tileListar.addMouseListener(new TileListener("Listar", tileListar));
        JLabel listar = new JLabel("Listar");
        listar.setFont(fonteTiles);
        listar.setForeground(Color.WHITE);
        listar.setBorder(new EmptyBorder(10,0,0,0));
        tileListar.add(listar,BorderLayout.SOUTH);
        tileListar.setBorder(new EmptyBorder(15,50,15,50));

        tileListarPorAssunto.add(new JLabel(new ImageIcon(getClass().getResource("listar_assuntos_icon_white.png"))), BorderLayout.CENTER);
        tileListarPorAssunto.addMouseListener(new TileListener("ListarPorAssuntos", tileListarPorAssunto));
        JLabel listarPorAssunto = new JLabel("Listar por assunto");
        listarPorAssunto.setFont(fonteTiles);
        listarPorAssunto.setForeground(Color.WHITE);
        listarPorAssunto.setBorder(new EmptyBorder(10,0,0,0));
        tileListarPorAssunto.add(listarPorAssunto, BorderLayout.SOUTH);
        tileListarPorAssunto.setBorder(new EmptyBorder(15,30,15,30));

        tileBuscar.add(new JLabel(new ImageIcon(getClass().getResource("buscar_icon_white.png"))), BorderLayout.CENTER);
        tileBuscar.addMouseListener(new TileListener("Buscar", tileBuscar));
        JLabel buscar = new JLabel("Buscar");
        buscar.setFont(fonteTiles);
        buscar.setForeground(Color.WHITE);
        buscar.setBorder(new EmptyBorder(10,0,0,0));
        tileBuscar.add(buscar, BorderLayout.SOUTH);
        tileBuscar.setBorder(new EmptyBorder(15,50,15,50));

        //os tiles sao posicionados dentro do gribBag layout atraves do objeto do tipo GridBagConstraints posicoes
        posicoes.gridx = 0;
        posicoes.gridy = 0;
        posicoes.anchor = GridBagConstraints.NORTH;
        posicoes.fill = GridBagConstraints.BOTH;
        posicoes.insets = new Insets(10,10,10,10);

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

    public void iniciaTelaAssuntos(){

        tileCadastrarAssunto.add(new JLabel(new ImageIcon(getClass().getResource("cadastrar_icon_white.png"))), BorderLayout.CENTER);
        JLabel cadastrar = new JLabel("Cadastrar");
        tileCadastrarAssunto.addMouseListener(new TileListener("CadastrarAssuntos", tileCadastrarAssunto));
        cadastrar.setFont(fonteTiles);
        cadastrar.setForeground(Color.WHITE);
        cadastrar.setBorder(new EmptyBorder(10,0,0,0));
        tileCadastrarAssunto.add(cadastrar, BorderLayout.SOUTH);
        tileCadastrarAssunto.setBorder(new EmptyBorder(20,60,15,60));

        tileListarAssunto.add(new JLabel(new ImageIcon(getClass().getResource("listar_icon_white.png"))), BorderLayout.CENTER);
        tileListarAssunto.addMouseListener(new TileListener("ListarAssuntos", tileListarAssunto));
        JLabel listar = new JLabel("Listar");
        listar.setFont(fonteTiles);
        listar.setForeground(Color.WHITE);
        listar.setBorder(new EmptyBorder(10,0,0,0));
        tileListarAssunto.add(listar,BorderLayout.SOUTH);
        tileListarAssunto.setBorder(new EmptyBorder(20,60,15,60));

        posicoes.gridx = 0;
        posicoes.gridy = 0;
        posicoes.anchor = GridBagConstraints.NORTH;
        posicoes.fill = GridBagConstraints.HORIZONTAL;
        posicoes.insets = new Insets(10,10,10,10);

        telaAssuntos.add(tileCadastrarAssunto,posicoes);
        posicoes.gridx = 1;
        posicoes.gridy = 0;
        telaAssuntos.add(tileListarAssunto, posicoes);
        posicoes.gridx = 0;
        posicoes.gridy = 1;

        tileCadastrarAssunto.setBackground(TileListener.estadoPadrao);
        tileListarAssunto.setBackground(TileListener.estadoPadrao);

    }

    public void iniciaTelaGerar(){
        tileGerarFormulario.add(new JLabel(new ImageIcon(getClass().getResource("formulario_icon_white.png"))), BorderLayout.CENTER);
        JLabel gerarFormulario = new JLabel("Gerar formulário");
        tileGerarFormulario.addMouseListener(new TileListener("GerarFormulario", tileGerarFormulario));
        gerarFormulario.setFont(fonteTiles);
        gerarFormulario.setForeground(Color.WHITE);
        gerarFormulario.setBorder(new EmptyBorder(10,0,0,0));
        tileGerarFormulario.add(gerarFormulario, BorderLayout.SOUTH);
        tileGerarFormulario.setBorder(new EmptyBorder(20,40,15,40));

        tileGerarProva.add(new JLabel(new ImageIcon(getClass().getResource("prova_icon_white.png"))), BorderLayout.CENTER);
        JLabel gerarProva = new JLabel("Gerar prova");
        tileGerarProva.addMouseListener(new TileListener("GerarProva", tileGerarProva));
        gerarProva.setFont(fonteTiles);
        gerarProva.setForeground(Color.WHITE);
        gerarProva.setBorder(new EmptyBorder(10,0,0,0));
        tileGerarProva.add(gerarProva, BorderLayout.SOUTH);
        tileGerarProva.setBorder(new EmptyBorder(20,40,15,40));

        tileGerarTXT.add(new JLabel(new ImageIcon(getClass().getResource("txt_icon_white.png"))), BorderLayout.CENTER);
        JLabel gerarTxt = new JLabel("Gerar txt");
        tileGerarTXT.addMouseListener(new TileListener("GerarTxt", tileGerarTXT));
        gerarTxt.setFont(fonteTiles);
        gerarTxt.setForeground(Color.WHITE);
        gerarTxt.setBorder(new EmptyBorder(10,0,0,0));
        tileGerarTXT.add(gerarTxt, BorderLayout.SOUTH);
        tileGerarTXT.setBorder(new EmptyBorder(20,40,15,40));

        tileGerarProva.setBackground(TileListener.estadoPadrao);
        tileGerarFormulario.setBackground(TileListener.estadoPadrao);
        tileGerarTXT.setBackground(TileListener.estadoPadrao);

        posicoes.gridx = 0;
        posicoes.gridy = 0;
        posicoes.anchor = GridBagConstraints.NORTH;
        posicoes.fill = GridBagConstraints.HORIZONTAL;
        posicoes.insets = new Insets(10,10,10,10);

        telaGerar.add(tileGerarFormulario,posicoes);
        posicoes.gridx = 1;
        posicoes.gridy = 0;
        telaGerar.add(tileGerarProva, posicoes);
        posicoes.gridx = 0;
        posicoes.gridy = 1;
        telaGerar.add(tileGerarTXT, posicoes);
    }

    public void iniciaTelaEnviar(){
        tileEnviarEmail.add(new JLabel(new ImageIcon(getClass().getResource("email_icon_white.png"))), BorderLayout.CENTER);
        JLabel enviarEmail = new JLabel("Enviar por email");
        tileEnviarEmail.addMouseListener(new TileListener("EnviarEmail", tileEnviarEmail));
        enviarEmail.setFont(fonteTiles);
        enviarEmail.setForeground(Color.WHITE);
        enviarEmail.setBorder(new EmptyBorder(10,0,0,0));
        tileEnviarEmail.add(enviarEmail, BorderLayout.SOUTH);
        tileEnviarEmail.setBorder(new EmptyBorder(20,40,15,40));
        tileEnviarEmail.setBackground(TileListener.estadoPadrao);

        posicoes.gridx = 0;
        posicoes.gridy = 0;
        posicoes.anchor = GridBagConstraints.NORTH;
        posicoes.fill = GridBagConstraints.HORIZONTAL;
        posicoes.insets = new Insets(10,10,10,10);

        telaEnviar.add(tileEnviarEmail, posicoes);

    }

    public static void main(String[] args) {
        TelaInicial inicio = new TelaInicial();

    }
}


