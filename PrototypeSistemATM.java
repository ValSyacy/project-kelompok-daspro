import java.util.Scanner;

public class PrototypeSistemATM {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        int password = 123;

        System.out.println("Masukkan Password Anda: ");
        password = sc.nextInt();

        if (password==123) {
            System.out.println("\nSilahkan Pilih Menu Transaksi \n1.Tarik Tunai \n2.Transfer Saldo \n3.Pengecekan Bunga Tabungan\n");
            int menu;
            menu = sc.nextInt();
            if (menu==1) {
                System.out.println("\nMasukkan Jumlah Saldo Anda");
                int saldo_awal, saldo_akhir, nominal_tariktunai;
                saldo_awal=sc.nextInt();
                System.out.println("\nMasukkan Nominal Jumlah Tarik Tunai");
                nominal_tariktunai=sc.nextInt();
                
                saldo_akhir= saldo_awal-nominal_tariktunai;

                System.out.println("\nTarik Tunai Berhasil Senilai\n" + nominal_tariktunai + "\nSisa Saldo Anda Sejumlah\n" + saldo_akhir + "\n");
            } else {
                System.out.println("\nMaaf Menu Lainnya Masih Dalam Pengembangan\n");
            }
           
        } else {
            System.out.println("\nPassword Yang Anda Masukkan Salah\n");
        }
    }
}