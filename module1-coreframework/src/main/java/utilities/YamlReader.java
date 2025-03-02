package utilities;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YamlReader {
    private Map<String, Object> yamlData = new HashMap<>();

    // Nested Map

    public YamlReader(String... filePaths) {
        Yaml yaml = new Yaml();
        for (String filePath : filePaths) {
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
                if (inputStream == null) {
                    throw new RuntimeException("YAML file not found: " + filePath);
                }
                Map<String, Object> data = yaml.load(inputStream);
                yamlData.putAll(data); // Merge data into a single map
            } catch (Exception e) {
                throw new RuntimeException("Error loading YAML file: " + filePath, e);
            }
        }
    }


    public String getValue(String key) {
        String[] keys = key.split("\\.");  // Handle nested keys (e.g., "Data.WarriorsData.WarriorsUrl")

        Map<String, Object> currentMap = yamlData;
        // Start from root data
        for (int i = 0; i < keys.length - 1; i++) {
            Object nestedData = currentMap.get(keys[i]);
            if (nestedData instanceof Map) {
                currentMap = (Map<String, Object>) nestedData;
            } else {
                return null;
                 // Key not found
            }
        }
        Object value = currentMap.get(keys[keys.length - 1]);
        if (value == null) {
            throw new RuntimeException("Key not found: " + keys[keys.length - 1]);
        }
        return value.toString(); // Return final value
    }

}
