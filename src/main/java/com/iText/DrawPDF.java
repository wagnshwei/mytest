//package com.iText;
//
//import com.itextpdf.io.font.PdfEncodings;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.geom.PageSize;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.property.HorizontalAlignment;
//import com.itextpdf.layout.property.TextAlignment;
//import com.itextpdf.layout.property.VerticalAlignment;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class ITextTableExample {
//    public class FpdkImportPDF {
//
//        /**
//         * 代开增值税专用发票缴纳税款申报单
//         */
//        public static void dkzzszyfp() {
//            // 1:建立Document对象实例
//            Document document = new Document();
//            try {
//                // 2:建立一个PDF 写入器与document对象关联通过书写器(Writer)可以将文档写入到磁盘中
//                StringBuilder filename = new StringBuilder();
//                filename.append("代开增值税专用发票缴纳税款申报单").append(new SimpleDateFormat("yyyyMMddHHmm").format(new Date())).append(".pdf");
//                PdfWriter.getInstance(document, new FileOutputStream(filename.toString()));
//
//                // 3:打开文档
//                document.open();
//
//                //解决中文不显示问题
//                BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//                Font fontChina18 = new Font(bfChinese, 18);
//                Font fontChina12 = new Font(bfChinese, 12);
//
//                // 4:向文档添加内容
//                // 标题
//                Paragraph titleParagraph = new Paragraph("代开增值税专用发票缴纳税款申报单",fontChina18);
//                titleParagraph.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(titleParagraph);
//
//                // 空格
//                Paragraph blank1 = new Paragraph(" ");
//                document.add(blank1);
//
//                // 编号
//                Chunk c1 = new Chunk("编号：", fontChina12);
//                Chunk c2 = new Chunk("20140531001", fontChina12);
//                Paragraph snoParagraph = new Paragraph();
//                snoParagraph.add(c1);
//                snoParagraph.add(c2);
//                snoParagraph.setAlignment(Element.ALIGN_RIGHT);
//                document.add(snoParagraph);
//
//                // 空格
//                document.add(blank1);
//
//                // 代开税务机关
//                Chunk c3 = new Chunk("代开税务机关名称：青岛经济技术开发区国税局", fontChina12);
//                Paragraph dkswjgParagraph = new Paragraph();
//                dkswjgParagraph.add(c3);
//                dkswjgParagraph.setAlignment(Element.ALIGN_LEFT);
//                document.add(dkswjgParagraph);
//
//                // 提醒
//                String alert = "我单位提供的开票资料真实、完整、准确，符合有关法律、法规，否则我单位将承担一切法律责任，现申请代开增值税专用发票。";
//                Paragraph alertParagraph = new Paragraph(alert, fontChina12);
//                alertParagraph.setFirstLineIndent(24);// 首行缩进个2字符
//                document.add(alertParagraph);
//
//                // 填开日期
//                Chunk c5 = new Chunk("填开日期：2014年05月31日", fontChina12);
//                Paragraph tkrqParagraph = new Paragraph();
//                tkrqParagraph.add(c5);
//                tkrqParagraph.setAlignment(Element.ALIGN_RIGHT);
//                document.add(tkrqParagraph);
//
//                // 空格
//                document.add(blank1);
//
//                // 表格处理
//                PdfPTable table = new PdfPTable(8);// 八列
//                table.setWidthPercentage(100);// 表格宽度为100%
//
//                // 购货单位
//                PdfPCell cell1 = new PdfPCell();
//                cell1.setBorderWidth(1);// Border宽度为1
//                cell1.setRowspan(3);// 跨三行
//                cell1.setPhrase(new Paragraph("购货单位", fontChina12));
//                cell1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell1.setExtraParagraphSpace(10);
//                table.addCell(cell1);
//
//                PdfPCell cell2 = new PdfPCell();
//                cell2.setBorderWidth(1);
//                cell2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell2.setPhrase(new Paragraph("名称", fontChina12));
//                table.addCell(cell2);
//                PdfPCell cell3 = new PdfPCell();
//                cell3.setBorderWidth(1);
//                cell3.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell3.setColspan(3);// 跨三列
//                cell3.setPhrase(new Paragraph("名称", fontChina12));
//                table.addCell(cell3);
//
//                PdfPCell cell4 = new PdfPCell();
//                cell4.setBorderWidth(1);
//                cell4.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell4.setPhrase(new Paragraph("税务登记号", fontChina12));
//                table.addCell(cell4);
//                PdfPCell cell5 = new PdfPCell();
//                cell5.setBorderWidth(1);
//                cell5.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell5.setColspan(2);// 跨两列
//                cell5.setPhrase(new Paragraph("税务登记号", fontChina12));
//                table.addCell(cell5);
//
//                PdfPCell cell6 = new PdfPCell();
//                cell6.setBorderWidth(1);
//                cell6.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell6.setPhrase(new Paragraph("地址", fontChina12));
//                table.addCell(cell6);
//                PdfPCell cell7 = new PdfPCell();
//                cell7.setBorderWidth(1);
//                cell7.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell7.setColspan(3);// 跨三列
//                cell7.setPhrase(new Paragraph("地址", fontChina12));
//                table.addCell(cell7);
//
//                PdfPCell cell8 = new PdfPCell();
//                cell8.setBorderWidth(1);
//                cell8.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell8.setPhrase(new Paragraph("开户银行", fontChina12));
//                table.addCell(cell8);
//                PdfPCell cell9 = new PdfPCell();
//                cell9.setBorderWidth(1);
//                cell9.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell9.setColspan(2);// 跨两列
//                cell9.setPhrase(new Paragraph("开户银行", fontChina12));
//                table.addCell(cell9);
//
//                PdfPCell cell10 = new PdfPCell();
//                cell10.setBorderWidth(1);
//                cell10.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell10.setPhrase(new Paragraph("电话", fontChina12));
//                table.addCell(cell10);
//                PdfPCell cell11 = new PdfPCell();
//                cell11.setBorderWidth(1);
//                cell11.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell11.setColspan(3);// 跨三列
//                cell11.setPhrase(new Paragraph("电话", fontChina12));
//                table.addCell(cell11);
//
//                PdfPCell cell12 = new PdfPCell();
//                cell12.setBorderWidth(1);
//                cell12.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell12.setPhrase(new Paragraph("开户银行账号", fontChina12));
//                table.addCell(cell12);
//                PdfPCell cell13 = new PdfPCell();
//                cell13.setBorderWidth(1);
//                cell13.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell13.setColspan(2);// 跨两列
//                cell13.setPhrase(new Paragraph("开户银行账号", fontChina12));
//                table.addCell(cell13);
//
//                // 货物或应税劳务信息
//                // Row1
//                PdfPCell cell14 = new PdfPCell();
//                cell14.setBorderWidth(1);
//                cell14.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell14.setPhrase(new Paragraph("货物或应税劳务名称", fontChina12));
//                table.addCell(cell14);
//                PdfPCell cell15 = new PdfPCell();
//                cell15.setBorderWidth(1);
//                cell15.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell15.setPhrase(new Paragraph("规格型号", fontChina12));
//                table.addCell(cell15);
//                PdfPCell cell16 = new PdfPCell();
//                cell16.setBorderWidth(1);
//                cell16.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell16.setPhrase(new Paragraph("计量单位", fontChina12));
//                table.addCell(cell16);
//                PdfPCell cell17 = new PdfPCell();
//                cell17.setBorderWidth(1);
//                cell17.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell17.setPhrase(new Paragraph("数量", fontChina12));
//                table.addCell(cell17);
//                PdfPCell cell18 = new PdfPCell();
//                cell18.setBorderWidth(1);
//                cell18.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell18.setPhrase(new Paragraph("单价", fontChina12));
//                table.addCell(cell18);
//                PdfPCell cell19 = new PdfPCell();
//                cell19.setBorderWidth(1);
//                cell19.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell19.setPhrase(new Paragraph("　金额", fontChina12));
//                table.addCell(cell19);
//                PdfPCell cell20 = new PdfPCell();
//                cell20.setBorderWidth(1);
//                cell20.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell20.setPhrase(new Paragraph("征收率", fontChina12));
//                table.addCell(cell20);
//                PdfPCell cell21 = new PdfPCell();
//                cell21.setBorderWidth(1);
//                cell21.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell21.setPhrase(new Paragraph("税额", fontChina12));
//                table.addCell(cell21);
//                // Row2 填写数据
//                PdfPCell cell22 = new PdfPCell();
//                cell22.setBorderWidth(1);
//                cell22.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell22.setPhrase(new Paragraph("货物或应税劳务名称", fontChina12));
//                table.addCell(cell22);
//                PdfPCell cell23 = new PdfPCell();
//                cell23.setBorderWidth(1);
//                cell23.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell23.setPhrase(new Paragraph("规格型号", fontChina12));
//                table.addCell(cell23);
//                PdfPCell cell24 = new PdfPCell();
//                cell24.setBorderWidth(1);
//                cell24.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell24.setPhrase(new Paragraph("计量单位", fontChina12));
//                table.addCell(cell24);
//                PdfPCell cell25 = new PdfPCell();
//                cell25.setBorderWidth(1);
//                cell25.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell25.setPhrase(new Paragraph("数量", fontChina12));
//                table.addCell(cell25);
//                PdfPCell cell26 = new PdfPCell();
//                cell26.setBorderWidth(1);
//                cell26.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell26.setPhrase(new Paragraph("单价", fontChina12));
//                table.addCell(cell26);
//                PdfPCell cell27 = new PdfPCell();
//                cell27.setBorderWidth(1);
//                cell27.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell27.setPhrase(new Paragraph("　金额", fontChina12));
//                table.addCell(cell27);
//                PdfPCell cell28 = new PdfPCell();
//                cell28.setBorderWidth(1);
//                cell28.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell28.setPhrase(new Paragraph("征收率", fontChina12));
//                table.addCell(cell28);
//                PdfPCell cell29 = new PdfPCell();
//                cell29.setBorderWidth(1);
//                cell29.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell29.setPhrase(new Paragraph("税额", fontChina12));
//                table.addCell(cell29);
//
//                // 价税合计
//                PdfPCell cell30 = new PdfPCell();
//                cell30.setBorderWidth(1);
//                cell30.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell30.setPhrase(new Paragraph("价税合计（大写）", fontChina12));
//                table.addCell(cell30);
//                PdfPCell cell31 = new PdfPCell();
//                cell31.setBorderWidth(1);
//                cell31.setColspan(4);// 跨四列
//                cell31.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell31.setPhrase(new Paragraph("价税合计（大写）", fontChina12));
//                table.addCell(cell31);
//                PdfPCell cell32 = new PdfPCell();
//                cell32.setBorderWidth(1);
//                cell32.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell32.setPhrase(new Paragraph("价税合计（小写）", fontChina12));
//                table.addCell(cell32);
//                PdfPCell cell33 = new PdfPCell();
//                cell33.setBorderWidth(1);
//                cell33.setColspan(2);// 跨两列
//                cell33.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell33.setPhrase(new Paragraph("价税合计（小写）", fontChina12));
//                table.addCell(cell33);
//                // 备注
//                PdfPCell cell34 = new PdfPCell();
//                cell34.setBorderWidth(1);
//                cell34.setMinimumHeight(40);
//                cell34.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell34.setPhrase(new Paragraph("备注", fontChina12));
//                table.addCell(cell34);
//                PdfPCell cell35 = new PdfPCell();
//                cell35.setBorderWidth(1);
//                cell35.setColspan(7);
//                cell35.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell35.setPhrase(new Paragraph("备注", fontChina12));
//                table.addCell(cell35);
//
//                // 销货单位
//                PdfPCell cell36 = new PdfPCell();
//                cell36.setBorderWidth(1);// Border宽度为1
//                cell36.setRowspan(3);// 跨三行
//                cell36.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell36.setPhrase(new Paragraph("销货单位", fontChina12));
//                table.addCell(cell36);
//
//                PdfPCell cell37 = new PdfPCell();
//                cell37.setBorderWidth(1);
//                cell37.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell37.setPhrase(new Paragraph("名称", fontChina12));
//                table.addCell(cell37);
//                PdfPCell cell38 = new PdfPCell();
//                cell38.setBorderWidth(1);
//                cell38.setColspan(3);// 跨三列
//                cell38.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell38.setPhrase(new Paragraph("名称", fontChina12));
//                table.addCell(cell38);
//
//                PdfPCell cell39 = new PdfPCell();
//                cell39.setBorderWidth(1);
//                cell39.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell39.setPhrase(new Paragraph("税务登记号", fontChina12));
//                table.addCell(cell39);
//                PdfPCell cell40 = new PdfPCell();
//                cell40.setBorderWidth(1);
//                cell40.setColspan(2);// 跨两列
//                cell40.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell40.setPhrase(new Paragraph("税务登记号", fontChina12));
//                table.addCell(cell40);
//
//                PdfPCell cell41 = new PdfPCell();
//                cell41.setBorderWidth(1);
//                cell41.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell41.setPhrase(new Paragraph("地址", fontChina12));
//                table.addCell(cell41);
//                PdfPCell cell42 = new PdfPCell();
//                cell42.setBorderWidth(1);
//                cell42.setColspan(3);// 跨三列
//                cell42.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell42.setPhrase(new Paragraph("地址", fontChina12));
//                table.addCell(cell42);
//
//                PdfPCell cell43 = new PdfPCell();
//                cell43.setBorderWidth(1);
//                cell43.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell43.setPhrase(new Paragraph("开户银行", fontChina12));
//                table.addCell(cell43);
//                PdfPCell cell44 = new PdfPCell();
//                cell44.setBorderWidth(1);
//                cell44.setColspan(2);// 跨两列
//                cell44.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell44.setPhrase(new Paragraph("开户银行", fontChina12));
//                table.addCell(cell44);
//
//                PdfPCell cell45 = new PdfPCell();
//                cell45.setBorderWidth(1);
//                cell45.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell45.setPhrase(new Paragraph("电话", fontChina12));
//                table.addCell(cell45);
//                PdfPCell cell46 = new PdfPCell();
//                cell46.setBorderWidth(1);
//                cell46.setColspan(3);// 跨三列
//                cell46.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell46.setPhrase(new Paragraph("电话", fontChina12));
//                table.addCell(cell46);
//
//                PdfPCell cell47 = new PdfPCell();
//                cell47.setBorderWidth(1);
//                cell47.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell47.setPhrase(new Paragraph("开户银行账号", fontChina12));
//                table.addCell(cell47);
//                PdfPCell cell48 = new PdfPCell();
//                cell48.setBorderWidth(1);
//                cell48.setColspan(2);// 跨两列
//                cell48.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell48.setPhrase(new Paragraph("开户银行账号", fontChina12));
//                table.addCell(cell48);
//
//                // 底部
//                Paragraph pQz = new Paragraph("（签字）", fontChina12);
//                pQz.setAlignment(Element.ALIGN_RIGHT);
//                pQz.setIndentationRight(20);
//                pQz.setExtraParagraphSpace(60);
//
//                Paragraph pJbrQz = new Paragraph("申请经办人（签字）", fontChina12);
//                pJbrQz.setAlignment(Element.ALIGN_RIGHT);
//                pJbrQz.setIndentationRight(20);
//                pJbrQz.setExtraParagraphSpace(60);
//
//                Paragraph pDate = new Paragraph(" 年   月   日", fontChina12);
//                pDate.setAlignment(Element.ALIGN_RIGHT);
//                pQz.setIndentationRight(20);
//
//                PdfPCell cellF1 = new PdfPCell();
//                cellF1.setBorderWidth(1);
//                cellF1.setColspan(2);
//                cellF1.setFixedHeight(200);//
//                Paragraph p0 = new Paragraph("税务机关税款征收岗位税收完税凭证号：", fontChina12);
//                cellF1.addElement(p0);
//                cellF1.addElement(blank1);
//                cellF1.addElement(blank1);
//                cellF1.addElement(blank1);
//                cellF1.addElement(pQz);
//                cellF1.addElement(pDate);
//                table.addCell(cellF1);
//
//                PdfPCell cellF2 = new PdfPCell();
//                cellF2.setBorderWidth(1);
//                cellF2.setColspan(3);
//                Paragraph p1 = new Paragraph("税务机关代开发票岗位", fontChina12);
//                Paragraph p2 = new Paragraph("发票代码： ", fontChina12);
//                Paragraph p3 = new Paragraph("发票号码： ", fontChina12);
//                cellF2.addElement(p1);
//                cellF2.addElement(p2);
//                cellF2.addElement(p3);
//                cellF2.addElement(blank1);
//                cellF2.addElement(blank1);
//                cellF2.addElement(pQz);
//                cellF2.addElement(pDate);
//                table.addCell(cellF2);
//
//                PdfPCell cellF3 = new PdfPCell();
//                cellF3.setBorderWidth(1);
//                cellF3.setColspan(3);
//                Paragraph p4 = new Paragraph("经核对，所开发票与申报单内容一致。", fontChina12);
//                p4.setFirstLineIndent(24);
//                cellF3.addElement(p4);
//                cellF3.addElement(blank1);
//                cellF3.addElement(blank1);
//                cellF3.addElement(blank1);
//                cellF3.addElement(pJbrQz);
//                cellF3.addElement(pDate);
//                table.addCell(cellF3);
//
//                document.add(table);
//
//                document.add(blank1);
//
//                //底部额外信息
//                StringBuilder sb1 = new StringBuilder();
//                sb1.append("申请代开发票纳税人（公章）_________");
//                sb1.append("法人代表_________");
//                sb1.append("财务负责人_________");
//                sb1.append("填写人_________");
//                Paragraph pE = new Paragraph(sb1.toString(),fontChina12);
//                pE.setAlignment(Element.ALIGN_CENTER);
//                document.add(pE);
//
//                document.add(blank1);
//
//                //注
//                StringBuilder sb2 = new StringBuilder();
//                sb2.append("注：第一联：税务机关代开发票岗位留存。");
//                sb2.append("第二联：税务机关税款征收岗位留存。");
//                Paragraph pZ = new Paragraph(sb2.toString(),fontChina12);
//                pZ.setAlignment(Element.ALIGN_CENTER);
//                document.add(pZ);
//
//                // 5:关闭文档
//                document.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (DocumentException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        /**
//         * 代开货物运输业增值税专用发票及缴纳税款申报单
//         */
//        public static void dkhyzzszyfp() {
//            Document document = new Document();
//            try {
//                // 2:建立一个PDF 写入器与document对象关联通过书写器(Writer)可以将文档写入到磁盘中
//                StringBuilder filename = new StringBuilder();
//                filename.append("代开货物运输业增值税专用发票及缴纳税款申报单").append(new SimpleDateFormat("yyyyMMddHHmm").format(new Date())).append(".pdf");
//                PdfWriter.getInstance(document, new FileOutputStream(filename.toString()));
//
//                // 3:打开文档
//                document.open();
//
//                //解决中文不显示问题
//                BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//                Font fontChina18 = new Font(bfChinese, 18);
//                Font fontChina12 = new Font(bfChinese, 12);
//
//                // 4:向文档添加内容
//                // 标题
//                Paragraph titleParagraph = new Paragraph("代开货物运输业增值税专用发票及缴纳税款申报单",fontChina18);
//                titleParagraph.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(titleParagraph);
//
//                // 空格
//                Paragraph blank1 = new Paragraph(" ");
//                document.add(blank1);
//
//                // 填开日期
//                Chunk c1 = new Chunk("填开日期：2014年05月31日", fontChina12);
//                Chunk c2 = new Chunk("   金额单位：元至角分", fontChina12);
//                Paragraph snoParagraph = new Paragraph();
//                snoParagraph.add(c1);
//                snoParagraph.add(c2);
//                snoParagraph.setAlignment(Element.ALIGN_RIGHT);
//                document.add(snoParagraph);
//
//                // 空格
//                document.add(blank1);
//
//                // 表格处理
//                PdfPTable table = new PdfPTable(6);// 六列
//                table.setWidthPercentage(100);// 表格宽度为100%
//
//                //以下由纳税人填写
//                PdfPCell cell1 = new PdfPCell();
//                cell1.setBorderWidth(1);// Border宽度为1
//                cell1.setColspan(6);//跨六列
//                cell1.setPhrase(new Paragraph("以下由纳税人填写", fontChina12));
//                cell1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//                table.addCell(cell1);
//
//                //实际受票方
//                PdfPCell cell2 = new PdfPCell();
//                cell2.setBorderWidth(1);
//                cell2.setRowspan(4);//跨四行
//                cell2.setPhrase(new Paragraph("实际受票方", fontChina12));
//                cell2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell2);
//
//                PdfPCell cell3 = new PdfPCell();
//                cell3.setBorderWidth(1);
//                cell3.setPhrase(new Paragraph("纳税人全称", fontChina12));
//                cell3.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell3);
//                PdfPCell cell4 = new PdfPCell();
//                cell4.setBorderWidth(1);
//                cell4.setColspan(4);//跨四列
//                cell4.setPhrase(new Paragraph("纳税人全称", fontChina12));
//                cell4.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell4);
//
//                PdfPCell cell5 = new PdfPCell();
//                cell5.setBorderWidth(1);
//                cell5.setPhrase(new Paragraph("纳税人识别号", fontChina12));
//                cell5.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell5);
//                PdfPCell cell6 = new PdfPCell();
//                cell6.setBorderWidth(1);
//                cell6.setColspan(4);//跨四列
//                cell6.setPhrase(new Paragraph("纳税人识别号", fontChina12));
//                cell6.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell6);
//
//                PdfPCell cell7 = new PdfPCell();
//                cell7.setBorderWidth(1);
//                cell7.setPhrase(new Paragraph("地址、电话", fontChina12));
//                cell7.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell7);
//                PdfPCell cell8 = new PdfPCell();
//                cell8.setBorderWidth(1);
//                cell8.setColspan(4);//跨四列
//                cell8.setPhrase(new Paragraph("地址、电话", fontChina12));
//                cell8.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell8);
//
//                PdfPCell cell9 = new PdfPCell();
//                cell9.setBorderWidth(1);
//                cell9.setPhrase(new Paragraph("开户行及帐号", fontChina12));
//                cell9.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell9);
//                PdfPCell cell10 = new PdfPCell();
//                cell10.setBorderWidth(1);
//                cell10.setColspan(4);//跨四列
//                cell10.setPhrase(new Paragraph("开户行及帐号", fontChina12));
//                cell10.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell10);
//
//                //承运人
//                PdfPCell cell11 = new PdfPCell();
//                cell11.setBorderWidth(1);
//                cell11.setRowspan(4);//跨四行
//                cell11.setPhrase(new Paragraph("承运人", fontChina12));
//                cell11.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell11);
//
//                PdfPCell cell12 = new PdfPCell();
//                cell12.setBorderWidth(1);
//                cell12.setPhrase(new Paragraph("纳税人全称", fontChina12));
//                cell12.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell12);
//                PdfPCell cell13 = new PdfPCell();
//                cell13.setBorderWidth(1);
//                cell13.setColspan(4);//跨四列
//                cell13.setPhrase(new Paragraph("纳税人全称", fontChina12));
//                cell13.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell13);
//
//                PdfPCell cell14 = new PdfPCell();
//                cell14.setBorderWidth(1);
//                cell14.setPhrase(new Paragraph("纳税人识别号", fontChina12));
//                cell14.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell14);
//                PdfPCell cell15 = new PdfPCell();
//                cell15.setBorderWidth(1);
//                cell15.setColspan(4);//跨四列
//                cell15.setPhrase(new Paragraph("纳税人识别号", fontChina12));
//                cell15.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell15);
//
//                PdfPCell cell16 = new PdfPCell();
//                cell16.setBorderWidth(1);
//                cell16.setPhrase(new Paragraph("地址、电话", fontChina12));
//                cell16.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell16);
//                PdfPCell cell17 = new PdfPCell();
//                cell17.setBorderWidth(1);
//                cell17.setColspan(4);//跨四列
//                cell17.setPhrase(new Paragraph("地址、电话", fontChina12));
//                cell17.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell17);
//
//                PdfPCell cell18 = new PdfPCell();
//                cell18.setBorderWidth(1);
//                cell18.setPhrase(new Paragraph("开户行及帐号", fontChina12));
//                cell18.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell18);
//                PdfPCell cell19 = new PdfPCell();
//                cell19.setBorderWidth(1);
//                cell19.setColspan(4);//跨四列
//                cell19.setPhrase(new Paragraph("开户行及帐号", fontChina12));
//                cell19.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell19);
//
//                //发货人
//                PdfPCell cell20 = new PdfPCell();
//                cell20.setBorderWidth(1);
//                cell20.setRowspan(2);//跨2行
//                cell20.setPhrase(new Paragraph("发货人", fontChina12));
//                cell20.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell20);
//
//                PdfPCell cell21 = new PdfPCell();
//                cell21.setBorderWidth(1);
//                cell21.setPhrase(new Paragraph("纳税人全称", fontChina12));
//                cell21.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell21);
//                PdfPCell cell22 = new PdfPCell();
//                cell22.setBorderWidth(1);
//                cell22.setColspan(4);//跨四列
//                cell22.setPhrase(new Paragraph("纳税人全称", fontChina12));
//                cell22.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell22);
//
//                PdfPCell cell23 = new PdfPCell();
//                cell23.setBorderWidth(1);
//                cell23.setPhrase(new Paragraph("纳税人识别号", fontChina12));
//                cell23.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell23);
//                PdfPCell cell24 = new PdfPCell();
//                cell24.setBorderWidth(1);
//                cell24.setColspan(4);//跨四列
//                cell24.setPhrase(new Paragraph("纳税人识别号", fontChina12));
//                cell24.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell24);
//
//                //收货人
//                PdfPCell cell25 = new PdfPCell();
//                cell25.setBorderWidth(1);
//                cell25.setRowspan(4);//跨四行
//                cell25.setPhrase(new Paragraph("收货人", fontChina12));
//                cell25.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell25);
//
//                PdfPCell cell26 = new PdfPCell();
//                cell26.setBorderWidth(1);
//                cell26.setPhrase(new Paragraph("纳税人全称", fontChina12));
//                cell26.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell26);
//                PdfPCell cell27 = new PdfPCell();
//                cell27.setBorderWidth(1);
//                cell27.setColspan(4);//跨四列
//                cell27.setPhrase(new Paragraph("纳税人全称", fontChina12));
//                cell27.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell27);
//
//                PdfPCell cell28 = new PdfPCell();
//                cell28.setBorderWidth(1);
//                cell28.setPhrase(new Paragraph("纳税人识别号", fontChina12));
//                cell28.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell28);
//                PdfPCell cell29 = new PdfPCell();
//                cell29.setBorderWidth(1);
//                cell29.setColspan(4);//跨四列
//                cell29.setPhrase(new Paragraph("纳税人识别号", fontChina12));
//                cell29.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell29);
//
//                PdfPCell cell30 = new PdfPCell();
//                cell30.setBorderWidth(1);
//                cell30.setPhrase(new Paragraph("地址、电话", fontChina12));
//                cell30.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell30);
//                PdfPCell cell31 = new PdfPCell();
//                cell31.setBorderWidth(1);
//                cell31.setColspan(4);//跨四列
//                cell31.setPhrase(new Paragraph("地址、电话", fontChina12));
//                cell31.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell31);
//
//                PdfPCell cell32 = new PdfPCell();
//                cell32.setBorderWidth(1);
//                cell32.setPhrase(new Paragraph("开户行及帐号", fontChina12));
//                cell32.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell32);
//                PdfPCell cell33 = new PdfPCell();
//                cell33.setBorderWidth(1);
//                cell33.setColspan(4);//跨四列
//                cell33.setPhrase(new Paragraph("开户行及帐号", fontChina12));
//                cell33.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell33);
//
//                //起运地、经由、到达地
//                PdfPCell cell34 = new PdfPCell();
//                cell34.setBorderWidth(1);
//                cell34.setColspan(2);//跨2列
//                cell34.setPhrase(new Paragraph("起运地、经由、到达地", fontChina12));
//                cell34.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell34);
//                PdfPCell cell35 = new PdfPCell();
//                cell35.setBorderWidth(1);
//                cell35.setColspan(4);//跨四列
//                cell35.setPhrase(new Paragraph("起运地、经由、到达地", fontChina12));
//                cell35.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell35);
//
//
//                //费用项目信息 -Title
//                PdfPCell cell36 = new PdfPCell();
//                cell36.setBorderWidth(1);
//                cell36.setPhrase(new Paragraph("费用项目名称", fontChina12));
//                cell36.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell36);
//                PdfPCell cell37 = new PdfPCell();
//                cell37.setBorderWidth(1);
//                cell37.setPhrase(new Paragraph("费用项目金额（不含税）", fontChina12));
//                cell37.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell37);
//                PdfPCell cell38 = new PdfPCell();
//                cell38.setBorderWidth(1);
//                cell38.setPhrase(new Paragraph("运输货物信息", fontChina12));
//                cell38.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell38);
//                PdfPCell cell39 = new PdfPCell();
//                cell39.setBorderWidth(1);
//                cell39.setPhrase(new Paragraph("合计金额（不含税销售额合计）称", fontChina12));
//                cell39.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell39);
//                PdfPCell cell40 = new PdfPCell();
//                cell40.setBorderWidth(1);
//                cell40.setPhrase(new Paragraph("征收率", fontChina12));
//                cell40.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell40);
//                PdfPCell cell41 = new PdfPCell();
//                cell41.setBorderWidth(1);
//                cell41.setPhrase(new Paragraph("增值税应纳税额", fontChina12));
//                cell41.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell41);
//                //费用项目信息-Alert
//                PdfPCell cell42 = new PdfPCell();
//                cell42.setBorderWidth(1);
//                cell42.setPhrase(new Paragraph("1", fontChina12));
//                cell42.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell42);
//                PdfPCell cell43 = new PdfPCell();
//                cell43.setBorderWidth(1);
//                cell43.setPhrase(new Paragraph("2", fontChina12));
//                cell43.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell43);
//                PdfPCell cell44 = new PdfPCell();
//                cell44.setBorderWidth(1);
//                cell44.setPhrase(new Paragraph("3", fontChina12));
//                cell44.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell44);
//                PdfPCell cell45 = new PdfPCell();
//                cell45.setBorderWidth(1);
//                cell45.setPhrase(new Paragraph("4", fontChina12));
//                cell45.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell45);
//                PdfPCell cell46 = new PdfPCell();
//                cell46.setBorderWidth(1);
//                cell46.setPhrase(new Paragraph("5", fontChina12));
//                cell46.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell46);
//                PdfPCell cell47 = new PdfPCell();
//                cell47.setBorderWidth(1);
//                cell47.setPhrase(new Paragraph("6＝4×5", fontChina12));
//                cell47.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell47);
//                //费用项目信息-Input
//                PdfPCell cell48 = new PdfPCell();
//                cell48.setBorderWidth(1);
//                cell48.setPhrase(new Paragraph("1", fontChina12));
//                cell48.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell48);
//                PdfPCell cell49 = new PdfPCell();
//                cell49.setBorderWidth(1);
//                cell49.setPhrase(new Paragraph("2", fontChina12));
//                cell49.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell49);
//                PdfPCell cell50 = new PdfPCell();
//                cell50.setBorderWidth(1);
//                cell50.setPhrase(new Paragraph("3", fontChina12));
//                cell50.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell50);
//                PdfPCell cell51 = new PdfPCell();
//                cell51.setBorderWidth(1);
//                cell51.setPhrase(new Paragraph("4", fontChina12));
//                cell51.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell51);
//                PdfPCell cell52 = new PdfPCell();
//                cell52.setBorderWidth(1);
//                cell52.setPhrase(new Paragraph("5", fontChina12));
//                cell52.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell52);
//                PdfPCell cell53 = new PdfPCell();
//                cell53.setBorderWidth(1);
//                cell53.setPhrase(new Paragraph("6", fontChina12));
//                cell53.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell53);
//
//                //合计
//                PdfPCell cell54 = new PdfPCell();
//                cell54.setBorderWidth(1);
//                cell54.setPhrase(new Paragraph("合计", fontChina12));
//                cell54.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell54);
//                PdfPCell cell55 = new PdfPCell();
//                cell55.setBorderWidth(1);
//                cell55.setColspan(5);//跨5列
//                cell55.setPhrase(new Paragraph("合计", fontChina12));
//                cell55.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell55);
//
//                //增值税价税合计
//                PdfPCell cell56 = new PdfPCell();
//                cell56.setBorderWidth(1);
//                cell56.setPhrase(new Paragraph("增值税价税合计", fontChina12));
//                cell56.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell56);
//                PdfPCell cell57 = new PdfPCell();
//                cell57.setBorderWidth(1);
//                cell57.setColspan(5);//跨5列
//                cell57.setPhrase(new Paragraph("增值税价税合计", fontChina12));
//                cell57.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell57);
//
//                //车辆信息
//                PdfPCell cell58 = new PdfPCell();
//                cell58.setBorderWidth(1);
//                cell58.setPhrase(new Paragraph("车种", fontChina12));
//                cell58.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell58);
//                PdfPCell cell59 = new PdfPCell();
//                cell59.setBorderWidth(1);
//                cell59.setPhrase(new Paragraph("车种", fontChina12));
//                cell59.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell59);
//
//                PdfPCell cell60 = new PdfPCell();
//                cell60.setBorderWidth(1);
//                cell60.setPhrase(new Paragraph("车号", fontChina12));
//                cell60.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell60);
//                PdfPCell cell61 = new PdfPCell();
//                cell61.setBorderWidth(1);
//                cell61.setPhrase(new Paragraph("车号", fontChina12));
//                cell61.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell61);
//
//                PdfPCell cell62 = new PdfPCell();
//                cell62.setBorderWidth(1);
//                cell62.setPhrase(new Paragraph("车船吨位", fontChina12));
//                cell62.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell62);
//                PdfPCell cell63 = new PdfPCell();
//                cell63.setBorderWidth(1);
//                cell63.setPhrase(new Paragraph("车船吨位", fontChina12));
//                cell63.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell63);
//
//                //申请资料清单
//                PdfPCell cell64 = new PdfPCell();
//                cell64.setBorderWidth(1);
//                cell64.setColspan(6);//跨六列
//                cell64.setPhrase(new Paragraph("申请资料清单", fontChina12));
//                cell64.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell64.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//                table.addCell(cell64);
//
//                PdfPCell cell65 = new PdfPCell();
//                cell65.setBorderWidth(1);
//                cell65.setColspan(3);//跨3列
//                cell65.setPhrase(new Paragraph("1、《税务登记证》或《临时税务登记证》副本、经办人合法身份证件及复印件（）", fontChina12));
//                cell65.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell65);
//                PdfPCell cell66 = new PdfPCell();
//                cell66.setBorderWidth(1);
//                cell66.setColspan(3);//跨3列
//                cell66.setPhrase(new Paragraph("2、承包、承租车辆、船舶营运的，应提供承包、承租合同复印件及出包、出租方车辆、船舶营运资质的有效证明原件及复印件（）", fontChina12));
//                cell66.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell66);
//
//                PdfPCell cell67 = new PdfPCell();
//                cell67.setBorderWidth(1);
//                cell67.setColspan(3);//跨3列
//                cell67.setPhrase(new Paragraph("3、承运人自有车辆、船舶及营运资质的有效证明原件及复印件（）", fontChina12));
//                cell67.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell67);
//                PdfPCell cell68 = new PdfPCell();
//                cell68.setBorderWidth(1);
//                cell68.setColspan(3);//跨3列
//                cell68.setPhrase(new Paragraph("4、承运人同货主签订的承运货物合同或者托运单、完工单等其它有效证明复印件（）", fontChina12));
//                cell68.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell68);
//
//                //以下由主管国税机关填写
//                PdfPCell cell69 = new PdfPCell();
//                cell69.setBorderWidth(1);
//                cell69.setColspan(6);//跨六列
//                cell69.setPhrase(new Paragraph("以下由主管国税机关填写", fontChina12));
//                cell69.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                cell69.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//                table.addCell(cell69);
//
//                PdfPCell cell70 = new PdfPCell();
//                cell70.setBorderWidth(1);
//                cell70.setPhrase(new Paragraph("完税凭证号码", fontChina12));
//                cell70.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell70);
//                PdfPCell cell71 = new PdfPCell();
//                cell71.setBorderWidth(1);
//                cell71.setPhrase(new Paragraph("完税凭证号码", fontChina12));
//                cell71.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell71);
//
//                PdfPCell cell72 = new PdfPCell();
//                cell72.setBorderWidth(1);
//                cell72.setPhrase(new Paragraph("填开日期", fontChina12));
//                cell72.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell72);
//                PdfPCell cell73 = new PdfPCell();
//                cell73.setBorderWidth(1);
//                cell73.setPhrase(new Paragraph("填开日期", fontChina12));
//                cell73.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell73);
//
//                PdfPCell cell74 = new PdfPCell();
//                cell74.setBorderWidth(1);
//                cell74.setPhrase(new Paragraph("税款征收岗（签章）", fontChina12));
//                cell74.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell74);
//                PdfPCell cell75 = new PdfPCell();
//                cell75.setBorderWidth(1);
//                cell75.setPhrase(new Paragraph("税款征收岗（签章）", fontChina12));
//                cell75.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell75);
//
//                PdfPCell cell76 = new PdfPCell();
//                cell76.setBorderWidth(1);
//                cell76.setPhrase(new Paragraph("发票号码", fontChina12));
//                cell76.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell76);
//                PdfPCell cell77 = new PdfPCell();
//                cell77.setBorderWidth(1);
//                cell77.setColspan(2);//跨2列
//                cell77.setPhrase(new Paragraph("发票号码", fontChina12));
//                cell77.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell77);
//
//                PdfPCell cell78 = new PdfPCell();
//                cell78.setBorderWidth(1);
//                cell78.setPhrase(new Paragraph("发票代码", fontChina12));
//                cell78.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell78);
//                PdfPCell cell79 = new PdfPCell();
//                cell79.setBorderWidth(1);
//                cell79.setColspan(2);//跨2列
//                cell79.setPhrase(new Paragraph("发票代码", fontChina12));
//                cell79.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell79);
//
//                PdfPCell cell80 = new PdfPCell();
//                cell80.setBorderWidth(1);
//                cell80.setPhrase(new Paragraph("填开日期", fontChina12));
//                cell80.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell80);
//                PdfPCell cell81 = new PdfPCell();
//                cell81.setBorderWidth(1);
//                cell81.setColspan(2);//跨2列
//                cell81.setPhrase(new Paragraph("填开日期", fontChina12));
//                cell81.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell81);
//
//                PdfPCell cell82 = new PdfPCell();
//                cell82.setBorderWidth(1);
//                cell82.setPhrase(new Paragraph("代开发票岗（签章）", fontChina12));
//                cell82.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell82);
//                PdfPCell cell83 = new PdfPCell();
//                cell83.setBorderWidth(1);
//                cell83.setColspan(2);//跨2列
//                cell83.setPhrase(new Paragraph("代开发票岗（签章）", fontChina12));
//                cell83.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell83);
//
//                PdfPCell cell84 = new PdfPCell();
//                cell84.setBorderWidth(1);
//                cell84.setMinimumHeight(40);
//                cell84.setPhrase(new Paragraph("备注", fontChina12));
//                cell84.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell84);
//                PdfPCell cell85 = new PdfPCell();
//                cell85.setBorderWidth(1);
//                cell85.setColspan(5);//跨5列
//                cell85.setPhrase(new Paragraph("备注", fontChina12));
//                cell85.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//                table.addCell(cell85);
//
//                document.add(table);
//
//                //申请人（签章）：
//                Paragraph p1 = new Paragraph("申请人（签章）：", fontChina12);
//                p1.setAlignment(Element.ALIGN_RIGHT);
//                p1.setIndentationRight(100);
//                document.add(p1);
//
//                //注
//                Paragraph p2 = new Paragraph("注：1．本表一式三份，税款征收岗、代开发票管理岗、纳税人各一份。", fontChina12);
//                p2.setAlignment(Element.ALIGN_CENTER);
//                document.add(p2);
//
//
//                // 5:关闭文档
//                document.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (DocumentException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException {
//
//    }
//}
