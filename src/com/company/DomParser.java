package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class DomParser {
    static String body2;
    private Document doc;
    int transfer;



    public void parse(String xmlPath, int transfer2){
            transfer = transfer2;
        try{
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = dBuilder.parse(new File(xmlPath));

            if(doc.hasChildNodes()){
                print(doc.getChildNodes());
            }

            body2=documentToString(doc);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
    private void print(NodeList nodeList){
        for(int i = 0; i<nodeList.getLength(); i++) {
            Node tempNode = nodeList.item(i);
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                if (tempNode.getNodeName().equals("t:CurrentDate")) {
                    addDate(tempNode);
                }

                if(tempNode.hasChildNodes()){
                    print(tempNode.getChildNodes());
                }
            }
        }
    }
    private void addDate(Node node){
        Node dateNode = doc.createElement("transfer");
        dateNode.appendChild(doc.createTextNode(String.valueOf(transfer)));
        node.appendChild(dateNode);

    }

    private static String documentToString(Document doc) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));

            // возвращаем преобразованный  в строку XML Document
            return writer.getBuffer().toString();

        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

}