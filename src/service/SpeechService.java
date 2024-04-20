package service;


import com.baidu.aip.speech.TtsResponse;
import org.json.JSONObject;
import utils.GetBaiduAIPClient;

import java.util.HashMap;

// 处理文字识别相关功能
public class SpeechService {
    // 语音合成
    public byte[] getSynthesis(String text, String spd, String pit, String per) {
        option.clear();
        option.put("spd", spd); // 语速
        option.put("pit", pit); // 语调
        option.put("per", per); // 人物模型

        TtsResponse tts_result = GetBaiduAIPClient.getSpeechAip().
                synthesis(text, "zh", 1, option);

        return tts_result.getData();
    }


    // 2024年4月20日19点12分 ： sb
    // 语音识别
    public String Getvoiceidentify(byte[] voive)//人脸检测
    {
        HashMap map = new HashMap<String,String>();

        //String voiveb64 = Base64Util.encode(voive);
        JSONObject jsonObject = GetBaiduAIPClient.getSpeechAip().asr(voive ,"wav", 16000, null);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }




    public static SpeechService getFaceService() {
        if (speech_service == null) {
            speech_service = new SpeechService();
        }
        return speech_service;
    }

    private HashMap<String, Object> option = new HashMap<String, Object>();
    private static SpeechService speech_service;
}
