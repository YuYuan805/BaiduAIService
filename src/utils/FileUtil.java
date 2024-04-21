package utils;


// FileUtil 获取请求二进制，获取本地路径二进制，获取文件内容二进制

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

// FileUtil 读取文件二进制的工具类
public class FileUtil {

    public FileUtil(){}

    /*
     * 解析请求输入流，返回二进制数据
     * @param req
     * @return byte[]
     *
     */

    public static byte[] readReqAsByte(HttpServletRequest req){

        // 创建一个字节（32字节）的缓冲区
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        // 异常捕捉
        try {
            // ServletFileUpload tomcat处理上传文件的高级API
            // DiskFileItemFactory 创建上文文件缓存区及配置
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            // setHeaderEncoding 设置编码
            fileUpload.setHeaderEncoding("utf-8");

            // ServletRequestContext 获取当前请求的上下文对象
            ServletRequestContext requestContext = new ServletRequestContext(req);
            // parseRequest 解析请求对象,返回文件的List列表
            List<FileItem> fileItems = fileUpload.parseRequest(requestContext);

            // 迭代器
            for(FileItem file:fileItems){

                // file 存在两种类型 1 普通表单文件（文本） 2 file表单文件
                // isFormField 判断是否是普通表单类型 true 是 false 不是
                if (!file.isFormField()){
                    // 文件输入流
                    InputStream is = file.getInputStream();

                    byte[] buffer = new byte[1024]; // 缓冲区
                    int len = 0; // 记录读取的长度
                    // IO流的读写
                    while ((len=is.read(buffer)) > 0){
                        os.write(buffer,0,len);
                    }

                    os.close();
                    is.close();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        // 返回字节数组
        // toByteArray() 转换
        return os.toByteArray();
    }

    public static ArrayList readReqAsListByte(HttpServletRequest req){

        ArrayList<byte[]> list  = new ArrayList<>();
        // 创建一个字节（32字节）的缓冲区
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        // 异常捕捉
        try {
            // ServletFileUpload tomcat处理上传文件的高级API
            // DiskFileItemFactory 创建上文文件缓存区及配置
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            // setHeaderEncoding 设置编码
            fileUpload.setHeaderEncoding("utf-8");

            // ServletRequestContext 获取当前请求的上下文对象
            ServletRequestContext requestContext = new ServletRequestContext(req);
            // parseRequest 解析请求对象,返回文件的List列表
            List<FileItem> fileItems = fileUpload.parseRequest(requestContext);

            // 迭代器
            for(FileItem file:fileItems){

                // file 存在两种类型 1 普通表单文件（文本） 2 file表单文件
                // isFormField 判断是否是普通表单类型 true 是 false 不是
                if (!file.isFormField()){
                    // 文件输入流
                    InputStream is = file.getInputStream();

                    byte[] buffer = new byte[1024]; // 缓冲区
                    int len = 0; // 记录读取的长度
                    // IO流的读写
                    while ((len=is.read(buffer)) > 0){
                        os.write(buffer,0,len);
                    }

                    os.close();
                    is.close();
                    list.add(os.toByteArray());
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        // 返回字节数组
        // toByteArray() 转换
        return list;
    }
    /**
     * 读取文件内容，作为字符串返回
     */
    public static String readFileAsString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        }

        if (file.length() > 1024 * 1024 * 1024) {
            throw new IOException("File is too large");
        }

        StringBuilder sb = new StringBuilder((int) (file.length()));
        // 创建字节输入流
        FileInputStream fis = new FileInputStream(filePath);
        // 创建一个长度为10240的Buffer
        byte[] bbuf = new byte[10240];
        // 用于保存实际读取的字节数
        int hasRead = 0;
        while ( (hasRead = fis.read(bbuf)) > 0 ) {
            sb.append(new String(bbuf, 0, hasRead));
        }
        fis.close();
        return sb.toString();
    }


    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }

}
