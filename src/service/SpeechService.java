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


    public static SpeechService getFaceService() {
        if (speech_service == null) {
            speech_service = new SpeechService();
        }
        return speech_service;
    }

    private HashMap<String, Object> option = new HashMap<String, Object>();
    private static SpeechService speech_service;
}
