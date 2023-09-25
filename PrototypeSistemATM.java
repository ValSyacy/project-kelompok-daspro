import java.util.Scanner;

public class PrototypeSistemATM {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        int password = 123;
        do {
            System.out.println("\nMasukkan Password Anda: ");
            password = sc.nextInt();

            if (password==123) {
                System.out.println("\nSilahkan Pilih Menu Transaksi \n1.Tarik Tunai \n2.Transfer Saldo \n3.Pengecekan Bunga Tabungan\n");
            
                int menu;
                menu = sc.nextInt();

                switch(menu) {
                    case 1: //Menu 1. Tarik Tunai

                    int saldo_awal, saldo_akhir, nominal_tariktunai;
                    
                    System.out.println("\nMasukkan Jumlah Saldo Anda");
                    saldo_awal=sc.nextInt();
                    System.out.println("\nMasukkan Nominal Jumlah Tarik Tunai");
                    nominal_tariktunai=sc.nextInt();
                    
                    saldo_akhir= saldo_awal-nominal_tariktunai;
                    
                    System.out.println("\n-----TARIK TUNAI BERHASIL-----");
                    System.out.println("Tarik Tunai Berhasil Senilai : Rp." + nominal_tariktunai + "\nSisa Saldo Anda Sejumlah     : Rp." + saldo_akhir + "\n");
                    break;

                    case 2: //Menu 2. Transfer Saldo

                    int saldo_akhir2, saldo_awal2, nominal_transfer;
                    String nama_penerima;
                    long rekening_penerima;

                    System.out.println("\nNama Penerima");
                    nama_penerima=sc.next();

                    System.out.println("\nMasukkan Rekening Penerima");
                    rekening_penerima=sc.nextLong();

                    System.out.println("\nMasukkan Jumlah Saldo Anda");
                    saldo_awal2=sc.nextInt();

                    System.out.println("\nMasukkan Nominal Transfer");
                    nominal_transfer=sc.nextInt();
                    
                    saldo_akhir2= saldo_awal2-nominal_transfer;

                    System.out.println("\n-----TRANSFER BERHASIL-----");
                    System.out.println("Nama Penerima\t  : " +nama_penerima);
                    System.out.println("Rekening Penerima : " +rekening_penerima);
                    System.out.println("\nTranfer Berhasil Senilai : Rp." +nominal_transfer + "\nSisa Saldo Anda Sejumlah : Rp." + saldo_akhir2 + "\n");
                    break;

                    case 3: // Menu 3. Pengecekan Bunga Tabungan
                    int jmlh_tabungan_awal, lama_tabungan;
                    double prosentase_bunga =0.02, bunga, jmlh_tabungan_akhir;

                    System.out.println("\nMasukkan Jumlah Tabungan Awal Anda");
                    jmlh_tabungan_awal=sc.nextInt();
                    System.out.println("\nMasukkan Lama Menabung Anda");
                    lama_tabungan=sc.nextInt();

                    bunga= lama_tabungan*prosentase_bunga*jmlh_tabungan_awal;
                    jmlh_tabungan_akhir=bunga+jmlh_tabungan_awal;

                    System.out.println("\nJumlah Tabungan Akhir Anda Adalah Senilai : Rp." +jmlh_tabungan_akhir +"\n");
                    break;

                    default:
                    System.out.println("\nMaaf Menu Lainnya Masih Dalam Pengembangan\n");
                }break;
            
            }else {
                System.out.println("\nPassword Yang Anda Masukkan Salah\nSilahkan Masukkan Ulang Password Anda");
            }
        }while(true);
    }
}