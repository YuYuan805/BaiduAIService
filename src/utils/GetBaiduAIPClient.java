package utils;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.imageprocess.AipImageProcess;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.speech.AipSpeech;

// 统一初始化应用参数并提交百度获取client对象
public class GetBaiduAIPClient {
    // OCR文字识别鉴权
    public static AipOcr getOrcAip() {
        // 初始化一个AipOcr
        ocr_client = new AipOcr(GetBaiduAIPClient.APPID,
                GetBaiduAIPClient.APPKEY, GetBaiduAIPClient.APPSECRETKEY);

        ocr_client.setConnectionTimeoutInMillis(2000); // 请求超时时间
        ocr_client.setSocketTimeoutInMillis(60000);    // 读取超时时间

        return ocr_client;
    }
    // NLP自然语言处理
    public static AipNlp getNlpAip() {
        // 初始化一个AipNlp
        nlp_client = new AipNlp(GetBaiduAIPClient.APPID,
                GetBaiduAIPClient.APPKEY, GetBaiduAIPClient.APPSECRETKEY);

        nlp_client.setConnectionTimeoutInMillis(2000); // 请求超时时间
        nlp_client.setSocketTimeoutInMillis(60000);    // 读取超时时间

       return nlp_client;
   }
    // Image图像增强
    public static AipImageProcess getImageAip() {
        // 初始化一个AipImageClassify
        image_client = new AipImageProcess(GetBaiduAIPClient.APPID,
                GetBaiduAIPClient.APPKEY, GetBaiduAIPClient.APPSECRETKEY);

        image_client.setConnectionTimeoutInMillis(2000); // 请求超时时间
        image_client.setSocketTimeoutInMillis(60000);    // 读取超时时间

        return image_client;
    }
    // 2024年4月20日11点00分
    // 修改：wyy
    // Image图像识别
    public static AipImageClassify getImageClassifyAip() {
        // 初始化一个AipImageClassify
        image_client_s = new AipImageClassify(GetBaiduAIPClient.APPID,
                GetBaiduAIPClient.APPKEY, GetBaiduAIPClient.APPSECRETKEY);

        image_client_s.setConnectionTimeoutInMillis(2000); // 请求超时时间
        image_client_s.setSocketTimeoutInMillis(60000);    // 读取超时时间

        return image_client_s;
    }
    // Speech语音合成识别
    public static AipSpeech getSpeechAip() {
        // 初始化一个AipSpeech
        speech_client = new AipSpeech(GetBaiduAIPClient.APPID,
                GetBaiduAIPClient.APPKEY, GetBaiduAIPClient.APPSECRETKEY);

        speech_client.setConnectionTimeoutInMillis(2000); // 请求超时时间
        speech_client.setSocketTimeoutInMillis(60000);    // 读取超时时间

        return speech_client;
    }
    // Face人脸识别
    public static AipFace getFaceAip() {
        // 初始化一个AipFace
        face_client = new AipFace(GetBaiduAIPClient.APPID,
                GetBaiduAIPClient.APPKEY, GetBaiduAIPClient.APPSECRETKEY);

        face_client.setConnectionTimeoutInMillis(2000); // 请求超时时间
        face_client.setSocketTimeoutInMillis(60000);    // 读取超时时间

        return face_client;
    }
    // PIC

    // 静态成员变量
    private static AipOcr ocr_client;
    private static AipNlp nlp_client;
    private static AipImageProcess image_client;
    private static AipImageClassify image_client_s;
    private static AipSpeech speech_client;
    private static AipFace face_client;

    public static final String APPID = "60364114";
    public static final String APPKEY = "agkAQ4J1smsBfbTumjWvDsTJ";
    public static final String APPSECRETKEY = "pHnsjlZBZq9gGzsh4XyNwcN3VwrfR63H";
}
