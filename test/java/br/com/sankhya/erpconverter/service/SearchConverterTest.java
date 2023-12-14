package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.entity.AndCondition;
import br.com.sankhya.erpconverter.entity.Criteria;
import br.com.sankhya.erpconverter.entity.RequestConverter;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;


@RunWith(MockitoJUnitRunner.class)
public class SearchConverterTest {


    @Test
    public void constructorSearchConverter(){

     //   RequestConverter requestConverter = buildRequestConverter();

        Gson gson = new Gson();

        RequestConverter requestConverter = gson.fromJson(requestConvert(), RequestConverter.class);

    //    requestConverter.setRootEntity("Parceiro");


        System.out.println(requestConverter);
        System.out.println(new Gson().toJson(requestConverter));


        SearchConverter response = new  SearchConverter(requestConverter, 0);

        System.out.println(response.getErpRequest());

        System.out.println(new Gson().toJson(response.getErpRequest()));

        //  assertThat( JsonNode.equals() ).isEqualTo(jsonInputBuilder());
    }


    public static RequestConverter buildRequestConverter(){
        RequestConverter requestConverter = new RequestConverter();
        requestConverter.setFieldSet(buildRequestEntity());
        requestConverter.setCriteria(buildCriteriaList());

        return requestConverter;
    }


