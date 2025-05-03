package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.SubmittingFormComponent;

public class PracticeFormPageObjectsTest extends TestBase {

    PracticeFormPage practiceForm = new PracticeFormPage();
    SubmittingFormComponent submittingForm = new SubmittingFormComponent();

    String firstName = "Ivan",
            lastName = "Ivanov",
            email = "qwe123@gmail.com",
            gender = "Male",
            mobile = "1234567890",
            monthOfBirth = "January",
            yearOfBirth = "2000",
            dayOfBirth = "10",
            subject1 = "Maths",
            subject2 = "Chemistry",
            hobby1 = "Sports",
            hobby2 = "Music",
            picture = "mem_1.jpg",
            address = "100, Lenina street",
            state = "NCR",
            city = "Delhi",
            stateAndCity = String.format("%s %s", state, city);

    @Test
    @DisplayName("Проверка успешного заполнения всех полей формы")
    void successfulSubmitTest() {
        practiceForm
                .openPage()
                .removeBanner();

        practiceForm
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobilePhone(mobile)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject1)
                .setSubject(subject2)
                .setHobbies(hobby1)
                .setHobbies(hobby2)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        submittingForm
                .checkForm()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject1 + ", " + subject2)
                .checkResult("Hobbies", hobby1 + ", " + hobby2)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", stateAndCity);
    }

    @Test
    @DisplayName("Проверка успешного заполнения обязательных полей формы")
    void successfulRequiredSubmitTest() {
        practiceForm
                .openPage()
                .removeBanner();

        practiceForm
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobilePhone(mobile)
                .submit();

        submittingForm
                .checkForm()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile);
    }

    @Test
    @DisplayName("Валидация обязательных полей формы")
    void validationRequiredSubmitTest() {
        practiceForm
                .openPage()
                .removeBanner();

        practiceForm
                .setLastName(lastName)
                .setGender(gender)
                .setMobilePhone(mobile)
                .submit();

        submittingForm
                .absenceForm();
    }
}
