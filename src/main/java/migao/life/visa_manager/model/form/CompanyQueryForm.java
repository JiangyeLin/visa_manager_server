package migao.life.visa_manager.model.form;

import lombok.Data;
import migao.life.visa_manager.common.dto.Pagination;

@Data
public class CompanyQueryForm extends Pagination {
    private String keyword;
}
