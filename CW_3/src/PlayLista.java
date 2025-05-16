import java.util.ArrayList;

public class PlayLista {
    private String nazwa;
    private ArrayList<String> utwory;

    public PlayLista(String nazwa) {
        this.nazwa = nazwa;
        this.utwory = new ArrayList<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public ArrayList<String> getUtwory() {
        return utwory;
    }

    public void dodajUtwor(String utwor) {
        if (!utwory.contains(utwor)) {
            utwory.add(utwor);
        }
    }

    public void usunUtwor(String utwor) {
        utwory.remove(utwor);
    }

    public boolean zawieraUtwor(String utwor) {
        return utwory.contains(utwor);
    }

    public void wyswietlPlayliste() {
        System.out.println("Playlista: " + nazwa);
        if (utwory.isEmpty()) {
            System.out.println("  (pusta)");
        } else {
            for (String utwor : utwory) {
                System.out.println("  - " + utwor);
            }
        }
    }
}