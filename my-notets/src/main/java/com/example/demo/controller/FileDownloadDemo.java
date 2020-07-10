package com.example.demo.controller;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author hongzf
 * @date 2020/7/6
 */
@RestController
@RequestMapping("/file")
public class FileDownloadDemo {

    /**
     * 已流的方式下载
     *
     * @param path
     * @param response
     * @return
     */
//    @RequestMapping("/do1")
//    public HttpServletResponse download(String path, HttpServletResponse response) throws IOException {
//        try {
//            // path是指欲下载的文件的路径。
//            File file = new File(path);
//            // 取得文件名。
//            String filename = file.getName();
//            // 取得文件的后缀名。
//            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
//
//            // 以流的形式下载文件。
//            InputStream fis = new BufferedInputStream(new FileInputStream(path));
//            byte[] buffer = new byte[fis.available()];
//            fis.read(buffer);
//            fis.close();
//            // 清空response
//            response.reset();
//            // 设置response的Header
//            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
//            response.addHeader("Content-Length", "" + file.length());
//            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
//            response.setContentType("application/octet-stream");
//            toClient.write(buffer);
//            toClient.flush();
//            toClient.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return response;
//    }

    /**
     * 下载本地文件
     *
     * @param response
     * @author hongzf
     * @date 2020/7/9 22:44
     */
    @RequestMapping("/do2")
    //可以对受检异常进行捕捉并抛出
    public void downloadLocal(HttpServletResponse response) throws IOException {
        //文件的默认保存名
        String fileName = "Fz.png";

        String path = System.getProperty("user.dir");
        //将存放的文件路径读到流中
        @Cleanup InputStream inStream = new FileInputStream(path + "/my-notets/src/main/resources/static/img/Fz.png");

        //设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // 循环取出流中的数据
        byte[] b = new byte[1 << 8];
        int len;

        @Cleanup ServletOutputStream outputStream = response.getOutputStream();
        while ((len = inStream.read(b)) > 0) {
            outputStream.write(b, 0, len);
        }
    }

    /**
     * 下载链接文件
     *
     * @param response
     * @throws MalformedURLException
     */
    @RequestMapping("/do3")
    public void downloadNet(HttpServletResponse response) throws MalformedURLException {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL url = new URL("https://image.cnhnb.com/image/jpeg/head/2020/02/20/015c8ea5c989414aafb4716017185e2c.jpeg?imageView2/1/w/525/h/525/format/jpg/interlace/1/quality/100/ignore-error/1");

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream("/Users/zhifa/Downloads/do");

            byte[] buffer = new byte[1 << 10];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 支持在线打开
     *
     * @param filePath
     * @param response
     * @param isOnLine
     * @throws Exception
     */
    @RequestMapping("/do4")
    public void downLoad(String filePath, HttpServletResponse response, boolean isOnLine) throws Exception {
        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1 << 10];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        br.close();
        out.close();
    }

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */

    @RequestMapping("/do5")
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {

        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取字节数组
        byte[] getData = readInputStream(inputStream);
//        byte[] getData = new byte[inputStream.available()];
//        inputStream.read(getData);
        //文件保存位置

        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }

