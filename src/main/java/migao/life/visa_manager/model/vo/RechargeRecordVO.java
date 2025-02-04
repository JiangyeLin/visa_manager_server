package migao.life.visa_manager.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author ls
 * @Description 充值记录详情
 * @Date 2024/12/5 15:50
 */
@Data
public class RechargeRecordVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private Long memberId;

    private Long prepaidCardId;

    private BigDecimal amount;

    private BigDecimal balance;

    private String payChannel;

    private String payNumber;

    private String remarks;

    private Long userId;
    private Long storeId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}


