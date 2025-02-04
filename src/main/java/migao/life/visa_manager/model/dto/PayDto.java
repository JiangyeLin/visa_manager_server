package migao.life.visa_manager.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/12/9 16:03
 */
@Data
public class PayDto {

    private String orderNo;

    private String payType;

    private String prepaidCardNumber;

    private Long memberId;

    private Long storeId;

    private Long userId;

    private BigDecimal consumptionAmount;

    private String remark;

    private Date createTime;
}