        File file = new File(saveDir + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        fos.close();

        inputStream.close();
        System.out.println("info:" + url + " download success");


    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();

    }

//    @RequestMapping("/do6")
//    public void recursion(String root, Vector<File> vecFile, HttpServletResponse response, HttpServletRequest request) throws IOException {
//        //根据路径生成一个文件
//        root = "/Users/zhifa/Downloads/fz";
//        java.io.File file = new java.io.File(root);
//        java.io.File[] subFile = file.listFiles();
//        //遍历文件里面的所有文件
//        for (File value : subFile) {
//            /*如果是文件夹，则递归下去寻找文件夹里面的文件*/
//            if (value.isDirectory()) {
//                //recursion(subFile[i].getAbsolutePath(), vecFile);
//            } else {
//                //如果不是文件夹的话就直接添加到vector容器里面去
//                //将遍历出来的文件进行压缩和下载：
////            String filename = subFile[i].getName();
////            vecFile.add(filename);
//                vecFile.add(value);
//            }
//        }
//        //设置下载文件的名称
//        String fileName = "temp1.zip";
//        response.setContentType("text/html; charset=UTF-8"); // 设置编码字符
//        response.setContentType("application/x-msdownload"); // 设置内容类型为下载类型
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName);// 设置下载的文件名称
//        OutputStream out = response.getOutputStream(); // 创建页面返回方式为输出流，会自动弹出下载框
//        //创建压缩文件需要的空的zip包
//        String zipBasePath = request.getSession().getServletContext().getRealPath("/logs/2/");
//        /* 输出basePath的路径，方便调试 */
//        System.out.println(zipBasePath);
//        /* 创建压缩文件需要的空的zip包 ，这里是自动生成的，不用我们自己去生成 */
//        String zipFilePath = "/Users/zhifa/Downloads/" + "temp.zip";
//        System.out.println("create the empty zip file successfully??????");
//        //根据临时的zip压缩包路径，创建zip文件
//        java.io.File zip = new java.io.File(zipFilePath);
//        if (!zip.exists()) {
//            zip.createNewFile();
//        }
//        System.out.println("create the  zip file successfully");
//        // 创建zip文件输出流
//        FileOutputStream fos = new FileOutputStream(zip);
//        ZipOutputStream zos = new ZipOutputStream(fos);
//        System.out.println("create the empty zip stream successfully");
//        //循环读取文件路径集合，获取每一个文件的路径（将文件一个一个进行压缩）
//        for (java.io.File fp : vecFile) {
//            zipFile(fp, zos); // 将每一个文件写入zip文件包内，即进行打包
//        }
//        System.out.println("get the path successfully");
//        // fos.close();//如果这样关两次的话会报错，java.io.IOException: Stream closed
//        zos.close();
//        System.out.println("ok??");
//        //将打包后的文件写到客户端,使用缓冲流输出
//        InputStream fis = new BufferedInputStream(new FileInputStream(zipFilePath));
//        byte[] buff = new byte[4096];
//        int size = 0;
//        while ((size = fis.read(buff)) != -1) {
//            out.write(buff, 0, size);
//        }
//        System.out.println("package is packed successfully");
//        //释放和关闭输入输出流
//        out.flush();//清楚缓存
//        out.close();
//        fis.close();
//
//    }

    /**
     * 文件压缩的方法
     *
     * @param inputFile
     * @param zipoutputStream
     */
    public static void zipFile(File inputFile, ZipOutputStream zipoutputStream) {
        try {
            if (inputFile.exists()) { // 判断文件是否存在
                if (inputFile.isFile()) { // 判断是否属于文件，还是文件夹

                    // 创建输入流读取文件
                    FileInputStream fis = new FileInputStream(inputFile);
                    BufferedInputStream bis = new BufferedInputStream(fis);

                    // 将文件写入zip内，即将文件进行打包
                    ZipEntry ze = new ZipEntry(inputFile.getName()); // 获取文件名
                    zipoutputStream.putNextEntry(ze);

                    // 写入文件的方法，同上
                    byte[] b = new byte[1024];
                    long l = 0;
                    while (l < inputFile.length()) {
                        int j = bis.read(b, 0, 1024);
                        l += j;
                        zipoutputStream.write(b, 0, j);
                    }
                    // 关闭输入输出流
                    bis.close();
                    fis.close();
                } else { // 如果是文件夹，则使用穷举的方法获取文件，写入zip
                    try {
                        File[] files = inputFile.listFiles();
                        for (int i = 0; i < files.length; i++) {
                            zipFile(files[i], zipoutputStream);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.err.println("文件不存在" + inputFile.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件压缩的方法
     *
     * @param fileUrl         文件网址
     * @param zipoutputStream
     */
    public static void zipFile(String fileUrl, ZipOutputStream zipoutputStream) {
        BufferedInputStream bis = null;
        InputStream inStream = null;
        try {
            URL url = new URL(fileUrl);
            URLConnection conn = url.openConnection();
            //这个是文件大小吗?
            long contentLengthLong = conn.getContentLengthLong();
            System.out.println("文件大小:" + contentLengthLong);
            inStream = conn.getInputStream();
            bis = new BufferedInputStream(inStream);

            // 将文件写入zip内，即将文件进行打包
            ZipEntry ze = new ZipEntry(System.currentTimeMillis() + ""); // 获取文件名
            //创建压缩文件
            zipoutputStream.putNextEntry(ze);
            // 写入文件的方法，同上
            byte[] b = new byte[1 << 10];
            long l = 0;
            while (l < contentLengthLong) {//原本是小于inputFile.length()
                int j = bis.read(b, 0, 1024);
                l += j;
                zipoutputStream.write(b, 0, j);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入输出流
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * @param list     待下载的文件url集合
     * @param fileName 下载的文件名称
     * @param response
     * @throws IOException
     */
    @RequestMapping("/do7")
    public static void recursion(String fileName, HttpServletResponse response) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("https://image.cnhnb.com/image/jpeg/head/2019/08/11/4be72c2a5d5c4b26b358c405db7c239d.jpeg?imageView2/1/w/525/h/525/format/jpg/interlace/1/quality/100/ignore-error/1");
        list.add("https://image.cnhnb.com/image/jpeg/head/2019/08/11/4be72c2a5d5c4b26b358c405db7c239d.jpeg?imageView2/1/w/525/h/525/format/jpg/interlace/1/quality/100/ignore-error/1");
        list.add("https://image.cnhnb.com/image/jpeg/head/2019/08/11/4be72c2a5d5c4b26b358c405db7c239d.jpeg?imageView2/1/w/525/h/525/format/jpg/interlace/1/quality/100/ignore-error/1");
        //2 将遍历出来的文件进行压缩和下载：（一个一个压缩）
        //2.1 设置下载文件的名称
        response.setContentType("text/html; charset=UTF-8"); // 设置编码字符
        response.setContentType("application/x-msdownload"); // 设置内容类型为下载类型
        response.setHeader("Content-disposition", "attachment;filename=" + "fileName.zip");// 设置下载的文件名称
        OutputStream out = response.getOutputStream(); // 创建页面返回方式为输出流，会自动弹出下载框
        System.out.println("配置成功");

        //2.2 创建压缩文件需要的空的zip包
//        String zipBasePath = request.getSession().getServletContext().getRealPath("/logs/2/");
        String zipBasePath = "/Users/zhifa/Downloads/";
        /* 输出basePath的路径，方便调试 */
        System.out.println(zipBasePath);
        /* 创建压缩文件需要的空的zip包 ，这里是自动生成的，不用我们自己去生成 */
        String zipFilePath = zipBasePath + "temp.zip";
        System.out.println("create the empty zip file successfully??????");

        //2.3 根据临时的zip压缩包路径，创建zip文件
        File zip = new File(zipFilePath);
        if (!zip.exists()) {
            zip.createNewFile();
        }
        System.out.println("create the  zip file successfully");

        //2.4 创建zip文件输出流
        FileOutputStream fos = new FileOutputStream(zip);
        ZipOutputStream zos = new ZipOutputStream(fos);
        System.out.println("create the empty zip stream successfully");

        //2.5 循环读取文件路径集合，获取每一个文件的路径（将文件一个一个进行压缩）
        //循环读取文件url,下载到压缩包中
        for (String url : list) {
            System.out.println(url);
            zipFile(url, zos); // 将每一个文件写入zip文件包内，即进行打包
        }
        System.out.println("get the path successfully");

        zos.close();
        fos.close();
        System.out.println("ok??");

        //2.6 将打包后的文件写到客户端，有两种方法可以实现（下面会进行介绍），这里使用缓冲流输出
        InputStream fis = new BufferedInputStream(new FileInputStream("/Users/zhifa/Downloads/filePicture.zip"));
        byte[] buff = new byte[4096];
        int size = 0;
        while ((size = fis.read(buff)) != -1) {
            out.write(buff, 0, size);
        }
        System.out.println("package is packed successfully");

        out.flush();
        out.close();
        fis.close();
    }

}
