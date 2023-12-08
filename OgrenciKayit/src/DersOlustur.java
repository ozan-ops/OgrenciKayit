import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DersOlustur extends JFrame {


    private javax.swing.JPanel JPanel;
    private JLabel baslik;
    private JLabel lbl_DersKodu;
    private JLabel lbl_DersAdi;
    private JTextField txt_DersAdi;
    private JTextField txt_DersKodu;
    private JLabel lbl_DersKredisi;
    private JTextField txt_DersKredi;
    private JComboBox cmb_DersOgretmeni;
    private JLabel lbl_DersOgretmen;
    private JLabel lbl_DersDurumu;
    private JComboBox cmb_DersDurumu;
    private JLabel lbl_DersSinifi;
    private JTextField txt_Sinif;
    private JLabel lbl_Bolum;
    private JTextField txt_Bolum;
    private JLabel lbl_DersDili;
    private JComboBox cmb_Dil;
    private JButton btn_Cikis;
    private JButton btn_Kaydet;
    private JButton btn_OgrenciKayit;

    public DersOlustur(){
        //form görüntüsü
        setTitle("Ders Oluştur");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,  600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(JPanel);

        //anasayfaya dönüş butonu
        btn_Cikis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //anasayfaya geri dön
                Anasayfa anasayfa = new Anasayfa();
                anasayfa.setVisible(true);

                //ders oluştur sayfasını kapat
                setVisible(false);

            }
        });

        //ders durumu sınıf seçilirse sınıf labelını ve textini açma
        cmb_DersDurumu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDersDurumu = (String) cmb_DersDurumu.getSelectedItem();

                //seçili öğe "sınıf" ise
                if ("Sınıf".equals(selectedDersDurumu)) {
                    //kompanentleri aktifleştir
                    lbl_DersSinifi.setEnabled(true);
                    txt_Sinif.setEnabled(true);
                }
                else {
                    //değilse aktifleştirme
                    lbl_DersSinifi.setEnabled(false);
                    txt_Sinif.setEnabled(false);
                }
            }
        });

        //kaydet butonunun listenerı
        btn_Kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //tüm text alanlarının boş olup olmama kontrolü
                if (txt_DersAdi.getText().isEmpty() ||
                        txt_DersKodu.getText().isEmpty() ||
                        txt_DersKredi.getText().isEmpty() ||
                        txt_Bolum.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(DersOlustur.this, "Tüm alanları doldurun.");
                    return;
                }

                //ders sınıfı alanı enable ve boşsa kontrolü
                if (lbl_DersSinifi.isEnabled() && txt_Sinif.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(DersOlustur.this, "Ders sınıfını doldurun.");
                    return;
                }

                //ders adı kontrolü regex ile boşluklar ve türkçe karakterlere de izin verildi
                String dersAdi = txt_DersAdi.getText();
                if (dersAdi.isEmpty() || !dersAdi.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+")) {
                    JOptionPane.showMessageDialog(DersOlustur.this, "Ders adı sadece harflerden oluşmalıdır.");
                    return;
                }

                //ders kodu kontrolü
                String dersKoduStr = txt_DersKodu.getText();
                if (dersKoduStr.isEmpty() || !dersKoduStr.matches("\\d+")) {
                    JOptionPane.showMessageDialog(DersOlustur.this, "Ders kodu sadece sayılardan oluşmalıdır.");
                    return;
                }
                int dersKodu = Integer.parseInt(dersKoduStr);

                //ders kredisi kontrolü
                String dersKrediStr = txt_DersKredi.getText();
                if (dersKrediStr.isEmpty() || !dersKrediStr.matches("\\d+(\\.\\d*)?")) {
                    JOptionPane.showMessageDialog(DersOlustur.this, "Ders kredisi sayı olmalıdır.");
                    return;
                }

                double dersKredi = Double.parseDouble(dersKrediStr);

                //bolum kontrolü
                String bolum = txt_Bolum.getText();
                if (bolum.isEmpty() || !bolum.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+")) {
                    JOptionPane.showMessageDialog(DersOlustur.this, "Bölüm adı sadece harflerden.");
                    return;
                }


                //ders dili kontrolü
                String dersDili = cmb_Dil.getSelectedItem().toString();

                //online durumu kontrolü
                boolean online = false;
                if (cmb_DersOgretmeni.getSelectedItem().equals("Online")) {
                    online = true;
                }

                //seçilen öğretmen adını ve soyadını al
                String ogretmenAdiSoyadi = cmb_DersOgretmeni.getSelectedItem().toString();

                //online durumu kontrolü
                boolean onlineDurumu = ogretmenAdiSoyadi.equals("Online");

                //ders sınıfını "Online" olarak ayarlama
                String dersSinifi = cmb_DersDurumu.getSelectedItem().equals("Online") ? "Online" : txt_Sinif.getText();


                Ders ders = new Ders(dersAdi, dersKodu, dersKredi, dersSinifi, bolum, dersDili, ogretmenAdiSoyadi);


                //ders nesnesini kullanarak bilgileri kaydetme
                try {
                    kaydetDersBilgileri(ders);
                    JOptionPane.showMessageDialog(DersOlustur.this, "Ders bilgileri başarıyla kaydedildi!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(DersOlustur.this, "Hata: Ders bilgileri kaydedilemedi.");
                    ex.printStackTrace();
                }




            }

        });

        //öğrenci kayıt sayfasına yönlendirme
        btn_OgrenciKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgrenciKayit ogrenciKayitSayfasi = new OgrenciKayit();
                ogrenciKayitSayfasi.setVisible(true);

                //anasayfayı kapat
                setVisible(false);
            }
        });
    }

    //dersleri kaydetme fonksiyonu
    private void kaydetDersBilgileri(Ders ders) throws IOException {
        //csv dosyasına yazmak için BufferedWriter kullanma
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("kaynaklar/Dersler.csv", true))) {
            //ders bilgilerini CSV dosyasına yazma
            writer.write(ders.toCSV());
            writer.newLine(); //yeni bir satır ekleme
        }
    }


    public static void main(String[] args) {

        new DersOlustur();
    }
}
