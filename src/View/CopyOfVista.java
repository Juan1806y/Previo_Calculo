package View;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.Parent;

/**
 * Use los comentarios para explicar el objetivo de este programa CopyOfVista .
 *
 * @author Ponga aqui su nombre y correo
 * @version Ponga aqu� la versi�n o fecha
 */
public class CopyOfVista extends Application{

    public void start(Stage stage) throws Exception {
        // Crear el FXMLLoader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));

        // Cargar el archivo FXML
        Parent root = loader.load();

        // Crear la escena
        Scene scene = new Scene(root);

        // Establecer la escena en el escenario
        stage.setScene(scene);

        // Establecer el t�tulo del escenario
        stage.setTitle("SUPERFICIES CUADRICAS");

        // Hacer que el escenario no sea redimensionable
        stage.setResizable(false);

        // Mostrar el escenario
        stage.show();
    }
}

