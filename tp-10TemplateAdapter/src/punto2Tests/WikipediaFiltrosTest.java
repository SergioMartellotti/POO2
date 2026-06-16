package punto2Tests;

import punto2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WikipediaFiltrosTest {

    private WikipediaPage laPlata;
    private WikipediaPage lucasArt;
    private WikipediaPage lobo;
    private WikipediaPage gimnasia;
    private WikipediaPage buenosAires;
    private WikipediaPage messi;
    private WikipediaPage maradona;
    
    private List<WikipediaPage> baseDeDatosWikipedia;

    @BeforeEach
    public void setUp() {
        // 1. Páginas para test de iniciales
        laPlata = new WikipediaPage("La Plata");
        lucasArt = new WikipediaPage("Lucas Art");
        lobo = new WikipediaPage("Lobo");

        // 2. Páginas para test de links en común
        gimnasia = new WikipediaPage("Gimnasia y Esgrima La Plata");
        buenosAires = new WikipediaPage("Buenos Aires");
        
        // Configuración de links: Ambas apuntan a "La Plata"
        gimnasia.addLink(laPlata);
        buenosAires.addLink(laPlata);

        // 3. Páginas para test de propiedades del Infobox en común
        messi = new WikipediaPage("Lionel Messi");
        maradona = new WikipediaPage("Diego Maradona");
        
        // Configuración de propiedades: Comparten la clave "birth_place" (valores distintos)
        messi.addDescripcion("birth_place", new WikipediaPage("Rosario"));
        maradona.addDescripcion("birth_place", new WikipediaPage("Lanús"));
        // Propiedad extra que no comparte nadie
        messi.addDescripcion("current_club", new WikipediaPage("Inter Miami"));

        // Metemos todas las páginas en una lista simulando ser "Wikipedia"
        baseDeDatosWikipedia = Arrays.asList(laPlata, lucasArt, lobo, gimnasia, buenosAires, messi, maradona);
    }

    @Test
    public void testFiltroMismaLetraInicial() {
        Filtro<String> filtroLetra = new FiltroMismaLetraInicial();
        
        // Buscamos similares a "La Plata" (Debería traer "Lucas Art" y "Lobo")
        List<WikipediaPage> resultado = filtroLetra.getSimilarPages(laPlata, baseDeDatosWikipedia);
        
        assertEquals(2, resultado.size(), "Debería encontrar 2 páginas con la letra L");
        assertTrue(resultado.contains(lucasArt));
        assertTrue(resultado.contains(lobo));
        assertFalse(resultado.contains(laPlata), "No debería incluirse a sí misma");
    }

    @Test
    public void testFiltroLinkEnComun() {
        Filtro<List<WikipediaPage>> filtroLinks = new LinkEnComun();
        
        // Buscamos similares a "Gimnasia..." (Debería traer "Buenos Aires" porque ambas apuntan a "La Plata")
        List<WikipediaPage> resultado = filtroLinks.getSimilarPages(gimnasia, baseDeDatosWikipedia);
        
        assertEquals(1, resultado.size(), "Debería encontrar solo 1 página con link en común");
        assertTrue(resultado.contains(buenosAires), "Buenos Aires comparte el link a 'La Plata'");
        assertFalse(resultado.contains(gimnasia), "No debería incluirse a sí misma");
    }

    @Test
    public void testFiltroPropiedadEnComun() {
        Filtro<java.util.Map<String, WikipediaPage>> filtroPropiedades = new FiltroPropiedadEnComun();
        
        // Buscamos similares a "Lionel Messi" (Debería traer a "Diego Maradona" por la clave "birth_place")
        List<WikipediaPage> resultado = filtroPropiedades.getSimilarPages(messi, baseDeDatosWikipedia);
        
        assertEquals(1, resultado.size(), "Debería encontrar 1 página con propiedad en común");
        assertTrue(resultado.contains(maradona), "Maradona comparte la propiedad 'birth_place'");
        assertFalse(resultado.contains(messi), "No debería incluirse a sí misma");
    }
    
    @Test
    public void testSinSimilares() {
        Filtro<String> filtroLetra = new FiltroMismaLetraInicial();
        WikipediaPage paginaZ = new WikipediaPage("Zorro");
        
        // Buscamos similares para una página cuya letra no coincide con nadie
        List<WikipediaPage> resultado = filtroLetra.getSimilarPages(paginaZ, baseDeDatosWikipedia);
        
        assertTrue(resultado.isEmpty(), "La lista debería estar vacía si no hay coincidencias");
    }
}