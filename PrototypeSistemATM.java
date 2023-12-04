import java.util.Scanner;

public class PrototypeSistemATM {

    private static final int PASSWORD = 123;

    private static Scanner scanner = new Scanner(System.in);

    // Fungsi untuk menampilkan menu
    private static void tampilkanMenu() {
        String[] menu = {"1. Cek Saldo", "2. Tarik Tunai", "3. Setor Tunai", "4. Cek Bunga Tabungan", "0. Keluar"};

        System.out.println("\nMenu:");
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }

    // Fungsi untuk cek saldo
    private static void cekSaldo(int saldoAwal) {
        System.out.println("\n-----CEK SALDO-----");
        System.out.println("Saldo Anda Saat Ini Adalah: Rp." + saldoAwal + "\n");
    }

    // Fungsi untuk setor tunai
    private static int setorTunai(int saldoAwal) {
        System.out.print("\nMasukkan Nominal Setor Tunai: Rp.");
        int nominalSetorTunai = scanner.nextInt();
        int saldoAkhirSetorTunai = saldoAwal + nominalSetorTunai;
        
        // Menampilkan hasil transaksi
        System.out.println("\n-----SETOR TUNAI BERHASIL-----");
        System.out.println("Setor Tunai Berhasil Senilai: Rp." + nominalSetorTunai);
        System.out.println("Sisa Saldo Anda Sejumlah : Rp." + saldoAkhirSetorTunai + "\n");

        return saldoAkhirSetorTunai;
    }

    // Fungsi untuk meminta input password
    private static int masukkanPassword() {
        System.out.print("\nMasukkan Password Anda: ");
        return scanner.nextInt();
    }

    // Fungsi untuk melakukan tarik tunai
    private static int tarikTunai(int saldoAwal) {
        System.out.print("\nMasukkan Nominal Jumlah Tarik Tunai: Rp.");
        int nominalTarikTunai = scanner.nextInt();
        int saldoAkhirTarikTunai = saldoAwal - nominalTarikTunai;

        // Menampilkan hasil transaksi
        System.out.println("\n-----TARIK TUNAI BERHASIL-----");
        System.out.println("Tarik Tunai Berhasil Senilai : Rp." + nominalTarikTunai);
        System.out.println("Sisa Saldo Anda Sejumlah : Rp." + saldoAkhirTarikTunai + "\n");

        return saldoAkhirTarikTunai;
    }

    // Fungsi untuk pengecekan bunga tabungan
    private static double cekBungaTabungan() {
        System.out.print("\nMasukkan Jumlah Tabungan Awal Anda: Rp.");
        int jumlahTabunganAwal = scanner.nextInt();

        System.out.print("\nMasukkan Lama Menabung Anda (bulan): ");
        int lamaTabungan = scanner.nextInt();

        double prosentaseBunga = 0.02;
        double bunga = lamaTabungan * prosentaseBunga * jumlahTabunganAwal;
        double jumlahTabunganAkhir = bunga + jumlahTabunganAwal;

        // Menampilkan hasil transaksi
        System.out.println("\n-----PENGECEKAN BUNGA TABUNGAN BERHASIL-----");
        System.out.println("Jumlah Tabungan Akhir Anda Adalah Senilai : Rp." + jumlahTabunganAkhir + "\n");

        return jumlahTabunganAkhir;
    }

    public static void main(String[] args) {
        int saldoAwal;

        // Perulangan Password
        do {
            int password = masukkanPassword();

            if (password == PASSWORD) {
                tampilkanMenu();
                int konfirmasiMenu;

                System.out.print("\nSilakan Pilih Menu yang Anda Inginkan: ");
                konfirmasiMenu = scanner.nextInt();

                switch (konfirmasiMenu) {
                    case 1: // Menu 1. Cek Saldo
                        System.out.print("\nMasukkan Jumlah Saldo Anda: Rp.");
                        saldoAwal = scanner.nextInt();
                        cekSaldo(saldoAwal);
                        break;

                    case 2: // Menu 2. Tarik Tunai
                        System.out.print("\nMasukkan Jumlah Saldo Anda: Rp.");
                        saldoAwal = scanner.nextInt();
                        tarikTunai(saldoAwal);
                        break;

                    case 3: // Menu 3. Setor Tunai
                        System.out.print("\nMasukkan Jumlah Saldo Anda: Rp.");
                        saldoAwal = scanner.nextInt();
                        saldoAwal = setorTunai(saldoAwal);
                        break;

                    case 4: // Menu 4. Cek Bunga Tabungan
                        cekBungaTabungan();
                        break;

                    case 0: // Menu 0. Keluar
                        System.out.println("\nTerima kasih telah menggunakan layanan ATM. Sampai jumpa!");
                        return;

                    default:
                        System.out.println("\nMaaf Menu Lainnya Masih Dalam Pengembangan\n");
                        break;
                }

                // Konfirmasi Transaksi Lain
                System.out.print("Apakah Anda Ingin Melakukan Transaksi Lainnya? (y/t) ");
                String konfirmasiLain = scanner.next();
                if (!konfirmasiLain.equalsIgnoreCase("y")) {
                    break;
                }
            } else {
                System.out.println("\nPassword yang Anda Masukkan Salah\nSilakan Masukkan Ulang Password Anda");
            }
        } while (true);

        scanner.close();
    }
}
