import java.util.Scanner;

public class PrototypeSistemATM {

    private static final int PASSWORD = 123;

    private static Scanner scanner = new Scanner(System.in);

    // Fungsi untuk menampilkan menu
    private static void displayMenu() {
        String[] menu = {"1. Tarik Tunai", "2. Transfer Saldo", "3. Pengecekan Bunga Tabungan"};

        System.out.println("\nMenu:");
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }

    // Fungsi untuk meminta input password
    private static int enterPassword() {
        System.out.print("\nMasukkan Password Anda: ");
        return scanner.nextInt();
    }

    // Fungsi untuk melakukan tarik tunai
    private static int withdrawCash(int saldoAwal) {
        System.out.print("\nMasukkan Nominal Jumlah Tarik Tunai: Rp.");
        int nominalTarikTunai = scanner.nextInt();
        return saldoAwal - nominalTarikTunai;
    }

    // Fungsi untuk melakukan transfer saldo
    private static int transferBalance(int saldoAwal) {
        System.out.print("\nMasukkan Nominal Transfer: Rp.");
        int nominalTransfer = scanner.nextInt();
        return saldoAwal - nominalTransfer;
    }

    // Fungsi untuk pengecekan bunga tabungan
    private static double checkInterest() {
        System.out.print("\nMasukkan Jumlah Tabungan Awal Anda: Rp.");
        int jumlahTabunganAwal = scanner.nextInt();

        System.out.print("\nMasukkan Lama Menabung Anda (bulan): ");
        int lamaTabungan = scanner.nextInt();

        double prosentaseBunga = 0.02;
        double bunga = lamaTabungan * prosentaseBunga * jumlahTabunganAwal;
        return bunga + jumlahTabunganAwal;
    }

    // Fungsi untuk menampilkan hasil transaksi
    private static void displayTransactionResult(String transactionType, String additionalInfo, int saldoAkhir) {
        System.out.println("\n-----" + transactionType + " BERHASIL-----");
        System.out.println(additionalInfo);
        System.out.println("Sisa Saldo Anda Sejumlah : Rp." + saldoAkhir + "\n");
    }

    public static void main(String[] args) {
        int saldoAwal;

        // Perulangan Password
        do {
            int password = enterPassword();

            if (password == PASSWORD) {
                displayMenu();
                int konfirmasiMenu;

                System.out.print("\nSilahkan Menu Yang Ingin Anda Pilih: ");
                konfirmasiMenu = scanner.nextInt();

                switch (konfirmasiMenu) {
                    case 1: // Menu 1. Tarik Tunai
                        System.out.print("\nMasukkan Jumlah Saldo Anda: Rp.");
                        saldoAwal = scanner.nextInt();
                        int saldoAkhirTarikTunai = withdrawCash(saldoAwal);

                        // Menampilkan hasil transaksi
                        displayTransactionResult("TARIK TUNAI", "Tarik Tunai Berhasil Senilai : Rp." + saldoAkhirTarikTunai, saldoAkhirTarikTunai);
                        break;

                    case 2: // Menu 2. Transfer Saldo
                        System.out.print("\nMasukkan Jumlah Saldo Anda: Rp.");
                        saldoAwal = scanner.nextInt();
                        int saldoAkhirTransfer = transferBalance(saldoAwal);

                        // Menampilkan hasil transaksi
                        displayTransactionResult("TRANSFER", "Transfer Berhasil Senilai : Rp." + saldoAkhirTransfer, saldoAkhirTransfer);
                        break;

                    case 3: // Menu 3. Pengecekan Bunga Tabungan
                        double jumlahTabunganAkhir = checkInterest();

                        // Menampilkan hasil transaksi
                        displayTransactionResult("PENGECEKAN BUNGA TABUNGAN", "Jumlah Tabungan Akhir Anda Adalah Senilai : Rp." + jumlahTabunganAkhir, (int) jumlahTabunganAkhir);
                        break;

                    default:
                        System.out.println("\nMaaf Menu Lainnya Masih Dalam Pengembangan\n");
                        break;
                }

                // Konfirmasi Transaksi Lain
                System.out.println("Apakah Anda Ingin Melakukan Transaksi Lainnya? (y/t)");
                String konfirmasiLain = scanner.next();
                if (!konfirmasiLain.equalsIgnoreCase("y")) {
                    break;
                }
            } else {
                System.out.println("\nPassword Yang Anda Masukkan Salah\nSilahkan Masukkan Ulang Password Anda");
            }
        } while (true);

        scanner.close();
    }
}
