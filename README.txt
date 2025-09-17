# WeatherNavApp

1) Öppna projektet i Android Studio (File > Open, välj mappen `WeatherNavApp`).
2) Lägg till din OpenWeather API-nyckel:
   - Alternativ A: i `gradle.properties` (projekt): `OWM_KEY=DIN_NYCKEL`
   - Alternativ B: kör med env var `OWM_KEY` när du bygger.
3) Synca Gradle. Kör appen på emulator/telefon (API 26+).
4) I appen: Main visar väder för Malmö. Klicka "Byt stad" för att sätta ny stad (VG: back stängs). "Se prognos" öppnar listan; klick på en rad för detaljer.