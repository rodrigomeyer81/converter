package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.entity.ResponseConverter;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseLogin;
import br.com.sankhya.erpconverter.enuns.StatusResponse;
import br.com.sankhya.erpconverter.exception.MessageError;
import br.com.sankhya.erpconverter.exception.SankhyaConverserException;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ErpResponseServiceTest {

    public ErpResponseServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Autowired
    ErpResponseService erpResponseService =new ErpResponseService();

    @Test
    public void erpResponseErrReadingErpResponse() {
        String response = null;
        try {
            erpResponseService.convert("2321312312");
        }catch (SankhyaConverserException ex){
            response = ex.getMessage();
        }
        System.out.println(response);
        assertThat(response).isEqualTo(MessageError.MSG_ERR_READ_ERP_REPONSE);
    }

    @Test
    public void erpResponsePostListSucess() {
        ResponseConverter response;
        String requestConverter = erpResponsePostList();
        System.out.println(requestConverter);
        response = erpResponseService.convert(requestConverter);

        System.out.println(response);
    }

    @Test
    public void erpResponseLoginSucess() {
        ErpResponseLogin response;
        response = LoginService.response(erpResponseLogin());
        String json = LoginService.response(erpResponseLogin()).toJson();
        System.out.println(new Gson().toJson(response));
        System.out.println(json);

    }

    @Test
    public void erpResponseLoginError() {
        ErpResponseLogin response;
        response = LoginService.response(erpResponseLoginErr());

        String json = LoginService.response(erpResponseLoginErr()).toJson();

        System.out.println(new Gson().toJson(response));
        System.out.println(json);

        Assert.assertEquals("0",  response.getStatus());
    }

    @Test
    public void erpResponseGetSucess() {
        ResponseConverter response;
        System.out.println(erpResponseGet());

        response = erpResponseService.convert(erpResponseGet());

        System.out.println(response);

        assertThat(response.getOffsetPage()).isEqualTo(0);
        assertThat(response.getOffset()).isEqualTo(0);
        assertThat(response.getTotal()).isEqualTo(1);
        assertThat(response.isHasMoreResult()).isFalse();
        assertThat(response.getStatus()).isEqualTo(StatusResponse.SUCCESS);
    }

    @Test
    public void erpResponseError() {
        ResponseConverter response;

        response = erpResponseService.convert(erpResponseErr());

        System.out.println(response);

        assertThat(response.getErro().getDescricao()).isEqualTo("CNPJ/CPF deve ser informado.");
        assertThat(response.getStatus()).isEqualTo(StatusResponse.FAIL);
    }

    public String erpResponseLogin(){
        return "{\n" +
                "    \"serviceName\": \"MobileLoginSP.login\",\n" +
                "    \"status\": \"1\",\n" +
                "    \"pendingPrinting\": \"false\",\n" +
                "    \"transactionId\": \"BC0DF5105C7B541931710F26D45FF35B\",\n" +
                "    \"responseBody\": {\n" +
                "        \"idusu\": {\n" +
                "            \"$\": \"MA==\\n\"\n" +
                "        },\n" +
                "        \"kID\": {\n" +
                "            \"$\": \"N0NDREQzNkYxNzkzRjNEQjkxMjhENzQyMjVBQ0Y0ODc=\\n\"\n" +
                "        },\n" +
                "        \"jsessionid\": {\n" +
                "            \"$\": \"57DE4966491ED408582A184050CAD2FE\"\n" +
                "        },\n" +
                "        \"callID\": {\n" +
                "            \"$\": \"7E24217D16420072157F84BE8C3CEBD3\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

    public String erpResponseGet(){
        return "{\n" +
                "    \"serviceName\": \"CRUDServiceProvider.loadRecords\",\n" +
                "    \"status\": \"1\",\n" +
                "    \"pendingPrinting\": \"false\",\n" +
                "    \"transactionId\": \"4F2D535E538D9B3C5A203B1D1CB8E155\",\n" +
                "    \"responseBody\": {\n" +
                "        \"entities\": {\n" +
                "            \"total\": \"1\",\n" +
                "            \"hasMoreResult\": \"false\",\n" +
                "            \"offsetPage\": \"0\",\n" +
                "            \"offset\": \"0\",\n" +
                "            \"metadata\": {\n" +
                "                \"fields\": \n" +
                "                    {\n" +
                "                        \"field\": {\n" +
                "                            \"name\": \"CODPROD\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                \n" +
                "            },\n" +
                "            \"entity\": {\n" +
                "                \"_rmd\": {\n" +
                "                    \"CODPROD\": {\n" +
                "                        \"$\": \"\",\n" +
                "                        \"provider\": \"PRODUTORMP\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"f0\": {\n" +
                "                    \"$\": \"80416\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

    public String erpResponseErr(){
        return "{\n" +
                "    \"serviceName\": \"CRUDServiceProvider.saveRecord\",\n" +
                "    \"status\": \"0\",\n" +
                "    \"pendingPrinting\": \"false\",\n" +
                "    \"transactionId\": \"0BD21D7F2B29002366C02EB8EC3BF502\",\n" +
                "    \"tsError\": {\n" +
                "        \"tsErrorCode\": \"CORE_E05365\",\n" +
                "        \"tsErrorLevel\": \"ERROR\"\n" +
                "    },\n" +
                "    \"statusMessage\": \"CNPJ/CPF deve ser informado.\"\n" +
                "}";

    }

    public String erpResponseLoginErr(){
        return "{\n" +
                "    \"serviceName\": \"MobileLoginSP.login\",\n" +
                "    \"status\": \"0\",\n" +
                "    \"pendingPrinting\": \"false\",\n" +
                "    \"transactionId\": \"0BD21D7F2B29002366C02EB8EC3BF502\",\n" +
                "    \"tsError\": {\n" +
                "        \"tsErrorCode\": \"CORE_E05365\",\n" +
                "        \"tsErrorLevel\": \"ERROR\"\n" +
                "    },\n" +
                "    \"statusMessage\": \"Usuário/Senha inválido.\"\n" +
                "}";
    }


    public String erpResponsePostList(){
        return "{\n" +
                "    \"serviceName\": \"CRUDServiceProvider.loadRecords\",\n" +
                "    \"status\": \"1\",\n" +
                "    \"pendingPrinting\": \"false\",\n" +
                "    \"transactionId\": \"3E1900FF711F659E492FBE47420460B3\",\n" +
                "    \"responseBody\": {\n" +
                "        \"entities\": {\n" +
                "            \"total\": \"11\",\n" +
                "            \"hasMoreResult\": \"false\",\n" +
                "            \"offsetPage\": \"0\",\n" +
                "            \"offset\": \"0\",\n" +
                "            \"metadata\": {\n" +
                "                \"fields\": {\n" +
                "                    \"field\": [\n" +
                "                        {\n" +
                "                            \"name\": \"Parceiro_CODPARC\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Contato_CODPARC\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Contato_NOMECONTATO\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Contato_APELIDO\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Contato_EMAIL\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Cidade_NOMECID\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Cidade_UF\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Cidade_UnidadeFederativa_DESCRICAO\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Cidade_UnidadeFederativa_UF\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Endereco_NOMEEND\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            },\n" +
                "            \"entity\": [\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"DUQUE DE CAXIAS\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {\n" +
                "                        \"$\": \"6\"\n" +
                "                    },\n" +
                "                    \"f2\": {\n" +
                "                        \"$\": \"MARIA APARECIDA\"\n" +
                "                    },\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"SANTOS DUMONT\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {\n" +
                "                        \"$\": \"7\"\n" +
                "                    },\n" +
                "                    \"f2\": {\n" +
                "                        \"$\": \"HENRIQUE\"\n" +
                "                    },\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"FLORIANO PEIXOTO\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {},\n" +
                "                    \"f2\": {},\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"CESÁRIO ALVIM\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {},\n" +
                "                    \"f2\": {},\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"RONDON PACHECO\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {\n" +
                "                        \"$\": \"1\"\n" +
                "                    },\n" +
                "                    \"f2\": {\n" +
                "                        \"$\": \"Zé das Coves\"\n" +
                "                    },\n" +
                "                    \"f3\": {\n" +
                "                        \"$\": \"Covinha\"\n" +
                "                    },\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"RONDON PACHECO\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {\n" +
                "                        \"$\": \"1\"\n" +
                "                    },\n" +
                "                    \"f2\": {\n" +
                "                        \"$\": \"JOAO PEDRO\"\n" +
                "                    },\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"JOÃO NAVES DE ÁVILA\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {},\n" +
                "                    \"f2\": {},\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"BELÉM\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {},\n" +
                "                    \"f2\": {},\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"AFONSO PENA\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {\n" +
                "                        \"$\": \"4\"\n" +
                "                    },\n" +
                "                    \"f2\": {\n" +
                "                        \"$\": \"THAISE\"\n" +
                "                    },\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"CESÁRIO ALVIM\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {},\n" +
                "                    \"f2\": {},\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"f6\": {\n" +
                "                        \"$\": \"2\"\n" +
                "                    },\n" +
                "                    \"f7\": {\n" +
                "                        \"$\": \"MINAS GERAIS\"\n" +
                "                    },\n" +
                "                    \"f8\": {\n" +
                "                        \"$\": \"MG\"\n" +
                "                    },\n" +
                "                    \"f9\": {\n" +
                "                        \"$\": \"BENEDITO JERÔNIMO DOS SANTOS\"\n" +
                "                    },\n" +
                "                    \"f0\": {},\n" +
                "                    \"f1\": {},\n" +
                "                    \"f2\": {},\n" +
                "                    \"f3\": {},\n" +
                "                    \"f4\": {},\n" +
                "                    \"f5\": {\n" +
                "                        \"$\": \"UBERLANDIA\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

}
