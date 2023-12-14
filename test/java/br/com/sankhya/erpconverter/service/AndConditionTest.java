package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.entity.AndCondition;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class AndConditionTest {

    @Test
    public void testValidScriptAndCondition(){
        AndCondition validScript = new AndCondition(Arrays.asList("ENDERECO","TESTE","TESTE2","TESTE3","TESTE4","script"),"S");
        AndCondition getCondition = new AndCondition(Arrays.asList("ENDERECO","TESTE","TESTE2","TESTE3","TESTE4","script"),"S");

        Assert.assertNotEquals(validScript.validScript(),null);

        Assert.assertTrue(getCondition.getCondition().contains("AND"));
    }
}
