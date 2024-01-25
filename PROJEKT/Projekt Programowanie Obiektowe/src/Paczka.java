public class Paczka extends NadawcaIOdbiorca{
    private boolean czyDelikatna;
    private double waga;
    private String status;

    public Paczka(String imieNadawcy, String nazwiskoNadawcy, String adresNadawcy, String kodPocztowyNadawcy, String kpMiejscowoscNadawcy, String imieObdiorcy, String nazwiskoOdbiorcy, String adresObdiorcy, String kodPocztowyOdbiorcy, String kpMiejscowoscOdbiorcy, boolean czyDelikatna, double waga) {
        super(imieNadawcy, nazwiskoNadawcy, adresNadawcy, kodPocztowyNadawcy, kpMiejscowoscNadawcy, imieObdiorcy, nazwiskoOdbiorcy, adresObdiorcy, kodPocztowyOdbiorcy, kpMiejscowoscOdbiorcy);
        this.czyDelikatna = czyDelikatna;
        this.waga = waga;
        this.status = "Oczekuje do wysłania";
    }
}
