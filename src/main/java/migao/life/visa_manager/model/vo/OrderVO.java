package migao.life.visa_manager.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/12/16 16:36
 */
@Data
public class OrderVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String id;

    private String orderNo;

    private BigDecimal amount;

    private String memberPhone;

    private String storeName;

    private String userName;

    private String deviceId;

    private String remarks;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
