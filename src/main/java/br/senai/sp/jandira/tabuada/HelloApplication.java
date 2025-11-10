package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    TextField textFieldmultiplicando = new TextField();
    TextField textFieldMaiorMultiplicador = new TextField();
    TextField textFieldMenorMultiplicado = new TextField();
    ListView listaTabuada;
    @Override
    public void start(Stage stage) throws IOException {
        //definir tamanho da tela
        stage.setWidth(800);
        stage.setHeight(600);

        //componente principal da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);


        /// /////////////////////////////////////////////////////////////
        //cabeçalho da tela
        VBox header = new VBox();
        header.setStyle("-fx-padding: 10;-fx-background-color: #0c05ff");

        //colocar label no header|| colocar label titulo dentro do header
        Label labeltitulo = new Label("Tabuada");
        labeltitulo.setStyle("-fx-text-fill: white;-fx-font-size: 30px;-fx-font-weight: bold;");
        Label labelsubTitulo = new Label("construa tabuada sem limites");
        labelsubTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 10px;");

        header.getChildren().add(labeltitulo);
        header.getChildren().add(labelsubTitulo);


        /// ////////////////////////////////////////////

        //criando um multiplicando
       // HBox multiplicandobox = new HBox();
      //  multiplicandobox.setStyle("-fx-padding: 10;-fx-background-color: #018dff");

        GridPane gridformulario = new GridPane();
        Label labelmultiplicando = new Label("Multiplicando");
        textFieldmultiplicando = new TextField();//inicia o iten do glogabal


        Label labelMenorMultiplicado = new Label("MenorMultiplicado");
        textFieldMenorMultiplicado = new TextField();

        Label labelMaiorMultiplicado = new Label("Maior Multiplicado");
        textFieldMaiorMultiplicador = new TextField();

        gridformulario.add(labelmultiplicando,0,0);
        gridformulario.add(textFieldmultiplicando,1,0);
        gridformulario.add(labelMenorMultiplicado,0,1);
        gridformulario.add(textFieldMenorMultiplicado,1,1);
        gridformulario.add(labelMaiorMultiplicado,0,2);
        gridformulario.add(textFieldMaiorMultiplicador,1,2);


        /// criar botoes
        //criar caixa
        HBox boxbotoes = new HBox();
        //criar botoes
        Button btnCalcular = new Button("calcular");
        btnCalcular.setOnAction(actionEvent -> {
            calcularTabuada();
        });

        Button btnLimpar = new Button("Limpar");
        Button btnSair = new Button("Sair");
        //por botoes na caixa dos botao
        boxbotoes.getChildren().addAll(btnCalcular,btnLimpar,btnSair);


        //adicionar component list viw
        VBox vboxResultado = new VBox(boxbotoes);
        Label labelResultado = new Label("Resultado");
        labelResultado.setStyle("-fx-text-fill: blue;-fx-font-size: 14px;-fx-font-weight: bold;");

        // adiciona listview
        listaTabuada = new ListView();

        vboxResultado.getChildren().addAll(labelResultado,listaTabuada);









        /// adiciona componentes ao root
        //coloca header no root
        root.getChildren().add(header);
        //colocar no root pra poder aparecer
        root.getChildren().add(gridformulario);
        //colocar no root
        root.getChildren().add(boxbotoes);
        root.getChildren().add(vboxResultado);

///  /////////////////////////////////////////////////////////////////////////////////
        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.show();

    }

    public void calcularTabuada() {
        // rebebe o dado e converte
        int multiplicando = Integer.parseInt(textFieldmultiplicando.getText());
        int menorMultiplicador = Integer.parseInt(textFieldMenorMultiplicado.getText());
        int maiorMultiplicador = Integer.parseInt(textFieldMaiorMultiplicador.getText());
        int tamanho = (maiorMultiplicador - menorMultiplicador) + 1;
        String[] tabuada = new String[tamanho];

        if(menorMultiplicador > maiorMultiplicador) {
            int aux = maiorMultiplicador;
            maiorMultiplicador = menorMultiplicador;
            menorMultiplicador = aux;
        }


        int contador = 0;
        while (contador < tamanho) {
            int produto = multiplicando * menorMultiplicador;
            tabuada  [contador] = multiplicando + " x " + menorMultiplicador + " = " + produto ;
            contador++;
            menorMultiplicador++;
        }
        listaTabuada.getItems().addAll(tabuada);
    }
}


