package punto2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WikipediaPage {

	private String nombre;
	private List<WikipediaPage> links;
	private Map<String, WikipediaPage> descripciones;
	
	public WikipediaPage(String nombre) {
		this.nombre = nombre;
		this.links = new ArrayList<WikipediaPage>();
		this.descripciones = new HashMap<>();
	}
	
	public void addLink(WikipediaPage page) {
		links.add(page);
	}
	
	public void addDescripcion(String texto, WikipediaPage page) {
		descripciones.put(texto, page);
	}
	
	public String getTitle() {
		return this.nombre;
	}
	
	public List<WikipediaPage> getLinks(){
		return this.links;
	}
	
	public Map<String, WikipediaPage> getInfobox(){
		return descripciones;
	}
}
