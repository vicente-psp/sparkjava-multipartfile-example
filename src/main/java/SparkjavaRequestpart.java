import static spark.Spark.*;

public class SparkjavaRequestpart {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}