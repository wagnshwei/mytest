package com.iText;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.ElementHandlerPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

/**
 * @description html转pdf 支持中文内容
 * @date 2023/11/9
 */

public class HtmlToPdfUtils {

	private static final Logger log = Logger.getLogger(HtmlToPdfUtils.class.getName());

	private HtmlToPdfUtils() {
	}

	/**
	 * 创建包含单词的PDF
	 *
	 * @param htmlStr 字符串
	 * @param pdfPath pdf路径
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void creatHtmlpdf(String htmlStr, String pdfPath) throws IOException, DocumentException {
		// step 1 new Document 默认大小A4
		Document document = new Document(PageSize.A4.rotate());
		// step 2
		PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(pdfPath)));
		// step 3
		document.open();
		// step 4
		Paragraph context = new Paragraph();
		ElementList elementList = parseToElementList(htmlStr, null);
		context.addAll(elementList);
		document.add(context);
		// step 5
		document.close();
	}

	/**
	 * 设置字体信息
	 *
	 * @return
	 */
	private static Font getFontInf() {
		// 字体路径
		String fontPath = "D:\\simhei.ttf";
		BaseFont baseFont = null;
		Font font = null;
		try {
			// 设置字体路径,字体编码，是否将字体嵌入pdf（默认false）
			baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			// 设置默认字体数据
			font = new Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK);
		} catch (DocumentException | IOException e) {
			log.log(Level.SEVERE, "获取pdf字体信息失败", e);
		}
		return font;
	}

	/**
	 * html转pdf 写法
	 *
	 * @param html
	 * @param css
	 * @return
	 * @throws IOException
	 */
	public static ElementList parseToElementList(String html, String css) throws IOException {
		// CSS
		CSSResolver cssResolver = new StyleAttrCSSResolver();
		if (css != null) {
			CssFile cssFile = XMLWorkerHelper.getCSS(new ByteArrayInputStream(css.getBytes()));
			cssResolver.addCss(cssFile);
		}

		// HTML
		MyFontsProvider fontProvider = new MyFontsProvider();
		CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
		HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
		htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
		htmlContext.autoBookmark(false);

		// Pipelines
		ElementList elements = new ElementList();
		ElementHandlerPipeline end = new ElementHandlerPipeline(elements, null);
		HtmlPipeline htmlPipeline = new HtmlPipeline(htmlContext, end);
		CssResolverPipeline cssPipeline = new CssResolverPipeline(cssResolver, htmlPipeline);

		// XML Worker
		XMLWorker worker = new XMLWorker(cssPipeline, true);
		XMLParser p = new XMLParser(worker);
		html = html.replace("<br>", "").replace("<hr>", "").replace("<img>", "").replace("<param>", "").replace("<link>", "");
		p.parse(new ByteArrayInputStream(html.getBytes()));
		return elements;
	}

	static class MyFontsProvider extends XMLWorkerFontProvider {
		public MyFontsProvider() {
			super(null, null);
		}

		@Override
		public Font getFont(final String fontname, String encoding, float size, final int style) {
			return getFontInf();
		}
	}


	public static void main(String[] args) throws DocumentException, IOException {
		String htmlPath = "C:\\Users\\HP\\IdeaProjects\\HelloWorld\\src\\main\\resources\\htmlTemplate\\conferenceResolution.html"; // 输入HTML文件的路径
		String pdfPath = "C:\\Users\\HP\\IdeaProjects\\HelloWorld\\src\\main\\resources\\htmlTemplate\\output.pdf"; // 输出PDF文件的路径
		// 获取html内容文字
		String htmlContent = new String(Files.readAllBytes(Paths.get(htmlPath)));
		creatHtmlpdf(htmlContent, pdfPath);
	}
}
