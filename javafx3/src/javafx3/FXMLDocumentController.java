package javafx3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLDocumentController implements Initializable 
{
    @FXML private TextField poleImie, poleTel;
    @FXML private TableView tabela;
    
    //zmien dane kontaktu
    @FXML private void zmienKontakt(ActionEvent event) 
    {
        ObservableList items = tabela.getItems();
        ((Osoba) items.get(tabela.getSelectionModel().getSelectedIndex())).setImie(poleImie.getText());
        ((Osoba) items.get(tabela.getSelectionModel().getSelectedIndex())).setTel(poleTel.getText());
        nadpiszPlik(items);
        wypelnij();
        czyscPola();
    }
    
    public void czyscPola() 
    {
        poleImie.setText("");
        poleTel.setText("");
    }
    
    @FXML private void usunKontakt(ActionEvent event) 
    {
        if(!tabela.getSelectionModel().isEmpty()) 
        {
            ObservableList items = tabela.getItems();
            items.remove(tabela.getSelectionModel().getSelectedIndex());
            nadpiszPlik(items);
            wypelnij();
            czyscPola();
        }
    }
    
    private void nadpiszPlik(ObservableList items) 
    {
        try 
        {
            PrintWriter plik = new PrintWriter("kontakty.txt");
            int n = 0;
            while(n < items.size()) 
            {
                plik.println(((Osoba)items.get(n)).getImie());
                plik.println(((Osoba)items.get(n)).getTel());
                n++;
            }
            plik.close();
        }
        catch(IOException e) {}
    }
    
    @FXML private void pobierzKontakt() 
    {
        Osoba person = (Osoba)tabela.getSelectionModel().getSelectedItem();
        poleImie.setText(person.getImie());
        poleTel.setText(person.getTel());
    }
    
    @FXML private void dodajKontakt(ActionEvent event) 
    {
        //sprawdz czy pola nie sa puste
        if(poleImie.getText().length() == 0 || poleTel.getText().length() == 0) 
        {
            Alert alert = new Alert(AlertType.ERROR, "wpisz imię i telefon!");
            alert.showAndWait();
        }
        else 
        {
            //jesli nie sa puste, dodaj kontakt
            ObservableList items = tabela.getItems();
            items.add(new Osoba(poleImie.getText(), poleTel.getText()));
            nadpiszPlik(items);
            wypelnij();
            czyscPola();
        }
    }
    
    private void wypelnij() 
    {
        try 
        {
            //pobranie kolumn tabeli
            ObservableList<TableColumn> cols = FXCollections.observableArrayList(tabela.getColumns());
            cols.get(0).setCellValueFactory(new PropertyValueFactory<Osoba, String>("imie"));
            cols.get(1).setCellValueFactory(new PropertyValueFactory<Osoba, String>("tel"));
            //otwarcie pliku do odczytu
            Scanner skaner = new Scanner(new File("kontakty.txt"));
            ObservableList<Osoba> items = FXCollections.observableArrayList();
            while(skaner.hasNextLine()) 
            {
                String name = skaner.nextLine();
                String number = skaner.nextLine();
                items.add(new Osoba(name, number));
            }
            tabela.setItems(items);
            skaner.close();
            czyscPola();
        }
        catch(Exception e) 
        {
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        wypelnij();
    }    
    
}
