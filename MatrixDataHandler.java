package ro.ase.cts.s02.src;

import java.io.*;

//de modificat:
//tratare caz in care a fost modificat fisierul
//separare in diferite metode: citire matrice din fisier, scriere matrice in fisier, alocare spatiu matrice
//tratare exceptii

public class MatrixDataHandler {
    private int[][] matrix;
    private int height;
    private int width;
    private String filename;

    public void citireMatriceDinFisier() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
                String line = bufferedReader.readLine();

                for (int i = 0; i < height; i++) {
                    line = bufferedReader.readLine();
                    for (int j = 0; j < width; j++) {
                        matrix[i][j] = Integer.parseInt(line.split("")[j]);
                    }
                }
                bufferedReader.close();
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
    }

    public void alocareSpatiuMatrice(int height, int width, String filename) {
        this.height = height;
        this.width = width;
        this.filename = filename;
        matrix = new int[height][];
        for (int i = 0; i < height; i++) {
            matrix[i] = new int[width];
        }
    }

    public void scriereMatriceInFisier() {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(height + " " + width + "\n");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    fw.write(matrix[i][j] + " ");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public MatrixDataHandler(int height, int width, String filename) {
        alocareSpatiuMatrice(height, width, filename);
        scriereMatriceInFisier();
    }

    //si aici si la metoda de mai jos trb sa verificam daca posH si posW sunt in interval
    public int getValueFromPosition(String filename, int posH, int posW) {
        try {
            int valueFromPosition = -1;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            height = Integer.parseInt(line.split(" ")[0]);
            width = Integer.parseInt(line.split(" ")[1]);
            citireMatriceDinFisier();
            if(posH < height-1 && posW<width-1)
                valueFromPosition = matrix[posH][posW];
            return valueFromPosition;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }

    public void modifyValueAndUpdateFile(String filename, int posH, int posW, int val) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            height = Integer.parseInt(line.split(" ")[0]);
            width = Integer.parseInt(line.split(" ")[1]);

            alocareSpatiuMatrice(height, width, filename);
            citireMatriceDinFisier();

            if(posH<height-1 && posW < width-1)
                matrix[posH][posW] = val;
            else
                val = -1;

            scriereMatriceInFisier();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
