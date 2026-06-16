package punto2;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Filtro <T>{

	public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia){
		T contexto = this.conQueFiltrar(page);
		return wikipedia.stream()
				.filter(pagina -> !pagina.equals(page))
				.filter(pagina -> this.modoDeFiltro(pagina, contexto)).collect(Collectors.toList());
	}
	
	public abstract T conQueFiltrar(WikipediaPage page);
	public abstract boolean modoDeFiltro(WikipediaPage pagina, T contexto);
	
}
