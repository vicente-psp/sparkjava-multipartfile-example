import com.google.gson.Gson;

import javax.servlet.MultipartConfigElement;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static spark.Spark.post;

public class SparkjavaRequestpart {
    public static void main(String[] args) {
        post("/upload", (request, response) -> {
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            try (InputStream is = request.raw().getPart("arquivo").getInputStream()) {
                // Use the input stream to create a file
                System.out.println("funfou arquivo");
            }
            try (InputStream is = request.raw().getPart("entidade").getInputStream()) {

                BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();

                String inputStr;
                while ((inputStr = streamReader.readLine()) != null) {
                    responseStrBuilder.append(inputStr);
                }

                Gson gson=new Gson();
                Categoria categoria = gson.fromJson(responseStrBuilder.toString(), Categoria.class);

                System.out.println(categoria.toString());
                System.out.println("funfou entidade");
            }
            return "File uploaded";
        });
    }
}