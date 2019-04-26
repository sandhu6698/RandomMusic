package com.example.lenovo.randommusic;

public class StationData {
    String url;
    String name;
    String info;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StationData(String url, String name, String info) {
        this.url = url;
        this.name = name;
        this.info= info;

    }
}
