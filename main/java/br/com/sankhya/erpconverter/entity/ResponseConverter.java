package br.com.sankhya.erpconverter.entity;

import br.com.sankhya.erpconverter.dto.ErrorDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseBodyDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.enuns.StatusResponse;
import br.com.sankhya.erpconverter.tool.FormattingTool;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class ResponseConverter {

    private StatusResponse status;

    private Integer total;

    private Integer offset;

    private Integer offsetPage;

    private boolean hasMoreResult;

    private ErrorDTO erro;

    private List<Map<String, Object>> entities;


    @JsonIgnore
    private HttpStatus httpStatus = HttpStatus.OK;

    public ResponseConverter(ErpResponseDTO erpResponse, StatusResponse status, List<Map<String, Object>> entities, ErrorDTO error) {

        this.httpStatus = erpResponse.getHttpStatus();

        this.status = status;

        this.erro = error;

        this.entities = entities;

        if(erpResponse.getResponseBody() != null) {

            ErpResponseBodyDTO erpResponseBody = erpResponse.getResponseBody();

            if (erpResponseBody.getEntities() != null){

                this.total = FormattingTool.stringToInteger(erpResponseBody.getEntities().getTotal());

                this.offset = FormattingTool.stringToInteger(erpResponseBody.getEntities().getOffset());

                this.offsetPage = FormattingTool.stringToInteger(erpResponseBody.getEntities().getOffsetPage());

                String hasMoreResult = erpResponseBody.getEntities().getHasMoreResult();

                if ("true".equalsIgnoreCase(hasMoreResult) || "s".equalsIgnoreCase(hasMoreResult)) {

                    this.hasMoreResult = Boolean.TRUE;
                } else {
                    this.hasMoreResult = Boolean.FALSE;
                }
            }
        }
    }
}