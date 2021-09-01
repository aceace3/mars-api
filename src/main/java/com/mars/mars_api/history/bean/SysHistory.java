package com.mars.mars_api.history.bean;

import com.mars.mars_api.user.bean.User;
import lombok.Data;

import java.util.Date;

@Data
public class SysHistory {
    private Integer id;

    private String title;

    private Integer createBy;

    private String content;

    private Integer pid;

    private Date createTime;

    private Integer isLeaf;

    private String pname;

    private String ogContent;

    private Date updateTime;

    private Integer updateUser;

    private Integer apiId;
}
