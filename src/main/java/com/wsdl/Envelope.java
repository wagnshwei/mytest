package com.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "soapenv:Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {
    @XmlElement(name = "soapenv:Header")
    private Header header;

    @XmlElement(name = "soapenv:Body")
    private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Header {}

@XmlAccessorType(XmlAccessType.FIELD)
class Body {
    @XmlElement(name = "ns1:erpPaymentJsonData", namespace = "http://server.webservice.standard.erp.hibernate.byttersoft.com")
    private ErpPaymentJsonData erpPaymentJsonData;

    public ErpPaymentJsonData getErpPaymentJsonData() {
        return erpPaymentJsonData;
    }

    public void setErpPaymentJsonData(ErpPaymentJsonData erpPaymentJsonData) {
        this.erpPaymentJsonData = erpPaymentJsonData;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class ErpPaymentJsonData {
    @XmlElement(name = "jsonInputString")
    private String jsonInputString;

    public String getJsonInputString() {
        return jsonInputString;
    }

    public void setJsonInputString(String jsonInputString) {
        this.jsonInputString = jsonInputString;
    }
}
