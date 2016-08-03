
package javafx1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLDocumentController implements Initializable 
{
    
    @FXML ToggleGroup grupa1;
    @FXML ToggleGroup grupa2;
    @FXML Button zamien;
    @FXML TextField wej;
    @FXML TextField wyj;
    
    @FXML
    private void sprawdzWartosc() 
    {
       RadioButton wybrany1 = (RadioButton) grupa1.getSelectedToggle();
       RadioButton wybrany2 = (RadioButton) grupa2.getSelectedToggle();
       String tekst = wej.getText();
       Double liczba = Double.parseDouble(tekst);
       String wybr1 = wybrany1.getText();
       String wybr2 = wybrany2.getText();
       Double a;
       if(wybr1.equals(wybr2))
       {
           a = liczba;
           wyj.setText(liczba.toString());
       }
       else if(wybr1.equals("celcius"))
       {
           if(wybr2.equals("fahrenheit"))
           {
               a = ((liczba*9)/5) + 32;
           }
           else
           {
               a = liczba + 273.15;
           }
       }
       else if(wybr1.equals("fahrenheit"))
       {
           if(wybr2.equals("celcius"))
           {
               a = ((liczba-32)*5)/9;
           }
           else
           {
               a = ((liczba+459.67)*5)/9;
           }
           
       }
       else
       {
           if(wybr2.equals("celcius"))
           {
               a = liczba - 273.15;
           }
           else
           {
               a = ((liczba*9)/5)-459.67;
           }
       }
      
           
           
           
       wyj.setText(a.toString());
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
