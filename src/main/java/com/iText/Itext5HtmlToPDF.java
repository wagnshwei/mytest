package com.iText;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class Itext5HtmlToPDF {
        // projectInitiateResolution.html
        // loanResolution.html
        // reviewResolution.html
//    public static String sourceHtmlPath = "C:\\Users\\HP\\IdeaProjects\\HelloWorld\\src\\main\\resources\\htmlTemplate\\test.html";
    public static String sourceHtmlPath = "D:\\workspace\\rzzl\\hussar-web\\src\\main\\resources\\htmlTemplate\\reviewResolution.html";

    public static String destinationPDFPath = "C:\\Users\\HP\\IdeaProjects\\HelloWorld\\src\\main\\resources\\pdfDir\\output.pdf";

    public static void htmlToPDF() {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destinationPDFPath));
            document.open();
            File htmlFile = ResourceUtils.getFile(sourceHtmlPath);
            String htmlStr = new String(Files.readAllBytes(htmlFile.toPath()));
            // TODO: 可以在此处处理htmlStr关键字的替换

            byte[] htmlByteArr = htmlStr.getBytes();
            try (ByteArrayInputStream fis = new ByteArrayInputStream(htmlByteArr)) {
                XMLWorkerHelper.getInstance().parseXHtml(writer, document, fis, null, Charset.defaultCharset(), new FontProviderUtil());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("Start!");
        htmlToPDF();
        System.out.println("OK!");
    }

}

class FontProviderUtil extends XMLWorkerFontProvider {
//    private static final Logger logger = LoggerFactory.getLogger(FontProviderUtil.class);

    @Override
    public Font getFont(final String fontname, final String encoding,
                        final boolean embedded, final float size, final int style,
                        final BaseColor color) {
        BaseFont bf = createBaseFont();
        if (bf == null) {
            return super.getFont(fontname, encoding, embedded, size, style, color);
        }
        Font font = new Font(bf, size, style, color);
        font.setColor(color);
        return font;
    }

    private BaseFont createBaseFont() {
        try {
            return BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
//            logger.error("Failed to create base font", e);
            return null;
        }
    }
}

//class FontProviderUtil extends XMLWorkerFontProvider {
//    @Override
//    public Font getFont(final String fontname, final String encoding,
//                        final boolean embedded, final float size, final int style,
//                        final BaseColor color) {
//        BaseFont bf = null;
//        try {
//            bf = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//        } catch (Exception e) {
//            // 处理异常。。。
//            e.printStackTrace();
//        }
//        Font font = new Font(bf, size, style, color);
//        font.setColor(color);
//        return font;
//    }
//}

//    public static void htmlToPDF() {
//        Document document = null;
//        FileOutputStream fos = null;
//        PdfWriter writer = null;
//        ByteArrayInputStream fis = null;
//
//        try {
//            // 第一步，创建一个 iTextSharp.text.Document对象的实例,为该Document创建一个Writer实例：
//            writer = PdfWriter.getInstance(document = new Document(), fos = new FileOutputStream(destinationPDFPath));
//            // 第二步，打开当前Document
//            document.open();
//
//            // 第三步，为当前Document添加内容：
//
//            // 3.1 该为加载html文件字符串生成pdf方式
//            File htmlFile = ResourceUtils.getFile(sourceHtmlPath);
//            FileReader htmlFileReader = FileReader.create(htmlFile);
//            String htmlStr = htmlFileReader.readString();
//            // TODO:
//            // 可以在此处处理htmlStr关键字的替换：
//            // for example：
//            // htmlStr = HtmlUtils.replaceKeyWords(htmlStr);
//            byte[] htmlByteArr = htmlStr.getBytes();
//
//            // 3.2 该为加载html文件生成pdf方式
//            XMLWorkerHelper.getInstance().parseXHtml(
//                    writer, document,
//                    fis = new ByteArrayInputStream(htmlByteArr),
//                    null,
//                    Charset.defaultCharset(),
//                    new FontProviderUtil()
//            );
//
//        } catch(Exception e) {
//            // 处理异常。。。。
//            e.printStackTrace();
//        } finally {
//            // 第四步，关闭
//            if(document != null) {
//                document.close();
//            }
//            if(fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(writer != null) {
//                writer.close();
//            }
//            if(fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }