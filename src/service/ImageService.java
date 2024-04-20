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

    //风格转换
    public String getStyleTrans(byte[] img) {
        option.clear();
        option.put("option", "gothic");

        JSONObject result = GetBaiduAIPClient.getImageAip().
                styleTrans(img, option);

        return result.toString();
    }

    // 2024年4月20日10点55分 ： wyy
    // 通用物体识别
    public String getObjectDetect(byte[] img) {
        option.clear();
        option.put("baike_num", "5");

        JSONObject result = GetBaiduAIPClient.getImageClassifyAip().
                advancedGeneral(img, option);

        return result.toString();
    }
    // 2024年4月20日15点42分 ： sb
    // 动物识别
    public String getAnimalDetect(byte[] img) {
        option.clear();
        option.put("top_num", "5");
        option.put("baike_num", "5");

        JSONObject jsonObject = GetBaiduAIPClient.getImageClassifyAip()
                .animalDetect(img, option);

        return jsonObject.toString();
    }

    // 2024年4月20日16点27分：wyy
    // 菜品识别
    public String getDishDetect(byte[] img) {
        option.clear();
        option.put("top_num", "3");
        option.put("filter_threshold", "0.7");
        option.put("baike_num", "5");

        JSONObject result = GetBaiduAIPClient.getImageClassifyAip().
                dishDetect(img, option);

        return result.toString();
    }

    // 2024年4月20日18点31分：wyy
    // logo商标识别
    public String getLogoSearch(byte[] img) {
        option.clear();
        option.put("custom_lib", "false");

        JSONObject result = GetBaiduAIPClient.getImageClassifyAip().
                logoSearch(img, option);

        return result.toString();
    }

    // 2024年4月20日18点46分：wyy
    // 植物识别
    public String getPlantDetect(byte[] img) {
        option.clear();
        option.put("baike_num", "3");

        JSONObject result = GetBaiduAIPClient.getImageClassifyAip().
                plantDetect(img, option);

        return result.toString();
    }
    // 2024年4月20日19点09分：wyy
    // 地标识别
    public String getLandmark(byte[] img) {
        option.clear();

        JSONObject result = GetBaiduAIPClient.getImageClassifyAip().
                landmark(img, option);

        return result.toString();
    }
    // 2024年4月20日19点10分：wyy
    // 果蔬识别
    public String getFruit(byte[] img) {
        option.clear();
        option.put("top_num", "3");

        JSONObject result = GetBaiduAIPClient.getImageClassifyAip().
                ingredient(img, option);

        return result.toString();
    }
    // 2024年4月20日19点12分：wyy
    // 红酒识别
    public String getRedwine(byte[] img) {
        option.clear();

        JSONObject result = GetBaiduAIPClient.getImageClassifyAip().
                redwine(img, option);

        return result.toString();
    }


    // 2024年4月20日19点13分：wyy
    // 货币识别
    public String getVehicleDetect(byte[] img) {
        option.clear();

        JSONObject result = GetBaiduAIPClient.getImageClassifyAip().
                currency(img, option);

        return result.toString();
    }


    // 获取对象
    public static ImageService getNlpService() {
        if (image_service == null) {
            image_service = new ImageService();
        }
        return image_service;
    }


    private HashMap<String, String> option = new HashMap<String, String>();
    private static ImageService image_service;
}
