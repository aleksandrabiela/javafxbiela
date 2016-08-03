/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx3;

/**
 *
 * @author A20111
 */
public class Osoba {
    private String imie, tel;
    
    public Osoba(String newName, String newNumber) {
        imie = newName;
        tel = newNumber;
    }
    
    public void setImie(String newName) {
        imie = newName;
    }
    
    public void setTel(String newNumber) {
        tel = newNumber;
    }
    
    public String getImie() {
        return imie;
    }
    
    public String getTel() {
        return tel;
    }
}
