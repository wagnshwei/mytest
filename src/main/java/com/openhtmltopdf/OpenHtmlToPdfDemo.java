//package com.openhtmltopdf;
//
//import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
//
//import java.io.FileOutputStream;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class OpenHtmlToPdfDemo {
//
//    public static void main(String[] args) {
//        try {
//            // HTML 文件路径
//            String htmlFilePath = "D:\\test.html";
//            // PDF 输出文件路径
//            String pdfFilePath = "D:\\output.pdf";
//
//            // 读取 HTML 文件内容
//            byte[] htmlBytes = Files.readAllBytes(Paths.get(htmlFilePath));
//            String htmlContent = new String(htmlBytes, StandardCharsets.UTF_8);
//
//            // 使用 PdfRendererBuilder 构建 PDF 渲染器
//            PdfRendererBuilder builder = new PdfRendererBuilder();
//            builder.withHtmlContent(htmlContent, null);
//            builder.toStream(new FileOutputStream(pdfFilePath));
//            builder.run();
//
//            System.out.println("PDF created successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}