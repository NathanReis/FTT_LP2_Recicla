package recicla.presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class TelaExibeQuizController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void btnAdicionaPergunta(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("TelaCadastroPergunta.fxml")); 
            Parent root = (Parent) fxml.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Pergunta");
            stage.setScene(new Scene(root));           
            stage.show();
        } catch(Exception e) {
            System.out.println("Falha ao carregar a janela");
        }
    }
}