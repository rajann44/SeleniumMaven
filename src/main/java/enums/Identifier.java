package enums;

public enum Identifier {

    ID("ID"),
    XPATH("XPATH"),
    CSS("CSS"),
    TAG_NAME("TAGNAME");

    private final String name;

    Identifier(String name) {this.name = name;}

}
