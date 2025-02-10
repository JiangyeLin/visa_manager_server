package migao.life.visa_manager.model.form;

import lombok.Data;
import migao.life.visa_manager.common.dto.Pagination;

@Data
public class CustomerQueryForm extends Pagination {
    private String keyword;

    private String companyId;
}
