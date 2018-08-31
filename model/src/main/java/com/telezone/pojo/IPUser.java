package com.telezone.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity(name = "IP_USERS_T")
public class IPUser{
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "Username")
    private String username;
    /**
     * 不打印
     */
    @JsonIgnore
    @Column(name = "Password")
    private String password;
    /**
     * 在没有数据的时候不返回
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "Principal_Name")
    private String principalName;
    /**
     * 在没有数据的时候不返回
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "Telephone")
    private Integer telephone;
    /**
     * Data 打印格式
     */
    @Column(name = "Modify_Time")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private Date modifyTime;
    /**
     * Data 打印格式
     */
    @Column(name = "Create_Date")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private Date createTime;
}
