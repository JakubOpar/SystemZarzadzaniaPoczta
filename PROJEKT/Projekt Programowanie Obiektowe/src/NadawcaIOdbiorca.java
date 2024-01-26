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

    public void setImieNadawcy(String imieNadawcy) {
        this.imieNadawcy = imieNadawcy;
    }

    public String getNazwiskoNadawcy() {
        return NazwiskoNadawcy;
    }

    public void setNazwiskoNadawcy(String nazwiskoNadawcy) {
        NazwiskoNadawcy = nazwiskoNadawcy;
    }

    public String getAdresNadawcy() {
        return AdresNadawcy;
    }

    public void setAdresNadawcy(String adresNadawcy) {
        AdresNadawcy = adresNadawcy;
    }

    public String getKodPocztowyNadawcy() {
        return KodPocztowyNadawcy;
    }

    public void setKodPocztowyNadawcy(String kodPocztowyNadawcy) {
        KodPocztowyNadawcy = kodPocztowyNadawcy;
    }

    public String getKpMiejscowoscNadawcy() {
        return kpMiejscowoscNadawcy;
    }

    public void setKpMiejscowoscNadawcy(String kpMiejscowoscNadawcy) {
        this.kpMiejscowoscNadawcy = kpMiejscowoscNadawcy;
    }

    public String getImieObdiorcy() {
        return imieObdiorcy;
    }

    public void setImieObdiorcy(String imieObdiorcy) {
        this.imieObdiorcy = imieObdiorcy;
    }

    public String getNazwiskoOdbiorcy() {
        return nazwiskoOdbiorcy;
    }

    public void setNazwiskoOdbiorcy(String nazwiskoOdbiorcy) {
        this.nazwiskoOdbiorcy = nazwiskoOdbiorcy;
    }

    public String getAdresObdiorcy() {
        return AdresObdiorcy;
    }

    public void setAdresObdiorcy(String adresObdiorcy) {
        AdresObdiorcy = adresObdiorcy;
    }

    public String getKodPocztowyOdbiorcy() {
        return KodPocztowyOdbiorcy;
    }

    public void setKodPocztowyOdbiorcy(String kodPocztowyOdbiorcy) {
        KodPocztowyOdbiorcy = kodPocztowyOdbiorcy;
    }

    public String getKpMiejscowoscOdbiorcy() {
        return kpMiejscowoscOdbiorcy;
    }

    public void setKpMiejscowoscOdbiorcy(String kpMiejscowoscOdbiorcy) {
        this.kpMiejscowoscOdbiorcy = kpMiejscowoscOdbiorcy;
    }
}
