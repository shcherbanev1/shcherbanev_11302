public class HumanData {

    private char gender;
    private byte plural;
    private byte age;
    private String race;
    private byte parity;
    private boolean married;
    private short bwt;
    private byte smokeN;
    private byte drinkN;
    private boolean firstep;
    private boolean welfare;
    private boolean smoker;
    private boolean drinker;
    private short wpre;
    private short wgain;
    private byte education;
    private byte gestation;

    public HumanData(String line) {
        String[] splittedLine = line.split("\\s+");
        gender = splittedLine[0].charAt(0);
        plural = Byte.parseByte(splittedLine[1]);
        age = Byte.parseByte(splittedLine[2]);
        race = splittedLine[3];
        parity = Byte.parseByte(splittedLine[4]);
        married = splittedLine[5].equals("1");
        bwt = Short.parseShort(splittedLine[6]);
        smokeN = Byte.parseByte(splittedLine[7]);
        drinkN = Byte.parseByte(splittedLine[8]);
        firstep = splittedLine[9].equals("1");
        welfare = splittedLine[10].equals("1");
        smoker = splittedLine[11].equals("Y");
        drinker = splittedLine[12].equals("Y");
        wpre = Short.parseShort(splittedLine[13]);
        wgain = Short.parseShort(splittedLine[14]);
        education = Byte.parseByte(splittedLine[15]);
        gestation = Byte.parseByte(splittedLine[16]);
    }

    public short getBwt() {
        return bwt;
    }

    public String getRace() {
        return race;
    }

    @Override
    public String toString() {
        return "" + gender + plural + age + race + parity
                + married + bwt + smokeN + drinkN + firstep
                + welfare + smoker + drinker +
                wpre + wgain + education + gestation;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public byte getGestation() {
        return gestation;
    }

    public byte getEducation() {
        return education;
    }
}
