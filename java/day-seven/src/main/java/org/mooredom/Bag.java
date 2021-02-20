package org.mooredom;

import lombok.Data;

@Data
public class Bag {
    private final BagType type;
    private final int quantity;
}
