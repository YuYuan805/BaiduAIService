package service;


import org.json.JSONObject;
import utils.GetBaiduAIPClient;

import java.util.HashMap;

// 处理文字识别相关功能
public class OcrService {
    // 文字识别
    public String getText(byte[] img) {
        option.clear();
        option.put("probability", "true"); // 返回置信度
        option.put("detect_direction", "true"); // 检测朝向
        JSONObject result = GetBaiduAIPClient.getOrcAip().
                basicAccurateGeneral(img, option); // 通过自定义GetBaiduAIPClient类返回一个OrcAip对象并调用文字识别api

        return result.toString();
    }
    // 身份证识别
    public String getIDcard(byte[] img) {
        option.clear();
        option.put("detect_risk", "false");
        option.put("detect_direction", "true");

        JSONObject result = GetBaiduAIPClient.getOrcAip().
                idcard(img, "front", option);

        return result.toString();
    }

    public static OcrService getOcrService() {
        if (ocr_service == null) {
            ocr_service = new OcrService();
        }
        return ocr_service;
    }

    private HashMap<String, String> option = new HashMap<String, String>();
    private static OcrService ocr_service;
}
