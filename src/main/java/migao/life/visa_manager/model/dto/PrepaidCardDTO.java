package migao.life.visa_manager.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/12/9 9:14
 */
@Data
public class PrepaidCardDTO {
    private Long id;
    private String number;
    private Long memberId;
    private BigDecimal balance;
    private Date effectiveDate;
    private Date expirationDate;
    private Byte type;
    private Byte status;
    private List<Long> scope;
}
