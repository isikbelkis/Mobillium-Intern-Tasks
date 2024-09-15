
Merhaba,

Bu proje, Android uygulama geliştirme üzerine odaklanarak, aktiviteler ve fragment'lar arasında navigasyon ile veri aktarma tekniklerini içeriyordu. ConstraintLayout kullanarak arayüz tasarımlarını gerçekleştirdik ve çeşitli navigasyon yöntemleri ile veri aktarma işlemlerini uyguladık.

## Konu 
Liste ve Detay Ekranları Arasında Navigasyon ve Veri Paslama

## Hedef 
Aşağıdaki UI tasarımları verilen ekranları ConstraintLayout ve ilgili View'ları kullanarak tasarladıktan sonra, 
1. Activity - Activity Navigasyon: İlk olarak, iki ayrı activity oluşturduk. Liste activity'sinde bir öğeye tıklandığında, kullanıcıyı detay activity'sine yönlendirdik. Liste öğesindeki tüm verileri başarıyla detay activity'sine aktarıp, ilgili alanlarda gösterdik.
2. Fragment - Fragment Navigasyon: Daha sonra bir activity altında iki fragment (liste ve detay) oluşturduk. Bu fragment'lar arasında veri aktarımı yaparak, navigasyonu tamamladık.
3. Navigation Component Kullanımı:  Fragment'lar arasında veri aktarımını ve navigasyonu yönetmek için Navigation Component'i entegre ettik. SafeArgs kullanarak verilerin güvenli bir şekilde taşınmasını sağladık ve navigasyonu kolaylaştırdık.
4.Fragment Result API Kullanımı: Detay ekranında bulunan yenileme simgesine tıklandığında rastgele bir sıcaklık değeri seçilip detay fragment'ine set edildi. Veri güncelleme butonu ile Fragment Result API kullanarak liste fragment'indeki sıcaklık değeri başarıyla güncellendi. Geri döndüğümüzde, seçilen sıcaklık değeri ilgili liste öğesine yansıtıldı.

## Kullanılan Teknolojiler 
- ConstraintLayout: UI bileşenlerini düzenlemek ve yerleştirmek için kullanıldı.
- Navigation Component: Fragment'lar arasında navigasyon ve veri paslama işlemlerini kolaylaştırmak için kullanıldı.
- Fragment Result API: Fragment'lar arasında veri taşımak ve güncellemeleri sağlamak için kullanıldı.
## UI Tasarım

| List            | Detail                                                               |
| ----------------- | ------------------------------------------------------------------ |
| <img src="./img/Light-List.png" width="50%" height="50%">  | <img src="./img/Light-Detail.png" width="50%" height="50%"> |




