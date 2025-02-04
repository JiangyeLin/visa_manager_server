package migao.life.visa_manager.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author ls
 * @Description 消费记录详情
 * @Date 2024/12/5 9:43
 */
@Data
public class ConsumptionRecordVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String storeName;
    private String prepaidCardNumber;
    private Byte prepaidCardType;
    private BigDecimal consumptionAmount;
    private BigDecimal balance;
    private String remarks;
    private String orderNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
