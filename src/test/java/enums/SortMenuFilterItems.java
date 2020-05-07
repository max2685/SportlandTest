package enums;

public enum SortMenuFilterItems {

    IZPARDOSANA("izpārdošana"),
    CENA_NO_ZEMAKAS_UZ_AUGSTAKO("cena no zemākās uz augstāko"),
    CENA_NO_AUGSTAKAS_UZ_ZEMAKO("cena no augstākās uz zemāko"),
    FUTBOLA_APAVI_CIETAM_SEGUMAM("futbola apavi cietam segumam"),
    FUTBOLA_APAVI_IEKSTELPAM("futbola apavi iekštelpām"),
    FUTBOLA_APAVI_MAKSLIGAJAM_SEGUMAM("futbola apavi mākslīgajam segumam"),
    NIKE("nike"),
    ADIDAS("adidas");

    private final String menuItem;

    SortMenuFilterItems(final String menuItem) {
        this.menuItem = menuItem;
    }

    public String menuItem() {
        return menuItem;
    }

    public String toString() {
        return this.menuItem;
    }
}
