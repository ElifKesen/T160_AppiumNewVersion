package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PttPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class PttAVMStepDef {
    PttPage page=new PttPage();

    @Given("Kullanici uygulamayi yukler")
    public void kullanici_uygulamayi_yukler() {
        Driver.getAndroidDriver();
    }

    @Given("Kullanici uygulamayi acar")
    public void kullanici_uygulamayi_acar() {
        Driver.getAndroidDriver();
    }

    @When("hesabim bolumune gider")
    public void hesabim_bolumune_gider() {
        page.accountButton.click();
        ReusableMethods.bekle(3);
    }

    @Then("Kullanıcı {string} butonunun göründüğünü doğrular")
    public void kullanıcı_butonunun_göründüğünü_doğrular(String GirisYap) {
        Assert.assertTrue(page.girisYapButton.isDisplayed());
        ReusableMethods.bekle(3);
    }

    @When("Kullanıcı ana sayfaya geri doner")
    public void kullanıcı_ana_sayfaya_geri_doner() {
        page.geriOkButton.click();
        ReusableMethods.bekle(3);
    }

    @When("{string} bolumune tiklar")
    public void bolumune_tiklar(String secenek) {
       // page.kategorilerButton.click();
        ReusableMethods.scrollWithUiScrollableAndClick(secenek);
        ReusableMethods.bekle(3);
    }

    @When("{string} bolumunu secer")
    public void bolumunu_secer(String urunkategorisi) {
        ReusableMethods.scrollWithUiScrollableAndClick(urunkategorisi);
        ReusableMethods.bekle(3);
    }

    @When("{string} secenegine gider")
    public void secenegine_gider(String urun) {
        ReusableMethods.dikeyKaydirma(Driver.getAndroidDriver(),0.70,0.30,0.50,80);
        ReusableMethods.bekle(3);
        ReusableMethods.scrollWithUiScrollableAndClick(urun);
        ReusableMethods.bekle(3);

    }
    @When("Urunleri {string} a gore siralar")
    public void urunleri_a_gore_siralar(String string) {
        page.siralaButton.click();
        ReusableMethods.bekle(3);
        page.AzalanFiyatText.click();
        ReusableMethods.bekle(3);

    }
    @Then("fiyatlarin azalan duzende oldugunu dogrular")
    public void fiyatlarin_azalan_duzende_oldugunu_dogrular() {
       String ilkfiyat= page.ilkFiyat.getText();
       ilkfiyat=ilkfiyat.replaceAll("\\D","");

        ReusableMethods.bekle(3);

       String ikincifiyat= page.ikinciFiyat.getText();
        ikincifiyat=ikincifiyat.replaceAll("\\D","");

       Assert.assertTrue(Integer.parseInt(ilkfiyat)<Integer.parseInt(ikincifiyat));

    }
    @Then("Kullanici ekran fotografi cekmek istedigi elementin {string} ekran fotografini ceker")
    public void kullanici_ekran_fotografi_cekmek_istedigi_elementin_ekran_fotografini_ceker(String ekranGoruntusu) throws IOException {
        ReusableMethods.bekle(7);
        ReusableMethods.screenShotElement(ekranGoruntusu);

    }

}
