package punto2;

import java.util.List;

public class LinkEnComun extends Filtro<List<WikipediaPage>>{
	
	public List<WikipediaPage> conQueFiltrar(WikipediaPage page) {
		return page.getLinks();
	}
	
	public boolean modoDeFiltro(WikipediaPage pagina, List<WikipediaPage> contexto) {
		return pagina.getLinks().stream().anyMatch(link -> contexto.contains(link));
	}
	
}
