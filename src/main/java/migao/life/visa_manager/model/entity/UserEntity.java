package migao.life.visa_manager.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import migao.life.visa_manager.base.BaseEntity;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/11/27 10:34
 */
@Data
@TableName("tb_user")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;

}
