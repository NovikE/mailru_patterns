package tests;

import factorymethod.QAUserCreator;
import factorymethod.User;
import factorymethod.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComposeEmailDialog;
import pages.DraftsFolderPage;
import pages.LoginPage;
import pages.SentEmailsFolderPage;
import utils.InputData;
import utils.StringUtils;

public class IsEmailSentTest extends BaseTest{

        String sendToAddress = InputData.SENDTOADRESS.getPersonalData();
        String emailSubject = StringUtils.getRandomString(9);
        String emailBody = StringUtils.getRandomString(50);

        @Test
        public void verifySentEmail() throws InterruptedException {

                UserCreator creator = new QAUserCreator();
                User testUser = creator.createUser();

                new LoginPage(driver)
                        .login(testUser);

                new ComposeEmailDialog(driver).clickCompose()
                        .createNewDraftEmail(sendToAddress, emailSubject, emailBody)
                        .closeEmail();

                DraftsFolderPage draftsFolder = new DraftsFolderPage(driver).draftsOpenFolder();
                draftsFolder.findEmail(emailSubject);
                draftsFolder.verifyEmails(sendToAddress, emailBody);
                draftsFolder.sendEmail();
                draftsFolder.closeAlertWindow();
                draftsFolder.draftsOpenFolder().findEmail(emailSubject);

                SentEmailsFolderPage sentEmailsFolder = new SentEmailsFolderPage(driver);
                Assert.assertTrue(sentEmailsFolder.openSentEmailsFolder().isEmailSent(emailSubject),"Email is not sent!");
                sentEmailsFolder.logout();

        }
}
