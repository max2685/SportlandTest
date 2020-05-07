package enums;

public enum ItemsInGenderTab {

    FUTBOLS("futbols");

    private final String menuItem;

    ItemsInGenderTab(final String menuItem) {
        this.menuItem = menuItem;
    }

    public String menuItem() {
        return menuItem;
    }

    public String toString() {
        return this.menuItem;
    }
}
