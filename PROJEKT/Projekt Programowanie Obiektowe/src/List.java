public class List extends NadawcaIOdbiorca{
    private boolean czyPolecony;
    private boolean czyZPotwierdzeniemOdbioru;
    private String status;


    public List(String imieNadawcy, String nazwiskoNadawcy, String adresNadawcy, String kodPocztowyNadawcy, String kpMiejscowoscNadawcy, String imieObdiorcy, String nazwiskoOdbiorcy, String adresObdiorcy, String kodPocztowyOdbiorcy, String kpMiejscowoscOdbiorcy,boolean czyPolecony, boolean czyZPotwierdzeniemOdbioru) {
        super(imieNadawcy, nazwiskoNadawcy, adresNadawcy, kodPocztowyNadawcy, kpMiejscowoscNadawcy, imieObdiorcy, nazwiskoOdbiorcy, adresObdiorcy, kodPocztowyOdbiorcy, kpMiejscowoscOdbiorcy);
        this.czyPolecony = czyPolecony;
        this.czyZPotwierdzeniemOdbioru = czyZPotwierdzeniemOdbioru;
        this.status = "Oczekuje do wysłania";
    }
}
