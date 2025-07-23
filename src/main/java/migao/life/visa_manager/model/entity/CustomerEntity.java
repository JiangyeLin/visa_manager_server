package migao.life.visa_manager.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import migao.life.visa_manager.base.BaseEntity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("customer")
public class CustomerEntity extends BaseEntity {

    //姓名
    private String name;

    //护照编号
    private String passportNumber;

    //护照签发日期
    private Date passportIssueDate;

    //护照有效期
    private Date passportValidity;

    //生日
    private Date birthDate;

    //出生地
    private String birthPlace;

    //性别
    private String gender;

    //护照签发地
    private String passportIssuePlace;

    //姓
    private String familyName;

    //名
    private String givenName;

    private String phoneNumber;

    //所属公司
    private String companyId;

    //国籍
    private String nationality;

    //护照照片
    private String photo;
}
