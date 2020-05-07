package enums;

public enum GenderTab {

    VIRIESI("vīrieši"),
    SIEVIETES("sievietes"),
    ZENI("zēni"),
    MEITENES("meitenes");


    private final String menuItem;

    GenderTab(final String menuItem) {
        this.menuItem = menuItem;
    }

    public String menuItem() {
        return menuItem;
    }

    public String toString() {
        return this.menuItem;
    }
}
