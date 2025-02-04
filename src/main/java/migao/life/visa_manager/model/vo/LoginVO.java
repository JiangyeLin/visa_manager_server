package migao.life.visa_manager.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/12/18 20:32
 */
@Data
public class LoginVO {

    private String token;

    private List<String> pharmacies;

}
