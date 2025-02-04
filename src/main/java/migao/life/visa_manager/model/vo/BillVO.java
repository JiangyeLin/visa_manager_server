package migao.life.visa_manager.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/12/17 10:04
 */
@Data
public class BillVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String title;

    private BigDecimal amount;

    private String status;

    private Integer type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
}
