
package javafx5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.HTMLEditor;

public class FXMLDocumentController implements Initializable 
{
   
    @FXML public HTMLEditor edytor;
    @FXML public void kolorujSkladnie()
    {
        String tekst;
        tekst = edytor.getHtmlText();
        tekst = tekst.replaceAll("</p>", "\n");
        tekst = tekst.replaceAll("<br />", "\n");
        tekst = tekst.replaceAll("\\<.*?>","");
        StringBuilder nowyTekst = new StringBuilder();
        StringBuilder ostateczny = new StringBuilder();
        for(int i = 0; i < tekst.length(); i++) 
        {
            if (tekst.charAt(i) == '\n')
            {
                nowyTekst.append("<br />");
            }
            nowyTekst.append(tekst.charAt(i));
           
            String nowyTekstTmp = nowyTekst.toString();
            if(nowyTekstTmp.contains("Ook. Ook?")) 
            {
                nowyTekstTmp = nowyTekstTmp.replaceAll("Ook. Ook\\?", "<font color=#990033>Ook. Ook\\?</font>");
                ostateczny.append(nowyTekstTmp);
                nowyTekst = new StringBuilder();
            }
            else if(nowyTekstTmp.contains("Ook. Ook.")) 
            {
                nowyTekstTmp = nowyTekstTmp.replaceAll("Ook. Ook.", "<font color=teal>Ook. Ook.</font>");
                ostateczny.append(nowyTekstTmp);
                nowyTekst = new StringBuilder();
            }
            else if(nowyTekstTmp.contains("Ook. Ook!")) 
            {
                nowyTekstTmp = nowyTekstTmp.replaceAll("Ook. Ook!", "<font color=blue>Ook. Ook!</font>");
                ostateczny.append(nowyTekstTmp);
                nowyTekst = new StringBuilder();
            }
            else if(nowyTekstTmp.contains("Ook! Ook?")) 
            {
                nowyTekstTmp = nowyTekstTmp.replaceAll("Ook! Ook\\?", "<font color=olive>Ook! Ook\\?</font>");
                ostateczny.append(nowyTekstTmp);
                nowyTekst = new StringBuilder();
            }
            else if(nowyTekstTmp.contains("Ook! Ook!")) 
            {
                nowyTekstTmp = nowyTekstTmp.replaceAll("Ook! Ook!", "<font color=#996699>Ook! Ook!</font>");
                ostateczny.append(nowyTekstTmp);
                nowyTekst = new StringBuilder();
            }
            else if(nowyTekstTmp.contains("Ook! Ook.")) 
            {
                nowyTekstTmp = nowyTekstTmp.replaceAll("Ook! Ook.", "<font color=silver>Ook! Ook.</font>");
                ostateczny.append(nowyTekstTmp);
                nowyTekst = new StringBuilder();
            }
            else if(nowyTekstTmp.contains("Ook? Ook?")) 
            {
                nowyTekstTmp = nowyTekstTmp.replaceAll("Ook\\? Ook\\?", "<font color=green>Ook\\? Ook\\?</font>");
                ostateczny.append(nowyTekstTmp);
                nowyTekst = new StringBuilder();
            }
            else if(nowyTekstTmp.contains("Ook? Ook!")) 
            {
                nowyTekstTmp = nowyTekstTmp.replaceAll("Ook\\? Ook!", "<font color=teal>Ook\\? Ook!</font>");
                ostateczny.append(nowyTekstTmp);
                nowyTekst = new StringBuilder();
            }
            else if(nowyTekstTmp.contains("Ook? Ook.")) 
            {
                nowyTekstTmp = nowyTekstTmp.replaceAll("Ook\\? Ook.", "<font color=#cc99ff>Ook\\? Ook.</font>");
                ostateczny.append(nowyTekstTmp);
                nowyTekst = new StringBuilder();
            }
        }
        ostateczny.append(nowyTekst.toString());
        edytor.setHtmlText(ostateczny.toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        edytor.setHtmlText("Ook. Ook.<br>\n" + "Ook. Ook?<br>\n" + "Ook. Ook!<br>\n" + "Ook? Ook.<br>\n" +
"Ook? Ook?<br>\n" +"Ook? Ook!<br>\n" + "Ook! Ook.<br>\n" + "Ook! Ook?<br>\n" + "Ook! Ook!\n");
    }    
    
}
