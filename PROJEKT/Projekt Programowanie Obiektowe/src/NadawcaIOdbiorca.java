public class NadawcaIOdbiorca {
    private String imieNadawcy;
    private String NazwiskoNadawcy;
    private String AdresNadawcy;
    private String KodPocztowyNadawcy;
    private String kpMiejscowoscNadawcy;
    private String imieObdiorcy;
    private String nazwiskoOdbiorcy;
    private String AdresObdiorcy;
    private String KodPocztowyOdbiorcy;
    private String kpMiejscowoscOdbiorcy;

    public NadawcaIOdbiorca(String imieNadawcy, String nazwiskoNadawcy, String adresNadawcy, String kodPocztowyNadawcy, String kpMiejscowoscNadawcy, String imieObdiorcy, String nazwiskoOdbiorcy, String adresObdiorcy, String kodPocztowyOdbiorcy, String kpMiejscowoscOdbiorcy) {
        this.imieNadawcy = imieNadawcy;
        NazwiskoNadawcy = nazwiskoNadawcy;
        AdresNadawcy = adresNadawcy;
        KodPocztowyNadawcy = kodPocztowyNadawcy;
        this.kpMiejscowoscNadawcy = kpMiejscowoscNadawcy;
        this.imieObdiorcy = imieObdiorcy;
        this.nazwiskoOdbiorcy = nazwiskoOdbiorcy;
        AdresObdiorcy = adresObdiorcy;
        KodPocztowyOdbiorcy = kodPocztowyOdbiorcy;
        this.kpMiejscowoscOdbiorcy = kpMiejscowoscOdbiorcy;
    }

    public String getImieNadawcy() {
        return imieNadawcy;
    }
    public String getNazwiskoNadawcy() {
        return NazwiskoNadawcy;
    }
    public String getAdresNadawcy() {
        return AdresNadawcy;
    }
    public String getKodPocztowyNadawcy() {
        return KodPocztowyNadawcy;
    }
    public String getKpMiejscowoscNadawcy() {
        return kpMiejscowoscNadawcy;
    }
    public String getImieObdiorcy() {
        return imieObdiorcy;
    }
    public String getNazwiskoOdbiorcy() {
        return nazwiskoOdbiorcy;
    }
    public String getAdresObdiorcy() {
        return AdresObdiorcy;
    }
    public String getKodPocztowyOdbiorcy() {
        return KodPocztowyOdbiorcy;
    }
    public String getKpMiejscowoscOdbiorcy() {
        return kpMiejscowoscOdbiorcy;
    }
}
