package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmittingFormComponent {

    private final String TITLE = "Thanks for submitting the form";
    private final SelenideElement submittingModalTitle = $("#example-modal-sizes-title-lg"),
                                  submittingModalResult = $(".table-responsive");

    public SubmittingFormComponent checkTitle() {
        submittingModalTitle.shouldHave(text(TITLE));

        return this;
    }

    public SubmittingFormComponent checkResult(String key, String value) {
        submittingModalResult.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
