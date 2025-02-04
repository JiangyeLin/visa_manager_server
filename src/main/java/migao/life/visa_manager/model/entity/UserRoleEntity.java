package migao.life.visa_manager.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import migao.life.visa_manager.base.BaseEntity;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/11/27 10:58
 */

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_user_role")
public class UserRoleEntity extends BaseEntity {

    /**
    * 用户编号
    */
    private Long userId;
    /**
    * 角色编号
    */
    private Long roleId;

}
