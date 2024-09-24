package pl.nn.exchange.infrastructure.config;

import lombok.experimental.UtilityClass;

import java.math.RoundingMode;

@UtilityClass
public class BigDecimalConst {
    public static final Integer SCALE = 4;
    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
}
