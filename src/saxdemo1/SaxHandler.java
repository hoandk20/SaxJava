/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saxdemo1;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author khang
 */
class SaxHandler extends DefaultHandler {

    ArrayList<contact> contacts;

    public SaxHandler() {
        contacts = new ArrayList<>();
    }
    public   ArrayList<contact> getList(){
        
        return contacts;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("characters: " + new String(ch, start, length));
      
        switch (currentElement) {
            case "first_name":
                b.setFirst_name(new String(ch, start, length));
                break;
            case "last_name":
                b.setLast_name(new String(ch, start, length));
                break;
            case "company_name":
                b.setCompany_name(new String(ch, start, length));
                break;
            case "address":
                b.setAddress(new String(ch, start, length));
                break;
            case "city":
                b.setCity(new String(ch, start, length));
                break;
            case "county":
                b.setCounty(new String(ch, start, length));
                break;
            case "state":
                b.setState(new String(ch, start, length));
                break;
            case "zip":
                b.setZip(new String(ch, start, length));
                break;
            case "phone1":
                b.setPhone1(new String(ch, start, length));
                break;
            case "phone":
                b.setPhone(new String(ch, start, length));
                break;
            case "email":
                b.setEmail(new String(ch, start, length));
                break;
                
        }
        currentElement= "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("endElement: " + uri + " - " + localName + " - " + qName);
        if (localName.equals("contact")) {
            contacts.add(b);
        }
    }
    contact b;
    String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("startElement: " + uri + " - " + localName + " - " + qName + " - " + attributes.toString());
        currentElement = localName;
        if (localName.equals("contact")) {
            b = new contact();
            b.setNameSpace(uri);
        }

    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("End Document");
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Start Document");
    }

}