    public static Map<List<String>, List<String>> buildRequestEntity(){
        Map<List<String>, List<String>> requestEntity = new LinkedHashMap<>();
        requestEntity.put( Arrays.asList(), Arrays.asList("CODPARC","TIPPESSOA","NOMEPARC","CODCID","ATIVO","CLIENTE","CLASSIFICMS"));
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


    public String requestConvert(){

        return "{\"rootEntity\":\"Parceiro\",\"fieldSet\":{\"[Usuario]\":[\"NOMEUSU\",\"CODUSU\"],\"[]\":[\"ATIVO\",\"OBSERVACOES\",\"TELEFONE\",\"TIPPESSOA\",\"IDENTINSCESTAD\",\"COMPLEMENTO\",\"NUMEND\",\"LATITUDE\",\"LONGITUDE\",\"CAIXAPOSTAL\",\"CEP\",\"DESCSTIVA\",\"TEMIPI\",\"SIMPLES\",\"BLOQUEAR\",\"CODPARC\",\"FAX\",\"INSCMUN\",\"EMAIL\",\"NOMEPARC\",\"CGC_CPF\",\"SITCADSEFAZ\",\"CLASSIFICMS\",\"DESCFIN\",\"EMAILNFE\",\"INSCESTADNAUF\",\"RAZAOSOCIAL\"],\"[EmpresaPreferencial]\":[\"NOMEFANTASIA\",\"CODEMP\"],\"[Empresa]\":[\"NOMEFANTASIA\",\"CODEMP\",\"NOMEFANTASIA\",\"CODEMP\"],\"[Vendedor]\":[\"SALDODISP\",\"ATIVO\",\"TIPVEND\",\"APELIDO\",\"CODVEND\",\"EMAIL\"],\"[Vendedor, Gerente]\":[\"ATIVO\",\"CODVEND\",\"APELIDO\",\"EMAIL\"],\"[Cidade]\":[\"NOMECID\",\"CODCID\"],\"[Bairro]\":[\"NOMEBAI\"],\"[Regiao]\":[\"NOMEREG\",\"CODREG\"],\"[Endereco]\":[\"DESCRICAOCORREIO\"],\"[Vendedor, Empresa]\":[\"NOMEFANTASIA\",\"CODEMP\"],\"[Cidade, UnidadeFederativa]\":[\"DESCRICAO\"],\"[Vendedor, Parceiro]\":[\"TELEFONE\"],\"[ParceiroMatriz]\":[\"NOMEPARC\",\"CODPARCMATRIZ\"]},\"criteria\":[{\"familyTree\":[\"CODPARC\"],\"value\":\"300\"},{\"familyTree\":[],\"value\":\"CLIENTE\\u003d\\u0027S\\u0027\"}],\"translate\":{\"Cidade_CODCID\":[\"EnderecoPrincipal\",\"idCidade\"],\"OBSERVACOES\":[\"observacao\"],\"COMPLEMENTO\":[\"EnderecoPrincipal\",\"complemento\"],\"NOMEPARC\":[\"nome\"],\"CLASSIFICMS\":[\"classificacaoICMS\"],\"EMAIL\":[\"email\"],\"Vendedor_Gerente_CODVEND\":[\"Vendedor\",\"Gerente\",\"id\"],\"Vendedor_EMAIL\":[\"Vendedor\",\"email\"],\"Cidade_NOMECID\":[\"EnderecoPrincipal\",\"nomeCidade\"],\"Usuario_CODUSU\":[\"Usuario\",\"id\"],\"Empresa_CODEMP\":[\"Empresa\",\"id\"],\"ParceiroMatriz_NOMEPARC\":[\"ParceiroMatriz\",\"nome\"],\"ATIVO\":[\"ativo\"],\"Vendedor_CODVEND\":[\"Vendedor\",\"id\"],\"EMAILNFE\":[\"emailNotaFiscal\"],\"Vendedor_Empresa_CODEMP\":[\"Vendedor\",\"Empresa\",\"id\"],\"EmpresaPreferencial_CODEMP\":[\"EmpresaPreferencial\",\"id\"],\"INSCMUN\":[\"cadastroMunicipalContribuinte\"],\"DESCFIN\":[\"percentualDescontoFinanceiro\"],\"CEP\":[\"EnderecoPrincipal\",\"cep\"],\"Endereco_DESCRICAOCORREIO\":[\"EnderecoPrincipal\",\"logradouro\"],\"ParceiroMatriz_CODPARCMATRIZ\":[\"ParceiroMatriz\",\"id\"],\"Cidade_UnidadeFederativa_DESCRICAO\":[\"EnderecoPrincipal\",\"uf\"],\"Regiao_NOMEREG\":[\"Regiao\",\"nome\"],\"LATITUDE\":[\"EnderecoPrincipal\",\"Coordenada\",\"latitude\"],\"Bairro_NOMEBAI\":[\"EnderecoPrincipal\",\"bairro\"],\"Empresa_NOMEFANTASIA\":[\"Empresa\",\"nome\"],\"BLOQUEAR\":[\"bloquearVenda\"],\"Usuario_NOMEUSU\":[\"Usuario\",\"NOMEUSU\"],\"TEMIPI\":[\"temIPI\"],\"Vendedor_SALDODISP\":[\"Vendedor\",\"saldoFlex\"],\"Vendedor_APELIDO\":[\"Vendedor\",\"apelido\"],\"LONGITUDE\":[\"EnderecoPrincipal\",\"Coordenada\",\"longitude\"],\"CODPARC\":[\"id\"],\"Vendedor_Gerente_EMAIL\":[\"Vendedor\",\"Gerente\",\"email\"],\"INSCESTADNAUF\":[\"inscricaoEstadual\"],\"DESCSTIVA\":[\"descontoStIva\"],\"Vendedor_Parceiro_TELEFONE\":[\"Vendedor\",\"telefone\"],\"CGC_CPF\":[\"cnpjCpf\"],\"Vendedor_Gerente_APELIDO\":[\"Vendedor\",\"Gerente\",\"apelido\"],\"Vendedor_Gerente_ATIVO\":[\"Vendedor\",\"Gerente\",\"ativo\"],\"TELEFONE\":[\"telefone\"],\"Vendedor_ATIVO\":[\"Vendedor\",\"ativo\"],\"IDENTINSCESTAD\":[\"inscricaoEstadualIdentidade\"],\"Vendedor_TIPVEND\":[\"Vendedor\",\"tipo\"],\"SITCADSEFAZ\":[\"situacaoSefaz\"],\"RAZAOSOCIAL\":[\"razaoSocial\"],\"TIPPESSOA\":[\"tipoPessoa\"],\"EmpresaPreferencial_NOMEFANTASIA\":[\"EmpresaPreferencial\",\"nome\"],\"Regiao_CODREG\":[\"Regiao\",\"id\"],\"SIMPLES\":[\"optaSimplesNacional\"],\"Vendedor_Empresa_NOMEFANTASIA\":[\"Vendedor\",\"Empresa\",\"nome\"],\"CAIXAPOSTAL\":[\"EnderecoPrincipal\",\"caixaPostal\"],\"FAX\":[\"fax\"],\"NUMEND\":[\"EnderecoPrincipal\",\"numero\"]}}";
    }
}