package com.fpi.test.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Infomation {

    private Long informationId;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @Email(message = "请输入正确邮箱账号")
    private String mail;

    @Pattern(regexp = "^[1][3-9][0-9]{9}$",message = "请输入正确手机号")
    private String phoneNumber;

    @Override
    public String toString() {
        return "{" +
                " 'informationId': " + informationId +
                ", 'nickName': '" + nickName  +
                "', 'mail': '" + mail  +
                "', 'phoneNumber': '" + phoneNumber  +
                "'}";
    }
}
