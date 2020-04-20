package enums;

public enum SideMenuItems {

    PRODUKTI("produkti"),
    ZIMOLI("zīmoli"),
    VEIKALI("veikali");

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
