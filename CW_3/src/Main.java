public class Main {
    public static void main(String[] args) {
        // Utworzenie nowej biblioteki muzycznej
        BibliotekaMuzyczna mojaBiblioteka = new BibliotekaMuzyczna("Kolekcja Rockowa", "Jan Kowalski");

        // Dodawanie utworów do biblioteki
        mojaBiblioteka.dodajUtwor("Led Zeppelin – Stairway to Heaven");
        mojaBiblioteka.dodajUtwor("Queen – Bohemian Rhapsody");
        mojaBiblioteka.dodajUtwor("Pink Floyd – Comfortably Numb");
        mojaBiblioteka.dodajUtwor("AC/DC – Back in Black");
        mojaBiblioteka.dodajUtwor("Metallica – Nothing Else Matters");

        // Wyświetlenie wszystkich utworów
        mojaBiblioteka.wyswietlUtwory();

        // Tworzenie playlist
        mojaBiblioteka.utworzPlayliste("Ulubione");
        mojaBiblioteka.utworzPlayliste("Na impreze");

        // Dodawanie utworów do playlist
        mojaBiblioteka.dodajUtworDoPlayListy("Queen – Bohemian Rhapsody", "Ulubione");
        mojaBiblioteka.dodajUtworDoPlayListy("Pink Floyd – Comfortably Numb", "Ulubione");
        mojaBiblioteka.dodajUtworDoPlayListy("AC/DC – Back in Black", "Na impreze");
        mojaBiblioteka.dodajUtworDoPlayListy("Metallica – Nothing Else Matters", "Na impreze");

        // Wyświetlenie wszystkich playlist
        mojaBiblioteka.wyswietlWszystkiePlaylisty();

        // Wyświetlenie zawartości playlisty "Ulubione"
        mojaBiblioteka.wyswietlPlayliste("Ulubione");

        // Wyszukiwanie utworów z frazą "Queen"
        mojaBiblioteka.wyszukajUtwory("Queen");

        // Usunięcie utworu z biblioteki
        mojaBiblioteka.usunUtwor("AC/DC – Back in Black");

        // Sprawdzenie czy utwór został usunięty z playlisty
        mojaBiblioteka.wyswietlPlayliste("Na impreze");

        System.out.println("\nŁączna liczba utworów w bibliotece: " + mojaBiblioteka.getLiczbaUtworow());
        System.out.println("Łączna liczba playlist: " + mojaBiblioteka.getLiczbaPlaylist());
    }
}