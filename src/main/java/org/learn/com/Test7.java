package org.learn.com;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;
import java.util.Map;

public class Test7 {


        public static void main(String[] args) {

            String json = "{\n" +
                    "  \"items\": {\n" +
                    "    \"item\": [\n" +
                    "      {\n" +
                    "        \"id\": \"0001\",\n" +
                    "        \"type\": \"donut\",\n" +
                    "        \"name\": \"Cake\",\n" +
                    "        \"ppu\": 0.55,\n" +
                    "        \"batters\": {\n" +
                    "          \"batter\": [\n" +
                    "            { \"id\": \"1001\", \"type\": \"Regular\" },\n" +
                    "            { \"id\": \"1002\", \"type\": \"Chocolate\" },\n" +
                    "            { \"id\": \"1003\", \"type\": \"Blueberry\" },\n" +
                    "            { \"id\": \"1004\", \"type\": \"Devil's Food\" }\n" +
                    "          ]\n" +
                    "        },\n" +
                    "        \"topping\": [\n" +
                    "          { \"id\": \"5001\", \"type\": \"None\" },\n" +
                    "          { \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
                    "          { \"id\": \"5005\", \"type\": \"Sugar\" },\n" +
                    "          { \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\n" +
                    "          { \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\n" +
                    "          { \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
                    "          { \"id\": \"5004\", \"type\": \"Maple\" }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}";

            JsonPath js = new JsonPath(json);

// Step 1: Get first item as a Map
            Map<String, Object> itemMap = js.getMap("items.item[0].batters.batter[2]");

            System.out.println("Item Map: " + itemMap);


            // 🔸 1. Extract a String
            String name = js.getString("items.item[0].name");
            System.out.println("Name: " + name);

            // 🔸 2. Extract a Double
            double ppu = js.getDouble("items.item[0].ppu");
            System.out.println("PPU: " + ppu);

            // 🔸 3. Extract a List of all batter types
            List<String> batterTypes = js.getList("items.item[0].batters.batter.type");
            System.out.println("Batter Types: " + batterTypes);

            // 🔸 4. Extract all topping IDs
            List<String> toppingIds = js.getList("items.item[0].topping.id");
            System.out.println("Topping IDs: " + toppingIds);

            // 🔸 5. Validation (Assertions) using Rest Assured’s built-in methods
            assert name.equals("Cake");
            assert ppu == 0.55;
            assert batterTypes.contains("Chocolate");
            assert toppingIds.size() == 7;
        }

}
