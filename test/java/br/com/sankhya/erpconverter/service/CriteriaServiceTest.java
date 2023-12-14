package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.entity.Script;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class CriteriaServiceTest {

    @Test
    public void createExpressionSucess(){

        String response = CriteriaService.createExpression(buildFields());
        System.out.println(response);
    }


    @Test
    public void CreateExpressionWithSonSuccess(){

        Map<String,Object> input = buildFieldsWithSon();
        System.out.println(input);
        String output = CriteriaService.createExpression(buildFieldsWithSon());
        System.out.println(output);
    }


    @Test
    public void CreateExpressionWithGrandsonSuccess(){

        Map<String,Object> input = buildFieldsWithGrandSon();
        System.out.println(input);
        String output = CriteriaService.createExpression(input);
        System.out.println(output);
    }

    @Test
    public void CreateExpressionOrSuccess(){

        Map<String,Object> input = buildFieldsList();
        System.out.println(input);
        String output = CriteriaService.createExpression(input);
        System.out.println(output);
    }


    @Test
    public void ScriptGetCondition(){
        Script script = new Script(Arrays.asList("Pedido","Cliente"), "cliente= 's'");
        System.out.println(script.getCondition());
    }


    private Map<String, Object> buildFields() {

        return buildFields("Uberlândia", "MG");
    }


    private Map<String, Object> buildFields(String city, String state) {
        Map<String, Object> address = new HashMap();
        address.put("NOMECID", city);
        address.put("NOMEBAR", "Centro");
        address.put("NUMERO", 10);
        address.put("ESTADO", state);

        return address;
    }


    private Map<String, Object> buildFieldsWithSon() {
        Map<String, Object> contact = new HashMap();

        contact.put("NOMECONT", "contatinho");
        contact.put("SOBNCONT", "contatao");
        contact.put("TIPOCONT", "Fisico");
        contact.put("SEXOCONT", "INDEFINIDO");

        contact.put("Endereco",buildFields());

        return contact;
    }

    private Map<String, Object> buildFieldsWithGrandSon() {
        Map<String, Object> client = new HashMap();

        client.put("TIPPESSOA", 'F');
        client.put("NOMEPARC", "cliente");
        client.put("CODCLI", 10);
        client.put("ATIVO", 'S');
        client.put("CLIENTE", 'S');
        client.put("CLASSIFICMS", 'C');

        client.put("Contato",buildFieldsWithSon());

        return client;
    }


    private Map<String, Object> buildFieldsListObject() {
        Map<String, Object> contato = new HashMap();

        contato.put("NOMECONT", "contatinho");
        contato.put("SOBNCONT", "contatao");
        contato.put("TIPOCONT", "Fisico");
        contato.put("SEXOCONT", "INDEFINIDO");

        List<Map<String, Object>> addresses = Arrays.asList(buildFields(), buildFields("vila velha", "ES"));
        contato.put("Endereco",addresses);

        return contato;
    }

    private Map<String, Object> buildFieldsList() {
        Map<String, Object> contato = new HashMap();

        contato.put("NOMECONT", "contatinho");
        contato.put("SOBNCONT", "sobre nome do contato");
        contato.put("TIPOCONT", "Fisico");
        contato.put("SEXOCONT", "INDEFINIDO");

        List<String> addresses = Arrays.asList("MG", "ES");
        contato.put("Endereco",addresses);

        return contato;
    }
}
