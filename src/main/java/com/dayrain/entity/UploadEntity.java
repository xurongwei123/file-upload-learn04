package com.dayrain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@TableName("db_upload")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class UploadEntity {

    @TableId(type = IdType.AUTO)
    private long id;

    //存在本地的地址
    private String location;

    //名称，业务中用到的名称，比如 ”档案模板“、”用户信息“、”登录记录“等等
    private String name;

    //保留文件原来的名字
    private String oldName;


    private String description;


    private Date createTime;


    private Date updateTime;

}
