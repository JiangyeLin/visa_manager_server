package migao.life.visa_manager.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author ls
 * @Description 充值记录列表
 * @Date 2024/12/5 15:16
 */
@Data
public class GetRechargeRecordListByMemberVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String payChannel;

    private BigDecimal amount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
