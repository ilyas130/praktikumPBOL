import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MahasiswaCRUD {
    private static Map<String, String> mahasiswaMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. tambah Mahasiswa");
            System.out.println("2. daftar Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Delete Mahasiswa");
            System.out.println("5. Exit");
            System.out.print("Pilih opsi: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    createMahasiswa();
                    break;
                case 2:
                    readMahasiswa();
                    break;
                case 3:
                    updateMahasiswa();
                    break;
                case 4:
                    deleteMahasiswa();
                    break;
                case 5:
                    running = false;
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

   
    private static void createMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        
        if (mahasiswaMap.containsKey(nim)) {
            System.out.println("NIM sudah terdaftar.");
        } else {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            mahasiswaMap.put(nim, nama);
            System.out.println("Mahasiswa berhasil ditambahkan.");
        }
    }

   
    private static void readMahasiswa() {
        if (mahasiswaMap.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("\nDaftar Mahasiswa:");
            for (Map.Entry<String, String> entry : mahasiswaMap.entrySet()) {
                System.out.println("NIM: " + entry.getKey() + ", Nama: " + entry.getValue());
            }
        }
    }

   
    private static void updateMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nim = scanner.nextLine();
        
        if (mahasiswaMap.containsKey(nim)) {
            System.out.print("Masukkan nama baru: ");
            String namaBaru = scanner.nextLine();
            mahasiswaMap.put(nim, namaBaru);
            System.out.println("Data mahasiswa berhasil diperbarui.");
        } else {
            System.out.println("NIM tidak ditemukan.");
        }
    }

   
    private static void deleteMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();
        
        if (mahasiswaMap.containsKey(nim)) {
            mahasiswaMap.remove(nim);
            System.out.println("Mahasiswa berhasil dihapus.");
        } else {
            System.out.println("NIM tidak ditemukan.");
        }
    }
}
