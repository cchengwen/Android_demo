package com.android_ch51_xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream in = getResources().openRawResource(R.raw.data);

        try {
            byte[] bytes = new byte[in.available()];
            in.read();
            String XMLstr = new String(bytes, "UTF-8");
            in.reset();
            System.out.println(XMLstr);

            // 开始解析
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document doc = builder.parse(in);
            //  定义一个节点
            Node node = doc.getFirstChild();
            System.out.println("第一个子节点："+node.getNodeName());

            NodeList list = doc.getElementsByTagName("c");

            NamedNodeMap map;
            for (int i = 0; i < list.getLength(); i++) {
                node = list.item(i);
                map = node.getAttributes();
                System.out.println(node.getTextContent() +"  studentNum = "+ map.getNamedItem("studentNum").getNodeValue());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
