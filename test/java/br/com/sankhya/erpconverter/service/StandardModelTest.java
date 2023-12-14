package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.dto.ResponseDTO;
import br.com.sankhya.erpconverter.dto.erp.response.ErpResponseDTO;
import br.com.sankhya.erpconverter.service.fieldSet.FieldSet;
import br.com.sankhya.erpconverter.service.fieldSet.StandardModel;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

class StandardModelTest {

    @Test
    void convertInput() {
    }

    @Test
    void convertOutput() {

        FieldSet fieldSet = new StandardModel();

        ErpResponseDTO erpResponseDTO = ErpResponseDTO.generation(responseJSON());

        System.out.println(erpResponseDTO);

        ResponseDTO response = fieldSet.convertOutput(erpResponseDTO, null);

        System.out.println(new Gson().toJson(response));
    }


    private String responseJSON(){

        return "{\n" +
                "    \"serviceName\": \"GatewayServiceProviderSP.getPriceList\",\n" +
                "    \"status\": \"1\",\n" +
                "    \"pendingPrinting\": \"false\",\n" +
                "    \"transactionId\": \"46960F5243FAE8B7AF177134AD58C7C3\",\n" +
                "    \"responseBody\": {\n" +
                "        \"dados\": [\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30725,\n" +
                "                    \"descricao\": \"SERVICO 30725\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80724,\n" +
                "                    \"descricao\": \"PRODUTO 80724\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80761,\n" +
                "                    \"descricao\": \"PRODUTO 80761\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80852,\n" +
                "                    \"descricao\": \"PRODUTO 80852\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 6900,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30678,\n" +
                "                    \"descricao\": \"SERVICO 30678\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30679,\n" +
                "                    \"descricao\": \"SERVICO 30679\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50137,\n" +
                "                    \"descricao\": \"SERVICO 50137\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30583,\n" +
                "                    \"descricao\": \"SERVICO 30583\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50622,\n" +
                "                    \"descricao\": \"SERVICO 50622\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50135,\n" +
                "                    \"descricao\": \"SERVICO 50135\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50372,\n" +
                "                    \"descricao\": \"SERVICO 50372\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 5.8,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80143,\n" +
                "                    \"descricao\": \"PRODUTO 80143\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30669,\n" +
                "                    \"descricao\": \"SERVICO 30669\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 495.74,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80149,\n" +
                "                    \"descricao\": \"PRODUTO 80149\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 24000,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30426,\n" +
                "                    \"descricao\": \"SERVICO 30426\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 90097,\n" +
                "                    \"descricao\": \"PRODUTO 90097\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 146,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80311,\n" +
                "                    \"descricao\": \"PRODUTO 80311\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80321,\n" +
                "                    \"descricao\": \"PRODUTO 80321\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80916,\n" +
                "                    \"descricao\": \"PRODUTO 80916\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80121,\n" +
                "                    \"descricao\": \"PRODUTO 80121\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 1001,\n" +
                "                    \"descricao\": \"PRODUTO 1001\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 38,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80208,\n" +
                "                    \"descricao\": \"PRODUTO 80208\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 19.8,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80209,\n" +
                "                    \"descricao\": \"PRODUTO 80209\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30600,\n" +
                "                    \"descricao\": \"SERVICO 30600\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30420,\n" +
                "                    \"descricao\": \"SERVICO 30420\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 4000,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 20441,\n" +
                "                    \"descricao\": \"SERVICO 20441\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 1495,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 20442,\n" +
                "                    \"descricao\": \"SERVICO 20442\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 7797,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 20443,\n" +
                "                    \"descricao\": \"SERVICO 20443\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 9205,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 20449,\n" +
                "                    \"descricao\": \"SERVICO 20449\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 20460,\n" +
                "                    \"descricao\": \"SERVICO 20460\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30536,\n" +
                "                    \"descricao\": \"SERVICO 30536\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 51056,\n" +
                "                    \"descricao\": \"SERVICO 51056\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50535,\n" +
                "                    \"descricao\": \"SERVICO 50535\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50538,\n" +
                "                    \"descricao\": \"SERVICO 50538\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 20487,\n" +
                "                    \"descricao\": \"SERVICO 20487\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50539,\n" +
                "                    \"descricao\": \"SERVICO 50539\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50369,\n" +
                "                    \"descricao\": \"SERVICO 50369\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 51059,\n" +
                "                    \"descricao\": \"SERVICO 51059\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 51064,\n" +
                "                    \"descricao\": \"SERVICO 51064\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 51066,\n" +
                "                    \"descricao\": \"SERVICO 51066\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50342,\n" +
                "                    \"descricao\": \"SERVICO 50342\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 50620,\n" +
                "                    \"descricao\": \"SERVICO 50620\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 30585,\n" +
                "                    \"descricao\": \"SERVICO 30585\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80405,\n" +
                "                    \"descricao\": \"PRODUTO 80405\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 64,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80407,\n" +
                "                    \"descricao\": \"PRODUTO 80407\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80420,\n" +
                "                    \"descricao\": \"PRODUTO 80420\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80424,\n" +
                "                    \"descricao\": \"PRODUTO 80424\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80436,\n" +
                "                    \"descricao\": \"PRODUTO 80436\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"PrecoPorContexto\": [\n" +
                "                    {\n" +
                "                        \"preco\": 0,\n" +
                "                        \"percentual\": 100,\n" +
                "                        \"regiaoVendedor\": [\n" +
                "                            \"1076\",\n" +
                "                            \"1071\",\n" +
                "                            \"1007\"\n" +
                "                        ],\n" +
                "                        \"codigoTabela\": 363,\n" +
                "                        \"dataVigor\": \"Aug 11, 2017 12:00:00 AM\",\n" +
                "                        \"dataAlteracao\": \"Aug 11, 2017 12:00:00 AM\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Produto\": {\n" +
                "                    \"id\": 80442,\n" +
                "                    \"descricao\": \"PRODUTO 80442\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"paginacao\": {\n" +
                "            \"pagina\": 1,\n" +
                "            \"paginaTamanho\": 49,\n" +
                "            \"maisPagina\": true,\n" +
                "            \"totalPagina\": 60,\n" +
                "            \"totalElemento\": 2974\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
}