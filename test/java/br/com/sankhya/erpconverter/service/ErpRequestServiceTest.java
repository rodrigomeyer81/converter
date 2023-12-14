package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.dto.erp.request.ErpRequest;
import br.com.sankhya.erpconverter.entity.AndCondition;
import br.com.sankhya.erpconverter.entity.Criteria;
import br.com.sankhya.erpconverter.entity.Entity;
import br.com.sankhya.erpconverter.entity.RequestConverter;
import br.com.sankhya.erpconverter.enuns.ConversionType;
import br.com.sankhya.erpconverter.tool.FormattingTool;
import net.minidev.json.JSONObject;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class ErpRequestServiceTest {

    SankhyaConverter sankhyaConverter =new SankhyaConverter();

    public ErpRequestServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidScriptAndCondition(){
        AndCondition result = new AndCondition(Arrays.asList("ENDERECO","TESTE","TESTE2","TESTE3","TESTE4","script"),"S");
        Assert.assertNotEquals(result,null);
    }

    @Test
    public void get(){

        RequestConverter requestConverter = buildRequestConverter();
        requestConverter.setRootEntity("Parceiro");
        System.out.println(requestConverter);

        //  ErpRequest response =  sankhyaConverter.getRequest(requestConverter, 0);

        //  System.out.println(response.toJson());

        //  assertThat( JsonNode.equals() ).isEqualTo(jsonInputBuilder());
    }


    public static RequestConverter buildRequestConverter(){
        RequestConverter requestConverter = new RequestConverter();
        requestConverter.setFieldSet(buildRequestEntity());
        requestConverter.setCriteria(buildCriteriaList());

        return requestConverter;
    }


    public static  Map<List<String>, List<String>> buildRequestEntity(){
        Map<List<String>, List<String>> requestEntity = new LinkedHashMap<>();
        requestEntity.put(null, Arrays.asList("CODPARC","TIPPESSOA","NOMEPARC","CODCID","ATIVO","CLIENTE","CLASSIFICMS"));
        requestEntity.put(Arrays.asList("Contato"), Arrays.asList("CODPARC","TIPPESSOA","NOMEPARC"));
        requestEntity.put(Arrays.asList("Contato","Cidade"), Arrays.asList("CODCID","NOMECID","UF"));
        return requestEntity;
    }


    public static List<Criteria> buildCriteriaList(){
        List<Criteria> criteriaList = new ArrayList<>();

        criteriaList.add(AndCondition.builder()
                        .familyTree(Arrays.asList("ATIVO"))
                    .value("S")
                .build());

        criteriaList.add(AndCondition.builder()
                .familyTree(Arrays.asList("Contato","TIPPESSOA"))
                .value("F")
                .build());
        criteriaList.add(AndCondition.builder()
                .familyTree(Arrays.asList("Contato","Cidade","UF"))
                .value("ES")
                .build());
        return criteriaList;
    }


    @Test
    public void login(){

        ErpRequest response =  LoginService.request("SUP", "");
        System.out.println(response);
        System.out.println(response.toJson());
        //  assertThat( JsonNode.equals() ).isEqualTo(jsonInputBuilder());
    }

    @Test
    public void post(){

        String rootEntity = "Parceiro";
        List<String> fieldSet = Arrays.asList("CODPARC","TIPPESSOA","NOMEPARC","CODCID","ATIVO","CLIENTE","CLASSIFICMS");

        ErpRequest response =  ErpRequestService.post(rootEntity,true,fieldSet, buildFields());

        System.out.println(response.toJson());
        //  assertThat( JsonNode.equals() ).isEqualTo(jsonInputBuilder());
    }

    @Test
    public void postSucessoTest(){

        String rootEntity = "Parceiro";
        List<String> fieldSet = Arrays.asList("CODPARC","TIPPESSOA","NOMEPARC","CODCID","ATIVO","CLIENTE","CLASSIFICMS");
        String json = FormattingTool.toJson(buildFields());

        ErpRequest response =  ErpRequestService.post(rootEntity,true, fieldSet, buildFields());

        System.out.println(response.toJson());

        //  assertThat( JsonNode.equals() ).isEqualTo(jsonInputBuilder());
    }


    @Test
    public void createEntity(){

        Entity entitySpecialist = ConversionType.STANDAR_MODEL.createFieldSet().convertInput(buildMap());

        System.out.println(entitySpecialist);

    }


    public Map<List<String>, List<String>> buildMap(){
        Map<List<String>, List<String>> response = new HashMap<>();


        response.put(Arrays.asList("Parceiro", "Contato", "SEXO"),
                Arrays.asList("Cliente", "Contat", "SEXO"));

        response.put(Arrays.asList("Parceiro", "Contato", "NOMEPARC"),
                Arrays.asList("Cliente", "Contat", "nome"));

        response.put(Arrays.asList("Parceiro", "Contato", "IDADEPARC"),
                Arrays.asList("Cliente", "Contat", "idade"));


        response.put(Arrays.asList("Parceiro", "IDADEPARC"),
                Arrays.asList("Cliente", "idade"));

        response.put(Arrays.asList("Parceiro", "NOMEPARC"),
                Arrays.asList("Cliente", "nome"));

        return response;

    }

    public static String buildJson() throws JSONException {

        JSONObject map1 = new JSONObject();
        map1.put("startDate", "2013-01-01");
        map1.put("endDate", "2013-02-01");
        map1.put("columns", "mode , event");

        JSONObject map2 = new JSONObject();

        map2.put("selectionType", "smart");
        map2.put("selectionMatch", "123456789012");

        map1.put("selection",map2);

        System.out.println(map1.toString());

        return null;

    }


    public List<Map<String, Object>>  buildFieldsList() {
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(buildFields());
        list.add(buildFields());
        return list;
    }


    public JSONObject buildFields() {
        JSONObject map = new JSONObject();
        map.put("TIPPESSOA", 'F');
        map.put("NOMEPARC", "JON SNOW");
        map.put("CODCID", 10);
        map.put("ATIVO", 'S');
        map.put("CLIENTE", 'S');
        map.put("CLASSIFICMS", 'C');
        return map;
    }
}
