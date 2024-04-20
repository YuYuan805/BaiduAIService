package controller;

import service.NlpService;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 声明Servlet应用
@WebServlet("/nlpcontrol") // 地址映射，url声明，做一个安全的数据传输通道，实现前后端数据交互
public class NlpControl extends HttpServlet {
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
        // 语言情感处理分析
        if (action.equals("sentiment")) {
            writer.print(NlpService.getNlpService().getSentiment(req.getParameter("text")));
        }
        // 地址识别
        if (action.equals("address")) {
            writer.print(NlpService.getNlpService().getAddress(req.getParameter("text")));
        }
        // 修改日期：2024年4月20日10点50分
        // 修改：lx
        // 文本纠错
        if (action.equals("ecnet")) {
            writer.print(NlpService.getNlpService().getecnet(req.getParameter("text")));
        }

        //2024年4月20日16:00:41
        // 文本纠错
        if (action.equals("newsSummary")) {
            writer.print(NlpService.getNlpService().getnewsSummary(req.getParameter("text")));
        }

        writer.flush();
        writer.close();
    }
}
