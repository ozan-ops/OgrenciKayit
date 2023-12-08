# Ders ve Öğrenci Kayıt Uygulaması

* Bu proje, ders ve öğrenci kayıt projesidir.
* Projede 3 tane form (Anasayfa, DersOlustur, OgrenciKayit) vardır.
* Projede 2 tane sınıf (Ders ve Ogrenci) vardır.
* Kayıtlar kaynaklar klasörünün içerisindeki Dersler ve Ogrenciler csv dosyalarına kayıt edilmektedir.

## Nasıl Çalışır

1. Anasayfa formu çalıştırılır.
2. Ders eklemek için açılan pencerede Ders Kaydı Oluştur buttonuna tıklanır.
3. Öğrenci eklemek için açılan pencerede Öğrenci Kaydı Oluştur butonuna tıklanır.
4. Ders eklemek için tüm alanlar doldurulur. Tüm alanlar doldurulmaz ise hata mesajı verir.

* Ders Kodu: TextField (Sayı olmalıdır. Regex kontrolü yapılmaktadır.)
* Ders Adı: TextField (Metin olmalıdır. Regex kontrolü yapılmaktadır.)
* Ders Kredisi: TextField (Sayı olmalıdır. Regex kontrolü yapılmaktadır.)
* Ders Öğretmeni: ComboBox
* Ders Durumu: ComboBox
* Ders Sınıfı: TextField (Ders Durumu Sınıf seçilir ise etkin olur.)
* Bölüm: TextField (Metin olmalıdır. Regex kontrolü yapılmaktadır.)
* Ders Dili: ComboBox

5. Öğrenci eklemek için tüm alanlar doldurulur. Tüm alanlar doldurulmaz ise işlem gerçekleştirilmez.

* Öğrenci TC: PasswordFiels (11 Karkater ve sayı olmalıdır. Regex kontrolü yapılmaktadır.)
* Öğrenci No: TextField (Sayı olmalıdır. Regex kontrolü yapılmaktadır.)
* Öğrenci Ad: TextField (Metin olmalıdır. Regex kontrolü yapılmaktadır.)
* Öğrenci Soyad: TextField (Metin olmalıdır. Regex kontrolü yapılmaktadır.)
* Öğrenci Sınıf: ComboBox
* Öğrenci Doğum Tarihi: TextField (Doğum tarihi biçiminde olmalıdır. Regex kontrolü yapılmaktadır.)
* Öğrenci Telefon Numarası: TextField (Numara biçiminde olmalıdır. Regex kontrolü yapılmaktadır.)
* Öğrenci Bölümü: TextField (Girilen bölüm csv dosyasında olmalıdır.)
* Öğrenci Ders: ComboBox (Öğrenci Bölümü girildikten sonra Enter tuşuna basılır. Bölümler csv dosyasında bulunmaktadır. Dersler bölümlere göre gelmektedir.)

* Not: İmleç alanların üzerine getirildiğinde girilmesi gerekilen biçim kullanıcıya gösterilmektedir.

## Sınıflar

- Ders -> Ders bilgi alanlarını tutan ve Dersler.csv dosyası için alanları düzenleyen sınıftır.
- Ogrenci -> Öğrenci bilgi alanlarını tutan ve Ogrenciler.csv dosyası için alanları düzenleyen sınıftır.

- AnaSayfa, DersOlustur ve OgrenciKayit sınıfları form sınıflarıdır.

## Alanlar

- Ders -> dersAdi: Ders adı bilgisini tutan alandır.
- Ders -> dersKodu: Ders kodu bilgisini tutan alandır.
- Ders -> dersKredi: Ders kredi bilgisini tutan alandır.
- Ders -> dersSinifi: Ders sınıfı bilgisini tutan alandır.
- Ders -> bolum: Ders bölümü bilgisini tutan alandır.
- Ders -> dersDili: Ders dili bilgisini tutan alandır.
- Ders -> ogretmenAdiSoyadi: Derse giren öğretmenin ad ve soyad bilgisini tutan alandır.

- Ogrenci -> tc: Öğrenci T.C. Kimlik Numarası bilgisini tutan alandır.
- Ogrenci -> ad: Öğrenci ad bilgisini tutan alandır.
- Ogrenci -> soyad: Öğrenci soyad bilgisini tutan alandır.
- Ogrenci -> sinif: Öğrenci sınıf bilgisini tutan alandır.
- Ogrenci -> dogumTarihi: Öğrenci doğum tarihi bilgisini tutan alandır.
- Ogrenci -> telefonNo: Öğrenci telefon numarası bilgisini tutan alandır.
- Ogrenci -> ders: Öğrenci ders bilgisini tutan alandır.
- Ogrenci -> ogrNo: Öğrenci numara bilgisini tutan alandır.

* Not: Tüm alanlar private tanımlanmıştır.

## Metodlar

- Ders -> Ders: Sınıfın kurucu metodudur. Gelen değerleri sınıftaki alanlara aktarır.
- Ders -> getDersSinifi: Sınıfta bulunan dersSinifi alanının değerini geriye döndürür.
- Ders -> setDersSinifi: Metod ile gönderilen dersSinifi değerini sınıfta bulanan dersSinifi değişkenine aktarır.
- Ders -> getOgretmenAdiSoyadi: Sınıfta bulunan ogretmenAdiSoyadi alanının değerini geriye döndürür.
- Ders -> setOgretmenAdiSoyadi: Metod ile gönderilen ogretmenAdiSoyadi değerini sınıfta bulanan ogretmenAdiSoyadi değişkenine aktarır.
- Ders -> toCSV: Sınıfta bulunan alanlardaki verileri istenilen düzene göre metin haline getirir ve geri döndürür.
* Not: Düzen Dersler.csv belgesine göredir.

- Ogrenci -> Ogrenci: Sınıfın kurucu metodudur. Gelen değerleri sınıftaki alanlara aktarır.
- Ogrenci -> toCSV: Sınıfta bulunan alanlardaki verileri istenilen düzene göre metin haline getirir ve geri döndürür.
* Not: Düzen Ogrenciler.csv belgesine göredir.

- DersOlustur -> kaydetDersBilgileri: Ders bilgilerini csv dosyasına yazdırır.

- OgrenciKayit -> getBolumeAitDersler: Girilen bölüme ait dersleri csv dosyasından çeker. String dizisi olarak geri döndürür.
- OgrenciKayit -> append: Metoda gönderilen elemanı metoda gönderilen diziye ekler. String dizisi olarak geri döndürür.
* Not: append metodu getBolumeAitDersler metodu için kullanılır.
- OgrenciKayit -> kaydetOgrenciBilgileri: Öğrenci bilgilerini csv dosyasına yazdırır.