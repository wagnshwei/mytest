//package com.iText;
//
//import com.itextpdf.html2pdf.HtmlConverter;
//import com.itextpdf.io.font.FontProgram;
//import com.itextpdf.io.font.FontProgramFactory;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.layout.font.FontProvider;
//import com.itextpdf.html2pdf.ConverterProperties;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class HtmlToPdfDemo {
//    public static void main(String[] args) {
//        String srcHtml = "D:\\test.html";
//        String destPdf = "D:\\output.pdf";
//        String fontPath = "D:\\simhei.tff";
//
//        try {
//            // 注册中文字体
//            PdfFontFactory.register(fontPath, "ChineseFont");
//
//            FontProvider fontProvider = new FontProvider();
//            fontProvider.addFont("ChineseFont"); // 使用前面注册的字体别名
//
//            ConverterProperties properties = new ConverterProperties();
//            properties.setFontProvider(fontProvider);
//
//            HtmlConverter.convertToPdf(new FileInputStream(srcHtml), new FileOutputStream(destPdf), properties);
//
//            System.out.println("PDF with Chinese content generated successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
