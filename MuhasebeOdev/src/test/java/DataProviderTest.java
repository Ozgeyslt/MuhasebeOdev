import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.test.MetotClass;
import web.test.Muhasebe;
import web.test.MuhasebeBuild;

public class DataProviderTest {
    MetotClass metotClass=new MetotClass();

    @BeforeClass
    public void beforeClass(){
        Muhasebe muhasebe=MuhasebeBuild.startMuhasebe().setName("ayse")
                .setId(1).setMaas(50000).setKidem("personel").build();
    }

    @DataProvider (name = "credentials")
    public Object[][] dataProvider(){
        return new Object[][]{
                {60000, 65000}, //Doğru veri
                {65000, 0},     //Hatali veri
                {0, 60000}      //Hatali veri
        };
    }

    @Test(dataProvider = "credentials")
    public void dataTest(int maas, int response){
        Assert.assertEquals(metotClass.zam(), response);
    }

}
