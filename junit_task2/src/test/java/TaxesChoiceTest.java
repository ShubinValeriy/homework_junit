import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class TaxesChoiceTest {
    @Test
    void taxEarningsTest() {
        // given:
        int earnings = 1000;
        int taxTrue = 60;

        // when:
        int tax = TaxesChoice.taxEarnings(earnings);

        // then:
        assertEquals(taxTrue, tax);
    }

    @Test
    void taxEarningsTestHamcrest() {
        // given:
        int earnings = 1000;
        int taxTrue = 60;

        // when:

        // then:
        assertThat(TaxesChoice.taxEarnings(earnings), equalTo(taxTrue));
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 100, 135",
            "100, 1000, 0"
    })
    void taxEarningsMinusSpendingsTest(int earnings, int spendings, int taxTrue) {
        // when:
        int tax = TaxesChoice.taxEarningsMinusSpendings(earnings, spendings);
        // then:
        assertEquals(taxTrue, tax);
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 100, 135",
            "100, 1000, 0",
            "350, 400, 0",
            "400, 350, 7"
    })
    void taxEarningsMinusSpendingsTestHamcrest(int earnings, int spendings, int taxTrue) {
        // when:
        int tax = TaxesChoice.taxEarningsMinusSpendings(earnings, spendings);
        // then:
        assertThat(tax, allOf(greaterThanOrEqualTo(0), equalTo(taxTrue)));
    }

}