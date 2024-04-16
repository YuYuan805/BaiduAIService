package service;


import org.json.JSONObject;
import utils.GetBaiduAIPClient;

import java.util.HashMap;

// 处理文字识别相关功能
public class ImageService {
    // 图片转动漫图
    public String getSelfieAnime(byte[] img) {
        option.clear();
        option.put("type", "anime");

        JSONObject result = GetBaiduAIPClient.getImageAip().
                selfieAnime(img, option);

        return result.toString();
    }
    // 黑白上色
    public String getBlackWhite(byte[] img) {
        option.clear();
        JSONObject result = GetBaiduAIPClient.getImageAip().
                colourize(img, option);

        return result.toString();
    }

    public static ImageService getNlpService() {
        if (image_service == null) {
            image_service = new ImageService();
        }
        return image_service;
    }

    private HashMap<String, String> option = new HashMap<String, String>();
    private static ImageService image_service;
}
