import lombok.*;

import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    private long id;

    private String name;

    private List<SubCategoria> subCategorias;

}