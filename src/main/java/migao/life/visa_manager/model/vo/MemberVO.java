package migao.life.visa_manager.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/11/27 16:39
 */
@Data
public class MemberVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 呢称
     */
    private String nickName;
    /*
     *头像
     */
    private String avatarUrl;
    /**
     *手机号码
     */
    private String phoneNumber;
    /**
     * 积分
     */
    private Integer points;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 余额
     */
    private BigDecimal balance;

    private Integer status;
}
