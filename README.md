Merhaba,

Task-3 kapsamında Android Jetpack Architecture komponentlerinden ViewModel ve LiveData'yı öğrendim. İşte bu görevde yaptıklarım:

1-ViewModel, Fragment ve Lifecycle Konseptleri: İlk olarak ViewModel, Fragment ve Activity lifecycle'larını öğrendim. ViewModel'ın Fragment ve Activity'lerle nasıl entegre olduğunu ve UI controller (Activity, Fragment) ile UI datasını yönetme sorumluluğunu anladım. 
Ayrıca, konfigürasyon değişikliklerinde (örneğin, cihazın döndürülmesi) verilerin nasıl korunacağını inceledim.
2-Yeni Fragment ve ViewModel Oluşturma: Yeni bir fragment oluşturdum ve buna ait bir ViewModel oluşturup bağladım. Fragment'ta bir sayaç değerini tutan bir TextView ve bir buton ekledim. Başlangıçta sayaç değeri sıfırdı ve butona her tıkladığımda sayacı artıracak şekilde ayarladım. 
Fragment içerisinde hem UI controller'da hem de ViewModel'da sayaç değerini tuttum. Cihaz döndürüldüğünde ViewModel'da tutulan değerin korunduğunu gözlemledim.
3-Sayı Tahmin Oyunu: Daha sonra bir sayı tahmin oyunu geliştirdim. Bu oyunda ViewModel oluştuğunda rastgele bir sayı ve bu sayıya karşılık gelen bir karakter üretildi. Kullanıcı tahmin ettiği sayıyı seçip "Guess" butonuna bastığında, tahmin edilen sayıyla rastgele üretilen sayıyı karşılaştırdım. 
Doğruysa "Kazandın", yanlışsa "Tekrar dene" mesajını gösterdim. Aynı zamanda UI state'in korunup korunmadığını cihazı döndürerek test ettim.
4-Detay Fragment ve SharedViewModel: Bir de gizli sayıyı gösterecek bir Detay Fragment oluşturup, bu fragment'a shared ViewModel ile veri aktardım. Gizli sayıya tıklandığında kullanıcıyı Detay Fragment'a yönlendirdim ve veriyi SharedViewModel kullanarak iki fragment arasında paylaştım. 
SharedViewModel'ın scope'unu araştırdım ve diğer shared ViewModel scope'ları ile karşılaştırdım.

## Kullanılan Teknolojiler:
1-ViewModel: UI state'ini korumak ve fragmentlar arası veri paylaşımı sağlamak için kullanıldı.
2-LiveData & MutableLiveData: Verileri gözlemlenebilir kılmak ve lifecycle-aware bir yapı oluşturmak için kullanıldı.
3-Fragment: UI yönetimi ve fragment'lar arası geçişler için kullanıldı.
4-Navigation Component: Fragment'lar arasında veri aktarımı ve yönlendirme için kullanıldı.
5-SharedViewModel: Activity düzeyinde veri paylaşımı sağlamak için kullanıldı.

## UI Tasarım

| List            | Detail                                                               |
| ----------------- | ------------------------------------------------------------------ |
| <img src="./img/Light-List.png" width="50%" height="50%">  | <img src="./img/Light-Detail.png" width="50%" height="50%"> |

