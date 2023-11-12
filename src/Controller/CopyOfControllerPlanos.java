package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.DeterminarSuperficie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;


public class CopyOfControllerPlanos {

     @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cmdActualizarDatos;

    @FXML
    private Button cmdAyuda;

    @FXML
    private Button cmdDeterminarSuperficie;

    @FXML
    private ImageView imgPlano;

    @FXML
    private Label lblDescripcion;

    @FXML
    private Label lblEcuacion;

    @FXML
    private Label lblEcuacionA2;

    @FXML
    private Label lblEcuacionCero;

    @FXML
    private Label lblEcuacionIgual;

    @FXML
    private Label lblEcuacionX;

    @FXML
    private Label lblEcuacionY;

    @FXML
    private Label lblEcuacionY2;

    @FXML
    private Label lblEcuacionZ;

    @FXML
    private Label lblEcuacionZ2;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtC;

    @FXML
    private TextField txtD;

    @FXML
    private TextField txtE;

    @FXML
    private TextField txtF;

    @FXML
    private TextField txtG;

    @FXML
    private TextField txtSuperficie;
    
    @FXML
    private DeterminarSuperficie s;

    Image image= null;

    @FXML
    void actualizarPlano(ActionEvent event) {
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtD.setText("");
        txtE.setText("");
        txtF.setText("");
        txtG.setText("");

    }

    @FXML
    void ayuda(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setHeaderText("Como usar esta aplicacion:");
        alert.setContentText("Esta aplicacion te permite determinar superficies. "
            + "Ingresa los valores a las constantes para determinar la superficie. "
            + "Para actualizar los datos, haz clic en el boton 'Actualizar Datos'. ");
        alert.showAndWait();

    }

    @FXML
    void determinarPlano(ActionEvent event) {
        try {
            double A = Double.parseDouble(txtA.getText());
            double B = Double.parseDouble(txtB.getText());
            double C = Double.parseDouble(txtC.getText());
            double D = Double.parseDouble(txtD.getText());
            double E = Double.parseDouble(txtE.getText());
            double F = Double.parseDouble(txtF.getText());
            double G = Double.parseDouble(txtG.getText());

            DeterminarSuperficie superficie = new DeterminarSuperficie(A, B, C, D, E, F, G);

            int tipoSuperficie = superficie.verificarSuperficie(A, B, C, D, E, F, G);

            String labelText = null;
            String imagePath = null;
            switch (tipoSuperficie) {
                case 1: 
                    imagePath = "/Images/esfera.png";
                    labelText = "Es una Esfera.";
                    break;
                case 2: 
                    imagePath = "/Images/cilindro.png";
                    labelText = "Es un Cilindro.";
                    break;
                case 3: 
                    imagePath = "/Images/cilindroParabolico.png";
                    labelText = "Es un Cilindro Parabolico.";
                    break;
                case 4: 
                    imagePath = "/Images/cilindroHiperbolico.png";
                    labelText = "Es un Cilindro Hiperbolico.";
                    break;
                case 5: 
                    imagePath = "/Images/paraboloideEliptico.png";
                    labelText = "Es un Paraboloide Eliptico.";
                    break;
                case 6: 
                    imagePath = "/Images/paraboloideHiperbolico.png";
                    labelText = "Es un Paraboloide Hiperbolico.";
                    break;
                case 7: 
                    imagePath = "/Images/elipsoide.png";
                    labelText = "Es un Elipsoide.";
                    break;
                case 8: 
                    imagePath = "/Images/conoEliptico.png";
                    labelText = "Es un Cono Eliptico.";
                    break;
                case 9: 
                    imagePath = "/Images/hiperboloideUnaHoja.png";
                    labelText = "Es un Hiperboloide de una Hoja.";
                    break;
                case 10: 
                    imagePath = "/Images/hiperboloideDosHojas.png";
                    labelText = "Es un Hiperboloide de dos Hojas.";
                    break;
                    
                case 11: 
                    imagePath = "/Images/Plano.png";
                    labelText = "Es un Plano.";
                    break;
                case 12: 
                    imagePath = "/Images/planoPerpendicular.png";
                    labelText = "Es un Plano Perpendicular.";
                    break;
                case 13: 
                    imagePath = "/Images/planosParalelos.png";
                    labelText = "Es un Plano Paralelo.";
                    break;
                case 14: 
                    imagePath = "/Images/puntoEnElOrigen.png";
                    labelText = "Es un Punto en el Origen.";
                    break;


                default:
                	imagePath = "/Images/desconocido.png";
                    labelText = "No se pudo determinar la superficie.";
                    break;

            }
            txtSuperficie.setText(labelText);

            if (imagePath != null){
                Image image = new Image(imagePath);
                imgPlano.setImage(image);
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Valores invalidos");
            alert.setContentText("Asegurate de ingresar valores num�ricos en los campos.");
            alert.showAndWait();
        }
    }


    @FXML
    void initialize() {
        assert cmdActualizarDatos != null : "fx:id=\"cmdActualizarDatos\" was not injected: check your FXML file 'primary.fxml'.";
        assert cmdAyuda != null : "fx:id=\"cmdAyuda\" was not injected: check your FXML file 'primary.fxml'.";
        assert cmdDeterminarSuperficie != null : "fx:id=\"cmdDeterminarSuperficie\" was not injected: check your FXML file 'primary.fxml'.";
        assert imgPlano != null : "fx:id=\"imgPlano\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblDescripcion != null : "fx:id=\"lblDescripcion\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblEcuacion != null : "fx:id=\"lblEcuacion\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblEcuacionA2 != null : "fx:id=\"lblEcuacionA2\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblEcuacionCero != null : "fx:id=\"lblEcuacionCero\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblEcuacionIgual != null : "fx:id=\"lblEcuacionIgual\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblEcuacionX != null : "fx:id=\"lblEcuacionX\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblEcuacionY != null : "fx:id=\"lblEcuacionY\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblEcuacionY2 != null : "fx:id=\"lblEcuacionY2\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblEcuacionZ != null : "fx:id=\"lblEcuacionZ\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblEcuacionZ2 != null : "fx:id=\"lblEcuacionZ2\" was not injected: check your FXML file 'primary.fxml'.";
        assert lblTitulo != null : "fx:id=\"lblTitulo\" was not injected: check your FXML file 'primary.fxml'.";
        assert txtA != null : "fx:id=\"txtA\" was not injected: check your FXML file 'primary.fxml'.";
        assert txtB != null : "fx:id=\"txtB\" was not injected: check your FXML file 'primary.fxml'.";
        assert txtC != null : "fx:id=\"txtC\" was not injected: check your FXML file 'primary.fxml'.";
        assert txtD != null : "fx:id=\"txtD\" was not injected: check your FXML file 'primary.fxml'.";
        assert txtE != null : "fx:id=\"txtE\" was not injected: check your FXML file 'primary.fxml'.";
        assert txtF != null : "fx:id=\"txtF\" was not injected: check your FXML file 'primary.fxml'.";
        assert txtG != null : "fx:id=\"txtG\" was not injected: check your FXML file 'primary.fxml'.";
        assert txtSuperficie != null : "fx:id=\"txtSuperficie\" was not injected: check your FXML file 'primary.fxml'.";

        s= new DeterminarSuperficie();
    }

}
