package tests;

import factorymethod.QAUserCreator;
import factorymethod.User;
import factorymethod.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComposeEmailDialog;
import pages.DraftsFolderPage;
import pages.LoginPage;
import utils.InputData;
import utils.StringUtils;

public class ComposeEmailTest extends BaseTest{

        String sendToAddress = InputData.SENDTOADRESS.getPersonalData();
        String emailSubject = StringUtils.getRandomString(9);
        String emailBody = StringUtils.getRandomString(50);

        @Test
        public void saveEmail() throws InterruptedException {
            UserCreator creator = new QAUserCreator();
            User testUser = creator.createUser();
            new LoginPage(driver)
                    .login(testUser);

            new ComposeEmailDialog(driver).clickCompose()
                    .createNewDraftEmail(sendToAddress, emailSubject, emailBody)
                    .closeEmail();

            DraftsFolderPage draftsFolder = new DraftsFolderPage(driver).draftsOpenFolder();
            Assert.assertTrue(draftsFolder.findEmail(emailSubject), "Email is not found in Drafts-folder!");
        }

    }

