enum DangerLevel {
    HIGH (3),
    MEDIUM(2),
    LOW(1);

    int Level;

    DangerLevel(int Level) {
        this.Level = Level;
    }

    int getLevel() {
        return Level;
    }
}