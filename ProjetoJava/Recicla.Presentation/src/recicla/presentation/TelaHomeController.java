/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recicla.presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class TelaHomeController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button button2;
    
    @FXML
  private void handleButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TelaLoginProfessor.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ExibeHomeAluno(ActionEvent event) {
           try{
            
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("TelaLoginAluno.fxml")); 
            Parent root = (Parent) fxml.load();
            Stage stage = new Stage();
            stage.setTitle("Home Aluno");
            stage.setScene(new Scene(root));           
            stage.show();
            
        }catch(Exception e){
            System.out.println("Falha ao carregar a janela");
        }
    }
    
}
