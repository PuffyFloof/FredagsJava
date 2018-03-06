interface MakkInterface {
    // En ny makk skal ha et Hode, en Hale og tre Segmenter
    // (dette skal gjøres i konstruktøren)

    // Øk avfallsmengden med 1. Hvis 4, skal den kvitte seg med det og øke
    // størrelse med 1.
    public void spis();

    // Kutter makken i to ved segment nr indeks.
    // Bakenden skal dø, og en ny bakende må opprettes
    public void bliKuttet(int indeks);

    // antall segmenter (inkludert hodet og halen)
    public int storrelse();

    // true hvis bare hodet er igjen.
    public boolean erDoed();
}
