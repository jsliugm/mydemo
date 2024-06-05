package com.xml;

import cn.hutool.core.io.resource.ClassPathResource;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class XmlUtil {
    private XmlUtil xmlUtil;
    static int i = 0;

    public XmlUtil getXmlUtil() {
        return xmlUtil;
    }

    public void setXmlUtil(XmlUtil xmlUtil) {
        this.xmlUtil = xmlUtil;
    }

    public static void main(String[] args) {
        //int i =0;

        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    XmlUtil xu = new XmlUtil();
                    xu.setXmlUtil(xu);
                    System.err.println(i++);

                }
            }).start();
        }
    }

    @Test
    public void testDom() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Element theBook = null, theElem = null, root = null;
        factory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder db = factory.newDocumentBuilder();
        Document xmldoc = db.parse(new File("C:\\Users\\jsliu\\Desktop\\test.xml"));
        root = xmldoc.getDocumentElement();
        System.out.println(root.getTagName());
        System.out.println(root.getFirstChild());
    }

    @Test
    public void testSax() throws ParserConfigurationException, SAXException, IOException {

        //File file = new File("resources/test.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser parser = spf.newSAXParser();
        parser.parse(new ClassPathResource("test.xml").getStream(), new MySaxHandler());
    }

    @Test
    public void testDom4j() throws DocumentException {
        // 创建saxreader对象
        SAXReader reader = new SAXReader();
        // 读取一个文件，把这个文件转换成Document对象
        org.dom4j.Document document = reader.read(new File("C:\\Users\\jsliu\\Desktop\\test.xml"));
        // 获取根元素
        org.dom4j.Element root = document.getRootElement();
    }
}

class MySaxHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }
}