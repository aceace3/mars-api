package com.mars.mars_api.sysapi.bean;

import lombok.Data;

import java.util.Date;

@Data
public class SysApi {

    private Integer id;

    private String title;

    private Integer createBy;

    private String content;

    private Integer pid;

    private Date createTime;

    private Integer isLeaf;

    private String pname;

    private String ogContent;
}
