import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Router {
    Map<String, Function<String, String>> simpleRoutes;
    Map<String, Function<String, String>> wildcardRoutes;

    public Router() {
        simpleRoutes = new HashMap<>();
        wildcardRoutes = new HashMap<>();
    }

    public void addRoute(String path, Function<String, String> handler) {
        if (path.contains("*")) {
            wildcardRoutes.put(path, handler);
        } else
            simpleRoutes.put(path, handler);
    }

    public String route(String path) {
        if (simpleRoutes.containsKey(path))
            return simpleRoutes.get(path).apply(path);

        for (Map.Entry<String, Function<String, String>> entry : wildcardRoutes.entrySet()) {
            String key = entry.getKey();
            // check if key can be mapped to path
            String regex = key.replace("*", ".*");
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(path);

            if (matcher.matches()) {
                return entry.getValue().apply(path);
            }

        }
        return "404 Not found";
    }

    public static String homeHandler(String path) {
        return "Home handler";
    }

    public static String userHandler(String path) {
        Pattern pattern = Pattern.compile("/user/(\\d+)");
        Matcher matcher = pattern.matcher(path);
        if (matcher.matches()) {
            return "User found " + matcher.group(1);
        }
        return "User not found";
    }

}
