import java.util.ArrayList;

public class BibliotekaMuzyczna {
    private String nazwa;
    private String wlasciciel;
    private ArrayList<String> utwory;
    private ArrayList<PlayLista> playlists;

    public BibliotekaMuzyczna(String nazwa, String wlasciciel) {
        this.nazwa = nazwa;
        this.wlasciciel = wlasciciel;
        this.utwory = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    // Operacje na utworach
    public void dodajUtwor(String utwor) {
        if (!utwory.contains(utwor)) {
            utwory.add(utwor);
            System.out.println("Dodano utwór: " + utwor);
        } else {
            System.out.println("Utwór " + utwor + " już istnieje w bibliotece");
        }
    }

    public void usunUtwor(String utwor) {
        if (utwory.remove(utwor)) {
            // Usuń utwór ze wszystkich playlist
            for (PlayLista playlist : playlists) {
                if (playlist.zawieraUtwor(utwor)) {
                    playlist.usunUtwor(utwor);
                }
            }
            System.out.println("Usunięto utwór: " + utwor);
        } else {
            System.out.println("Utwór " + utwor + " nie istnieje w bibliotece");
        }
    }

    public void wyswietlUtwory() {
        System.out.println("\nWszystkie utwory w bibliotece:");
        if (utwory.isEmpty()) {
            System.out.println("  (brak utworów)");
        } else {
            for (String utwor : utwory) {
                System.out.println("  - " + utwor);
            }
        }
    }

    public void wyszukajUtwory(String fraza) {
        System.out.println("\nWyniki wyszukiwania dla frazy '" + fraza + "':");
        boolean znaleziono = false;
        for (String utwor : utwory) {
            if (utwor.toLowerCase().contains(fraza.toLowerCase())) {
                System.out.println("  - " + utwor);
                znaleziono = true;
            }
        }
        if (!znaleziono) {
            System.out.println("  (brak wyników)");
        }
    }

    // Operacje na playlistach
    public void utworzPlayliste(String nazwa) {
        if (znajdzPlayListe(nazwa) == null) {
            playlists.add(new PlayLista(nazwa));
            System.out.println("Utworzono playlistę: " + nazwa);
        } else {
            System.out.println("Playlista " + nazwa + " już istnieje");
        }
    }

    private PlayLista znajdzPlayListe(String nazwa) {
        for (PlayLista playlist : playlists) {
            if (playlist.getNazwa().equalsIgnoreCase(nazwa)) {
                return playlist;
            }
        }
        return null;
    }

    public void dodajUtworDoPlayListy(String utwor, String nazwaPlaylisty) {
        if (!utwory.contains(utwor)) {
            System.out.println("Utwór " + utwor + " nie istnieje w bibliotece");
            return;
        }

        PlayLista playlist = znajdzPlayListe(nazwaPlaylisty);
        if (playlist != null) {
            playlist.dodajUtwor(utwor);
            System.out.println("Dodano utwór " + utwor + " do playlisty " + nazwaPlaylisty);
        } else {
            System.out.println("Playlista " + nazwaPlaylisty + " nie istnieje");
        }
    }

    public void wyswietlPlayliste(String nazwa) {
        PlayLista playlist = znajdzPlayListe(nazwa);
        if (playlist != null) {
            playlist.wyswietlPlayliste();
        } else {
            System.out.println("Playlista " + nazwa + " nie istnieje");
        }
    }

    public void wyswietlWszystkiePlaylisty() {
        System.out.println("\nWszystkie playlisty:");
        if (playlists.isEmpty()) {
            System.out.println("  (brak playlist)");
        } else {
            for (PlayLista playlist : playlists) {
                System.out.println("  - " + playlist.getNazwa() +
                        " (" + playlist.getUtwory().size() + " utworów)");
            }
        }
    }

    // Gettery
    public int getLiczbaUtworow() {
        return utwory.size();
    }

    public int getLiczbaPlaylist() {
        return playlists.size();
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }
}