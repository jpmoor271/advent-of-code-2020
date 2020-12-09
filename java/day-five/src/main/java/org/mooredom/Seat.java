package org.mooredom;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Seat {
    private static final Pattern SEAT_PATTERN = Pattern.compile("([BF]{7})([RL]{3})");

    private final int row;
    private final int column;

    public static Seat from(String seatCode) {
        Matcher matcher = SEAT_PATTERN.matcher(seatCode);
        if (matcher.matches()) {
            String rowCode = matcher.group(1);
            String columnCode = matcher.group(2);

            rowCode = rowCode.replaceAll("B", "1").replaceAll("F", "0");
            columnCode = columnCode.replaceAll("R", "1").replaceAll("L", "0");

            return new Seat(Integer.parseInt(rowCode, 2), Integer.parseInt(columnCode, 2));
        } else {
            throw new IllegalArgumentException("Invalid seat code: " + seatCode);
        }
    }

    public int getSeatId() {
        return this.getRow() * 8 + this.getColumn();
    }
}
