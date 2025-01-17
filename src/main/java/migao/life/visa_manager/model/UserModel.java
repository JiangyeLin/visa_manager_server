package migao.life.visa_manager.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserModel {

    private String username;
}