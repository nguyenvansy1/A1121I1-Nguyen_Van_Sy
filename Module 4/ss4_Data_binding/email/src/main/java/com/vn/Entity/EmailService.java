package com.vn.Entity;

public class EmailService {
    private String language;
    private int page;
    private String filter;
    private String signature;

    public EmailService() {
    }

    public EmailService(String language, int page, String filter, String signature) {
        this.language = language;
        this.page = page;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
