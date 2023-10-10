
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;




class MainTest {


@Test
    void validateNegativeMinLengthSet(){
    // given:
    int length = -1;
    PasswordChecker passwordChecker = new PasswordChecker();
    // when:

    // then:
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
        passwordChecker.setMinLength(length);
    });
}



    @ParameterizedTest
    @CsvSource ({
            "3, 2, aabb, true",
            "3, 2, 12, false",
            "3, 2, 11122, false"
    })
    public void validatePass(int minLength, int maxRepeats, String pass, boolean expected ){
    // given:
    PasswordChecker passwordChecker = new PasswordChecker();
    passwordChecker.setMinLength(minLength);
    passwordChecker.setMaxRepeats(maxRepeats);

    // when:
    boolean isValid = passwordChecker.verify(pass);

    // then:
    Assertions.assertEquals(expected,isValid);
    }

}