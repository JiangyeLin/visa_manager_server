package migao.life.visa_manager.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/12/9 9:05
 */
@Data
public class PayCheckVO {

    private String orderNo;

    private BigDecimal consumptionAmount;

    private String memberPhone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
