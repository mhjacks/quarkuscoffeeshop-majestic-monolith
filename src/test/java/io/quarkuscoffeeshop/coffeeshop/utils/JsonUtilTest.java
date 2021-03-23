package io.quarkuscoffeeshop.coffeeshop.utils;

import io.quarkuscoffeeshop.coffeeshop.TestUtils;
import io.quarkuscoffeeshop.coffeeshop.domain.commands.PlaceOrderCommand;
import io.quarkuscoffeeshop.utils.JsonUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JsonUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtilTest.class);

    @Test
    public void testUnmarshalling() {
        PlaceOrderCommand placeOrderCommand = TestUtils.mockPlaceOrderCommand();
        logger.info("placeOrderCommand: {}", JsonUtil.toJson(placeOrderCommand));
        String result = JsonUtil.toJson(placeOrderCommand);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void testMarshalling() {
        String json = "{\"id\":\"964e94e6-700e-4dfb-99a3-1c27acf9a384\",\"orderSource\":\"COUNTER\",\"location\":\"ATLANTA\",\"loyaltyMemberId\":\"PeskyParrot\",\"timestamp\":1616519311.982413000,\"baristaLineItems\":null,\"kitchenLineItems\":null}";
        PlaceOrderCommand result = JsonUtil.fromJson(json, PlaceOrderCommand.class);
        assertEquals("964e94e6-700e-4dfb-99a3-1c27acf9a384", result.getId());
    }
}
