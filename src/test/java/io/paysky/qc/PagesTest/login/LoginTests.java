package io.paysky.qc.PagesTest.login;

import io.paysky.qc.pages.Login.LogInPage;
import io.paysky.qc.utilities.BaseTest.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    final LogInPage login = new LogInPage();

    @Test(description = "Delete Role")
    @Epic("EPIC NAME AND ID")
    @Story("STORY NAME AND ID")
    @Severity(SeverityLevel.CRITICAL)
    @Description("DESCRIPTION")
    @Link(value = "ID FOR AZURE",type = "Testcase",url ="ISSUE URL")
    @Owner("Owner Name")
    public void  loginWithUser() {
        login.LogInWithValidUser();
    }

}
