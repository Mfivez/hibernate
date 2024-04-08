package jpaPark.models;

public enum EnumDiet {
    CARNIVORE ("carnivore"),
    HERBIVORE ("herbivore"),
    OMNIVORE ("omnivore");

    private String lowerCaseDiet;
    EnumDiet(String lowerCaseDiet){
        this.lowerCaseDiet = lowerCaseDiet;
    }

    public String getLowerCaseDiet() {
        return lowerCaseDiet;
    }

    public void setLowerCaseDiet(String lowerCaseDiet) {
        this.lowerCaseDiet = lowerCaseDiet;
    }
}
