package service;


import org.json.JSONObject;
import utils.Base64Util;
import utils.GetBaiduAIPClient;

import java.util.HashMap;

// 处理文字识别相关功能
public class FaceService {
    // 人脸信息识别
    public String getFaceDetect(byte[] img) {
        option.clear();
        option.put("face_field", "age,beauty,expression,gender");
        //option.put("face_field", "age,expression,face_shape,gender,landmark,beauty,quality,eye_status,emotion,face_type,spoofing");
        option.put("max_face_num", "1");
        option.put("face_type", "LIVE");
        option.put("liveness_control", "LOW");

        JSONObject result = GetBaiduAIPClient.getFaceAip().
                detect(Base64Util.encode(img), "BASE64", option);

        return result.toString();
    }
    // 黑白上色
    public String getBlackWhite(byte[] img) {
        option.clear();
        JSONObject result = GetBaiduAIPClient.getImageAip().
                colourize(img, option);

        return result.toString();
    }

    public static FaceService getFaceService() {
        if (face_service == null) {
            face_service = new FaceService();
        }
        return face_service;
    }

    private HashMap<String, String> option = new HashMap<String, String>();
    private static FaceService face_service;
}
