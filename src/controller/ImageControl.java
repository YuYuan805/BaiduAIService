package controller;

import service.ImageService;
import service.NlpService;
import utils.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 声明Servlet应用
@WebServlet("/imagecontrol") // 地址映射，url声明，做一个安全的数据传输通道，实现前后端数据交互
public class ImageControl extends HttpServlet {
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
        // 图片头像转动漫
        if (action.equals("anime")) {
            writer.print(ImageService.getNlpService().getSelfieAnime(FileUtil.readReqAsByte(req)));
        }
        // 黑白上色
        if (action.equals("bw")) {
            writer.print(ImageService.getNlpService().getBlackWhite(FileUtil.readReqAsByte(req)));
        }
        // 图片风格转换
        if (action.equals("styletrans")) {
            writer.print(ImageService.getNlpService().getStyleTrans(FileUtil.readReqAsByte(req)));
        }
        // 2024年4月20日10点55分 ： wyy
        // 通用物体识别
        if (action.equals("objectdetect")) {
            writer.print(ImageService.getNlpService().getObjectDetect(FileUtil.readReqAsByte(req)));
        }
        // 2024年4月20日15点42分 ： sb
        // 动物识别
        if (action.equals("animal")) {
            writer.print(ImageService.getNlpService().getAnimalDetect(FileUtil.readReqAsByte(req)));
        }
        // 2024年4月20日16点29分：wyy
        // 菜品识别
        if (action.equals("dish")) {
            writer.print(ImageService.getNlpService().getDishDetect(FileUtil.readReqAsByte(req)));
        }
        // 2024年4月20日18点31分：wyy
        // logo商标识别
        if (action.equals("logo")) {
            writer.print(ImageService.getNlpService().getLogoSearch(FileUtil.readReqAsByte(req)));
        }
        // 2024年4月20日18点46分：wyy
        // 植物识别
        if (action.equals("plant")) {
            writer.print(ImageService.getNlpService().getPlantDetect(FileUtil.readReqAsByte(req)));
        }
        // 2024年4月20日19点09分：wyy
        // 地标识别
        if (action.equals("landmark")) {
            writer.print(ImageService.getNlpService().getLandmark(FileUtil.readReqAsByte(req)));
        }
        // 2024年4月20日19点10分：wyy
        // 果蔬识别
        if (action.equals("fruit")) {
            writer.print(ImageService.getNlpService().getFruit(FileUtil.readReqAsByte(req)));
        }
        // 2024年4月20日19点12分：wyy
        // 红酒识别
        if (action.equals("redwine")) {
            writer.print(ImageService.getNlpService().getRedwine(FileUtil.readReqAsByte(req)));
        }
        // 2024年4月20日19点13分：wyy
        // 货币识别
        if (action.equals("currency")) {
            writer.print(ImageService.getNlpService().getVehicleDetect(FileUtil.readReqAsByte(req)));
        }






        writer.flush();
        writer.close();
    }
}
