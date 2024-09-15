
Merhaba,

Bu proje, Android uygulama geliştirmede Activity ve Fragment'lar arasında navigasyon yapmayı ve veri paslamayı kapsamlı bir şekilde ele alır. Projede, ConstraintLayout kullanarak UI tasarımını yapacak, farklı navigasyon yöntemlerini uygulayacak ve veri taşımayı gerçekleştireceksiniz
Navigasyon için farklı yollar uygulayacaksın.

## Konu 
Liste ve Detay Ekranları Arasında Navigasyon ve Veri Paslama

## Hedef 
Aşağıdaki UI tasarımları verilen ekranları ConstraintLayout ve ilgili View'ları kullanarak tasarladıktan sonra, 
1. Activity - Activity Navigasyon: İlk olarak, iki ayrı activity oluşturulacak. Liste activity'sinde, kullanıcı bir liste öğesine tıkladığında, detay activity'sine geçiş yapılacak ve tıklanan öğeye ait tüm veriler detay activity'sine aktarılacak ve ilgili alanlarda gösterilecektir.
2. Fragment - Fragment Navigasyon: Daha sonra, aynı işlevselliği sağlayan iki fragment içeren bir activity oluşturulacak. Liste ve detay fragment'ları arasında veri paslanacak ve navigasyon yapılacaktır.
3. Navigation Component Kullanımı: Projeye Navigation Component eklenerek, iki fragment arasında navigasyon ve veri paslama yapılacaktır. SafeArgs kullanılarak veri güvenliği sağlanacak ve navigasyon işlemleri kolaylaştırılacaktır.
4.Fragment Result API Kullanımı: Detay ekranında bulunan refresh ikonuna tıklandığında, rastgele bir sıcaklık değeri seçilecek ve bu değer detay fragment'ında güncellenecek. Verileri güncelleme butonuna basıldığında ise, Fragment Result API kullanılarak liste fragment'ındaki değer güncellenecektir. Geri döndüğünde, seçilen sıcaklık değeri liste öğesindeki ilgili alana yansıtılacaktır.

## Kullanılan Teknolojiler 
- ConstraintLayout: UI bileşenlerini düzenlemek ve yerleştirmek için kullanıldı.
- Navigation Component: Fragment'lar arasında navigasyon ve veri paslama işlemlerini kolaylaştırmak için kullanıldı.
- Fragment Result API: Fragment'lar arasında veri taşımak ve güncellemeleri sağlamak için kullanıldı.
## UI Tasarım

| List            | Detail                                                               |
| ----------------- | ------------------------------------------------------------------ |
| <img src="./img/Light-List.png" width="50%" height="50%">  | <img src="./img/Light-Detail.png" width="50%" height="50%"> |




