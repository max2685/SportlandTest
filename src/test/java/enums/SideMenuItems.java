package enums;

public enum SideMenuItems {

    PRODUKTI("produkti"),
    ZIMOLI("zīmoli"),
    VEIKALI("veikali"),
    DAVANU_KARTE("dāvanu karte"),
    SERVISS("serviss"),
    BEZPROCENTU_AIZDEVUMS("bezprocentu aizdevums"),
    KAMPANAS("kampaņas"),
    PAR_MUMS("par mums"),
    ATBALSTAM("atbalstām");

    private final String menuItem;

    SideMenuItems(final String menuItem) {
        this.menuItem = menuItem;
    }

    public String menuItem() {
        return menuItem;
    }

    public String toString() {
        return this.menuItem;
    }
}
