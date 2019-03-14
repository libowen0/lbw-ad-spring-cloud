package com.lbw.ad.constant;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 17:00 Description:
 */

@Getter
public enum CreativeMetrialType {

    JPG(1, "jpg"),
    BMP(2, "bmp"),

    MP4(3, "mp4"),
    AVI(4, "avi"),

    TXT(5, "txt");

    private int type;
    private String desc;

    CreativeMetrialType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }}
