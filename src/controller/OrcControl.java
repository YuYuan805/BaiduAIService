package controller;

import service.OcrService;
import utils.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 声明Servlet应用
@WebServlet("/ocrcontrol") // 地址映射，url声明，做一个安全的数据传输通道，实现前后端数据交互
public class OrcControl extends HttpServlet {
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
        // 返回数据到客户端
        PrintWriter writer = resp.getWriter();

        // 文字提取
        if (action.equals("text")) {
            writer.print(OcrService.getOcrService().getText(FileUtil.readReqAsByte(req)));
        }

        // 身份证识别
        if (action.equals("IDcard")) {
            writer.print(OcrService.getOcrService().getIDcard(FileUtil.readReqAsByte(req)));
        }

        // 银行卡识别
        if (action.equals("bankcard")) {
            writer.print(OcrService.getOcrService().getBankCard(FileUtil.readReqAsByte(req)));
        }

        // 车牌识别
        if (action.equals("plateLicense")) {
            writer.print(OcrService.getOcrService().getPlateLicense(FileUtil.readReqAsByte(req)));
        }

        // 车票识别
        if (action.equals("trainTicket")) {
            writer.print(OcrService.getOcrService().getTrainTicket(FileUtil.readReqAsByte(req)));
        }

        writer.flush();
        writer.close();
    }
}
