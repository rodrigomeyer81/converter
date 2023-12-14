package br.com.sankhya.erpconverter.entity;

import br.com.sankhya.erpconverter.tool.FormattingTool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Script implements Criteria{
    private List<String> familyTree;
    private String value;

    @Override
    public String getCondition() {

        StringBuffer condition = new StringBuffer();
        condition.append(FormattingTool.AND);
        if(familyTree!= null && familyTree.size()>0) {
            String field = FormattingTool.concatList(familyTree, "->");
            condition.append(field);
            condition.append("->");
        }
        condition.append(value);

        return condition.toString();
    }

}
