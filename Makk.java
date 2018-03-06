class Makk implements MakkInterface {
    private String navn;
    private Hode hode;
    private Hale hale;

    public Makk() {
        this("Markus");
    }

    public Makk(String navn) {
        this.navn = navn;
        hode = new Hode();
        Segment s1 = new Segment();
        Segment s2 = new Segment();
        Segment s3 = new Segment();
        hale = new Hale();
        s1.settMellom(hode, s2);
        s3.settMellom(s2, hale);
    }

    @Override
    public void spis() {
        // Makken kan ikke spise hvis den er død.
        if (erDoed()) {
            System.out.println(navn + " er doed og kan ikke spise");
            return;
        }

        hale.avfallsmengde++;
        if (hale.avfallsmengde >= 4) {
            hale.avfallsmengde = 0;
            Segment nyttSegment = new Segment();
            nyttSegment.settMellom(hale.forrige, hale);
        }
    }

    @Override
    public void bliKuttet(int indeks) {

        // Hvis indeks er 0, kuttes makken på hodet. Makken består da bare
        // av et hode, og er død. Hvis indeks er 1 skjer det samme, siden
        // hodet ikke kan være hale samtidig.
        if (indeks == 0 || indeks == 1) {
            hode.settMellom(null, null);
            return;
        }

        // Hvis indeks er større enn størrelsen på makken, eller mindre enn 0,
        // bommet den som kuttet, og makken forblir urørt.
        if (indeks < 0 || indeks >= storrelse()) {
            return;
        }

        // Vi finner segmentet som skal kuttes
        Segment temp = hode;
        int i = 0;
        while (i < indeks && temp != hale) {
            i++;
            temp = temp.neste;
        }

        // Segmentet fjernes, og segmentet før blir til den nye halen.
        // Det siste segmentet blir da segmentet to forran det som kuttes.
        Segment sisteSegment = temp.forrige.forrige;

        // Da må vi ordne referansene slik at vi mister bakdelen av makken.
        hale = new Hale();
        sisteSegment.settMellom(sisteSegment.forrige, hale);
    }

    @Override
    public int storrelse() {
        int storrelse = 1;
        Segment temp = hode;
        while (temp != hale && temp != null) {
            storrelse++;
            temp = temp.neste;
        }
        return storrelse;
    }

    @Override
    public boolean erDoed() {
        return hode.neste == null;
    }

    public String hentNavn() {
        return navn;
    }

    @Override
    public String toString() {
        if (erDoed()) {
            return navn + " er doed! \n<X-";
        }

        String makk = "<:";
        for (Segment temp = hode.neste; temp != hale; temp = temp.neste) {
            makk += "|-";
        }
        return makk + "|>";
    }

    private class Segment {
        protected Segment neste;
        protected Segment forrige;

        protected void settMellom(Segment venstre, Segment hoyre) {
            this.neste = hoyre;
            this.forrige = venstre;
            if (venstre != null) venstre.neste = this;
            if (hoyre != null) hoyre.forrige = this;
        }
    }

    private class Hode extends Segment {
        int oyne = 2;
    }

    private class Hale extends Segment {
        int avfallsmengde = 0;
    }
}
