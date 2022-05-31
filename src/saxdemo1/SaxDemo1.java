/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package saxdemo1;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author khang
 */
public class SaxDemo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser saxParser = factory.newSAXParser();

            File file = new File("contacts.xml");
            SaxHandler handler = new SaxHandler();
            saxParser.parse(file, handler);
            for (contact contact : handler.contacts) {
                System.out.println(contact.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
