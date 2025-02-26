package migao.life.visa_manager.model.dto;

import lombok.Data;

@Data
public class PassportOCRDTO {

    //国家码 CHN
    private String Country;

    //护照号
    private String PassportNo;

    //Sex F/M
    private String Sex;

    //国籍
    private String Nationality;

    //生日
    private String BirthDate;

    //出生地点
    private String BirthPlace;

    //签发日期
    private String IssueDate;

    //签发地点
    private String IssuePlace;

    //有效期
    private String ExpiryDate;

    //持证人签名
    private String Signature;

    //最下方第一行 MRZ Code 序列
    private String CodeSet;

    //最下方第二行 MRZ Code 序列
    private String CodeCrc;

    //姓名
    private String Name;

    //姓
    private String FamilyName;

    //名
    private String FirstName;

    private String RequestId;

}
