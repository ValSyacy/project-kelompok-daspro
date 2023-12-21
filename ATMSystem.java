import java.util.Scanner;

public class ATMSystem {

    private static final int PASSWORD = 123;

    private static Scanner scanner = new Scanner(System.in);

    private static int saldoAwal = 50000;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("||                                                      ||");
        System.out.println("||               SELAMAT DATANG DI ATM 01               ||");
        System.out.println("||                                                      ||");
        System.out.println("==========================================================");

        loginLoop();
        scanner.close();
    }

    // fungsi rekening
    private static void login() {
        System.out.println();
        System.out.print("| Masukkan no. rekening Anda    : ");
        String rekening = scanner.next();
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    // fungsi input password
    private static int masukkanPassword() {
        System.out.println();
        System.out.print("| Masukkan Password Anda        : ");
        return scanner.nextInt();
    }
    
    // fungsi password salah
    private static void loginLoop() {
        do {
            login();
            int password = masukkanPassword();

            if (password == PASSWORD) {
                menuLoop();
            } else {
                System.out.println();
                System.out.println("==========================================================");
                System.out.println("||                                                      ||");
                System.out.println("||           Password yang Anda Masukkan Salah          ||");
                System.out.println("||                                                      ||");
                System.out.println("==========================================================");
            }
        } while (true);
    }

    // fungsi utk looping menu
    private static void menuLoop() {
        int konfirmasiMenu;

        do {
            tampilkanMenu();
            System.out.println();
            System.out.print("| Silakan Pilih Menu yang Anda Inginkan : ");
            konfirmasiMenu = scanner.nextInt();

            switch (konfirmasiMenu) {
                case 1:
                    cekSaldo();
                    break;
                case 2:
                    tarikTunai();
                    break;
                case 3:
                    setorTunai();
                    break;
                case 4:
                    transferSaldo();
                    break;
                case 5:
                    cekBungaTabungan();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("==========================================================");
                    System.out.println("||                                                      ||");
                    System.out.println("||     Terima kasih telah menggunakan layanan ATM 01    ||");
                    System.out.println("||                                                      ||");
                    System.out.println("==========================================================");
                    System.exit(konfirmasiMenu);
                    break;
                default:
                    System.out.println();
                    System.out.println("==========================================================");
                    System.out.println("||                                                      ||");
                    System.out.println("||       Maaf, menu tidak valid. Silakan coba lagi      ||");
                    System.out.println("||                                                      ||");
            }

            // Konfirmasi Transaksi Lain
            System.out.println("==========================================================");
            System.out.println();
            System.out.print("| Apakah Anda Ingin Melakukan Transaksi Lainnya? (y/t) : ");
            String konfirmasiLain = scanner.next();
            if (konfirmasiLain.equalsIgnoreCase("y")) {
                menuLoop();
                break;
            } else {
                System.out.println();
                System.out.println("==========================================================");
                System.out.println("||                                                      ||");
                System.out.println("||     Terima kasih telah menggunakan layanan ATM 01    ||");
                System.out.println("||                                                      ||");
                System.out.println("==========================================================");
                System.exit(0);
            }
        } while (true);
    }

    // fungsi utk display menu
    private static void tampilkanMenu() {
        String[] menu = {
            "----------------------------------------------------------",
            "|  1  |                    Cek Saldo                     |",
            "----------------------------------------------------------",
            "|  2  |                   Tarik Tunai                    |",
            "----------------------------------------------------------",
            "|  3  |                   Setor Tunai                    |",
            "----------------------------------------------------------",
            "|  4  |                 Transfer Saldo                   |",
            "----------------------------------------------------------",
            "|  5  |                Cek Bunga Tabungan                |",
            "----------------------------------------------------------",
            "|  0  |                      Keluar                      |",
            "----------------------------------------------------------",
        };

        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println("| no. |                       MENU                       |");
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }

    // fungsi utk cek saldo
    private static void cekSaldo() {
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("||                                                      ||");
        System.out.println("||                       CEK SALDO                      ||");
        System.out.println("||                                                      ||");
        System.out.println("==========================================================");
        System.out.println("|                                                        |");
        System.out.println("|             Saldo anda saat ini : Rp." + saldoAwal);
        System.out.println("|                                                        |");
    }

    // fungsi utk setor tunai
    private static void setorTunai() {
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("||                                                      ||");
        System.out.println("||                      SETOR TUNAI                     ||");
        System.out.println("||                                                      ||");
        System.out.println("==========================================================");
        System.out.println();
        System.out.print("| Masukkan Nominal Setor Tunai  : Rp.");
        int nominalSetorTunai = scanner.nextInt();
        saldoAwal += nominalSetorTunai;

        System.out.println();
        System.out.println("==========================================================");
        System.out.println("||                                                      ||");
        System.out.println("||                 SETOR TUNAI BERHASIL                 ||");
        System.out.println("||                                                      ||");
        System.out.println("==========================================================");
        System.out.println("|                                                        |");
        System.out.println("| Setor Tunai Berhasil Senilai : Rp." + nominalSetorTunai);
        System.out.println("| Saldo Anda saat ini          : Rp." + saldoAwal);
        System.out.println("|                                                        |");
        
    }

    // fungsi utk tarik tunai
    private static void tarikTunai() {
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("||                                                      ||");
        System.out.println("||                      TARIK TUNAI                     ||");
        System.out.println("||                                                      ||");
        System.out.println("==========================================================");
        System.out.println();
        System.out.print("| Masukkan Nominal Jumlah Tarik Tunai   : Rp.");
        int nominalTarikTunai = scanner.nextInt();

        if (nominalTarikTunai > saldoAwal) {
            System.out.println();
            System.out.println("==========================================================");
            System.out.println("||                                                      ||");
            System.out.println("||           Maaf, Saldo Anda Tidak Mencukupi           ||");
            System.out.println("||                                                      ||");
        } else {
            saldoAwal -= nominalTarikTunai;

            System.out.println();
            System.out.println("==========================================================");
            System.out.println("||                                                      ||");
            System.out.println("||                 TARIK TUNAI BERHASIL                 ||");
            System.out.println("||                                                      ||");
            System.out.println("==========================================================");
            System.out.println("|                                                        |");
            System.out.println("| Tarik Tunai Berhasil Senilai  : Rp." + nominalTarikTunai);
            System.out.println("| Sisa Saldo Anda Sejumlah      : Rp." + saldoAwal);
            System.out.println("|                                                        |");
        }
    }
    
    // fungsi utk mengecek bunga tabungan
    private static void cekBungaTabungan() {
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("||                                                      ||");
        System.out.println("||                   CEK BUNGA TABUNGAN                 ||");
        System.out.println("||                                                      ||");
        System.out.println("==========================================================");
        System.out.println();
        System.out.print("| Masukkan Jumlah Tabungan Awal Anda    : Rp.");
        int jumlahTabunganAwal = scanner.nextInt();

        System.out.println();
        System.out.println("==========================================================");
        System.out.println();
        System.out.print("| Masukkan Lama Menabung Anda (bulan)   : ");
        int lamaTabungan = scanner.nextInt();
        
        double prosentaseBunga = 0.02;
        double bunga = lamaTabungan * prosentaseBunga * jumlahTabunganAwal;
        double jumlahTabunganAkhir = bunga + jumlahTabunganAwal;
        
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("||                                                      ||");
        System.out.println("||          PENGECEKAN BUNGA TABUNGAN BERHASIL          ||");
        System.out.println("||                                                      ||");
        System.out.println("==========================================================");
        System.out.println("|                                                        |");
        System.out.println("|          Jumlah bunga          : Rp." + bunga);
        System.out.println("|          Jumlah tabungan akhir : Rp." + jumlahTabunganAkhir);
        System.out.println("|                                                        |");
    }

    // fungsi utk transfer saldo
    private static void transferSaldo() {
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("||                                                      ||");
        System.out.println("||                     TRANSFER SALDO                   ||");
        System.out.println("||                                                      ||");
        System.out.println("==========================================================");
        System.out.println("| no. |              MENU TRANSFER SALDO                ||");
        System.out.println("----------------------------------------------------------");
        System.out.println("|  1. |                  Sesama Bank                     |");
        System.out.println("----------------------------------------------------------");
        System.out.println("|  2. |                   Bank Lain                      |");
        System.out.println("----------------------------------------------------------");
        System.out.println("|  3. |                    Kembali                       |");
        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.print("| Silakan Pilih Menu yang Anda Inginkan : ");
        int menuTf = scanner.nextInt();

        if (menuTf == 1) {
            System.out.println();
            System.out.print("| Masukkan Nomer Rekening Tujuan        : ");
            String rekTujuan = scanner.next();
            System.out.print("| Masukkan Nominal Transfer             : Rp.");
            int nominalTransferSaldo = scanner.nextInt();

                if (nominalTransferSaldo > saldoAwal) {
                System.out.println();
                System.out.println("==========================================================");
                System.out.println("||                                                      ||");
                System.out.println("||          Maaf, Saldo Anda Tidak Mencukupi            ||");
                System.out.println("||                                                      ||");
                } else {
                    saldoAwal -= nominalTransferSaldo;
                    
                    System.out.println();
                    System.out.println("==========================================================");
                    System.out.println("||                                                      ||");
                    System.out.println("||               TRANSFER SALDO BERHASIL                ||");
                    System.out.println("||                                                      ||");
                    System.out.println("==========================================================");
                    System.out.println("|                                                        |");
                    System.out.println("| Transfer Saldo Berhasil Sejumlah : Rp." + nominalTransferSaldo);
                    System.out.println("| Sisa Saldo Anda Sejumlah         : Rp." + saldoAwal);
                    System.out.println("|                                                        |");
                }
            } else if (menuTf == 2) {
                System.out.println();
                System.out.println("----------------------------------------------------------");
                System.out.println("| no. |                    BANK TUJUAN                   |");
                System.out.println("----------------------------------------------------------");
                System.out.println("|  1. |                        BRI                       |"); // admin = Rp.4000
                System.out.println("----------------------------------------------------------");
                System.out.println("|  2. |                      MANDIRI                     |"); // admin = Rp.4500
                System.out.println("----------------------------------------------------------");
                System.out.println("|  3. |                        BCA                       |"); // admin = Rp.6500
                System.out.println("----------------------------------------------------------");
                System.out.println();
                System.out.print("| Pilih Bank Tujuan                     : ");
                int bankTujuan = scanner.nextInt();
                switch (bankTujuan) {
                        // Transfer ke BRI
                        case 1:
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.print("| Masukkan Nomer Rekening Tujuan        : ");
                            String rekBRI = scanner.next();
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.print("| Masukkan Nominal Transfer             : Rp.");
                            int nominalTransferSaldo1 = scanner.nextInt();
                            int biayaAdminBRI = 4000;
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.println("| Akan Dikenakan Biaya Admin Sebesar Rp." + biayaAdminBRI);
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.print("| Apakah Anda Ingin Tetap Melanjutkan Transaksi ? (y/t) ");
                            String confirm1 = scanner.next();
                                if (confirm1.equalsIgnoreCase("y")) {
                                    if ((nominalTransferSaldo1 + biayaAdminBRI) > saldoAwal) {
                                        System.out.println();
                                        System.out.println("==========================================================");
                                        System.out.println("||                                                      ||");
                                        System.out.println("||          Maaf, Saldo Anda Tidak Mencukupi            ||");
                                        System.out.println("||                                                      ||");
                                        } else {
                                            saldoAwal -= nominalTransferSaldo1 + biayaAdminBRI;
                                        
                                        System.out.println();
                                        System.out.println("==========================================================");
                                        System.out.println("||                                                      ||");
                                        System.out.println("||               TRANSFER SALDO BERHASIL                ||");
                                        System.out.println("||                                                      ||");
                                        System.out.println("==========================================================");
                                        System.out.println("|                                                        |");
                                        System.out.println("| Transfer Saldo Berhasil Sejumlah : Rp." + nominalTransferSaldo1);
                                        System.out.println("| Sisa Saldo Anda Sejumlah         : Rp." + saldoAwal);
                                        System.out.println("|                                                        |");;
                                    }
                                } else {
                                    menuLoop();
                                }
                            break;
                        // Transfer ke Mandiri
                        case 2:
                            System.out.println();
                            System.out.print("| Masukkan Nomer Rekening Tujuan        : ");
                            String rekMandiri = scanner.next();
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.print("| Masukkan Nominal Transfer         : Rp.");
                            int nominalTransferSaldo2 = scanner.nextInt();
                            int biayaAdminMandiri = 4500;
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.println("| Akan Dikenakan Biaya Admin Sebesar Rp." + biayaAdminMandiri);
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.print("| Apakah Anda Ingin Tetap Melanjutkan Transaksi? (y/t) ");
                            String confirm2 = scanner.next();
                                if (confirm2.equalsIgnoreCase("y")) {
                                    if ((nominalTransferSaldo2 + biayaAdminMandiri) > saldoAwal) {
                                    System.out.println();
                                    System.out.println("==========================================================");
                                    System.out.println("||                                                      ||");
                                    System.out.println("||          Maaf, Saldo Anda Tidak Mencukupi            ||");
                                    System.out.println("||                                                      ||");
        
                                    } else {
                                        saldoAwal -= nominalTransferSaldo2 + biayaAdminMandiri;
                                        
                                        System.out.println();
                                        System.out.println("==========================================================");
                                        System.out.println("||                                                      ||");
                                        System.out.println("||               TRANSFER SALDO BERHASIL                ||");
                                        System.out.println("||                                                      ||");
                                        System.out.println("==========================================================");
                                        System.out.println("|                                                        |");
                                        System.out.println("| Transfer Saldo Berhasil Sejumlah : Rp." + nominalTransferSaldo2);
                                        System.out.println("| Sisa Saldo Anda Sejumlah         : Rp." + saldoAwal);
                                        System.out.println("|                                                        |");
                                    }
                                } else {
                                    menuLoop();
                                }
                            break;
                        // Transfer ke BCA
                        case 3:
                            System.out.println();
                            System.out.print("| Masukkan Nomer Rekening Tujuan        : ");
                            String rekBCA = scanner.next();
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.print("| Masukkan Nominal Transfer         : Rp.");
                            int nominalTransferSaldo3 = scanner.nextInt();
                            
                            int biayaAdminBCA = 6500;
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.println("| Akan Dikenakan Biaya Admin Sebesar Rp." + biayaAdminBCA);
                            System.out.println();
                            System.out.println("----------------------------------------------------------");
                            System.out.println();
                            System.out.print("| Apakah Anda Ingin Tetap Melanjutkan Transaksi? (y/t) ");
                            String confirm3 = scanner.next();
                                if (confirm3.equalsIgnoreCase("y")) {
                                    if ((nominalTransferSaldo3 + biayaAdminBCA) > saldoAwal) {
                                    System.out.println();
                                    System.out.println("==========================================================");
                                    System.out.println("||                                                      ||");
                                    System.out.println("||          Maaf, Saldo Anda Tidak Mencukupi            ||");
                                    System.out.println("||                                                      ||");
        
                                    } else {
                                        saldoAwal -= nominalTransferSaldo3 + biayaAdminBCA;
                                        
                                        System.out.println();
                                        System.out.println("==========================================================");
                                        System.out.println("||                                                      ||");
                                        System.out.println("||               TRANSFER SALDO BERHASIL                ||");
                                        System.out.println("||                                                      ||");
                                        System.out.println("==========================================================");
                                        System.out.println("|                                                        |");
                                        System.out.println("| Transfer Saldo Berhasil Sejumlah : Rp." + nominalTransferSaldo3);
                                        System.out.println("| Sisa Saldo Anda Sejumlah         : Rp." + saldoAwal);
                                        System.out.println("|                                                        |");
                                    }
                                } else {
                                    menuLoop();
                                }
                            break;
                        default:
                            System.out.println();
                            System.out.println("==========================================================");
                            System.out.println("||                                                      ||");
                            System.out.println("||       Maaf, menu tidak valid. Silakan coba lagi      ||");
                            System.out.println("||                                                      ||");
                            break;
                    }
            } else if (menuTf == 3) {
            menuLoop();
        } else {
            System.out.println();
            System.out.println("==========================================================");
            System.out.println("||                                                      ||");
            System.out.println("||       Maaf, menu tidak valid. Silakan coba lagi      ||");
            System.out.println("||                                                      ||");
            transferSaldo();
        }
    }
}