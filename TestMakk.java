class TestMakk {
    public static void main(String[] args) {
        Makk bob = new Makk("Bob");
        System.out.println(bob.hentNavn() + ":");
        System.out.println(bob);
        System.out.println("Bob har " + bob.storrelse() + " segmenter.");
        
        System.out.println("Bob legger paa seg 10 segmenter");
        for (int i = 0; i < 40; i++) bob.spis();
        System.out.println(bob);

        System.out.println("Bob blir kuttet to segmenter foer halen");
        bob.bliKuttet(bob.storrelse() - 3);
        System.out.println(bob);

        System.out.println("Bob blir kuttet to segmenter etter hodet");
        bob.bliKuttet(3);
        System.out.println(bob);

        System.out.println("Bob blir kuttet ett segment etter hodet");
        bob.bliKuttet(2);
        System.out.println(bob);

        System.out.println("Bob spiser og legger paa seg 3 segmenter");
        for (int i = 0; i < 12; i++) bob.spis();
        System.out.println(bob);

        System.out.println("Bob blir kuttet i segmentet etter hodet");
        bob.bliKuttet(1);
        System.out.println(bob);

        System.out.println("Bob proever aa spise");
        bob.spis();


        Makk frida = new Makk("Frida");
        System.out.println("\n" + frida.hentNavn() + ":");
        System.out.println(frida);

        System.out.println("Frida blir kuttet langt etter halen");
        frida.bliKuttet(9999999);
        System.out.println(frida);

        System.out.println("Frida blir kuttet foer hodet");
        frida.bliKuttet(-25);
        System.out.println(frida);

        System.out.println("Frida blir en stor og sunn makk");
        while (frida.storrelse() < 40) {
            frida.spis();
        }
        System.out.println(frida);
    }
}
