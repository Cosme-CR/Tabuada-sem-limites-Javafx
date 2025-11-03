package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //definir tamanho da tela
        stage.setWidth(800);
        stage.setHeight(600);

        //componente principal da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);

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


        //coloca header no root
        root.getChildren().add(header);


        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.show();



    }
}
