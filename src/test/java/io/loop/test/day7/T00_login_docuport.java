package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import org.testng.annotations.Test;

public class T00_login_docuport  extends TestBase {

    @Test
    public void test_login_logout_docuport() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.CLIENT);
        DocuportUtils.logout(driver);

        Thread.sleep(3000);

        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        DocuportUtils.logout(driver);

        Thread.sleep(3000);

        DocuportUtils.login(driver, DocuportConstants.EMPLOYEE);
        DocuportUtils.logout(driver);

        Thread.sleep(3000);

        DocuportUtils.login(driver, DocuportConstants.SUPERVISOR);
        DocuportUtils.logout(driver);

    }


}
