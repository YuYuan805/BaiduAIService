package service;


import org.json.JSONObject;
import utils.Base64Util;
import utils.GetBaiduAIPClient;

import java.util.HashMap;

import com.baidu.aip.face.MatchRequest;

import java.util.ArrayList;
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

    //新增 2024年4月21日09:16:50 ss
    // 人脸对比
    public String GetFacecontrastive(byte[] img1,byte[] img2)//人脸检测
    {
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();

        String img1b64 = Base64Util.encode(img1);
        String img2b64 = Base64Util.encode(img2);
        MatchRequest req1 = new MatchRequest(img1b64, "BASE64");
        MatchRequest req2 = new MatchRequest(img2b64, "BASE64");
        requests.add(req1);
        requests.add(req2);
        JSONObject jsonObject = GetBaiduAIPClient.GetFaceContrastive().match(requests);

        return jsonObject.toString();
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
