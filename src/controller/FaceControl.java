package controller;

import service.FaceService;
import service.ImageService;
import utils.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// 声明Servlet应用
@WebServlet("/facecontrol") // 地址映射，url声明，做一个安全的数据传输通道，实现前后端数据交互
public class FaceControl extends HttpServlet {
    // http协议请求方式:get、post
    // get:地址栏，携带的数据显示，有大小限制
    // post:隐式请求，携带的数据不可见，无大小限制
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HttpServletRequest 请求对象
        // HttpServletResponse 响应对象

        // 配置servlet应用
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 配置编码格式，避免前后端乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 定义统一参数action，表示提交的动作请求类型
        String action = req.getParameter("action");

        PrintWriter writer = resp.getWriter();
        // 人脸信息识别
        if (action.equals("face")) {
            writer.print(FaceService.getFaceService().getFaceDetect(FileUtil.readReqAsByte(req)));
        }


        //新增 2024年4月21日09:16:50 ss
        // 人脸对比
        if (action.equals("FaceContrastive")) {
            ArrayList list = FileUtil.readReqAsListByte(req);
            System.out.println(list.size());
            byte[] img1 = (byte[]) list.get(0);
            byte[] img2 = (byte[]) list.get(1);
            writer.write(FaceService.getFaceService().GetFacecontrastive(img1, img2));

        }

        writer.flush();
        writer.close();
    }
}
