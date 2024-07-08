package com.wsdl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JAXBException {
        // 创建 Envelope 对象
        Envelope envelope = new Envelope();

        // 创建 Header 对象
        Header header = new Header();
        envelope.setHeader(header);

        // 创建 Body 对象
        Body body = new Body();

        // 创建 ErpPaymentJsonData 对象，并设置 jsonInputString 字段
        ErpPaymentJsonData erpPaymentJsonData = new ErpPaymentJsonData();
        String jsonInputString = "[{\"serialNoErp\":\"111\",\"voucherNoErp\":\"222\",\"noYN\":\"333\",\"wishPayday\":\"2024-06-12\",\"corpCode\":\"111\",\"payerAccNo\":\"2222\",\"payerBankName\":\"3333\",\"payerAccName\":\"\",\"付款户名\":\"\",\"payerProv\":\"222\",\"payerCity\":\"333\",\"amt\":\"1\",\"cur\":\"\",\"payeeCorpCode\":\"222\",\"payeeAccNo\":\"3333\",\"payeeAccName\":\"2222\",\"payeeBank\":\"222\",\"payeeCode\":\"222\",\"payeeProv\":\"333\",\"payeeCity\":\"555\",\"abs\":\"0\",\"voucherType\":\"0\",\"isforindividual\":\"0\",\"dataSource\":\"NC\"}]";
        erpPaymentJsonData.setJsonInputString(jsonInputString);

        // 设置 Body 中的 erpPaymentJsonData 字段
        body.setErpPaymentJsonData(erpPaymentJsonData);

        // 设置 Envelope 中的 Body 字段
        envelope.setBody(body);

        // 最后，你可以使用 JAXB 或其他 XML 库将 Envelope 对象转换成 XML 字符串
        // 使用 JAXB 将 Java 对象转换为 XML 字符串
        StringWriter writer = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(envelope, writer);

        // 输出 XML 字符串
        String xmlString = writer.toString();
        System.out.println(xmlString);
    }
}
