package org.fest.assertions.api.localdatetime;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.fest.assertions.api.JODA_TIME.assertThat;

import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Only test String based assertion (tests with {@link LocalDateTime} are already defined in fest-assert-core)
 * 
 * @author Joel Costigliola
 */
@RunWith(Theories.class)
public class LocalDateTimeAssert_isNotEqualTo_Test extends LocalDateTimeAssertBaseTest {

  @Theory
  public void test_isNotEqualTo_assertion(LocalDateTime referenceDate) {
    // WHEN
    assertThat(referenceDate).isNotEqualTo(referenceDate.plusDays(1).toString());
    // THEN
    verify_that_isNotEqualTo_assertion_fails_and_throws_AssertionError(referenceDate);
  }

  @Test
  public void test_isNotEqualTo_assertion_error_message() {
    try {
      assertThat(new LocalDateTime(2000, 1, 5, 3, 0, 5))
          .isNotEqualTo(new LocalDateTime(2000, 1, 5, 3, 0, 5).toString());
    } catch (AssertionError e) {
      assertThat(e).hasMessage("<2000-01-05T03:00:05.000> should not be equal to:<2000-01-05T03:00:05.000>");
      return;
    }
    fail("Should have thrown AssertionError");
  }

  @Test
  public void should_fail_if_dateTime_as_string_parameter_is_null() {
    expectException(IllegalArgumentException.class,
        "The String representing the LocalDateTime to compare actual with should not be null");
    assertThat(new LocalDateTime()).isNotEqualTo((String) null);
  }

  private static void verify_that_isNotEqualTo_assertion_fails_and_throws_AssertionError(LocalDateTime reference) {
    try {
      assertThat(reference).isNotEqualTo(reference.toString());
    } catch (AssertionError e) {
      // AssertionError was expected
      return;
    }
    fail("Should have thrown AssertionError");
  }

}
