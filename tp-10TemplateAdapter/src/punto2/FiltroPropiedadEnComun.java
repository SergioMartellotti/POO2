package punto2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FiltroPropiedadEnComun  extends Filtro<Map<String, WikipediaPage>>{

	public Map<String, WikipediaPage> conQueFiltrar(WikipediaPage page) {
		return page.getInfobox();
	}
	
	public boolean modoDeFiltro(WikipediaPage pagina, Map<String, WikipediaPage> contexto) {
		return pagina.getInfobox()
				.keySet()
				.stream()
				.anyMatch(propiedad-> contexto.keySet().contains(propiedad));
	}
}
