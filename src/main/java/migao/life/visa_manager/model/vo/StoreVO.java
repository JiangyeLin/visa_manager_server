package migao.life.visa_manager.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @Author ls
 * @Description TODO
 * @Date 2024/12/4 15:36
 */
@Data
public class StoreVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;
    private String address;
    private String longitude;
    private String latitude;
    private Long principalId;
    private String bindCode;

}
