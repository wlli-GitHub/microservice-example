package com.liwenli.microservice.example.core.resp;

public class DefaultInterfaceRespHead {
    /**
     * 响应码
     */
    private String respCode;
    /**
     * 响应内容
     */
    private String respContent;



    public DefaultInterfaceRespHead(String respCode, String respContent) {
        this.respCode = respCode;
        this.respContent = respContent;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespContent() {
        return respContent;
    }

    public void setRespContent(String respContent) {
        this.respContent = respContent;
    }

    @Override
    public String toString() {
        return "DefaultInterFaceRespHead{" +
                "respCode='" + respCode + '\'' +
                ", respContent='" + respContent + '\'' +
                '}';
    }
}
