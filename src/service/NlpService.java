package service;


import org.json.JSONObject;
import utils.GetBaiduAIPClient;

import java.util.HashMap;

// 处理文字识别相关功能
public class NlpService {
    // 语言情感处理
    public String getSentiment(String text) {
        JSONObject result = GetBaiduAIPClient.getNlpAip().
                sentimentClassify(text, option);

        return result.toString();
    }

    public String getAddress(String text) {
        JSONObject result = GetBaiduAIPClient.getNlpAip().
                address(text, option);

        return result.toString();
    }

    public static NlpService getNlpService() {
        if (nlp_service == null) {
            nlp_service = new NlpService();
        }
        return nlp_service;
    }

    private HashMap<String, Object> option = new HashMap<String, Object>();
    private static NlpService nlp_service;
}
