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
    // 地址识别
    public String getAddress(String text) {
        JSONObject result = GetBaiduAIPClient.getNlpAip().
                address(text, option);

        return result.toString();
    }

    // 文本纠错
    public String getecnet(String text) {
        JSONObject result = GetBaiduAIPClient.getNlpAip().
                ecnet(text, option);

        return result.toString();
    }

    //新增 2024年4月20日18:53:50 lx
    // 新闻摘要
    public String getnewsSummary(String text) {
        option.put("title", "标题");
        JSONObject result = GetBaiduAIPClient.getNlpAip().
                newsSummary(text, 200, option);

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
