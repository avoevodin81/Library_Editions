package parser;

import lib.*;
import lib.editions.Book;
import lib.editions.Encyclopedia;
import lib.editions.Magazine;
import lib.editions.Newspaper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileParser {
    // not need to create exemplar
    private FileParser() {
    }

    // for creating list with all editions
    public static ArrayList<Edition> getEditions(String url) {
        // get list with data from xml database
        NodeList nList = readFile(url);
        ArrayList<Edition> editions = new ArrayList<Edition>();

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element element = (Element) nNode;

            // check type attribute where we put type of edition
            if (element.getAttribute("type").equals(EditionTypes.Book.toString())) {
                editions.add(getBook(element));
            } else if (element.getAttribute("type").equals(EditionTypes.Encyclopedia.toString())) {
                editions.add(getEncyclopedia(element));
            } else if (element.getAttribute("type").equals(EditionTypes.Magazine.toString())) {
                editions.add(getMagazine(element));
            }  else if (element.getAttribute("type").equals(EditionTypes.Newspaper.toString())) {
                editions.add(getNewspaper(element));
            } else throw new IllegalArgumentException("\"" + element.getAttribute("type") + "\" element is not founded!");
        }
        return editions;
    }

    // for reading xml database
    private static NodeList readFile(String url) {
        // list for data
        NodeList nList = null;
        try {
            File xmlFile = new File(url);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(xmlFile);
            nList = doc.getElementsByTagName("edition");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nList;
    }
    // parser for Book class
    private static Book getBook(Element element) {
        String[] s = EditionTypes.Book.getFields();
        String name = element.getElementsByTagName(s[0]).item(0).getTextContent();
        int pageQuantity = Integer.parseInt(element.getElementsByTagName(s[1]).item(0).getTextContent());
        String author = element.getElementsByTagName(s[2]).item(0).getTextContent();
        String publisher = element.getElementsByTagName(s[3]).item(0).getTextContent();
        int y = Integer.parseInt(element.getElementsByTagName(s[4]).item(0).getTextContent());
        Date year = new Date();
        year.setYear(y);
        return new Book(name, pageQuantity, author, publisher, year);
    }

    // parser for Encyclopedia class
    private static Encyclopedia getEncyclopedia(Element element) {
        String[] s = EditionTypes.Encyclopedia.getFields();
        String name = element.getElementsByTagName(s[0]).item(0).getTextContent();
        int pageQuantity = Integer.parseInt(element.getElementsByTagName(s[1]).item(0).getTextContent());
        int tomNumber = Integer.parseInt(element.getElementsByTagName(s[2]).item(0).getTextContent());
        int y = Integer.parseInt(element.getElementsByTagName(s[3]).item(0).getTextContent());
        Date year = new Date();
        year.setYear(y);
        return new Encyclopedia(name, pageQuantity, tomNumber, year);
    }

    // parser for Magazine class
    private static Magazine getMagazine(Element element) {
        String[] s = EditionTypes.Magazine.getFields();
        String name = element.getElementsByTagName(s[0]).item(0).getTextContent();
        int pageQuantity = Integer.parseInt(element.getElementsByTagName(s[1]).item(0).getTextContent());
        int serialNumber = Integer.parseInt(element.getElementsByTagName(s[2]).item(0).getTextContent());
        String category = element.getElementsByTagName(s[3]).item(0).getTextContent();
        return new Magazine(name, pageQuantity, serialNumber, category);
    }

    // parser for Newspaper class
    private static Newspaper getNewspaper(Element element) {
        String[] s = EditionTypes.Newspaper.getFields();
        String name = element.getElementsByTagName(s[0]).item(0).getTextContent();
        int pageQuantity = Integer.parseInt(element.getElementsByTagName(s[1]).item(0).getTextContent());
        int serialNumber = Integer.parseInt(element.getElementsByTagName(s[2]).item(0).getTextContent());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        Date date = null;
        try {
            date = sdf.parse(element.getElementsByTagName(s[3]).item(0).getTextContent());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Newspaper(name, pageQuantity, serialNumber, date);
    }
}