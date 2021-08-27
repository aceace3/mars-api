package com.mars.mars_api.sysapi.bean.dto;

import lombok.Data;

import java.util.List;

@Data
public class DirDTO {
    private Integer id;
    private Integer pid;
    private String name;
    private Boolean open;
    private List<DirDTO> children;
}
