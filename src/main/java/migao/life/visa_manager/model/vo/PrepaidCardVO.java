package migao.life.visa_manager.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/12/4 14:32
 */
@Data
public class PrepaidCardVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String number;
    private BigDecimal balance;
    private Date effectiveDate;
    private Date expirationDate;
    private Byte status;

}
