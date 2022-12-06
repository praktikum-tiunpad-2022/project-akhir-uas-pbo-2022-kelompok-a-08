# Tic-Tac-Toe

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran. 

[Challenge Guidelines](challenge-guideline.md)

Tic-tac-toe adalah permainan untuk dua pemain, X dan O, yang bergiliran menandai ruang dalam grid 3 × 3. Pemain yang berhasil menempatkan tiga tanda mereka di baris horisontal, vertikal, atau diagonal memenangkan pertandingan. Biasanya permainan ini dilakukan dengan menggunakan dengan kertas dan alat tulis, namun permainan ini juga dapat diimplementasikan secara digital dengan object-oriented programming

## Credits
| NPM           | Name                   |
| ------------- |------------------------|
| 140810210005  | Aliya Rahmania         |
| 140810210007  | Felicia Natania Lingga |
| 140810210017  | Adinda Salsabila       |

## Change log
- **[Sprint Planning](changelog/sprint-planning.md) - (15/11/2021)** 
   - Mendiskusikan changelog

- **[Sprint 1](changelog/sprint-1.md) - (15/11/2021 - 21/11/2021)** 
   - Inisiasikan JavaFX dan Gradle
   - Inisiasikan ukuran dan komponen window
   - Inisiasikan board pada window

- **[Sprint 2](changelog/sprint-2.md) - (22/11/2021 - 28/11/2021)** 
   - Membuat class Player
   - Membuat class AI 
   - Membuat logic memilih board untuk User
   - Membuat logic merubah tanda setelah User lain memilih
   - Membuat logic kemenangan
   - Membuat logic menginput username
   - Membuat logic leaderboard
   - Membuat leaderboard
   - Membuat menu utama
   
- **[Sprint 3](changelog/sprint-3.md) - (29/11/2021 - 05/12/2021)** 
   - Merapikan UI Board
   - Membuat UML
   - Bug Fixing

## Running The App

1. Git clone repository, dan buka di VSCode (Pastikan JavaFX telah terinstall)
2. Buka terminal dan ketik "gradlew run" lalu enter

## Classes Used

1. Program (Program.Java)
Berisi kode logic program TicTacToe seperti inisialisasi game, set Symbol pemain, restart game, reset Button, setupButton, game, dan exit.

2. App (App.Java)
Class main untuk memanggil .fxml

3. Interface (Interface.Java)
Interface untuk Delay, Reset Button, dan ExitApp

![UML project UAS](https://user-images.githubusercontent.com/100197250/205794489-bf385fb7-c072-4680-803b-fc3a4c54c93a.png)


## Notable Assumption and Design App Details

- Pemain mengisi kotak permainan berukuran 3 x 3, dimana pemain X akan memulai permainan terlebih dahulu.
- Setelah pemain X mengisi papan permainan, maka akan ada petunjuk giliran untuk pemain O, begitupun setelah pemain O mengisi papan permainan. 
- Pemain dinyatakan menang jika berhasil membentuk 1 garis dengan huruf yang sama, baik berupa garis horizontal, vertikal, atau diagonal.
- Kemenangan ditandai dengan munculnya notifikasi kemenangan. 
- Apabila pemain telah menekan tombol “OK” pada notifikasi kemenangan, kotak permainan akan ter-reset/terbersihkan secara otomatis.
- Jika kotak permainan sudah terisi penuh dan tidak ada satupun garis yang terbentuk, akan muncul notifikasi seri. 
- Apabila pemain telah menekan tombol “OK” pada notifikasi seri, kotak permainan akan ter-reset/terbersihkan secara otomatis.
- Terdapat tombol “Restart” apabila pada pertengahan permainan, pemain ingin mengulang permainan.
- Terdapat Papan Score Kemenangan baik dari Pemain X maupun Pemain O.
- Terdapat Tombol Menu untuk kembali ke Main Menu dan Tombol Exit untuk mengakhiri dan keluar dari permainan.
