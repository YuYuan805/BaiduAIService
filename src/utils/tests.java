package utils;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.speech.AipSpeech;

public class tests {
    public static void main(String[] args) {
        AipOcr aipOcr = GetBaiduAIPClient.getOrcAip();
        System.out.println(aipOcr);

        AipNlp aipNlp = GetBaiduAIPClient.getNlpAip();
        System.out.println(aipNlp);

        AipSpeech aipSpeech = GetBaiduAIPClient.getSpeechAip();
        System.out.println(aipSpeech);

        //AipImageClassify aipImageClassify = GetBaiduAIPClient.getImageAip();
        //System.out.println(aipImageClassify);

        AipFace aipFace = GetBaiduAIPClient.getFaceAip();
        System.out.println(aipFace);


    }
}
