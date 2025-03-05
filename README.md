# T9WordPredictor

T9WordPredictor to aplikacja oparta na Javie, która symuluje klasyczną klawiaturę telefonu z funkcją przewidywania słów na podstawie wprowadzonych cyfr.
Aplikacja wykorzystuje mapowanie liter na cyfry w stylu klasycznych telefonów komórkowych (T9). Użytkownik może wprowadzać cyfry na wirtualnej klawiaturze, a program sugeruje możliwe słowa na podstawie wbudowanego słownika.

## Funkcjonalności

- Symulacja klawiatury numerycznej
- Konwersja wprowadzonych cyfr na możliwe słowa
- Obsługa słownika z popularnymi słowami i terminami programistycznymi
- Interfejs graficzny oparty na Swing

## Wymagania

- Java 8+

## Instalacja

1. Sklonuj repozytorium:

   ```sh
   git clone https://github.com/twoj-uzytkownik/T9WordPredictor.git
   ```

2. Przejdź do katalogu projektu:

   ```sh
   cd T9WordPredictor
   ```

3. Skompiluj i uruchom aplikację:

   ```sh
   javac -d out src/org/example/*.java
   java -cp out org.example.Keypad
   ```

## Jak używać

1. Uruchom aplikację.
2. Używaj przycisków numerycznych, aby wprowadzać cyfry odpowiadające literom.
3. Naciśnij "OK", aby zobaczyć pasujące słowa.
4. Użyj "Clear", aby wyczyścić ekran.

