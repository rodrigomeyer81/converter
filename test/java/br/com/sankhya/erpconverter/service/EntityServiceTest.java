package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseMetaDataDTO;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class EntityServiceTest {

    public EntityServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void converter(){
        ErpResponseDTO bodyDTO = new Gson().fromJson(buildResponseDTO(), ErpResponseDTO.class);
        Map<List<String>, List<String>> translate = buildTranslate();
        List<Map<String, Object>>response =  ErpResponseService.converter(bodyDTO.getResponseBody(), translate);
        System.out.println(new Gson().toJson(response));
    }

    @Test
    public void addResponseMap(){

        Map<String,Object> entities = new HashMap<>();

        Map<String,Object> tatatata = new HashMap<>();

        Map<String,Object> biza = new HashMap<>();

        Map<String,Object> tatara = new HashMap<>();

        biza.put("teste2",2222);

        tatara.put("biza", biza);

        tatatata.put("tatara", tatara);

        entities.put("tatatata",tatatata);

       Map<String, Object> response =  ErpResponseService.addResponseMap(entities, Arrays.asList("tatatata","tatara","biza","avo","pai","filho","neto"), "valor");

        System.out.println(response);
    }


    @Test
    public void converterMetaData(){

        ErpResponseMetaDataDTO metaData = new Gson().fromJson(buildMetaDados(), ErpResponseMetaDataDTO.class);

        List<List<String>> response =  ErpResponseService.converterMetaData(metaData, buildTranslate());
        assertThat(response).isEqualTo(Arrays.asList(
                Arrays.asList("SimplesSemApelido0"),
                Arrays.asList("SimplesApelidado1"),
                Arrays.asList("Composto", "SemApelido2"),
                Arrays.asList("apelido", "aplicado3")));
        System.out.println(response);
    }

    public Map<List<String>, List<String>> buildTranslate(){
        Map<List<String>, List<String>> response = new HashMap<>();
        response.put(Arrays.asList("SimplesComApelido1"),Arrays.asList("SimplesApelidado1"));
        response.put(Arrays.asList("Composto","ComApelido3"),Arrays.asList("apelido", "aplicado3"));
        response.put(Arrays.asList("Composto","ComApelido4"),Arrays.asList("apelido", "aplicado4"));
        return response;
    }

    public String buildMetaDados(){
        return "{\n" +
                "    \"fields\": {\n" +
                "        \"field\": [\n" +
                "            {\n" +
                "                \"name\": \"SimplesSemApelido0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"SimplesComApelido1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Composto_SemApelido2\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Composto_ComApelido3\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
    }
    public String buildResponseDTO(){
        return "{ " +
                "\"serviceName\": \"CRUDServiceProvider.loadRecords\", " +
                "\"status\": \"1\", " +
                "\"pendingPrinting\": \"false\", " +
                "\"transactionId\": \"11045006CD6E63CFD528873AA09448AE\", " +
                "\"responseBody\": { " +
                "\"entities\": { " +
                "\"total\": \"1\", " +
                "\"hasMoreResult\": \"false\", " +
                "\"offsetPage\": \"0\", " +
                "\"offset\": \"0\", " +
                "\"entity\": { " +
                "\"f1\": { \"$\": \"F1-TESTE123\" }, " +
                "\"f0\": { \"$\": \"F0-648\" }, " +
                "\"f3\": { \"$\": \"F3-S\" }, " +
                "\"f2\": { \"$\": \"F2-S\" }, " +
                "\"f5\": { \"$\": \"F5-C\" }, " +
                "\"f4\": { \"$\": \"F4-10\" } }," +
                " \"metadata\": { " +
                "\"fields\": { " +
                "\"field\": [ " +
                "{ \"name\": \"SimplesSemApelido0\" }, " +
                "{ \"name\": \"SimplesComApelido1\" }, " +
                "{ \"name\": \"Composto_SemApelido2\" }, " +
                "{ \"name\": \"Composto_ComApelido3\" }, " +
                "{ \"name\": \"Composto_ComApelido4\" }, " +
                "{ \"name\": \"CLASSIFICMS5\" } ] } } } } }";
    }
}
