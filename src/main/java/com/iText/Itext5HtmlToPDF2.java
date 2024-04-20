//package com.iText;
//
//import cn.hutool.core.io.file.FileReader;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.tool.xml.XMLWorkerFontProvider;
//import com.itextpdf.tool.xml.XMLWorkerHelper;
//import org.springframework.util.ResourceUtils;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.nio.charset.Charset;
//
//
//public class Itext5HtmlToPDF2 {
//
//    public static String htmlPath = "D:\\test.html";
//
//    public static String PDFPath = "D:\\output.pdf";
//
//    public static void main(String[] args) throws Exception {
//
//        Document document = new Document();
//
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(PDFPath));
//        //第三步，打开当前Document
//        document.open();
//        //第四步，为当前Document添加内容：
//
//        // 4.1 该为加载html文件字符串生成pdf方式
//        File file2 = ResourceUtils.getFile(htmlPath);
//        String s = FileReader.create(file2).readString();
//
//        ByteArrayInputStream fis = new ByteArrayInputStream(s.getBytes());
//
//        // 4.2 该为加载html文件生成pdf方式
//        //FileInputStream fis = new FileInputStream("D:\\test\\HelloWorld.html");
//        XMLWorkerHelper.getInstance().parseXHtml(writer, document,fis ,null, Charset.defaultCharset(),new FontProviderUtil());
//        //第五步，关闭Document
//        document.close();
//        System.out.println("OK!");
//
//    }
//}
//
//class FontProviderUtil2 extends XMLWorkerFontProvider {
//    @Override
//    public Font getFont(final String fontname, final String encoding,
//                        final boolean embedded, final float size, final int style,
//                        final BaseColor color) {
//        BaseFont bf = null;
//        try {
//            bf = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Font font = new Font(bf, size, style, color);
//        font.setColor(color);
//        return font;
//    }
//}