package migao.life.visa_manager.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import migao.life.visa_manager.base.BaseEntity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("company")
public class CompanyEntity extends BaseEntity {

    private String companyNameCn;
    private String companyNameEn;
    private String address;
    private Date registrationDate;
    private String unifiedSocialCreditCode;
    private String legalRepresentative;

}
