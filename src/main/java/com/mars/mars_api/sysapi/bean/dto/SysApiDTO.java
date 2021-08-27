package com.mars.mars_api.sysapi.bean.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SysApiDTO {
    private Integer id;

    private String title;

    private Integer createBy;

    private String content;

    private Integer pid;

    private Date createTime;

    private Integer isLeaf;

    private List<SysApiDTO> children;

    private String createName;
}
