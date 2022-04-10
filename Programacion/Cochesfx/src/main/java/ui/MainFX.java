package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.common.Constantes;

import java.io.IOException;
import java.util.ResourceBundle;


public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        ResourceBundle bundle = ResourceBundle.getBundle(Constantes.TEXTOS_UI);
        FXMLLoader loaderMenu = new FXMLLoader(
                getClass().getResource(Constantes.PRINCIPAL_FXML), bundle);

        AnchorPane root = loaderMenu.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle(bundle.getString(Constantes.TITULO_VENTANA));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
