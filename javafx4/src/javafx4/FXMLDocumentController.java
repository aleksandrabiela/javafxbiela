
package javafx4;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable 
{
    @FXML AnchorPane okno;
    @FXML Label punkty;
    int punktyGracza, punktyKrupiera, iloscKartGracza, iloscKartKrupiera;
    String[] karty = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "D", "K", "A"};
    int[] wartosci = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
    int graczX, krupierX;
    Label zakryta;
    @FXML Button pass, dobierz;
    
    public void LosujKarte(boolean czlowiek)
    {
        Random r = new Random();
        int wylosowana;
        wylosowana = r.nextInt(13);
       
        if(czlowiek == true)
        {
            punktyGracza += wartosci[wylosowana];
            Label karta = new Label();
            karta.setText(karty[wylosowana]);
            iloscKartGracza += 1;
            karta.setLayoutX(20 * iloscKartGracza);
            karta.setLayoutY(200);
            okno.getChildren().add(karta);
        }
        else
        {
            punktyKrupiera += wartosci[wylosowana];
            Label karta = new Label();
            karta.setText(karty[wylosowana]);
            iloscKartKrupiera += 1;
            karta.setLayoutX(20 * iloscKartKrupiera);
            karta.setLayoutY(100);
            okno.getChildren().add(karta);
        }
        ustawPunkty();
    }
    
    public void sprawdzPunkty()
    {
        if (punktyGracza == 21)
        {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("Wygrałeś");
            a.showAndWait();
            System.exit(0);
        }
        else if(punktyGracza > 21)
        {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("Przegrałeś");
            a.showAndWait();
            System.exit(0);
        }
        else if(punktyKrupiera > 21)
        {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("Wygrałeś");
            a.showAndWait();
            System.exit(0);
        }
        else if(punktyKrupiera == 21)
        {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("Przegrałeś");
            a.showAndWait();
            System.exit(0);
        }
    }
    
    public void ustawPunkty()
    {
        punkty.setText("Punkty gracza: " + punktyGracza + " Punkty krupiera: " + punktyKrupiera);
        sprawdzPunkty();
    }
    
    @FXML public void dobierzKarte()
    {
        LosujKarte(true);
        ustawPunkty();
    }
    
    @FXML public void pasuj()
    {
        zakryta.setVisible(false);
        LosujKarte(false);
        while (punktyKrupiera < 17)
        {
            LosujKarte(false);
        }
        Alert a = new Alert(AlertType.INFORMATION);
        if (punktyGracza > punktyKrupiera)
        {
            a.setContentText("Wygrałeś");
        }
        else if (punktyGracza < punktyKrupiera)
        {
            a.setContentText("Przegrałeś");
        }
        else
        {
            a.setContentText("Remis");
        }
        a.showAndWait();
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        punktyGracza = punktyKrupiera = 0;
        iloscKartGracza = iloscKartKrupiera = 0;
        ustawPunkty();
        LosujKarte(true);
        LosujKarte(true);
        LosujKarte(false);
        zakryta = new Label();
        zakryta.setText("?");
        zakryta.setLayoutX(40);
        zakryta.setLayoutY(100);
        okno.getChildren().add(zakryta);
        sprawdzPunkty();
    }    
    
}
