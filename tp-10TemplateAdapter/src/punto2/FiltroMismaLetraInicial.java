package punto2;

public class FiltroMismaLetraInicial extends Filtro<String>{
	
	public String conQueFiltrar(WikipediaPage page) {
		return page.getTitle().substring(0,1).toLowerCase();
	}
	
	public boolean modoDeFiltro(WikipediaPage pagina, String contexto) {
		return pagina.getTitle().substring(0,1).toLowerCase().equals(contexto);
	}

}
