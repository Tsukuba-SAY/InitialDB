/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posterdatacsv2xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.dom.*;
import javax.xml.parsers.*;


/**
 *
 * @author Yuji
 */
public class PosterDataCsv2XML {

    //ファイルパスをそれぞれ定数に入れておく
    public static final String CSV_FILE = "posterdata.csv";
    public static final String XML_FILE = "posterdata.xml";
    
    //XMLの要素名
    public static final String ELEMENT_POSTER = "poster";
    public static final String[] ELEMENT_INDEX =
            {"id","sessionid","title","abstract","authorname","authorbelongs"};

    //1件のポスターデータに含まれる要素数
    public static final int DATA_ROW = 6;

    public static void main(String[] args)
            throws FileNotFoundException, IOException {

        // BufferedReaderの呼び出し
        File csvFile = new File(CSV_FILE);
        FileReader fileReader = new FileReader(csvFile);
        BufferedReader csvReader = new BufferedReader(fileReader);

        //XML書き込みの準備
        Document posterData = new 
        FileWriter xmlFileWriter = new FileWriter(XML_FILE);
        BufferedWriter xmlBufferedWriter =
                new BufferedWriter(xmlFileWriter);        

        //XMLにルート要素を追加
        Element rootElement = posterData.createElement("posterdata");
        posterData.appendChild(rootElement);
        
        
        // 一行ずつ読み込んでカンマ区切りでString[]に格納したあと
        // XMLに子要素を追加しながら書き込む        
        String line = "";
        while ((line = csvReader.readLine()) != null) {
            String[] posterDataElements = new String[DATA_ROW];
            posterDataElements = line.split(",");     

            //XMLにポスター1件分の要素を追加
            Element aPoster = posterData.createElement(ELEMENT_POSTER);
            rootElement.appendChild(aPoster);
            
            //切り出した文字列を子要素にしてXMLに書き込む
            for (int i = 0; i < DATA_ROW; i++) {
                Text t = posterData.createTextNode(posterDataElements[i]);
                aPoster.appendChild(t);
            }
        }
        
        //TODO:XMLDocumentのファイル書き込み
        ((XMLDocument)posterData).write(xmlFileWriter, "Shift_JIS");
        xmlBufferedWriter.flush();
        xmlBufferedWriter.close();
    }
}
