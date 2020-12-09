package org.mooredom;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SeatTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/test-input.csv")
    void testFactoryMethodWithValidInput (String seatCode, int expectedRow, int expectedColumn) {
        Seat seat = Seat.from(seatCode);
        assertThat(seat.getRow(), is(equalTo(expectedRow)));
        assertThat(seat.getColumn(), is(equalTo(expectedColumn)));
    }

    @Test
    void testGetSeatId() {
        int row = 44;
        int column = 5;
        Seat seat = new Seat(row, column);
        assertThat(seat.getSeatId(), is(equalTo(357)));
    }
}