import lib.Edition;
import org.w3c.dom.NodeList;
import parser.FileParser;

import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        // url to xml database
        String url = "src/main/resources/library.xml";
        // get list from the FileParser class
        ArrayList<Edition> editions = FileParser.getEditions(url);

        // sort
        Collections.sort(editions);

        // print information about all editions
        for (Edition e : editions){
            e.printInformation();;
        }
    }
}
