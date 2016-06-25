package task;

import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;

public class home {
   public static void main(String[] args){

      try {	
         File inputFile = new File("src/office.xml");
         DocumentBuilderFactory dbFactory 
            = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
        
         NodeList nList = doc.getElementsByTagName("worker");
        
         for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            System.out.println("\n"+ nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println(eElement.getAttribute("id"));
               System.out.println(eElement.getElementsByTagName("name").item(0)
                  .getTextContent());
               System.out.println(eElement.getElementsByTagName("company").item(0)
                  .getTextContent());
               System.out.println(eElement.getElementsByTagName("position").item(0)
                  .getTextContent());
               System.out.println(eElement.getElementsByTagName("salary").item(0)
                  .getTextContent());
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}