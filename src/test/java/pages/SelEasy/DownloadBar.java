package pages.SelEasy;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DownloadBar {

    private String header = "//h2";
    private String downloadButton = "//button[@id='downloadButton']";

    private String dlDialog = "//div[@id='dialog']";
    private String dlStatus = dlDialog + "/div[text()='Complete!']";
    private String dialogButton = dlDialog + "/..//button[text()='Close']";

    public DownloadBar() {
        PageLayout layout = new PageLayout();
        $x(header).shouldHave(Condition.exactText("JQuery UI Progress bar - Download Dialog"));
        $x(downloadButton).shouldBe(Condition.visible);
    }

    @Step("Press Start Download, wait until 1) dialog reads \"File download Complete!\" 2) button has Close text")
    public DownloadBar runDownload() {
        $x(downloadButton).click();
        $x(dlStatus).waitUntil(Condition.visible, 20000);
        $x(dialogButton).shouldBe(Condition.visible);
        return this;
    }
}
