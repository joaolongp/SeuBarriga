package Test.IntegratedTest;

import Test.BaseTest;
import Util.Screens;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class FlowTests extends BaseTest {

    private Screens screens = new Screens(driver);

    @Test
    public void validateCriarContaEditarContaRemoverConta(){
        screens.loginScreen.Do();
        screens.homeScreen.addConta();
        screens.addContaScreen.saveButton();
        Assert.assertEquals("Informe o nome da conta",driver.findElement(By.className("alert-danger")).getText());

        screens.addContaScreen.setName("Neymar");
        screens.addContaScreen.saveButton();
        Assert.assertEquals("Conta adicionada com sucesso!", driver.findElement(By.className("alert-success")).getText());

        screens.backtoHome();

        screens.homeScreen.listaContas();
        Assert.assertTrue(screens.listaContaScreen.getNames().contains("Neymar"));

        screens.listaContaScreen.editarConta(0);
        screens.editarContaScreen.setName("Menino Ney");
        screens.editarContaScreen.saveButton();
        Assert.assertEquals("Conta alterada com sucesso!", driver.findElement(By.className("alert-success")).getText());

        screens.listaContaScreen.excluirConta(0);
        Assert.assertEquals("Conta removida com sucesso!", driver.findElement(By.className("alert-success")).getText());
    }

    @Test
    public void validateContaCriadaMovimentacaoCriadaMovimentacaoListada(){
        screens.loginScreen.Do();
        screens.homeScreen.addConta();
        screens.addContaScreen.setName("Neymar");
        screens.addContaScreen.saveButton();
        Assert.assertEquals("Conta adicionada com sucesso!", driver.findElement(By.cssSelector("body > div.alert.alert-success")).getText());

        screens.backtoHome();
        screens.homeScreen.criarMovimentacao();
        screens.movimentacaoScreen.saveButton();
        for (String message : screens.movimentacaoScreen.errorMessagesList()) {
            Assert.assertTrue(screens.movimentacaoScreen.mandatoryFields.containsValue(message));
        }

        screens.movimentacaoScreen.setDataTransacao("01/07/2020");
        screens.movimentacaoScreen.setDataPgto("01/07/2020");
        screens.movimentacaoScreen.setDescricao("test");
        screens.movimentacaoScreen.setInteressado("test");
        screens.movimentacaoScreen.setValor("abc");
        screens.movimentacaoScreen.setTipo("REC");
        screens.movimentacaoScreen.setConta(0);
        screens.movimentacaoScreen.setSituacao("status_pago");
        screens.movimentacaoScreen.saveButton();

        Assert.assertTrue(screens.movimentacaoScreen.errorMessagesList().contains(screens.movimentacaoScreen.mandatoryFields.get("caracterValor")));

        screens.movimentacaoScreen.setValor("200");
        screens.movimentacaoScreen.saveButton();
        Assert.assertEquals("Movimentação adicionada com sucesso!", driver.findElement(By.cssSelector(".alert.alert-success")).getText());

        screens.backtoHome();
        screens.homeScreen.resumoMensal();
        screens.extratoScreen.setMes("07");
        screens.extratoScreen.setAno("2020");
        screens.extratoScreen.buscarButton();
        Assert.assertEquals("test",screens.extratoScreen.getItemByIndex(0,0).getText());
        Assert.assertEquals("01/07/2020",screens.extratoScreen.getItemByIndex(0,1).getText());
        Assert.assertEquals("Neymar",screens.extratoScreen.getItemByIndex(0,2).getText());
        Assert.assertEquals("200.00",screens.extratoScreen.getItemByIndex(0,3).getText());
        Assert.assertEquals("Pago",screens.extratoScreen.getItemByIndex(0,4).getText());
    }
}
