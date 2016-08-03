
package javafx2;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable 
{

    @FXML AnchorPane okno;
    @FXML Button guzik;
    @FXML void zmienPolozenie()
    {
        double x = okno.getWidth()-guzik.getWidth();
        double y = okno.getHeight()-guzik.getHeight();
        Random r = new Random();
        double x2 = r.nextDouble()*x;
        double y2 = r.nextDouble()*y;
        guzik.setLayoutX(x2);
        guzik.setLayoutY(y2);
    }
    @FXML void wylaczProgram()
    {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
