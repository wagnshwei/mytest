//package com.openhtmltopdf;
//
//import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
//
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//
//public class HtmlToPdf {
//    public static void main(String[] args) {
//        try {
//            OutputStream os = new FileOutputStream("D:\\output.pdf");
//            PdfRendererBuilder builder = new PdfRendererBuilder();
//
//            builder.useFastMode();
//            builder.withUri("file:///D:/test.html");
//            builder.toStream(os);
//            builder.useFont(() -> HtmlToPdf.class.getResourceAsStream("D:\\simhei.ttf"), "Tahoma", 400, PdfRendererBuilder.FontStyle.NORMAL, true);
//
//            builder.run();
//            os.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}